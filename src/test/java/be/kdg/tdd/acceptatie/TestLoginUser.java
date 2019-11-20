package be.kdg.tdd.acceptatie;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static be.kdg.tdd.acceptatie.CommonOperations.createUser;
import static be.kdg.tdd.acceptatie.CommonOperations.loginAsUser;
import static org.junit.Assert.assertEquals;

public class TestLoginUser {

    @Before
    public void setup() {
        createUser("normaluser", "normaluser");
    }

    @Test
    public void testHomeScreenNormalUser() {
        WebDriver driver = new HtmlUnitDriver();
        loginAsUser(driver, "normaluser", "normaluser");
        WebElement element = driver.findElement(By.name("favorites"));
        String tagname = element.getTagName();
        assertEquals("table", tagname);
        element = driver.findElement(By.name("favorite"));
        tagname = element.getTagName();
        assertEquals("input", tagname);
        element = driver.findElement(By.name("Add favorite"));
        tagname = element.getTagName();
        assertEquals("input", tagname);
        String type = element.getAttribute("type");
        assertEquals("submit", type);
    }

    @Test
    public void testHomeScreenOtherNormalUser() {
        createUser("otheruser", "password");
        WebDriver driver = new HtmlUnitDriver();
        loginAsUser(driver, "otheruser", "password");
    }

    @Test
    public void testLoginWrongUser() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/tdd");
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("kris");
        element = driver.findElement(By.name("password"));
        element.sendKeys("wrong password");
        element.submit();
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> !(d.findElement(By.id("error")).getText().equals("")));
        element = driver.findElement(By.id("error"));
        String error = element.getText();
        assertEquals("Wrong username or password", error);
    }
}
