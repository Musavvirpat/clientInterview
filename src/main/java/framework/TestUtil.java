package framework;

import org.openqa.selenium.WebDriver;

public class TestUtil {

    private WebDriver driver;

    public void setDriver(WebDriver driver)
    {
        this.driver=driver;
    }

    public WebDriver getDriver()
    {
        return driver;
    }
    
   
}
