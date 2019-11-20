package be.kdg.tdd.acceptatie;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static be.kdg.tdd.acceptatie.CommonOperations.*;

public class TestUser {
    @Before
    public void setup() {
        createUser("normaluser", "normaluser");
    }

    @Test
    public void testAddFavorite() {
        WebDriver driver = new HtmlUnitDriver();
        loginAsUser(driver, "normaluser", "normaluser");
        WebElement element = driver.findElement(By.name("favorite"));
        element.sendKeys("pasta");
        element.submit();
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> {
            List<WebElement> elements = d.findElements(By.name("favorites"));
            if (elements.size() != 1) return false;
            WebElement webElement = elements.get(0);
            elements = webElement.findElements(By.tagName("td"));
            if (elements.size() != 1) return false;
            return "pasta".equals(elements.get(0).getText());
        });

        element = driver.findElement(By.name("favorite"));
        element.sendKeys("frieten");
        element.submit();
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> {
            List<WebElement> elements = d.findElements(By.name("favorites"));
            if (elements.size() != 1) return false;
            WebElement webElement = elements.get(0);
            elements = webElement.findElements(By.tagName("td"));
            if (elements.size() != 2) return false;
            return "pasta".equals(elements.get(0).getText()) && "frieten".equals(elements.get(1).getText());
        });
    }

    @Test
    public void testFavoritePersistence() {
        createUser("bla", "blabla");
        WebDriver driver = new HtmlUnitDriver();
        loginAsUser(driver, "bla", "blabla");
        addFavorite(driver, "soep");
        addFavorite(driver, "friet");
        addFavorite(driver, "steak");
        driver = new HtmlUnitDriver();
        loginAsUser(driver, "bla", "blabla");
        Assert.assertTrue(pageContainsFavorite(driver, "soep"));
        Assert.assertTrue(pageContainsFavorite(driver, "friet"));
        Assert.assertTrue(pageContainsFavorite(driver, "steak"));
    }
}
