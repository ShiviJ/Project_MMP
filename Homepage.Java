package com.org.Patient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.Admin.AdminLoginPage;

public class MMPHomePage {
	
	WebDriver driver;
	//Define all WebElement
	@FindBy(linkText="Home")
	private WebElement clickHome;
	
	@FindBy(linkText="Patient Login")
	private WebElement clickPatientLogin ;
	
	@FindBy(linkText="Office Login")
	private WebElement  clickOfficeLogin;
	//Admin Login
	@FindBy(xpath=".//*[@id='welcome']/div/div[2]/a[1]")
	private WebElement  clickAdminLogin;
	
	@FindBy(linkText="About Us")
	private WebElement  clickAboutUs;
	
	@FindBy(linkText="Contact Us")
	private WebElement  clickContactUs;
	//Login Button
	@FindBy(xpath=".//*[@id='testimonials']/div/div/div/div[2]/a")
	private WebElement  clickLogin;
	//Register Button
	@FindBy(xpath=".//*[@id='testimonials']/div/div/div/div[3]/a")
	private WebElement  clickRegister;
	
	//Get Text on Page
	@FindBy(xpath=".//*[@id='testimonials']/div/div/h1")
	private WebElement textMMppage;
	WebDriverWait wait;
	
	public MMPHomePage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
		 wait = new WebDriverWait(driver,10);
		
	}
	
	public MMPHomePage clickHome()
	{
		clickHome.click();
		return this;
	}
	
	public void clickPatientLogin()
	{
		clickPatientLogin.click();
	}
	
	public String getTextPatientLogin()
	{
		return clickPatientLogin.getText();
	}
	
	public void clickOfficeLogin()
	{
		clickOfficeLogin.click();
	}
	
	public void clickAboutUs()
	{
		clickAboutUs.click();
		
	}
	public String getTextAboutUs()
	{
		return clickAboutUs.getText();
		
	}
	
	public void clickContactUs()
	{
		clickContactUs.click();
	}
	public void clickLoginbutton()
	{
		System.out.println("Click Login Button");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='testimonials']/div/div/div/div[2]/a")));
		driver.findElement(By.xpath(".//*[@id='testimonials']/div/div/div/div[2]/a")).click();
		//clickLogin.click();
	}
	
	//Get Page Title
	public String getMMPHomePageTitle()
	{
		return driver.getTitle();
	}
	//Get Text on MMP Page
	public String gettextonMMPpage()
	{
		return textMMppage.getText();
	}
	//Go to Patient Login Page
	public PatientLoginPage clickPatientLoginButton()
	{
		clickLoginbutton();
		return new PatientLoginPage(driver);
	}
	
	//Go to Regsiter page
	public RegisterPatientPage  clickRegisterButton()
	{
		clickRegister.click();
		return new RegisterPatientPage(driver);
	}
	
	// Admin Module
	//Go to Admin
	public AdminLoginPage  clickAdminLoginButton()
	{
		clickAdminLogin.click();
		return new AdminLoginPage(driver);
	}
	
}
