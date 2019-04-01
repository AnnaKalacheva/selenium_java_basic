package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class Sample3Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void assertEqualsTask() throws Exception {
//         TODO:
//         check how many element with class "test" there are on page (5)
//         check that value of second button is "This is also a button"
        assertEquals(5, driver.findElements(By.className("test")).size());
        assertEquals("This is also a button", driver.findElement(By.id("buttonId")).getAttribute("value"));

        /*int expected = 5;
        int actual = driver.findElements(By.className("test")).size();
        assertEquals(expected, actual);*/

        /*String expected2 = "This is also a button";
        String actual2 = driver.findElement(By.id("buttonId")).getAttribute("value");
        assertEquals(expected2, actual2);*/

    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        assertTrue("Custom message",
                driver.findElement(By.name("randomButton2")).getAttribute("value").equalsIgnoreCase("this is Also a Button"));


        /*String elementTrueTask = driver.findElement(By.id("buttonId")).getAttribute("value");
        assertTrue(elementTrueTask.equals("this is Also a Button"));
        assertTrue(elementTrueTask.equalsIgnoreCase("this is Also a Button"));
        // pass:
        assertTrue(true);
        // fail:
//        assertTrue(false);*/
    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        assertFalse(driver.findElement(By.name("randomButton2")).getAttribute("value").equals("This is a button"));
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test"
//        contain number 190
        List<WebElement> elements = driver.findElements(By.className("test"));
        for (WebElement element : elements) {
            assertFalse(element.getText().contains("190"));
        }

        /*List<WebElement> elements = driver.findElements(By.className("test"));
        for (WebElement element : elements){
            assertFalse(element.getText().contains("190"));
        }*/
    }
}
