package Tests;

import Pages.MainPage;
import Pages.TermOrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Parameterized.class)
public class TestOrderPage {
    private WebDriver driver;
    private final String name;
    private final String serName;
    private final String adres;
    private final String stationLocator;
    private final String phoneNumber;
    private final String date;
    private final String termLocator;
    private final String checkBox;
    private final String comment;

    public TestOrderPage(String name, String serName, String adres, String stationLocator, String phoneNumber, String date, String termLocator, String checkBox, String comment) {
        this.name = name;
        this.serName = serName;
        this.adres = adres;
        this.stationLocator = stationLocator;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.termLocator = termLocator;
        this.checkBox = checkBox;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Георгий", "Семенов","Брянск Ворошилова 20", "//ul/li[5]", "79373333333","15.05.2023", "//div[@class='Dropdown-option' and text()='сутки']", "//input[@id='black']", "абв"},
                {"Максим", "Минин","Москва Жукова 37", "//ul/li[4]", "79377899076","17.05.2023", "//div[@class='Dropdown-option' and text()='двое суток']", "//input[@id='grey']", "лд"}
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();


    }

    @Test
    public void getOrder(){
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru");

        //вызов шага для нажатия на кнопку заказа
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonOrder();

        //вызов шага для заполнения страницы "для кого самокат"
        TermOrderPage objWhoIsScooter = new TermOrderPage(driver);
        objWhoIsScooter.whoIsScooter(name, serName,adres, stationLocator,phoneNumber);

        //вызов шага для нажатия на кнопку далее
        TermOrderPage objTermOrderPage = new TermOrderPage(driver);
        objTermOrderPage.clickButtonNext();

        //шаг для заполнения страницы "про аренду"
        TermOrderPage objForRent = new TermOrderPage(driver);
        objForRent.forRent(date, termLocator, checkBox, comment);

        //метод для нажатия на кнопку заказа
        TermOrderPage objCLickButtonOrder = new TermOrderPage(driver);
        objCLickButtonOrder.clickButtonOrder();

        //метод для подтверждения заказа
        TermOrderPage objClickButtonConfirmation = new TermOrderPage(driver);
        objClickButtonConfirmation.clickButtonConfirmation();

        //ищем что модалка с номером заказа появилась
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']")).isDisplayed());


    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
