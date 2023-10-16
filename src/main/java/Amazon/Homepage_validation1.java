package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage_validation1 {
	
	public WebDriver driver;
	

	public Homepage_validation1(WebDriver driver) {
		this.driver = driver;
	
	}
	
	
	
	private By Amazon_logo= By.xpath("//a[@id='nav-logo-sprites']");
	
	private By Retuns_and_Orders= By.xpath("//span[normalize-space()='Returns']");
	
	

	
	
	public WebElement Get_amazon_logo() {
		return driver.findElement(Amazon_logo);
	}
	
	
	
	
	public void Get_Retuns_and_Orders()
	{
		driver.findElement(Retuns_and_Orders);
	}
	

}
