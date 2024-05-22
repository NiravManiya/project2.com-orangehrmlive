package com_orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-2- ProjectName : com-orangehrmlive
 *  BaseUrl = https://opensource-demo.orangehrmlive.com/
 *  1. Setup Chrome browser.
 *  2. Open URL.
 *  3. Print the title of the page.
 *  4. Print the current url.
 *  5. Print the page source.
 *  6. Click on ‘Forgot your password?’ link.
 *  7. Print the current url.
 *  8. Navigate back to the login page.
 *  9. Refresh the page.
 *  10. Enter the email to email field.
 *  11. Enter the password to password field.
 *  12. Click on Login Button.
 *  13. Close the browser.
 */


public class OrangeHrmLive {
    //1. Setup Chrome Browser
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        //2. Open URL
        driver.get(baseUrl);

        //3. Print the title of the page.
        System.out.println("Page Title: " + driver.getTitle());

        //4. Print the current Url.
        System.out.println("Current Url: " + driver.getCurrentUrl());

        //5. Print the page source.
        System.out.println("Page Source: " + driver.getPageSource());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 6: Click on 'Forgot your password?' link

        driver.findElement(By.className("orangehrm-login-forgot")).click();
        //7. Print the current Url.
        System.out.println("Current Url: " + driver.getCurrentUrl());

        //8. Navigate back to the login page.
        driver.navigate().back();

        //9. Refresh the page.
        driver.navigate().refresh();

        //10. Enter the email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //11. Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");

        //12. Click on the Login Button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();


        //13. Close the browser.
        driver.close();


}


}
