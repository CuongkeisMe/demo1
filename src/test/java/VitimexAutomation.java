import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VitimexAutomation {

    @Test
    public void testRegisterAndLogin() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://vitimex.com.vn/");

        // Đăng ký tài khoản mới
        wait.until(d -> d.findElement(By.linkText("Đăng ký"))).click();
        wait.until(d -> d.findElement(By.id("firstName"))).sendKeys("Nguyen");
        driver.findElement(By.id("lastName")).sendKeys("Trang");
        String email = "test" + System.currentTimeMillis() + "@gmail.com";
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("Test@1234");
        driver.findElement(By.id("confirmPassword")).sendKeys("Test@1234");
        driver.findElement(By.id("registerButton")).click();

        // Chờ trang chuyển hướng & kiểm tra đăng ký thành công
        wait.until(d -> d.getCurrentUrl().contains("account"));
        assertTrue(driver.getCurrentUrl().contains("account"));

        // Đăng xuất
        wait.until(d -> d.findElement(By.linkText("Đăng xuất"))).click();

        // Đăng nhập lại
        wait.until(d -> d.findElement(By.linkText("Đăng nhập"))).click();
        wait.until(d -> d.findElement(By.id("email"))).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("Test@1234");
        driver.findElement(By.id("loginButton")).click();

        // Chờ trang chuyển hướng & kiểm tra đăng nhập thành công
        wait.until(d -> d.getCurrentUrl().contains("account"));
        assertTrue(driver.getCurrentUrl().contains("account"));

        driver.quit();
    }
}
