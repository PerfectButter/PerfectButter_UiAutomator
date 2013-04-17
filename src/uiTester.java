import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class uiTester extends UiAutomatorTestCase {
  
  public static void startTest() {
    int numTests = 100;
    
    while(numTests != 0) {
      goToAboutPhone();
      launchPerfectButter();
      romOptions();
      backup();
      restore();
      numTests--;
    }
  }
  
  public static void goToAboutPhone() {
    
  }
  
  public static void launchPerfectButter() {
    
  }
  
  public static void romOptions() {
    
  }
  
  public static void backup() {
    
  }
  
  public static void restore() {
    
  }

}
