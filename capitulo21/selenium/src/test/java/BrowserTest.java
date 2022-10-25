/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;

import org.junit.Test;

/**
 *
 * @author avbravo
 */
public class BrowserTest {
    
    public BrowserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test   

public void testGoogleSearch() throws InterruptedException {     

  // Optional. If not specified, WebDriver searches the PATH for chromedriver.    
  System.setProperty("webdriver.chrome.driver", "/home/avbravo/chromedriver_linux64");      
  WebDriver driver = new ChromeDriver(); 

  driver.get("http://www.google.com/");    

  Thread.sleep(5000);  // Let the user actually see something!     

  WebElement searchBox = driver.findElement(By.name("q"));

  searchBox.sendKeys("ChromeDriver");     

  searchBox.submit();    

  Thread.sleep(5000);  // Let the user actually see something!     

  driver.quit();  

 } 
}
