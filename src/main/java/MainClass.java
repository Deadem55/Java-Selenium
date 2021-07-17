import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\deade\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    // Выставить время ожидания (количество, единица измерения)

        driver.manage().window().setSize(new Dimension(1000, 800));   // Задать своё разрешение окна браузера в котором будет происходить выполнение
        driver.manage().window().maximize();    // Открыть браузер в окне на весь экран

//        driver.get("https://www.google.ru/");
//        driver.navigate().to("https://www.selenium.dev/");
//        driver.navigate().to("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();    // Перезагрузить страницу
//        WebElement link = driver.findElement(By.linkText("Войти"));
//        WebElement link2 = driver.findElement(By.partialLinkText("Свежие"));
//        WebElement searchField = driver.findElement(By.name("search"));
//        WebElement searchButton = driver.findElement(By.className("searchButton"));
//        WebElement li = driver.findElement(By.id("ca-viewsource"));
//        WebElement input = driver.findElement(By.tagName("input"));
//        WebElement goToMain = driver.findElement(By.cssSelector("#p-logo > a"));
//        WebElement linkToMain = driver.findElement(By.xpath("//*[@id=\"Добро_пожаловать_в_Википедию,\"]/a"));

        driver.get("https://github.com/");

        WebElement button = driver.findElement(By.xpath("//form[@class='mx-auto mx-md-0 col-5-max js-signup-form position-relative z-2']//button"));
        System.out.println("Button text is: " + button.getText());

        if (button.getText().equals("Sign up for GitHub")) {    // Сравнить текст с кнопки со значением("")
            System.out.println("Success!");
        } else System.out.println("Fail!");

        button.submit();

        driver.navigate().back();
//        WebElement menu = driver.findElement(By.xpath("//button[@class='btn-link d-lg-none mt-1 js-details-target']"));
//        menu.click();

        WebElement signIn = driver.findElement(By.xpath("//a[@class='HeaderMenu-link flex-shrink-0 no-underline']"));
        signIn.click();

        System.out.println(driver.getTitle());  // Вывести в консоль Наименование вкладки браузера
        System.out.println(driver.getCurrentUrl()); // Вывести в консоль URL страницы

        driver.get("https://ru-ru.facebook.com/");
        WebElement createAccount = driver.findElement(By.xpath("//a[contains(@class, \"_6lti _4jy6 _4jy2 select\")]"));
        createAccount.click();

        System.out.println(driver.getTitle());  // Вывести в консоль Наименование вкладки браузера
        System.out.println(driver.getCurrentUrl()); // Вывести в консоль URL страницы

        driver.navigate().to("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");
        WebElement link = driver.findElement(By.xpath("//a[@title='Место, где можно получить справку']"));
        System.out.println(link.getText());
        link.click();

        driver.navigate().to("https://github.com");
        WebElement teamLink = driver.findElement(By.xpath("//nav[@class='mt-0 px-3 px-lg-0 mb-5 mb-lg-0']/ul/li[2]/a[contains(@class, 'HeaderMenu-link no-underline')]"));
        System.out.println(teamLink.getText());
        teamLink.click();

//        driver.quit();  // Закрывать браузер и завершать работу драйвера (дописывать в конце теста - всегда)

    }
}
