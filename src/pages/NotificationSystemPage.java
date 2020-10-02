package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {
	
	public NotificationSystemPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	
	}
	//take element for notification red or green
	public WebElement getAlertMsg() {
	return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}
	//return value of text masseges
	public String AlertMsg() {
		return getAlertMsg().getText();
	}
	// wait until massege disappear
	public void MsgFadeAway(){
		wait.until(ExpectedConditions.attributeContains(By.className("system_message"), "style", "display:none"));
	}
}
//get metodu za element koji prikazuje poruku
////*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]
//metodu koja vraća poruku koja se nalazi u obaveštenju
//metodu koja čeka da obaveštenje nestane
//čeka se da element //*[contains(@class, 'system_message')]
//za atribut style dobije vrednost  "display: none;"
