package com.gurukula.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gurukula.structure.MenuBar;
import com.gurukula.structure.StaffViewPage;
import com.gurukula.structure.StaffsPage;

public class StaffsTest extends BaseTestWithLogin{
	private MenuBar menuBar;
	private StaffsPage staffsPage;
	private StaffViewPage staffViewPage;
	
	@DataProvider(name = "dataStaffs")
	public Object[][] createData() {
          return new Object[][] {
            { "Supriya Dsouza", "Philosophy"},
            { "Googly Woogly", "Philosophy"},
            { "Humpty Dumpty", "Chemistry"},
            { "Jack Sparrow", "Chemistry"},
            { "Hokey Pokey", "Chemistry"},    
            { "Oompah Loompah", "Physics"},  
          };
	}

	@Test(dataProvider="dataStaffs", enabled=true)
	public void testAddStaff(String sName, String sBranch){
		menuBar = new MenuBar(driver);
		menuBar.clickEntities();
		staffsPage = menuBar.clickStaff();
		staffsPage.clickCreate();
		staffsPage.enterName(sName);
		staffsPage.selectBranch(sBranch);
		staffsPage.clickSave();

		//searching the recently added staff and confirming that there is 1 occurrence
		//is time consuming. Therefore skipped an assert here
	}
	
	@Parameters({"query", "expectedOccurrences"})
	@Test(priority=2, enabled=true)
	public void testSearchStaff(String query, int expectedOccurrences){
		searchForStaff(query);
		int actualOccurrences = staffsPage.searchResultsContains(query);
		
		Assert.assertEquals(actualOccurrences, expectedOccurrences);
	}

	@Parameters({"name", "branch"})
	@Test(priority=3, enabled=true)
	public void testViewStaff(String sName, String sBranch){
		searchForStaff(sName);
		staffViewPage = (StaffViewPage)staffsPage.clickViewResultAtIndex(1);
	
		Assert.assertEquals(staffViewPage.getName(), sName);
		Assert.assertEquals(staffViewPage.getBranchName(), sBranch);
		
		staffViewPage.clickBack();
	}
	
	@Parameters({"staffForEditing", "newName", "sbranch"})
	@Test(priority=4, enabled=true)
	public void testEditStaff(String sName, String sNewName, String branch){
		searchForStaff(sName);
		staffsPage.clickEditResultAtIndex(1);
		staffsPage.enterName(sNewName);
		staffsPage.clickSave();
		
		testViewStaff(sNewName, branch);
	}
	
	@Parameters({"nameForDeletion"})
	@Test(priority=5, enabled=true)
	public void testDeleteStaff(String sName){
		searchForStaff(sName);
		staffsPage.clickDeleteResultAtIndex(1);
		staffsPage.clickDelete();
		testSearchStaff(sName, 0);
	}
	
	protected void searchForStaff(String query) {
		menuBar = new MenuBar(driver);
		menuBar.clickEntities();
		staffsPage = menuBar.clickStaff();
		
		staffsPage.enterQuery(query);
		staffsPage.clickSearch();
	}
}
