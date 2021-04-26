package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.HotProdPage;
import pages.MainPage;

public class CustomSteps {
    protected static final String mainBigText = "AliRadar – лучший способ выбрать товар в интернете";

    protected WebDriver driver;
    MainPage mainPage;
    HotProdPage hotProdPage;

    @When("^Open GoogleChrome and go to site$")
    public void goToSite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://aliradar.com/");
    }

    @When("^user checks title of Main page$")
    public void checkTitleMainPage() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "AliRadar - выбрать и купить товар в интернет-магазинах, сравнить цены и найти похожий товар дешевле или со скидкой");
    }

    @When("^user checks title on Hot Products page$")
    public void checkTitleHotProductPage() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Горящие товары с Алиэкспресс на русском в рублях со скидками до 90% и бесплатной доставкой");
    }

    @When("^user checks text AliradarBest on Main page$")
    public void assertTextAliBest() {
        mainPage = new MainPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mainPage.getMainBigText(), mainBigText, "Главный текст не совпадает или изменился");
        softAssert.assertAll();
    }

    @When("^user checks Useful Category on Main page$")
    public void assertUsefulCategoryText() {
        mainPage = new MainPage(driver);
        mainPage.getUsefulCategory();
    }

    @Then("^user clicks to useful category Instruments$")
    public void clickToInstrumentsCategory(){
        mainPage = new MainPage(driver);
        mainPage.clickToInstrumentsCategory();
    }

    @When("^user checks title on Instruments page$")
    public void checkTitleInstrumentsPage() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Инструменты - купить недорого, выбрать и сравнить цены в интернет-магазинах");
    }

    @Then("^user clicks to Install button$")
    public void clickToInstallButton(){
        mainPage = new MainPage(driver);
        mainPage.clickToInstallButton();
    }

    @Then("^user clicks to Hot Products on header$")
    public void clickToHotProducts(){
        hotProdPage = new HotProdPage(driver);
        hotProdPage.clickToHotProducts();
    }

    @When("^user counts Hot items$")
    public void countHotItems() {
        hotProdPage = new HotProdPage(driver);
        hotProdPage.getCountHotItems();
        System.out.println("Количество горящих товаров = " + hotProdPage.getCountHotItems());
    }

    @When("^user waits$")
    public void userWaits(){
        mainPage = new MainPage(driver);
        mainPage.sleep(2000);
    }

    @When("^user clicks back$")
    public void clickBack(){
        driver.navigate().back();
    }

    @Then("^user logs out$")
    public void quit() {
        driver.quit();
    }
}
