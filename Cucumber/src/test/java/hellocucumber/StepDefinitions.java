package hellocucumber;

import io.cucumber.java.en.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Path;
import java.nio.file.Paths;

public class StepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;

    private openCartAcuator adminOpenCartAcuator; //ziv
    private openCartAcuator userOpenCartAcuator; //eden
    Path currentRelativePath = Paths.get("");
    String s = currentRelativePath.toAbsolutePath().toString();
    private String webDriver = "webdriver.chrome.driver";
    private String path = "C:/Users/Owner/BGU/sqe/hw3/sqe-hw3-main/Selenium/chromedriver.exe";
    String adminUserName="admin";
    String adminPassword="1234";
    public boolean found = false;

    public void userOpenCartInit(){
        System.out.println("--------------- INITIALIZING USER OPEN CART- OPENING WEBPAGE ---------------");
        if(userOpenCartAcuator != null){
            userOpenCartAcuator.terminateDriver();
        }
        userOpenCartAcuator =new openCartAcuator();
        userOpenCartAcuator.initUserSession(webDriver, path);
    }

    public void adminOpenCartInit(){
        System.out.println("--------------- INITIALIZING ADMIN OPEN CART- OPENING WEBPAGE ---------------");
        if(adminOpenCartAcuator != null){
            adminOpenCartAcuator.terminateDriver();
        }
        adminOpenCartAcuator = new openCartAcuator();
        adminOpenCartAcuator.initAdminSession(webDriver,path);
    }
    public void beforeAll(){
        adminOpenCartInit();
        adminOpenCartAcuator.adminLogin(adminUserName,adminPassword);
    }
    @Given("an admin is in adminPage and goes to product list")
    public void anAdminIsInAdminPageAndGoesToProductList() {
       beforeAll();
    }
    @And("admin choose a product to delete")
    public void adminChooseAProductToDelete() {
        adminOpenCartAcuator.chooseProduct();
    }

    @And("admin clicks on delete button")
    public void adminClicksOnDeleteButton() {
        adminOpenCartAcuator.deleteProduct();
    }

    @Then("product is deleted from the list of products")
    public void productIsDeletedFromTheListOfProducts() {
        adminOpenCartAcuator.checkIfProductDeleted();
    }

    ///// eden
    @Given("^A customer user is on home page$")
    public void init() {userOpenCartInit();}

    @When("^User navigates to cameras page$")
    public void userNavigatesToPhonesPage() {
        userOpenCartAcuator.goToPhones();
    }

    @When("^User selects a product$")
    public void userSelectsAProduct() {
        userOpenCartAcuator.selectProduct();
    }

    @When("^User adds product to cart$")
    public void userAddsProductToCart() {
        userOpenCartAcuator.addProductToCart();
    }

    @When("^User navigates to checkout$")
    public void userNavigatesToCheckout() {
        userOpenCartAcuator.goToCheckout();
    }



//    @When("^User enters Shipping and payment Method$")
//    public void userEntersShippingAndPaymentMethod(String val1, String val2) {
//        userOpenCartAcuator.enterShippingAndPaymentMethod(val1,val2);
//        // opencart.enterShippingAndPaymentMethod("flat.flat","cod");
//    }

    @When("^user confirms order$")
    public void userConfirmsOrder() {
        //userOpenCartAcuator.ConfirmOrder();
    }

    @Then("^Message displayed that the order has been placed successfully$")
    public void messageDisplayedThatTheOrderHasBeenPlacedSuccessfully() {
        System.out.println("order has been placed successfully");
        terminate();
    }

    @When("^User selects guest$")
    public void userSelectsGuest() {
        userOpenCartAcuator.clickGuest();
    }

    @When("^enter first name$")
    public void enterFirstName() {
        userOpenCartAcuator.enterFirstName("user1");
    }

    @When("^enter last name$")
    public void enterLastName() {
        userOpenCartAcuator.enterLastName("lastNameUser1");
    }

    @When("^enter email$")
    public void enterEmail() {
        userOpenCartAcuator.enterEmail("user1@gmail.com");
    }

    @When("^enter address$")
    public void enterAddress() {
        userOpenCartAcuator.enterAddress("UserAddress1");
    }

    @When("^enter city$")
    public void enterCity() {
        userOpenCartAcuator.enterCity("City1");
    }

    @When("^enter country$")
    public void enterCountry() {
        userOpenCartAcuator.enterCountry("4");
    }

    @When("^enter region$")
    public void enterRegion() {
        userOpenCartAcuator.enterRegion("117");
    }

    @When("^click Continue$")
    public void clickContinue() {
        userOpenCartAcuator.clickContinue();
    }

    @When ("^User enters shipping Method$")
    public void userEntersShippingMethod() {

//        userOpenCartAcuator.enterShippingMethod("flat.flat");
    }

    @When("^User enters payment Method$")
    public void userEntersPaymentMethod() {
       // userOpenCartAcuator.enterPaymentMethod("cod");
    }
    private void terminate(){
        System.out.println("in terminate");
        if(userOpenCartAcuator != null){
            userOpenCartAcuator.terminateDriver();
        }
        if(adminOpenCartAcuator != null){
            adminOpenCartAcuator.terminateDriver();
        }
    }
}
