package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HerokuAppChrome {
    public static void main(String[] args) {
        //setup Chrome browser
        WebDriver driver = new ChromeDriver();
        System.out.println(driver);
        String baseUrl = "https://the-internet.herokuapp.com/login";
        driver.get(baseUrl);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Print the title of the page
        System.out.println("The title of the page is :" + driver.getTitle());
        //Print current Url
        System.out.println("The current url is :" + driver.getCurrentUrl());
        //Print the page source
        System.out.println("The page source is :" + driver.getPageSource());
        //Enter email to email field
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("tomsmith");
        //Enter password to password field
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        //Click in to login button
        driver.findElement(By.className("fa-sign-in")).click();
        //Print current url
        System.out.println("The current url is :" + driver.getCurrentUrl());
        //Refresh the page
        driver.navigate().refresh();
        //close the browser
        driver.quit();
    }
}
