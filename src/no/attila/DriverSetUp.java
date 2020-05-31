package no.attila;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetUp {

    public WebDriver driver;

    public DriverSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abulen\\Desktop\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    public WebDriver getDrvier() {
        return this.driver;
    }
}
