package no.attila;

public class Main {

    public static void main(String[] args) {

        MainPOM main = new MainPOM();

        main.getWebPage("http://the-internet.herokuapp.com/");

        //A/B Testing
        /*main.getAndClickButtonByLinkText("A/B Testing");
        main.navigateBack();*/

        //Add/Remove Elements
        /*main.getAndClickButtonByLinkText("Add/Remove Elements");
        main.testAddAndRemoveButton("/html/body/div[2]/div/div/button","/html/body/div[2]/div/div/div/button");
        main.navigateBack();*/

        //Basic Auth
       // main.getWebPage("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        // main.navigateBack();

        //Test broken images
       /* main.getAndClickButtonByLinkText("Broken Images");
        main.testBrokenImages();
        main.navigateBack();*/

       //Challenging DOM elements
        //main.getAndClickButtonByLinkText("Challenging DOM");
        /*main.getElementByClass("button");
        main.getElementByMultipleClassName(".button.alert");
        main.getElementByMultipleClassName(".button.success");
        main.printTableRowElements("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]");
        main.clickEditeAndDeleteInRow("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[1]",
                                    "/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[2]");
        main.navigateBack();
        */

        //Checkboxes
        /*main.getAndClickButtonByLinkText("Checkboxes");
        main.getAndClickCheckBoxes("//*[@id=\"checkboxes\"]");
        main.navigateBack();*/

        //Context menu
        /*main.getAndClickButtonByLinkText("Context Menu");
        main.selectAndClickContextMenu("hot-spot");
        main.navigateBack();*/

        //Drag & Drop
        /*main.getAndClickButtonByLinkText("Drag and Drop");
        main.dragAndDropElement("column-a", "column-b");
        main.navigateBack();*/

        //Dropdown
        /*main.getAndClickButtonByLinkText("Dropdown");
        main.selectDropdownMenu("dropdown");
        main.navigateBack();*/


    }
}
