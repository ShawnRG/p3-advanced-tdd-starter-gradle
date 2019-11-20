package be.kdg.tdd.acceptatie;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static be.kdg.tdd.acceptatie.CommonOperations.loginAsRoot;
import static org.junit.Assert.assertEquals;

public class TestLoginRoot {
    @Test
    public void testHomeScreenRoot() {
        WebDriver driver = new HtmlUnitDriver();
        loginAsRoot(driver);
        WebElement element = driver.findElement(By.name("newusername"));
        String tagName = element.getTagName();
        assertEquals("input", tagName);
        element = driver.findElement(By.name("newpassword"));
        tagName = element.getTagName();
        assertEquals("input", tagName);
        element = driver.findElement(By.name("Add user"));
        tagName = element.getTagName();
        assertEquals("input", tagName);
        String type = element.getAttribute("type");
        assertEquals("submit", type);
    }


}
