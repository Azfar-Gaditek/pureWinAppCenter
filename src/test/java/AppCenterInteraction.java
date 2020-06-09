import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    public void navigateToAppCenter() {
        driver.get("https://appcenter.ms/");
        driver.manage().window().maximize();
        Assert.assertEquals("Visual Studio App Center | iOS, Android, Xamarin & React Native", driver.getTitle());
        System.out.println("App Center Title Verified");
    }

    @Test(priority = 2)
    public void clickingOnSingInButton() {
        signInButton = driver.findElement(By.xpath("//a[@class='c-call-to-action secondary']"));
        System.out.println("Clicking on Sign In Button");
        signInButton.click();
    }

    @Test(priority = 3)
    public void clickingOnAccountType() throws InterruptedException {
        accountType = driver.findElement(By.xpath("//body/div[@id='app']/div/div[@id='content']/div[@class='_2jgAulfPx']/div[@class='_4NgctJhvx']/div[@class='_4Bfk16ptx']/div[@class='_48Aw1dv8x']/div/div[@class='_7k6SBxWEx']/a[2]"));
        accountType.click();
        Assert.assertEquals("Sign in to your account", driver.getTitle());
        System.out.println("Login Area Title Verify");
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void enteringEmailAddress() {
        userName = driver.findElement(By.id("i0116"));
        System.out.println("Entering User Email Address");
        userName.sendKeys("syed.azfar@purevpn.com");
    }

    @Test(priority = 5)
    public void clickingOnNextButton() {
        nextButton = driver.findElement(By.id("idSIButton9"));
        System.out.println("Clicking Next Button");
        nextButton.click();
    }

    @Test(priority = 6)
    public void enteringPassword() throws InterruptedException {
        System.out.println("Entering Password");
        String pass = "[thethunder27]";
        Thread.sleep(3000);
        //driver.switchTo().activeElement();
        password = driver.findElement(By.xpath("//*[@id=\"i0118\"]"));
        System.out.println("Test Check Point 1");
        password.sendKeys(pass);
        System.out.println("Test Check Point 2");
        waitForControl(finalSignInButton = driver.findElement(By.id("idSIButton9")));
    }

    @Test(priority = 7, dependsOnMethods = {"enteringPassword"})
    public void clickingOnSignInFinalButton() throws InterruptedException {
        Thread.sleep(5000);
        finalSignInButton = driver.findElement(By.id("idSIButton9"));
        finalSignInButton.click();
        Thread.sleep(5000);
        dashboardLogo = driver.findElement(By.xpath("//div[@class='_44xW5tefx _3hEGIAIGx _4VRKoDHBx IlREmqz0x _5N2hOvNFx']"));
        dashboardLogo.isDisplayed();
        System.out.println("User Login Successfully...!!!");
    }

    @Test(priority = 8)
    public void clickingOnUploadedApp() {
        winPure = driver.findElement(By.xpath("//a[@class='_1zDwii8Lx _136WrIQ4x _6GyIR6yFx _3EG9ZwF1x _4pXFWAGkx _4JcVoPdKx tyoGf2CPx']"));
        System.out.println("Clicking on Uploaded App");
        winPure.click();
    }

    @Test(priority = 9)
    public void clickingOnDistributeOption() throws InterruptedException {
        Thread.sleep(5000);
        distributeButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/span/div/div/div[2]/div[2]"));
        System.out.println("Clicking on Distribute Option");
        distributeButton.click();
        Thread.sleep(5000);
    }

    @Test(priority = 10)
    public void clickingOnReleaseLink(){
        driver.switchTo().activeElement();
        releaseLink = driver.findElement(By.xpath("//body/div[@id='app']/div[contains(@class,'_6CY9PqIJx')]/div[@id='layout-viewport']/div[contains(@class,'_3Yoa7i6Cx _1ZSuYu4hx _3yG0Wp9xx _1ZSuYu4hx')]/div[@id='page-in-primary']/div[contains(@class,'_4hta4qYox')]/div[contains(@class,'_6dNIBX5mx krhTRqZvx _5RYKG3jbx _6dNIBX5mx _5BUBEsgkx _6vC3eK2xx edgeToEdge')]/div[contains(@class,'_3ntfDwIyx _5sJtSbnSx _7LsMfddpx _15KxxJDxx _5iLGAshSx _4FHRj32Ux _6tqQ8rWSx')]/div[contains(@class,'_6dNIBX5mx krhTRqZvx')]/div/div[2]"));
        System.out.println("Clicking On Release Link");
        releaseLink.click();
    }

    @Test(priority = 11)
    public void clickingOnDownloadButton() throws InterruptedException {
        Thread.sleep(5000);
        downloadButton = driver.findElement(By.xpath("//a[contains(@class,'_3k76urKAx _74rbA585x _3zf7sutyx _6hRTqZW0x _1iGRM5hHx _3tDpoKRvx _3tDpoKRvx _4TNVoStDx _1P6nIJX2x _7LsMfddpx _7bvYyZbfx')]"));
        System.out.println("Clicking on Download Button");
        downloadButton.click();
        Thread.sleep(5000);
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