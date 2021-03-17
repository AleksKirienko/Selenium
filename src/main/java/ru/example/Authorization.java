package ru.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Authorization {

    public static Properties properties;
    public static WebDriver driver = new ChromeDriver();

    public static void test() throws IOException {
        properties = new Properties();
        properties.load(new FileReader("src/main/resources/app.properties"));

        driver.get(Main.url);

        System.out.println("Успешный переход на страницу");

        WebElement login = driver.findElement(By.id("username"));
        login.click();
        login.sendKeys(properties.getProperty("login"));
        System.out.println("Введен логин");

        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys(properties.getProperty("password"));
        System.out.println("Введен пароль");

        WebElement signIn = driver.findElement(By.id("loginbtn"));
        signIn.click();

        List<WebElement> error = driver.findElements(By.id("yui_3_17_2_1_1615973571902_28"));

        if (error.size() > 0)
            System.out.println("Вход выполнен нажатием кнопки.");
        else System.out.println("Неверный логин или пароль, попробуйте заново.");

    }

}
