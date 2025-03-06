import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class GoogleSearchTes {
    public static void main(String[] args) {
        // Khởi tạo WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Thay đổi đường dẫn
        WebDriver driver = new ChromeDriver();

        try {
            // Mở trang Google
            driver.get("https://www.google.com");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Tìm hộp tìm kiếm và nhập từ khóa
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");
            searchBox.submit(); // Gửi form tìm kiếm

            // Đợi kết quả hiển thị và in ra tiêu đề trang
            Thread.sleep(2000);
            System.out.println("Tiêu đề trang: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
