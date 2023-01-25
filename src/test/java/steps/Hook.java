package steps;

import framework.Reusable;
import framework.TestUtil;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Hook {

    static //This gets executed only once per execution
    {
        try
        {
            Runtime.getRuntime().exec("TASKKILL -f -im chrome.exe"); //Kills all the existing chrome browsers
            Runtime.getRuntime().exec("TASKKILL -f -im chromedriver.exe"); //Kills all the existing chrome driver objects
        }

        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    TestUtil testUtil=new TestUtil();

    @Before
    public void beforeTestCase(Scenario sc)
    {
        if(Reusable.testUtilThread.size()==0)
        {
            WebDriver driver;
            System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "TestLog.txt");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

            ChromeOptions options=new ChromeOptions();

            options.setExperimentalOption("useAutomationExtension", false);

            options.addArguments("--silent");

            options.addArguments("--disable-cache");

            options.addArguments("--disable-notifications");

            options.addArguments("--disable-features=VizDisplayCompositor");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-browser-side-navigation");

            Map<String, Object> preferences = new HashMap<String, Object>();

            preferences.put("download.prompt_for_download", false);
            preferences.put("credentials_enable_service", false);
            preferences.put("profile.password_manager_enabled", false);

            options.setExperimentalOption("prefs", preferences);
            options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
            options.addArguments("start-maximized");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
            driver.manage().deleteAllCookies();

            testUtil.setDriver(driver);
            Reusable.testUtilThread.add(testUtil);
        }

    }

    @BeforeStep
    public void beforeStep(Scenario sc)
    {
        System.out.println("Before Every Test Step");
    }

    @AfterStep
    public void afterStep(Scenario sc)
    {
        byte[] bytes=((TakesScreenshot)Reusable.testUtilThread.get(0).getDriver()).getScreenshotAs(OutputType.BYTES);
        sc.attach(bytes,"image/png","Screenshot Name");
    }

    @After
    public void afterTest(Scenario sc)
    {
        System.out.println(sc.getStatus());
    }
}
