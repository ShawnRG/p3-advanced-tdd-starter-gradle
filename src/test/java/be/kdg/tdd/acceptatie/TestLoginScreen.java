package be.kdg.tdd.acceptatie;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertEquals;

public class TestLoginScreen {
    @Test
    public void testLoginScreen() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/tdd");
        String title = driver.getTitle();
        assertEquals("Favorites login", title);
        WebElement element = driver.findElement(By.name("username"));
        String tagName = element.getTagName();
        assertEquals("input", tagName);
        element = driver.findElement(By.name("password"));
        tagName = element.getTagName();
        assertEquals("input", tagName);
        String type = element.getAttribute("type");
        assertEquals("password", type);
        element = driver.findElement(By.name("login"));
        tagName = element.getTagName();
        assertEquals("input", tagName);
        type = element.getAttribute("type");
        assertEquals("submit", type);
    }
}
