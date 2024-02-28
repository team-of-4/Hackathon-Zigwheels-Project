package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.UpcomingBikesPage;
import pageobjects.UpcomingHondaBikesPage;
import pageobjects.UsedCarChennaiPage;
import pageobjects.ZigWheelsPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class BaseClass {
	
	public static  WebDriver driver;
	public static Logger logger;
	//public ZigWheelsPage zw;
	//public UpcomingBikesPage ub;
	//public UpcomingHondaBikesPage uh;
	//public UsedCarChennaiPage uc;
	//public LoginPage lp;
	public Properties p;
	
	@BeforeTest(groups= {"sanity","regression","smoke","master"})
	@Parameters({"browser","os"})
	public WebDriver setup(String browser, String os) throws IOException {
		
		FileReader f = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(f);
		// Loading log4j2 file
		logger = LogManager.getLogger(this.getClass());
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capabalities = new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabalities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac")) {
				capabalities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("no matching os .....");
				return null;
			}
			
			//browser
			if(browser.equalsIgnoreCase("chrome")) {
				capabalities.setBrowserName("chrome");
			}
			else if(browser.equalsIgnoreCase("edge")) {
				capabalities.setBrowserName("MicrosoftEdge");
			}
			else {
				System.out.println("no matching browser .....");
				return null;
			}
			
			
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabalities);
			
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			
			// launching browser based on condition - locally
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				logger.info("Chrome browser opened successfully");
			}
			else if(browser.equalsIgnoreCase("edge")){
				driver = new EdgeDriver();
				logger.info("Edge browser opened successfully");
			}
			else {
				System.out.println("no matching browser......");
				logger.info("no matching browser......");
				return null;
			}
			
			
		}
			
		
		driver.get(p.getProperty("appUrl"));
		logger.info("Base Page loaded sucessfully");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		logger.info("Maximize the window sucessfully");
		
//		zw = new ZigWheelsPage(driver);
//		ub = new UpcomingBikesPage(driver);
//		uh = new UpcomingHondaBikesPage(driver);
//		uc = new UsedCarChennaiPage(driver);
//		lp = new LoginPage(driver);
		
		// edited for cucumber
		return driver;
		
	}
		
	
	
//	public void takescreenshot(String fileName) {
//		
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);      // capture 
//		File trg = new File(".\\screenshots\\" + fileName);  // store
//		
//		try {
//			FileUtils.copyFile(src, trg);
//		}
//		catch(IOException e) {
//			System.out.println("could not take screenshot");
//		}
//		
//	}
//		
//		public String captureScreen(String tname)throws IOException{
//			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//			TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
//			File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
//			String targetFilePath=System.getProperty("user.dir")+"\\ER_screenshots\\" + tname +"-" + timeStamp + ".png";
//			File targetFile = new File(targetFilePath);
//			
//			sourceFile.renameTo(targetFile);
//			return targetFilePath;
//		}
		
	
	
	public String getUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	

	@AfterTest(groups= {"sanity","regression","smoke","master"})
	public void tearDown(){
		driver.quit();
	}
	
}
