package com.gurukula.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gurukula.structure.BranchViewPage;
import com.gurukula.structure.BranchesPage;
import com.gurukula.structure.MenuBar;

public class BranchesTest extends BaseTestWithLogin{
	private MenuBar menuBar;
	private BranchesPage branchesPage;
	private BranchViewPage branchViewPage;
	
	@DataProvider(name = "dataBranches")
	public Object[][] createData() {
          return new Object[][] {
            { "Philosophy", "PHIL"},
            { "Physics", "PHY"},
            { "Chemistry", "CHEM"},
            { "Economics", "ECON"},
            { "Biology", "BIO"},    
            {"Portuguese", "PORT"},
          };
	}

	@Test(dataProvider="dataBranches", enabled=true, priority=1)
	public void testAddBranch(String bName, String bCode){
		menuBar = new MenuBar(driver);
		menuBar.clickEntities();
		branchesPage = menuBar.clickBranch();
		branchesPage.clickCreate();
		branchesPage.enterName(bName);
		branchesPage.enterCode(bCode);
		branchesPage.clickSave();
		
		//searching the recently added branch and confirming that there is 1 occurrence
		//is time consuming. Therefore skipped an assert here
	}
	
	@Parameters({"query", "expectedOccurrences"})
	@Test(priority=2, enabled=true)
	public void testSearchBranch(String query, int expectedOccurrences){
		searchForBranch(query);
		int actualOccurrences = branchesPage.searchResultsContains(query);
		
		Assert.assertEquals(actualOccurrences, expectedOccurrences);
	}
	
	@Parameters({"code", "name"})
	@Test(priority=3, enabled=true)
	public void testViewBranch(String bCode, String bName){
		searchForBranch(bCode);
		branchViewPage = (BranchViewPage)branchesPage.clickViewResultAtIndex(1);
	
		Assert.assertEquals(branchViewPage.getBranchCode(), bCode);
		Assert.assertEquals(branchViewPage.getBranchName(), bName);
		
		branchViewPage.clickBack();
	}

	@Parameters({"codeForEditing", "newName"})
	@Test(priority=4, enabled=true)
	public void testEditBranch(String bCode, String bNewName){
		searchForBranch(bCode);
		branchesPage.clickEditResultAtIndex(1);
		branchesPage.enterName(bNewName);
		branchesPage.clickSave();
		
		testViewBranch(bCode, bNewName);
	}
	
	@Parameters({"codeForDeletion"})
	@Test(priority=5, enabled=true)
	public void testDeleteBranch(String bCode){
		searchForBranch(bCode);
		branchesPage.clickDeleteResultAtIndex(1);
		branchesPage.clickDelete();
		testSearchBranch(bCode, 0);
	}
	
	protected void searchForBranch(String query) {
		menuBar = new MenuBar(driver);
		menuBar.clickEntities();
		branchesPage = menuBar.clickBranch();
		
		branchesPage.enterQuery(query);
		branchesPage.clickSearch();
	}
}
