package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

// Главная страница
public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    // Текст AliRadar – лучший
    @FindBy(xpath  = "//h1[contains(text(), 'AliRadar – лучший')]")
    private WebElement textAliradarBest;

    // кнопка Установить приложение
    @FindBy(xpath  = "//a[text() = 'Установить приложение']")
    private WebElement installButton;

    // блок Полезные категории
    @FindBy(xpath  = "//h2[text() = 'Полезные категории']/parent::div")
    private WebElement usefulCategory;

    // Категория Инструменты (Instruments)
    @FindBy(xpath  = "//h3[text() = 'Инструменты']")
    private WebElement instrumentsCategory;

//-----------------------------------------------------------------

    // Нажимаем на кнопку Установить приложение
    public void clickToInstallButton() {
        installButton.click();
    }

    // Нажимаем на категорию Инструменты (Instruments)
    public void clickToInstrumentsCategory() {
        wait.until(ExpectedConditions.visibilityOf(instrumentsCategory)).click();
    }

    // Текст AliRadar – лучший
    public String getMainBigText() {
        return textAliradarBest.getText();
    }

    // блок Полезные категории
    public void getUsefulCategory() {
        String usefulCategoryText = usefulCategory.getText();
        Assert.assertTrue(usefulCategoryText.contains("Наручные часы"));
        System.out.println("Полезные категории есть на странице, в том числе: ");
        System.out.println("Наручные часы");

        Assert.assertTrue(usefulCategoryText.contains("Мобильные телефоны и аксессуары"));
        System.out.println("Мобильные телефоны и аксессуары");
        
        Assert.assertTrue(usefulCategoryText.contains("Ремонт и обустройство дома"));
        System.out.println("Ремонт и обустройство дома");

        Assert.assertTrue(usefulCategoryText.contains("Мать и ребенок"));
        System.out.println("Мать и ребенок");
    }

}





