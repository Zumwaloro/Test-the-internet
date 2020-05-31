package no.attila;

import org.openqa.selenium.WebDriver;

public class MainPOM {

    DriverSetUp setup = new DriverSetUp();
    WebDriver driver = setup.getDrvier();

    public void getWebPage(String url) {
        driver.get(url);
    }
}
