package Amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_OptionHomepage {
	public WebDriver driver;
	
	public Search_OptionHomepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	private @FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement Searchbar;
	

	private @FindBy(xpath="//select[@id='searchDropdownBox']")
	WebElement SearchDropdownBox;
	
	private @FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement SearchSubmitButton;
	
	
	
	By Searchname=By.xpath("//div[@class='left-pane-results-container']/div");
	
	
	public WebElement Get_Searchbar()
	{
		return Searchbar;
	}

	public WebElement Get_SearchDropdownBox()
	{
		return SearchDropdownBox;
	}
	
	public WebElement Get_SearchSubmitButton()
	{
		return SearchSubmitButton;
	}
	public List<WebElement> GetSearchname() {
		return driver.findElements(Searchname);
	}
	
}
