package org.example.tanami.payment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PaymentTransactionTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String BASE_URL = "https://www.example.com/payment";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Fintech_Payment\\chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSuccessfulPaymentTransaction() {
        driver.get(BASE_URL);



        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
        amountInput.sendKeys("1000");

        WebElement currencySelect = driver.findElement(By.id("currency"));
        currencySelect.sendKeys("BHD");

        WebElement cardNumberInput = driver.findElement(By.id("cardNumber"));
        cardNumberInput.sendKeys("1234567890123456");

        WebElement expiryDateInput = driver.findElement(By.id("expiryDate"));
        expiryDateInput.sendKeys("12/27");

        WebElement cvvInput = driver.findElement(By.id("cvv"));
        cvvInput.sendKeys("123");

        WebElement payButton = driver.findElement(By.id("payButton"));
        payButton.click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));
        assertTrue(successMessage.isDisplayed(), "Success message should be displayed.");
        assertEquals(successMessage.getText(), "Payment successful!", "Success message text mismatch.");

        WebElement paymentAmount = driver.findElement(By.id("paymentAmount"));
        assertEquals(paymentAmount.getText(), "$1000.00", "payment amount mismatch");
    }
}