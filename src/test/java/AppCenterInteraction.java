import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AppCenterInteraction extends ConnectionString {

    public WebElement signInButton;
    public WebElement accountType;
    public WebElement userName;
    public WebElement nextButton;
    public WebElement password;
    public WebElement finalSignInButton;
    public WebElement dashboardLogo;
    public WebElement winPure;
    public WebElement distributeButton;
    public WebElement releaseLink;
    public WebElement downloadButton;

    @Test(priority = 1)
    public void navigateToAppCenter() throws IOException {
        try {
            driver.navigate().to("https://appcenter.ms/");
            driver.manage().window().maximize();
            Assert.assertEquals("Visual Studio App Center | iOS, Android, Xamarin & React Native", driver.getTitle());
            System.out.println("App Center Title Verified");
        } catch (Exception ex) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\ErrorScrenshots\\testFail1.png"));
        }
    }

    @Test(priority = 2)
    public void clickingOnSingInButton() throws IOException {
        try {
            signInButton = driver.findElement(By.xpath("//a[@class='c-call-to-action secondary']"));
            System.out.println("Clicking on Sign In Button");
            signInButton.click();
        } catch (Exception ex) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\ErrorScrenshots\\testFail2.png"));
        }
    }

    @Test(priority = 3)
    public void clickingOnAccountType() throws IOException {
        try {
            accountType = driver.findElement(By.xpath("//body/div[@id='app']/div/div[@id='content']/div[@class='_2jgAulfPx']/div[@class='_4NgctJhvx']/div[@class='_4Bfk16ptx']/div[@class='_48Aw1dv8x']/div/div[@class='_7k6SBxWEx']/a[2]"));
            accountType.click();
            Assert.assertEquals("Sign in to your account", driver.getTitle());
            System.out.println("Login Area Title Verify");
            Thread.sleep(5000);
        } catch (Exception ex) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\ErrorScrenshots\\testFail3.png"));
        }
    }

    @Test(priority = 4)
    public void enteringEmailAddress() throws IOException {
        try {
            userName = driver.findElement(By.id("i0116"));
            System.out.println("Entering User Email Address");
            userName.sendKeys("syed.azfar@purevpn.com");
        } catch (Exception ex) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\ErrorScrenshots\\testFail4.png"));
        }
    }

    @Test(priority = 5)
    public void clickingOnNextButton() throws IOException {
        try {
            nextButton = driver.findElement(By.id("idSIButton9"));
            System.out.println("Clicking Next Button");
            nextButton.click();
        } catch (Exception ex) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\ErrorScrenshots\\testFail5.png"));
        }
    }

    @Test(priority = 6)
    public void enteringPassword() throws IOException {
        try {
            System.out.println("Entering Password");
            String pass = "[thethunder27]";
            Thread.sleep(3000);
            //driver.switchTo().activeElement();
            password = driver.findElement(By.xpath("//*[@id=\"i0118\"]"));
            password.sendKeys(pass);
            waitForControl(finalSignInButton = driver.findElement(By.id("idSIButton9")));
        } catch (Exception ex) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\ErrorScrenshots\\testFail6.png"));
        }
    }

    @Test(priority = 7, dependsOnMethods = {"enteringPassword"})
    public void clickingOnSignInFinalButton() throws IOException {
        try {
            Thread.sleep(5000);
            finalSignInButton = driver.findElement(By.id("idSIButton9"));
            finalSignInButton.click();
            Thread.sleep(9000);
            dashboardLogo = driver.findElement(By.xpath("//div[@class='_44xW5tefx _3hEGIAIGx _4VRKoDHBx IlREmqz0x _5N2hOvNFx']"));
            dashboardLogo.isDisplayed();
            System.out.println("User Login Successfully...!!!");
        } catch (Exception ex) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\ErrorScrenshots\\testFail7.png"));
        }
    }

    @Test(priority = 8)
    public void clickingOnUploadedApp() throws IOException {
        try {
            winPure = driver.findElement(By.xpath("//a[@class='_1zDwii8Lx _136WrIQ4x _6GyIR6yFx _3EG9ZwF1x _4pXFWAGkx _4JcVoPdKx tyoGf2CPx']"));
            System.out.println("Clicking on Uploaded App");
            winPure.click();
        } catch (Exception ex) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\ErrorScrenshots\\testFail8.png"));
        }
    }

    @Test(priority = 9)
    public void clickingOnDistributeOption() throws IOException {
        try {
            Thread.sleep(5000);
            distributeButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/span/div/div/div[2]/div[2]"));
            System.out.println("Clicking on Distribute Option");
            distributeButton.click();
            Thread.sleep(9000);
        } catch (Exception ex) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\ErrorScrenshots\\testFail9.png"));
        }
    }

    @Test(priority = 10)
    public void clickingOnReleaseLink() throws IOException {
        try {
            //driver.switchTo().activeElement();
            releaseLink = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[1]/div/div[3]/div/div/div[2]/div/div/div[2]/div/div[2]/div[3]"));
            System.out.println("Clicking on Release Link");
            releaseLink.click();
        } catch (Exception ex) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\ErrorScrenshots\\testFail10.png"));
        }
    }

    @Test(priority = 11)
    public void clickingOnDownloadButton() throws IOException {
        try {
            Thread.sleep(5000);
            //downloadButton = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M6 32v-2h1')]"));
            downloadButton = driver.findElement(By.xpath("//a[contains(@class,'_3k76urKAx _74rbA585x _3zf7sutyx _6hRTqZW0x _1iGRM5hHx _3tDpoKRvx _3tDpoKRvx _4TNVoStDx _1P6nIJX2x _7LsMfddpx _7bvYyZbfx')]"));
            System.out.println("Clicking on Download Button");
            downloadButton.click();
            Thread.sleep(5000);
//            driver.switchTo().activeElement();
//            WebElement popupDownload = driver.findElement(By.xpath("//a[@class='_4gUP4vh6x _4fixDQ17x']"));
//            popupDownload.click();
//            Thread.sleep(9000);
//            List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
//            driver.switchTo().window(browserTabs.get(1));
//            Thread.sleep(5000);
//            System.out.println("Check Point 1");
//            Assert.assertEquals("App Center", driver.getTitle());
//            System.out.println("Check Point 2");
//            WebElement btnDownload = driver.findElement(By.xpath("//span[contains(text(),'Download')]"));
//            btnDownload.click();
//            System.out.println("Check Point 3");
//            Thread.sleep(5000);
            driver.get("chrome://downloads/");
            System.out.println("Check Point 4");
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\ErrorScrenshots\\testFail11a.png"));
            Thread.sleep(30000);
        } catch (Exception ex) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("D:\\ErrorScrenshots\\testFail11b.png"));
        }
    }

    // WebDriverWait will wait until the certain condition to occur before proceeding further in the code
    public void waitForControl(WebElement element) {
        try {
            // This waits up to 30 seconds before throwing a TimeoutException or if it finds the element will return it in 0 - 15 seconds
            WebDriverWait wait = new WebDriverWait(driver, 30);
            // It will wait until the element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("Element is Clickable: " + element);
        } catch (Exception ex) {
            System.out.println("Timeout :: Element Not Load");
            try {
                System.out.println("Getting Page Source Issue - Found");
                System.out.println(driver.getPageSource());
            } catch (Exception nEx) {
                System.out.println("Getting Page Source Issue - Not Found");
                nEx.printStackTrace();
            }
        }
    }
}