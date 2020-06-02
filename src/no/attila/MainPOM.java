package no.attila;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainPOM {

    public static Tests tests;

    //-------------------------------- set up test environment --------------------------------//
    @BeforeClass
    public static void setup() {
        tests = new Tests();
        tests.getWebPage("http://the-internet.herokuapp.com/");
    }

    @AfterClass
    public static void tearDown() {
        tests.closeWebPage();
    }

    @After
    public void navigateBack() {
        tests.navigateBack();
    }

    //-------------------------------- tests --------------------------------//

    @Test
    public void ABTest() {
        tests.getAndClickButtonByLinkText("A/B Testing");
    }

    @Test
    public void addOrRemoveElement() {
        tests.getAndClickButtonByLinkText("Add/Remove Elements");
        tests.testAddAndRemoveButton("/html/body/div[2]/div/div/button","/html/body/div[2]/div/div/div/button");
    }

    @Test
    public void basicAuth() {
        tests.getWebPage("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    @Test
    public void brokenImages() {
        tests.getAndClickButtonByLinkText("Broken Images");
        tests.testBrokenImages();
    }

    @Test
    public void challengingDOM() {
        tests.getAndClickButtonByLinkText("Challenging DOM");
        tests.getElementByClass("button");
        tests.getElementByMultipleClassName(".button.alert");
        tests.getElementByMultipleClassName(".button.success");
        tests.printTableRowElements("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]");
        tests.clickEditeAndDeleteInRow("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[1]",
                                    "/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[2]");
    }

    @Test
    public void checkBoxes() {
        tests.getAndClickButtonByLinkText("Checkboxes");
        tests.getAndClickCheckBoxes("//*[@id=\"checkboxes\"]");
    }

    @Test
    public void contextMenu() {
        tests.getAndClickButtonByLinkText("Context Menu");
        tests.selectAndClickContextMenu("hot-spot");
    }

    @Test
    public void dragAndDrop() {
        tests.getAndClickButtonByLinkText("Drag and Drop");
        tests.dragAndDropElement("column-a", "column-b");
    }

    @Test
    public void dropdown() {
        tests.getAndClickButtonByLinkText("Dropdown");
        tests.selectDropdownMenu("dropdown");
    }

    @Test
    public void dynamicControls() {
        tests.getAndClickButtonByLinkText("Dynamic Controls");
        tests.testDynamicControls();
    }

    @Test
    public void entryAd() {
        tests.getAndClickButtonByLinkText("Entry Ad");
        tests.closeModalWindow();
    }

    @Test
    public void download() {
        tests.getAndClickButtonByLinkText("File Download");
        tests.getAndClickButtonByLinkText("atlc1.jpg");
    }

    @Test
    public void hovers() {
        tests.getAndClickButtonByLinkText("Hovers");
        tests.hoverOverElements();
    }

    @Test
    public void horizontalSlider() {
        tests.getAndClickButtonByLinkText("Horizontal Slider");
        tests.dragHorizontalSlider();
    }

}
