import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class ConnectionString {
    public static WebDriver driver;
    File myFile;

    @BeforeClass
    public void initialization() {
        try {
/*            System.out.println("Setup Firefox Driver");
            System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\bin\\geckodriver.exe");
            System.out.println("Initialize Firefox Driver");
            driver = new FirefoxDriver();*/
            System.out.println("Setup Opera Driver");
            WebDriverManager.operadriver().setup();
            //ChromeOptions options = new ChromeOptions();
            //System.out.println("Setup Chrome Options");
            //options.addArguments("--incognito");
            //options.addArguments("--headless");
            driver = new OperaDriver();
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
    }

    @AfterClass
    public void teardown() {
        try {
            System.out.println("Unzip PureVPN Downloaded Zip File");
            executeBatchUnZipPureVPNDownloadedFile();
            System.out.println("Closing Driver");
            driver.close();
            System.out.println("Quiting Driver");
            driver.quit();
        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
    }

    public void executeBatchUnZipPureVPNDownloadedFile() {
        String batFilePath = "D:\\Backup\\appCenter_purewin\\src\\test\\java\\unZipPureVPNDownloadedFile.bat";
        if ((Desktop.isDesktopSupported())) {
            try {
                myFile = new File(batFilePath);
                Desktop.getDesktop().open(myFile);
                System.out.println("unZip PureVPN Downloaded File");
            } catch (IOException | IllegalArgumentException ex) {
                System.err.println("Either there is no application found which is associated " +
                        "with \\n the file you want to work with or the file doesn't exist! \\n\\n" + batFilePath);
            }
        }
    }
}