package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

// Главная страница
public class HotProdPage extends BasePage {
    public HotProdPage(WebDriver driver) {
        super(driver);
    }

    // кнопка Горящие товары в хэдере
    @FindBy(xpath  = "//a[text() = 'Горящие товары']")
    private WebElement hotProdButton;

    // Все горящие товары на странице
    @FindBy(xpath  = "//div[@class='rpv6pr']")
    private List<WebElement> hotProdItems;


//-----------------------------------------------------------------

    // Нажимаем на Горящие товары в хэдере
    public void clickToHotProducts() {
        wait.until(ExpectedConditions.visibilityOf(hotProdButton)).click();
    }

    // Сохраняем кол-во горящих товаров
    public int getCountHotItems() {
        return hotProdItems.size();
    }
}


