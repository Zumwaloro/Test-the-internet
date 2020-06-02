package no.attila;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainPOM {

    private final DriverSetUp setup = new DriverSetUp();
    private final WebDriver driver = setup.getDrvier();
    private final Actions actions = new Actions(driver);

    public void getWebPage(String url) {
        driver.get(url);
    }

    public void getAndClickButtonByLinkText(String text) {
        WebElement button = ((ChromeDriver) driver).findElementByLinkText(text);
        button.click();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void testAddAndRemoveButton(String addPath, String removePath) {
        WebElement add = driver.findElement(By.xpath(addPath));
        add.click();
        WebElement remove = driver.findElement(By.xpath(removePath));
        remove.click();
    }

    public void testBrokenImages() {
        List<WebElement> images = driver.findElements(By.tagName("img"));
        for (WebElement e : images) {
            try {
                URL url = new URL(e.getAttribute("src"));
                HttpURLConnection http = (HttpURLConnection)url.openConnection();
                if (http.getResponseCode() != 200) {
                    System.out.println("Invalid image with src: " + e.getAttribute("src"));
                } else {
                    System.out.println("Valid image with source: " + e.getAttribute("src"));
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public void getElementByClass(String className) {
        WebElement button = driver.findElement(By.className(className));
        button.click();
    }

    public void getElementByMultipleClassName(String multiClass) {
        driver.findElement(By.cssSelector(multiClass)).click();
    }

    public void printTableRowElements(String rowPath) {
        List<WebElement> tableElements = driver.findElement(By.xpath(rowPath)).findElements(By.tagName("td"));
        for (WebElement e : tableElements) {
            System.out.println(e.getText());
        }
    }

    public void clickEditeAndDeleteInRow(String edit, String delete) {
        driver.findElement(By.xpath(edit)).click();
        driver.findElement(By.xpath(delete)).click();
    }

    public void getAndClickCheckBoxes(String containerPath) {
        List<WebElement> elements = driver.findElement(By.xpath(containerPath)).findElements(By.tagName("input"));
        elements.get(0).click();
        elements.get(1).click();
    }

    public void selectAndClickContextMenu(String id) {
        actions.contextClick(driver.findElement(By.id(id))).perform();
    }

    public void dragAndDropElement(String idSource, String idTarget) {
        WebElement source = driver.findElement(By.xpath(idSource));
        WebElement target = driver.findElement(By.id(idTarget));
        actions.dragAndDrop(source, target).build().perform();
    }

    public void selectDropdownMenu(String id) {
        Select menu = new Select(driver.findElement(By.id(id)));
        menu.selectByVisibleText("Option 1");
        menu.selectByVisibleText("Option 2");
    }

    public void testDynamicControls() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //Checkbox
        WebElement checkBox = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/div/input"));
        WebElement button = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        checkBox.click();
        button.click();
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
        wait.until(ExpectedConditions.elementToBeClickable(button));
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/div/input")).click();

        //Input box
        WebElement enableButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button\n"));
        WebElement input = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/input\n"));
        enableButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(input));
        input.sendKeys("Hello world!");
        enableButton.click();
    }


}
