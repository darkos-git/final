package tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public abstract class BasicTest {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected String baseUrl = "http://demo.yo-meals.com";
	protected String userId = "customer@dummyid.com";
	protected String userPw = "12345678a";

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.js = (JavascriptExecutor) driver;

		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();

	}

	// if test fail this method make screenshot
	@AfterMethod
	public void afterTest(ITestResult result) throws Exception {
		String testTime = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File ss = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(ss, new File("C:\\Users\\bice\\Desktop\\FINAL PROJECT\\final\\screenshots\\" + testTime + ".png"));
		}
		this.driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void afterClass() {
		this.driver.close();
	}
}
//Basic Test:
//apstraktna klasa koja sadrži sve zajedničke funkcionalnosti za sve test klase
//od dodatnih atributa ima:
//baseUrl 
//imejl i lozinku demo korisnika customer@dummyid.com/12345678a
//BeforeClass metoda koja konfiguriše Selenium drajver
//AfterMethod metoda koja u slučaju pada testa kreira screenshot stranice i te slike čuva u okviru screenshots direktorijuma. Nevezano za ishod testa metoda uvek briše sve kolačiće.
//AfterClass metoda koja zatvara sesiju drajvera
//sve ostale test klase nasleđuju ovu klasu
