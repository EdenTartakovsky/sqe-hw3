package hellocucumber;
import org.junit.Assert;
import org.openqa.selenium.*;
//import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

public class openCartAcuator {
    private WebDriver adminDriver;
    private WebDriver userDriver;
    private WebDriverWait adminWait;
    private WebDriverWait userWait;


    public void initAdminSession(String webDriver, String path) {
        // webDriver = "webdriver.chrome.driver"
        //path = "C:\\Users\\Owner\\BGU\\sqe\\hw3\\sqe-hw3-main\\Selenium\\chromedriver.exe";
        System.setProperty(webDriver, path);

        // new chrome driver object
        this.adminDriver = new ChromeDriver();

        // new web driver wait -> waits until element are loaded (40 sec max)
        this.adminWait = new WebDriverWait(adminDriver, 10);


        // launch website -> localhost
        adminDriver.get("http://localhost/opencart/adminDir");

        // maximize the window - some web apps look different in different sizes
        adminDriver.manage().window().maximize();


        /*
            If we wanted to test the web application on different devices -
                1. Open the web app
                2. Right click -> click inspect
                3. Click on the phone icon at the top left corner of the inspect window (the app changes preview format at this point)
                4. Locate the dimensions drop-down list at the top of the web app and choose device
                5. Copy dimensions size (on the right side of the drop-down list)
                   -> driver.manage().window().setSize(new Dimension(width, height));
         */

        System.out.println("Driver setup finished for - " + adminDriver.getTitle());
    }
    public void initUserSession(String webDriver, String path) {
        // webDriver = "webdriver.chrome.driver"
        //path = "C:\\Users\\Owner\\BGU\\sqe\\hw3\\sqe-hw3-main\\Selenium\\chromedriver.exe";
        System.setProperty(webDriver, path);

        // new chrome driver object
        this.userDriver = new ChromeDriver();

        // new web driver wait -> waits until element are loaded (40 sec max)
        this.userWait = new WebDriverWait(userDriver, 40);


        // launch website -> localhost
        userDriver.get("http://localhost/opencart/");

        // maximize the window - some web apps look different in different sizes
        userDriver.manage().window().maximize();


        /*
            If we wanted to test the web application on different devices -
                1. Open the web app
                2. Right click -> click inspect
                3. Click on the phone icon at the top left corner of the inspect window (the app changes preview format at this point)
                4. Locate the dimensions drop-down list at the top of the web app and choose device
                5. Copy dimensions size (on the right side of the drop-down list)
                   -> driver.manage().window().setSize(new Dimension(width, height));
         */

        System.out.println("Driver setup finished for - " + userDriver.getTitle());
    }
    public void waitMilliseconds(int milli) {
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (Exception ignored) {
        }
    }
    public void adminLogin(String userName, String pass) {
        adminDriver.get("http://localhost/opencart/adminDir/index.php?route=catalog/product");
        waitMilliseconds(500);
        //*[@id="input-username"]
        adminWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-username"))).sendKeys(userName);
        adminWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-password"))).sendKeys(pass);
        adminWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"form-login\"]/div[3]/button"))).click();
        waitMilliseconds(500);
    }


//<a href="http://localhost/opencart/adminDir/index.php?route=catalog/product|list&user_token=16a4f7337572f3e9d5e52298393fbb73&page=2" class="page-link">2</a>
    public void chooseProduct() {
        adminWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/table/tbody/tr[6]/td[1]/input"))).click();
    }

    public void deleteProduct() {
        adminWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/button[3]"))).click();
            adminDriver.switchTo().alert().accept();
    }

    public void checkIfProductDeleted() {
        try {
            adminDriver.findElement(By.id("alert"));

        } catch (Exception exception) {
            Assert.assertTrue(false);
        }
    }
    public void goToPhones(){
        userWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[6]/a"))).click();
    }
    public void selectProduct() {
        userDriver.findElement(By.xpath("//*[@id=\"product-list\"]/div[3]/form/div/div[2]/div[1]/h4/a")).click();
    }
    public void addProductToCart(){
        userWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"button-cart\"]"))).click();
    }
    public void goToCheckout(){
        userWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav/div/div[2]/ul/li[5]/a"))).click();
    }
    public void clickGuest(){
        WebElement option1 =userWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-guest")));
        option1.click();
    }
    public void enterFirstName(String _firstName){
        WebElement firstName =userDriver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[1]/div[2]/div[1]/input"));
        firstName.sendKeys(_firstName);
    }
    public void enterLastName(String _LastName){
        WebElement lastName =userDriver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[1]/div[2]/div[2]/input"));
        lastName.sendKeys(_LastName);
    }
    public void enterEmail(String _email){
        userDriver.manage().window().maximize();
        WebElement email =userDriver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[1]/div[2]/div[3]/input"));
        email.sendKeys(_email);
    }
    public void enterAddress(String _address){
        WebElement address =userDriver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[2]/div/div[2]/input"));
        address.sendKeys(_address);
    }
    public void enterCity(String _city){
        WebElement city =userDriver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[2]/div/div[4]/input"));
        city.sendKeys(_city);
    }
    public void enterCountry(String _country){
//        Select country = new Select(driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[2]/div/div[6]/select")));
//        country.selectByValue(_country);
        WebElement dropDownList= userDriver.findElement(By.xpath("//*[@id=\"input-shipping-country\"]"));
        Select select= new Select(dropDownList);
        select.selectByVisibleText("Albania");
    }
    public void enterRegion(String _region){
//        Select region = new Select(driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[2]/div/div[7]/select")));
//        region.selectByValue(_region);
        WebElement dropDownList= userDriver.findElement(By.xpath("//*[@id=\"input-shipping-zone\"]"));
        Select select= new Select(dropDownList);
        select.selectByVisibleText("Berat");
    }
    public void clickContinue() {
        userWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[2]/div/div/div/div[1]/div/form/div/div[3]/button"))).click();
        try {
            userWait.wait(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void enterShippingMethod(String val1){
//        WebElement dropDownList= userDriver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div[2]/div[1]/form/fieldset/div/select/optgroup\n"));
//        Select select= new Select(dropDownList);
//        select.selectByIndex(0);
        WebElement grade = userDriver.findElement(By.xpath("//*[@id=\"input-shipping-method\"]"));
      //  grade.click();
        grade.sendKeys(Keys.DOWN);
        grade.sendKeys(Keys.DOWN);
        grade.sendKeys(Keys.DOWN);
//        grade.sendKeys(Keys.UP);
//        grade.sendKeys(Keys.UP);
//        grade.sendKeys(Keys.UP);
//        grade.sendKeys(Keys.UP);
//        grade.sendKeys(Keys.UP);
//        grade.sendKeys(Keys.UP);
//        grade.sendKeys(Keys.UP);
        grade.sendKeys(Keys.ENTER);
    }
    public void enterPaymentMethod(String val2){
        WebElement dropDownList= userDriver.findElement(By.xpath("//*[@id=\"input-payment-method\"]"));
        Select select= new Select(dropDownList);
        select.selectByValue(val2);
    }


    public void ConfirmOrder() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(text(),'Confirm Order')])[0]"))).click();
        //"(//*[contains(text(),'Submit all and finish')])[1]"
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//xpath_to_element")));
        userWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/div[2]/div/div/div/div[2]/div[3]/div[2]/div/button"))).click();

    }
    public void terminateDriver() {
        this.adminDriver.quit();
        this.userDriver.quit();
    }

}
