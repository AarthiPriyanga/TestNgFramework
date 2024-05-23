package pages;

import base.BaseClass;

public class HomePage extends MenuPage {
	
	public HomePage verifyHomeElement() {
		if(driver.findElement(applauncherIcon).isDisplayed()&&
				driver.findElement(userImg).isDisplayed()) {
			System.out.println("User landed in the home page");
			return this;
		}else {
			System.out.println("User not landed in the home page");
			return this;
		}
	}
}
