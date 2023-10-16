package Common_Methods;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;




import Amazon.Login_to_page;



public class Base_Class {
	public static WebDriver driver;
	String Browser_name;
	public Properties Prop_file;
	public Login_to_page Lp;
	
	public WebDriver Driver_IntializationBack() throws Throwable 
	
	{
		Prop_file= new Properties();
		FileInputStream FIS= new FileInputStream(
				"C:\\amazonfile\\getdata.properties");
		
		Prop_file.load(FIS);
		
		Browser_name= Prop_file.getProperty("Browsername");
		
		System.out.println(Browser_name);
		
		if(Browser_name.equalsIgnoreCase("Chrome"))
		{
			
		
			System.setProperty("webdriver.chrome.driver","C:\\Chrome\\chromedriver-win64\\chromedriver.exe");
			ChromeOptions co= new ChromeOptions();
			co.setBinary("C:\\Chrome\\chrome-win64\\chrome.exe");
			 driver = new ChromeDriver(co);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		else if (Browser_name.equalsIgnoreCase("IE")) {
			//System.setProperty("webdriver.edge.driver", "C:\\\\edgedriver_win64\\\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

		
		return driver;
		
		
		
	}
	
	@BeforeTest
	public void Login() throws Throwable {
		
		driver = Driver_IntializationBack();
		
		driver.get(Prop_file.getProperty("url")
				);
		Lp = new Login_to_page(driver);
		Actions act= new Actions(driver);
		act.moveToElement(Lp.Get_Accountlist() ).perform();
		Thread.sleep(3000);
		Lp.Get_Signin().click();
		
		Lp.Get_MobileNo_or_Email().sendKeys(Prop_file.getProperty("email"));
		Lp.Get_MobileNo_or_Email_submit().click();
		Lp.Get_Password().sendKeys(Prop_file.getProperty("pass"));
		Lp.Get_Password_submit().click();
		
		

	}
	
	
	public String getScreenshot(String TestcaseName,WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir") + "//reports//" + TestcaseName +".png");
	//	FileUtils.copyFile(source,file);
		return System.getProperty("user.dir") + "//reports//" + TestcaseName +".png";
		
		
		
	}
	
	@AfterTest
	public void closedriver() {
		driver.close();
	}
	
	

}

