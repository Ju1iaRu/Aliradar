package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.MainPage;

public class CustomSteps {
    protected static final String mainBigText = "AliRadar – лучший способ выбрать товар в интернете";

    protected WebDriver driver;
    MainPage mainPage;

    @When("^Open GoogleChrome and go to site$")
    public void goToSite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://aliradar.com/");
    }

    @When("^user checks title of Main page$")
    public void checkTitlePage() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "AliRadar - выбрать и купить товар в интернет-магазинах, сравнить цены и найти похожий товар дешевле или со скидкой");
    }

    @When("^user checks text AliradarBest of Main page$")
    public void assertTextAliBest() {
        mainPage = new MainPage(driver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mainPage.getMainBigText(), mainBigText, "Главный текст не совпадает или изменился");
        softAssert.assertAll();
    }

    @Then("^user click to Install button$")
    public void elementsMainPage(){
        mainPage = new MainPage(driver);
        mainPage.clickToInstallButton();
    }

    @When("^user waits$")
    public void userWait(){
        mainPage = new MainPage(driver);
        mainPage.sleep(3000);
    }

    @Then("^user logs out$")
    public void quit() {
        driver.quit();
    }
}
