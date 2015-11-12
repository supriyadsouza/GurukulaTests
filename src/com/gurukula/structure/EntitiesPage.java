package com.gurukula.structure;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntitiesPage extends BasePage{

	private static final String RESULTS_TABLE_XPATH = "html/body/div[3]/div[1]/div/div[4]/table";

	EntitiesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div[1]/div/div[1]/button")
	protected WebElement buttonCreate;
	
	@FindBy(xpath=".//*[@id='searchQuery']")
	protected WebElement textboxQuery;
	
	@FindBy(xpath="html/body/div[3]/div[1]/div/div[1]/div/div[2]/form/button")
	protected WebElement buttonSearch;
	
	@FindBy(xpath=RESULTS_TABLE_XPATH)
	protected WebElement tableResults;

	public void clickCreate(){
		buttonCreate.click();
	}
	
	public void enterQuery(String q){
		textboxQuery.click();
		textboxQuery.clear();
		textboxQuery.sendKeys(q);
	}
	
	public void clickSearch(){
		buttonSearch.click();
	}
	
	public void search(String s){
		enterQuery(s);
		clickSearch();
	}
	
	public int searchResultsContains(String q){
		int searchCount = 0;
		String col1, col2;
		tableResults = driver.findElement(By.xpath(RESULTS_TABLE_XPATH));
		List<WebElement> rows = tableResults.findElements(By.xpath("./tbody/tr"));
		
		for(WebElement row:rows){
			col1 = row.findElement(By.xpath("./td[2]")).getText();
			col2 = row.findElement(By.xpath("./td[3]")).getText();
			if (col1.contains(q) || col2.contains(q))
				searchCount++;
		}
		
		textboxQuery.clear();
		return searchCount;
	}
	
	public EntityViewPage clickViewResultAtIndex(int i) {
		WebElement buttonView = tableResults.findElement(By.xpath("./tbody/tr["+i+"]/td[4]/button[1]"));
		buttonView.click();
		if ((driver.getTitle()).equals("Branch"))
			return new BranchViewPage(driver);
		else
			return new StaffViewPage(driver);
	}

	public void clickEditResultAtIndex(int i) {
		WebElement buttonEdit = tableResults.findElement(By.xpath("./tbody/tr["+i+"]/td[4]/button[2]"));
		buttonEdit.click();		
	}
	
	public void clickDeleteResultAtIndex(int i) {
		WebElement buttonEdit = tableResults.findElement(By.xpath("./tbody/tr["+i+"]/td[4]/button[3]"));
		buttonEdit.click();
	}
}
