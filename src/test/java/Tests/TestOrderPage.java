package Tests;

import Pages.MainPage;
import Pages.TermOrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;





public class TestOrderPage {
    private WebDriver driver;
    @Before
    public void startUp() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void getOrderOne(){
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru");
        //вызов шага для нажатия на кнопку заказа
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonOrder();

        //вызов шага для заполнения страницы "для кого самокат"
        TermOrderPage objOrderOne = new TermOrderPage(driver);
        objOrderOne.whoIsScooterSok("Георгий", "Семенов", "Брянск Ворошилова 20", "79373333333");
        //вызов шага для нажатия на кнопку далее
        objOrderOne.clickButtonNext();
        //шаг для заполнения страницы "про аренду"
        objOrderOne.aboutRentOne("24.05.2023", "привет");
        //метод для нажатия на кнопку заказа
        objOrderOne.clickButtonOrder();
        //метод для подтверждения заказа
        objOrderOne.clickButtonConfirmation();
        //ищем что модалка с номером заказа появилась
        objOrderOne.assertModalWindow();

        driver.quit();
    }

    @Test
    public void getOrderTwo(){
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickButtonOrder();

        TermOrderPage objOrderTwo = new TermOrderPage(driver);
        objOrderTwo.whoIsScooterLub("Андрей", "Лапин", "Москва Жукова 15", "79377777777");

        objOrderTwo.clickButtonNext();

        objOrderTwo.aboutRentTwo("26.05.2023", "пока");

        objOrderTwo.clickButtonOrder();

        objOrderTwo.clickButtonConfirmation();

        objOrderTwo.assertModalWindow();

        driver.quit();
    }

}
