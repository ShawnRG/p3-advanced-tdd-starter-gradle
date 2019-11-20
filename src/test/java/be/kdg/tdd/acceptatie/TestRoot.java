package be.kdg.tdd.acceptatie;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static be.kdg.tdd.acceptatie.CommonOperations.loginAsRoot;
import static be.kdg.tdd.acceptatie.CommonOperations.loginAsUser;

public class TestRoot {
    @Test
    public void testAddUser() throws InterruptedException {
        WebDriver driver = new HtmlUnitDriver();
        loginAsRoot(driver);
        WebElement element = driver.findElement(By.name("newusername"));
        element.sendKeys("testuser");
        element = driver.findElement(By.name("newpassword"));
        element.sendKeys("testuser");
        element.submit();
        driver = new HtmlUnitDriver();
        loginAsUser(driver, "testuser", "testuser");
    }
}
