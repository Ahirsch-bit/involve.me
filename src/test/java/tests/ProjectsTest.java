package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProjectsPage;

public class ProjectsTest extends BaseTest {
	

	//Add New Workspace
	@Test
	public void newWorkspace(){
		ProjectsPage newws = new ProjectsPage(driver);
		int size1 = newws.getWorkspaceSize();
		newws.newWorkspace("Testing");
		int expected = size1 + 1;
		newws.sleep(5000);;
		int actual = newws.getWorkspaceSize();
		Assert.assertEquals(actual, expected);
	}
	
	//Delete Workspace
	@Test
	public void delWorskspace() {
		ProjectsPage delWs = new ProjectsPage(driver);
		int size1 = delWs.getWorkspaceSize();
		delWs.deleteWorkspace("Testing");
		int expected = size1 - 1;
		int actual = delWs.getWorkspaceSize();
		Assert.assertEquals(actual, expected);
		
	}

}
