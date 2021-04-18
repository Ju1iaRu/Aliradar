package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.concurrent.TimeUnit;


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


    // Нажимаем на кнопку Установить приложение
    public void clickToInstallButton() {
        installButton.click();
    }

    // Текст AliRadar – лучший
    public String getMainBigText() {
        return textAliradarBest.getText();
    }


    // Ожидание
    public void sleep(int millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}





