package pages;

import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class HomePage extends MenuPage {
    
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
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
