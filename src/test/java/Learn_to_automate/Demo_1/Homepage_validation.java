package Learn_to_automate.Demo_1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Amazon.Homepage_validation1;
import Common_Methods.Base_Class;
import junit.framework.Assert;


public class Homepage_validation extends Base_Class
{
	public Homepage_validation1 val;
	public WebDriver driver;
	@Test
	void validation()
	{
		val= new Homepage_validation1(driver);
		String Amazon_logo=val.Get_amazon_logo().getText();
		
		Assert.assertEquals("Amazon",Amazon_logo);
		
	}

}
