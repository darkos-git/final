package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage {
	protected WebDriver driver;
	protected JavascriptExecutor js;

	// WebElement locators
	public WebElement getLocation() {
		return this.driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[1]/div/a"));
	}

	public WebElement getClose() {
		return this.driver.findElement(By.className("close-btn"));
	}

	public WebElement getKeyword() {
		return this.driver.findElement(By.id("locality_keyword"));
	}

	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}

	public WebElement getLocationInput() {
		return this.driver.findElement(By.id("location_id"));

	}

	public WebElement getSubmit() {
		return this.driver.findElement(By.name("btn_submit"));
	}

	// opens the location selection field
	public void openPopUpLocator() {
		getLocation().click();
	}

	// sets the location
	public void setUpLocation(String locationName) {
		js.executeScript("arguments[0].value=arguments[1];", getLocationInput(), getLocationItem(locationName));
		js.executeScript("arguments[0].click();", getSubmit());

	}

	public void closePopLocation() {
		getClose().click();
	}

}
//Location Popup Page:
//get metoda za element koji prikazuje lokaciju u hederu 
//get metodu za close element
//get metode potrebne za implementaciju metode u kojoj se postavlja lokacija
//getKeyword()
////*[@id='locality_keyword']
//getLocationItem(String locationName)
////li/a[contains(text(), '" + locationName + "')]/..
//getLocationInput()
////*[@id='location_id']
//getSubmit()
////*[@name='btn_submit']
//metodu koja otvara iskačući dijalog
//klikom na lokaciju iz hedera
//metodu koja postavlja lokaciju - naziv lokacije (locationName) se prosleđuje kao parametar metode
//metoda prvo klikne na element keyword element
//čita vrednost data-value atributa location item elementa
//postavlja lokaciju izvršavajući JavaScript kod
//Skripta: arguments[0].value=arguments[1]
//prvi argument skripte je location input
//drugi argument skripte je vrednost pročitanog atributa iz drugog koraka.
//Klikće na submit element preko skripte arguments[0].click();
//metodu koja zatvara iskačući dijalog, klikom na X dugme
