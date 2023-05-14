package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private By buttonOrder = By.xpath("//button[@class='Button_Button__ra12g']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButtonOrder(){
        driver.findElement(buttonOrder).click();
    }

}