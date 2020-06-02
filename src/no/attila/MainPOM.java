package no.attila;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainPOM {

    public static Tests tests;

    //-------------------------------- set up test environment --------------------------------//
    @BeforeAll
    public static void setup() {
        tests = new Tests();
        tests.getWebPage("http://the-internet.herokuapp.com/");
    }

    @AfterAll
    public static void tearDown() {
        tests.closeWebPage();
    }

    @AfterEach
    public void navigateBack() {
        tests.navigateBack();
    }

    //-------------------------------- tests --------------------------------//

    @Test
    @Order(1)
    public void ABTest() {
        tests.getAndClickButtonByLinkText("A/B Testing");
    }

    @Test
    @Order(2)
    public void addOrRemoveElement() {
        tests.getAndClickButtonByLinkText("Add/Remove Elements");
        tests.testAddAndRemoveButton("/html/body/div[2]/div/div/button","/html/body/div[2]/div/div/div/button");
    }

    @Test
    @Order(3)
    public void basicAuth() {
        tests.getWebPage("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    @Test
    @Order(4)
    public void brokenImages() {
        tests.getAndClickButtonByLinkText("Broken Images");
        tests.testBrokenImages();
    }

    @Test
    @Order(5)
    public void challengingDOM() {
        tests.getAndClickButtonByLinkText("Challenging DOM");
        tests.getElementByClass("button");
        tests.getElementByMultipleClassName(".button.alert");
        tests.getElementByMultipleClassName(".button.success");
        tests.printTableRowElements("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]");
        tests.clickEditeAndDeleteInRow("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[1]",
                                    "/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[2]");
        tests.navigateBack();
        tests.navigateBack();
    }

    @Test
    @Order(6)
    public void checkBoxes() {
        tests.getAndClickButtonByLinkText("Checkboxes");
        tests.getAndClickCheckBoxes("//*[@id=\"checkboxes\"]");
    }

    @Test
    @Order(7)
    public void contextMenu() {
        tests.getAndClickButtonByLinkText("Context Menu");
        tests.selectAndClickContextMenu("hot-spot");
    }

    @Test
    @Order(8)
    public void dragAndDrop() {
        tests.getAndClickButtonByLinkText("Drag and Drop");
        tests.dragAndDropElement("column-a", "column-b");
    }

    @Test
    @Order(9)
    public void dropdown() {
        tests.getAndClickButtonByLinkText("Dropdown");
        tests.selectDropdownMenu("dropdown");
    }

    @Test
    @Order(10)
    public void dynamicControls() {
        tests.getAndClickButtonByLinkText("Dynamic Controls");
        tests.testDynamicControls();
    }

    @Test
    @Order(11)
    public void entryAd() {
        tests.getAndClickButtonByLinkText("Entry Ad");
        tests.closeModalWindow();
    }

    @Test
    @Order(12)
    public void download() {
        tests.getAndClickButtonByLinkText("File Download");
        tests.getAndClickButtonByLinkText("atlc1.jpg");
    }

    @Test
    @Order(13)
    public void hovers() {
        tests.getAndClickButtonByLinkText("Hovers");
        tests.hoverOverElements();
    }

    @Test
    @Order(14)
    public void horizontalSlider() {
        tests.getAndClickButtonByLinkText("Horizontal Slider");
        tests.dragHorizontalSlider();
    }

}
