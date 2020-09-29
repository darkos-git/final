package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {
	
	public LoginPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		
	}

	
	
	// webElements locator
	public WebElement loginButton() {
		return this.driver.findElement(By.xpath("//*[text()='Login']"));
	}

	public WebElement getUserName() {
		return this.driver.findElement(By.name("username"));

	}

	public WebElement getPasword() {
		return this.driver.findElement(By.name("password"));

	}

	public WebElement getLoginBtn() {
		return this.driver.findElement(By.name("btn_submit"));
	}

	// Login method
	public void Login(String userid, String password) {
		getUserName().clear();
		getUserName().sendKeys(userid);
		getPasword().clear();
		getPasword().sendKeys(password);
		getLoginBtn().click();
	}

}
