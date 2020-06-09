import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class ConnectionString {
    public static WebDriver driver;

    @BeforeClass
    public void initialization() {
        try {
            System.out.println("Setup Chrome Driver");
            WebDriverManager.chromedriver().setup();
            System.out.println("Setup Chrome Options");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            //options.addArguments("--headless");
            System.out.println("Initialize Chrome Driver with Headless Property");
            driver = new ChromeDriver(options);
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
    }

    @AfterClass
    public void teardown() {
        try {
            System.out.println("Closing Driver");
            //driver.close();
            System.out.println("Quiting Driver");
            //driver.quit();
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
    }
}