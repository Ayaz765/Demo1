package Learn_to_automate.Demo_1;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Amazon.Login_to_page;
import Amazon.Search_OptionHomepage;
import Common_Methods.Base_Class;

public class SearchProduct extends Base_Class {

	public Login_to_page Lp;
	public Search_OptionHomepage Sc;

	Logger log = LogManager.getLogger(this.getClass().getSimpleName());

	@Test
	void Search_product() throws Throwable {

		Sc = new Search_OptionHomepage(driver);
		Sc.Get_Searchbar().sendKeys("iphone");

		List<WebElement> options = Sc.GetSearchname();
		Thread.sleep(9000);
		for (WebElement option : options)

		{
			if (option.getText().equalsIgnoreCase("iphone 15"))

			{

				option.click();

				break;

			}

		}
	}

}
