package framework;

import org.openqa.selenium.WebDriver;


import java.util.ArrayList;
import java.util.List;

public class Reusable {

    public static List<TestUtil> testUtilThread=new ArrayList<TestUtil>();

    protected TestUtil testUtil=testUtilThread.get(0);
    protected WebDriver driver= testUtil.getDriver();
   
    
  
}
