package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



@RunWith(Parameterized.class)
public class TestMainPage {
    private final String faqLocator;
    private final String faqMessage;
    private final String faqText;


    public TestMainPage(String faqLocator, String faqMessage, String faqText) {
        this.faqLocator = faqLocator;
        this.faqMessage = faqMessage;
        this.faqText = faqText;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"//*[@id='accordion__heading-0']", "//*[@id='accordion__panel-0']", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"//*[@id='accordion__heading-1']", "//*[@id='accordion__panel-1']", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"//*[@id='accordion__heading-2']", "//*[@id='accordion__panel-2']", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"//*[@id='accordion__heading-3']", "//*[@id='accordion__panel-3']", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"//*[@id='accordion__heading-4']", "//*[@id='accordion__panel-4']", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"//*[@id='accordion__heading-5']", "//*[@id='accordion__panel-5']", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"//*[@id='accordion__heading-6']", "//*[@id='accordion__panel-6']", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"//*[@id='accordion__heading-7']", "//*[@id='accordion__panel-7']", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };

    }
    @Before
    public void startUp() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

    }
    @Test
    public void getFaqText(){
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru");
        WebElement element = driver.findElement(By.xpath(faqLocator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(faqLocator)).click();
        String textMessage = driver.findElement(By.xpath(faqMessage)).getText();
        Assert.assertEquals(faqText, textMessage);
        driver.quit();
    }

}
