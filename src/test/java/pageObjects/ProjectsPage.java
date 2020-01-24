package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {

	@FindBy(css = "[name='email']")
	private WebElement email;
	@FindBy(css = "[name='password']")
	private WebElement password;
	@FindBy(css = "[type='submit']")
	private WebElement loginBtn;
	@FindBy(css = "div.mb-3 > h1")
	private List<WebElement> heading;
	@FindBy(css = ".px-5 > button")
	private WebElement addNewWorkspace;
	@FindBy(css = "[placeholder = 'Workspace name']")
	private WebElement newWorkspaceName;
	@FindBy(css = "#confirm-create-button")
	private WebElement newWSButton;
	@FindBy(css = "a> span.mr-3.truncate")
	private List<WebElement> workspaces;
	@FindBy(css = "[data-icon='chevron-down']")
	private WebElement workspaceBtn;
	@FindBy(css = "li:nth-child(2) > button")
	private WebElement deleteWorkspace;
	@FindBy(css = "div.p-6.md\\:p-8 > input")
	private WebElement confirmDlt;
	@FindBy(css = "#confirm-create-button")
	private WebElement confirmBtn;

	public ProjectsPage(WebDriver driver) {
		super(driver);
	}

	public void newWorkspace(String wsName) {
		click(addNewWorkspace);
		fillText(newWorkspaceName, wsName);
		click(newWSButton);
	}
	
	public void deleteWorkspace(String wsName) {
		for (WebElement we : workspaces) {
			if (we.getText().equals(wsName)) {
				click(we);
			}
		}
		click(workspaceBtn);
		click(deleteWorkspace);
		fillText(confirmDlt, wsName);
		click(confirmBtn);
		sleep(5000);
	}

	// verification methods
	public int getWorkspaceSize() {
		int size = workspaces.size();
		return size;
	}

}
