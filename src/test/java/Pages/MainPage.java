package Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {

    private WebDriver driver;

    //локаторы для списка
    private By list = By.xpath("//div[@data-accordion-component='AccordionItemButton']");
    //локаторы для сообщений в списке

    private By listMessage = By.xpath("//div[@data-accordion-component='AccordionItemPanel']");

    private By buttonOrder = By.xpath("//button[@class='Button_Button__ra12g']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButtonOrder(){
        driver.findElement(buttonOrder).click();
    }

    public void getAssertMessage(){
        List<WebElement> lists = driver.findElements(list);
        List<WebElement> listMessages = driver.findElements(listMessage);
        String [] message = {
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области."

        };

        for (int i =0; i < lists.size(); i ++){
            lists.get(i).click();
            String text = listMessages.get(i).getText();
            Assert.assertEquals(text, message[i]);
        }
    }

}