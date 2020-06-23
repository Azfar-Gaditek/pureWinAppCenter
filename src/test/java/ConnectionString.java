import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ConnectionString {
    public static WebDriver driver;

    @BeforeClass
    public void initialization() {
        try {
            System.out.println("Setup Firefox Driver");
            System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\bin\\geckodriver.exe");
            System.out.println("Initialize Firefox Driver");
            driver = new FirefoxDriver();
/*            System.out.println("Setup Chrome Driver");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            System.out.println("Setup Chrome Options");
            options.addArguments("--incognito");
            //options.addArguments("--headless");
            System.out.println("Initialize Chrome Driver in Incognito Mode");
            driver = new ChromeDriver(options);*/
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