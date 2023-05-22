package Pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;




public class TermOrderPage {
    private final WebDriver driver;
    //локатор для поля имя
    private final  By userName = By.xpath("//input[@placeholder='* Имя']");
    //локатор для поля фамилия
    private final By userSerName = By.xpath("//input[@placeholder='* Фамилия']");
    //локатор для поля адрес
    private final By userAdres = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор для поля "станци метро"
    private final By fieldMetro = By.xpath("//div[@class='select-search']");
    //локатор для поля "номер телефона"
    private final By phone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");


    //локатор для станции метро Сокольники
    private final By metroStationSok = By.xpath("//ul/li[4]");
    //локатор для станции метро Лубянка
    private final By metroStationLub = By.xpath("//ul/li[5]");

    //локатор для кнопки далее
    private final By buttonNext = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");

    //локатор для поля когда привезти самокат
    private final By dateOfDelivery = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //локатора для поля "срок аренды"
    private final By termOrder = By.className("Dropdown-control");

    //локатор для поля срок аренды на сутки
    private final By termOrderOne = By.xpath("//div[@class='Dropdown-option' and text()='сутки']");
    //локатор для поля срок аренды на двое суток
    private final By termOrderTwo = By.xpath("//div[@class='Dropdown-option' and text()='двое суток']");

    //локатор для чекбокс "черный цвет"
    private final By checkBoxBlack = By.xpath("//input[@id='black']");
    //локатор для чекбокс "серый цвет"
    private final By checkBoxGrey = By.xpath("//input[@id='grey']");


    //локатор для поля комментарий
    private final By userComment = By.xpath("//input[@placeholder='Комментарий для курьера']");

    //локатор для кнопки заказать
    private final By buttonOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    //локатор для кнопки подтверждение заказа
    private final By confirmationButtonOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //локатор для модалки с номером заказа
    private final By modalOrderNumber = By.xpath("//div[@class='Order_Modal__YZ-d3']");


    public TermOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод для заполенения поля Имя
    public void setName(String name) {
        driver.findElement(userName).sendKeys(name);
    }

    //метод для заполнения поля фамилия
    public void setSerName(String serName) {
        driver.findElement(userSerName).sendKeys(serName);
    }

    //метод для заполнения поля адрес
    public void setAdress(String adress) {
        driver.findElement(userAdres).sendKeys(adress);
    }

    //метол для выбора поля " станция метро "
    public void metroStation() {
        driver.findElement(fieldMetro).click();
    }

    //шаг дя выбора станции метро "сокольники"
    public void getStationSok() {
        metroStation();
        driver.findElement(metroStationSok).click();
    }

    //шаг дя выбора станции метро "лубянка"
    public void getStationLub() {
        metroStation();
        driver.findElement(metroStationLub).click();
    }

    //метод для заполнения поля "номер телефона"
    public void setPhoneNumber(String number) {
        driver.findElement(phone).sendKeys(number);
    }

    //метод для нажатия на кнопку далее
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    //метод для выбора даты
    public void getDateOfDelivery(String date) {
        driver.findElement(dateOfDelivery).sendKeys(date, Keys.ENTER);
    }

    //метод для нажатия на поле срок аренды
    public void clickTermOfDelivery() {
        driver.findElement(termOrder).click();
    }

    //шаг для выбора срока доставки на "сутки"
    public void getTermOne() {
        clickTermOfDelivery();
        driver.findElement(termOrderOne).click();
    }

    //шаг для выбора срока доставки на "двое суток"
    public void getTermTwo() {
        clickTermOfDelivery();
        driver.findElement(termOrderTwo).click();
    }

    //шаг для нажатия на черный чекбокс
    public void clickBlackCheckBox() {
        driver.findElement(checkBoxBlack).click();
    }

    //шаг для нажатия на серый чекбокс
    public void clickGreyCheckBox() {
        driver.findElement(checkBoxGrey).click();
    }

    //заполнение поля комментарий
    public void setComment(String comment) {
        driver.findElement(userComment).sendKeys(comment);
    }

    //шаг для заполнения страницы для кого самокат
    public void whoIsScooterSok(String name, String serName, String adress, String number) {
        setName(name);
        setSerName(serName);
        setAdress(adress);
        getStationSok();
        setPhoneNumber(number);
    }

    public void whoIsScooterLub(String name, String serName, String adress, String number) {
        setName(name);
        setSerName(serName);
        setAdress(adress);
        getStationLub();
        setPhoneNumber(number);
    }

    //шаг для заполнения страницы про аренду
    public void aboutRentOne(String date, String comment) {
        getDateOfDelivery(date);
        getTermOne();
        clickBlackCheckBox();
        setComment(comment);
    }

    public void aboutRentTwo(String date, String comment) {
        getDateOfDelivery(date);
        getTermTwo();
        clickGreyCheckBox();
        setComment(comment);
    }

    //метод для нажатия на кноку заказать
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    //метод для подтверждения заказа
    public void clickButtonConfirmation() {
        driver.findElement(confirmationButtonOrder).click();
    }

    public void assertModalWindow() {
        Assert.assertTrue(driver.findElement(modalOrderNumber).isDisplayed());
    }


}
