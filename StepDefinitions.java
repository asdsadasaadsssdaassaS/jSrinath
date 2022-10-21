

package Day004;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	static WebDriver driver;
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		
		//System.out.println("User launch chrome browser");
		
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		  driver =new ChromeDriver();
		  driver.manage().window().maximize() ;	
	   
	}
	
	
	@When("User opens URL {string}")
	public void user_opens_url(String TestURL) {
		
		//System.out.println("User opens URL : "+TestURL);
		  driver.get(TestURL);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	   
	}
	
	
	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String UserName, String Password) throws Exception {
		
		System.out.println("UserName as  : "+UserName);
		System.out.println("Password as : "+ Password);
		
		  findElement(By.name("username")).sendKeys(UserName);
		  findElement(By.name("password")).sendKeys(Password);
		  findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		  Thread.sleep(5000);
		


	}
	@Then("Go to Skill Page")
	public void go_to_skill_page() throws Exception {

		
		//System.out.println("Go to Skill Page");
		  findElement(By.xpath("//span[text()='Admin']")).click();
		  findElement(By.xpath("//span[text()='Qualifications ']")).click();
		  findElement(By.xpath("//a[text()='Skills']")).click();
		  findElement(By.xpath("//button[text()=' Add ']")).click();


	}
	
	
	@When("Add skills with skillname as {string} and skilldescription as {string}")
	public void add_skills_with_skillname_as_and_skilldescription_as(String SkillName, String SkillDescr) throws Exception {


		//System.out.println("SkillDescr as  : "+SkillName);
		//System.out.println("SkillDescr as : "+ SkillDescr);
		
		 findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(SkillName);
		  findElement(By.xpath("//textarea[@placeholder='Type description here']")).sendKeys(SkillDescr);
		  
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//button[text()=' Save ']")).click();
	}
	
	
	
	@When("Click on logout button")
	public void click_on_logout_button() {

		System.out.println("Click on logout button");

	}
	
	
	@Then("Close Browser")
	public void close_browser() {

		System.out.println("Close Browser");
		driver.quit();
	}
	
	
	public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}

	

}
