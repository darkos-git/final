package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LocationPopupPage;
import pages.LoginPage;
import pages.NotificationSystemPage;

public class ProfileTest extends BasicTest {
	
	
	
	
	

	@Test
	public void LoginTest() throws Exception {
		this.driver.navigate().to(baseUrl + "/guest-user/login-form");
		LocationPopupPage lpp = new LocationPopupPage(driver, wait, js);
		LoginPage lp = new LoginPage(driver, wait, js);
		NotificationSystemPage np = new NotificationSystemPage(driver, wait, js);
		Thread.sleep(1000);
		lpp.closePopLocation();
		lp.Login(userId, userPw);
		Assert.assertEquals("Login Successfull", np.AlertMsg(),"[ERROR]  you are not log in");
		
		
		
	}
}
//U okviru edit profile testa potrebno je izvršiti sledeće korake:
//učitajte stranicu http://demo.yo-meals.com/guest-user/login-form
//ugasite lokacioni iskačući dijalog
//prijavite se na aplikaciju preko demo naloga
//verifikujte da je prikazana poruka sa tekstom "Login Successfull"
//učitajte stranicu http://demo.yo-meals.com/member/profile
//zamenite sve osnovne informacije korisnika
//verifikujte da je prikazana poruka sa tekstom "Setup Successful"
//odjavite se sa sajta
//verifikujte da je prikazana poruka sa tekstom "Logout Successfull!"
