package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class HerokuAppMultiBrowser {
    static WebDriver driver;
    static String browser = "Chrome";
    static String baseUrl = "https://the-internet.herokuapp.com/login";

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        //Open Url
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

