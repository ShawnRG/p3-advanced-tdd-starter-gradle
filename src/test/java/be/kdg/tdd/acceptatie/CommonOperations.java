package be.kdg.tdd.acceptatie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommonOperations {
    public static void loginAsRoot(WebDriver driver) {
        driver.get("http://127.0.0.1:8080/tdd");
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("root");
        element = driver.findElement(By.name("password"));
        element.sendKeys("rootpasswd");
        element.submit();
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> d.getTitle().equals("Favorites: root"));
    }

    public static void createUser(String username, String password) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/tdd");
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("root");
        element = driver.findElement(By.name("password"));
        element.sendKeys("rootpasswd");
        element.submit();
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> d.getTitle().equals("Favorites: root"));
        element = driver.findElement(By.name("newusername"));
        element.sendKeys(username);
        element = driver.findElement(By.name("newpassword"));
        element.sendKeys(password);
        element.submit();
    }

    public static void loginAsUser(WebDriver driver, String username, String password) {
        driver.get("http://127.0.0.1:8080/tdd");
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element.submit();
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> d.getTitle().equals("Favorites: " + username));
    }

    public static void addFavorite(WebDriver driver, String favoriteToCreate) {
        WebElement element = driver.findElement(By.name("favorite"));
        element.sendKeys(favoriteToCreate);
        element.submit();
        (new WebDriverWait(driver, 10)).until((WebDriver d) -> pageContainsFavorite(d, favoriteToCreate));
    }

    public static boolean pageContainsFavorite(WebDriver d, String favorite) {
        List<WebElement> elements = d.findElements(By.name("favorites"));
        if (elements.size() == 0) return false;
        WebElement webElement = elements.get(0);
        elements = webElement.findElements(By.tagName("td"));
        if (elements.size() == 0) return false;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(favorite)) return true;
        }
        return false;
    }
}
