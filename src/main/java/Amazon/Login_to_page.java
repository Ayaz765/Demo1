package Amazon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_to_page {
	public WebDriver driver;

	public Login_to_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	private @FindBy(xpath = "//input[@name='email']") WebElement MobileNo_or_Email;

	private @FindBy(xpath = "//input[@type='submit']") WebElement MobileNo_or_Email_submit;
	
	private @FindBy(xpath ="//input[@name='password']" ) WebElement Password;

	private @FindBy(xpath = "//input[@id='signInSubmit']") WebElement Password_submit;

	private @FindBy(xpath="//a[@id='nav-link-accountList']") WebElement Accountlist;
	
	private @FindBy(xpath="//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']")
	WebElement Signin;
	
	public WebElement Get_MobileNo_or_Email() {
		return MobileNo_or_Email;
	}

	public WebElement Get_MobileNo_or_Email_submit() {
		return MobileNo_or_Email_submit;
	}
	
	public WebElement Get_Accountlist() {
		return Accountlist;
	}

	public WebElement Get_Signin() {
		return Signin;
	}

	public WebElement Get_Password() {
		return Password;
	}

	public WebElement Get_Password_submit() {
		return Password_submit;
	}

}
