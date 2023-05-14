package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;






public class TermOrderPage {
    private WebDriver driver;
    //локатор для поля имя
    private By userName = By.xpath("//input[@placeholder='* Имя']");
    //локатор для поля фамилия
    private By userSerName = By.xpath("//input[@placeholder='* Фамилия']");
    //локатор для поля адрес
    private By userAdres = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор для поля "станци метро"
    private By fieldMetro = By.xpath("//div[@class='select-search']");
    //локатор для поля "номер телефона"
    private By phone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //локатор для поля станция метро
    private By fieldMetroStation = By.xpath("//div[@class='select-search']");

    //локатор для станции метро
    private By metroStation = By.xpath("//ul/li[5]");

    //локатор для кнопки далее
    private By buttonNext = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");

    //локатор для поля когда привезти самокат
    private By dateOfDelivery = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    //локатор для поля срок аренды
    private By termOrder = By.className("Dropdown-placeholder");

    //локатор для поля комментарий
    private By userComment = By.xpath("//input[@placeholder='Комментарий для курьера']");

    //локатор для кнопки заказать
    private By buttonOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    //локатор для кнопки подтверждение заказа
    private By confirmationButtonOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");


    public TermOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //шаг для заполнения страницы "для кого самокат"
    public void whoIsScooter(String name, String serName, String adres, String stationLocator, String phoneNumber){
        driver.findElement(userName).sendKeys(name);
        driver.findElement(userSerName).sendKeys(serName);
        driver.findElement(userAdres).sendKeys(adres);
        driver.findElement(fieldMetro).click();
        driver.findElement(By.xpath(stationLocator)).click();
        driver.findElement(phone).sendKeys(phoneNumber);
    }

    //метод для нажатия на кнопку далее
    public void clickButtonNext(){
        driver.findElement(buttonNext).click();
    }


    //шаг для заполнения страницы "про аренду"
    public void forRent(String date, String termLocator, String checkBox, String comment){
        driver.findElement(dateOfDelivery).sendKeys(date, Keys.ENTER);
        driver.findElement(termOrder).click();
        driver.findElement(By.xpath(termLocator)).click();
        driver.findElement(By.xpath(checkBox)).click();
        driver.findElement(userComment).sendKeys(comment);

    }


    //метод для нажатия на кноку заказать
    public void clickButtonOrder(){
        driver.findElement(buttonOrder).click();
    }
    //метод для подтверждения заказа
    public void clickButtonConfirmation(){
        driver.findElement(confirmationButtonOrder).click();
    }


}
