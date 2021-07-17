import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WikiTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\deade\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    // Выставить время ожидания (количество, единица измерения)
        driver.manage().window().maximize();
        driver.get("https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");

//        WebElement link = driver.findElement(By.linkText("Войти")); // По тексту ссылки
//        WebElement link2 = driver.findElement(By.partialLinkText("Свежие"));    // По частичному тексту ссылки
//        WebElement searchField = driver.findElement(By.name("search")); // По имени
//        WebElement searchButton = driver.findElement(By.className("searchButton")); // По имени класса
//        WebElement li = driver.findElement(By.id("ca-viewsource")); // По id
//        WebElement input = driver.findElement(By.tagName("input")); // По имени тэга
//        WebElement goToMain = driver.findElement(By.cssSelector("#p-logo > a"));    // По css (selector)
//        WebElement linkToMain = driver.findElement(By.xpath("//*[@id=\"Добро_пожаловать_в_Википедию,\"]/a"));   // По XPath
//        driver.findElement(By.xpath("//input[@id='searchButton']")).click();

        WebElement searchInput = driver.findElement(By.xpath("//Input[@id='searchInput']"));
        WebElement searchButton = driver.findElement(By.xpath("//Input[@id='searchButton']"));


        searchInput.sendKeys("Текст вводимый в поле локатора");   // Ввод текста в поле локатора .sendKeys("Значение вводимое в поле локатора"
        searchButton.click();
        WebElement reSearchInput = driver.findElement(By.xpath("//div[@id='searchText']/input"));
//        reSearchInput.getAttribute("value");    // Получить значение атрибута("тип атрибута) .getAttribute("id/class/type/name/title/value/etc")
        System.out.println("В поле поиска до очистки был введён текст: " + reSearchInput.getAttribute("value"));
        reSearchInput.clear();  // Очистить поле локатора

        System.out.println(driver.getTitle());  // Вывести в консоль Наименование вкладки браузера
        System.out.println(driver.getCurrentUrl()); // Вывести в консоль URL страницы

        driver.quit();

    }
}
