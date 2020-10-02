package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}

	public WebElement getFirstName() {
		return this.driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastName() {
		return this.driver.findElement(By.name("user_last_name"));
	}

	public WebElement getEmailName() {
		return this.driver.findElement(By.name("user_email"));
	}

	public WebElement getAdress() {
		return this.driver.findElement(By.name("user_address"));
	}

	public WebElement getPhoneNo() {
		return this.driver.findElement(By.name("user_phone"));
	}

	public WebElement getZipCode() {
		return this.driver.findElement(By.name("user_zip"));

	}

	public WebElement getUploadPic() {
		return this.driver.findElement(By.className("upload uploadFile-Js"));
	}

	public WebElement getRemovePicture() {
		return this.driver.findElement(By.className("remove"));
	}
	public WebElement getSubmitBtn() {
		return this.driver.findElement(By.name("btn_submit"));
	}

	public Select selectCountry() {
		WebElement wb = this.driver.findElement(By.name("user_country_id"));
		Select select = new Select(wb);
		return select;
	}

	public Select selectState() {
		WebElement ab = this.driver.findElement(By.name("user_state_id"));
		Select select = new Select(ab);
		return select;

	}

	public Select getCity() {
		WebElement gc = this.driver.findElement(By.id("user_city"));
		Select select = new Select(gc);
		return select;
	}

	public void uploadPic(String a) {
		js.executeScript("arguments[0].click();", getUploadPic());
		getUploadPic().sendKeys(a);
	}
	
	public void changeProfile(String fname,String lname,String email,String adress, String phone,String zip,String country,String state, String city,String picUrl) {
	this.getFirstName().sendKeys(fname);
	this.getLastName().sendKeys(lname);
	this.getEmailName().sendKeys(email);
	this.getAdress()
	}

}
//get metode za sve potrebne elemente
//sve elemente za izmenu osnovnih informacija kao i 
//sve elemente potrebne za rad sa profilnom slikom
//da bi se na stranici pojavio element input type="file" potrebno je da se prvo izvrši JavaScript kod koji vrši akciju klik na Upload dugme 
//Skripta: arguments[0].click();
//metodu koja otprema profilnu sliku - kao parametar se prosleđuje putanja do fajla, tj. u ovom slučaju do slike
//metodu koja briše profilnu sliku
//klikom na Remove dugme 
//Preporuka: izvršite JavaScript kod arguments[0].click(); nad tim dugmetom
//metodu koja menja sve osnovne informacije korisnika - kao parametri se prosleđuju sve potrebne informacije
