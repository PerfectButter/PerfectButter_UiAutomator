package com.perfectbutter.uiautomator;

import android.util.Log;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class UiTester extends UiAutomatorTestCase {
  
  private static final String TAG = "Perfect Butter Ui Automator";
  private int numTests = 100;
  
  /**
   * Main method that will execute the test
   * @throws UiObjectNotFoundException
   */
  public void testPerfectButter() throws UiObjectNotFoundException {
    
    UiDevice.getInstance().pressHome();
    
    while(numTests != 0) {
      goToAboutPhone();
      launchPerfectButter();
      romOptions();
      backup();
      restore();
      numTests--;
    }
  }
  
  /**
   * Navigate to About Phone through the notification shade
   * @throws UiObjectNotFoundException
   */
  private void goToAboutPhone() throws UiObjectNotFoundException {
    Log.d(TAG, "Going to About Phone to view Project Name");
    
    Log.d(TAG,  "Launching Settings App from Notification shade");
    PhoneUtilities.goToSettings();
    
    UiScrollable settingsView = new UiScrollable(new UiSelector().scrollable(true));
    
    UiObject aboutPhone = settingsView.getChildByText(new UiSelector()
    .className(android.widget.TextView.class.getName()), "About phone");
    
    aboutPhone.clickAndWaitForNewWindow();
    
    UiScrollable aboutPhoneView = new UiScrollable(new UiSelector().scrollable(true));
    
    Log.d(TAG, "Scroll to bottom of screen to show ROM version & Build number");
    aboutPhoneView.scrollToEnd(1);
    
    Log.d(TAG, "Delay to allow demo to view the information about ROM");
    PhoneUtilities.delay(5);
    
    Log.d(TAG, "Press home button to go back to homescreen");
    UiDevice.getInstance().pressHome();
  }
  
  /**
   * Launch PerfectButterBackup application
   */
  private static void launchPerfectButter() throws UiObjectNotFoundException {
    
    Log.d(TAG, "Launch PerfectButterBackup App");
    PhoneUtilities.goToAppDrawer();
        
    UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
    appViews.setAsHorizontalList();
    
    UiObject perfectButterApp = appViews.getChildByText(new UiSelector()
    .className(android.widget.TextView.class.getName()), "Perfect Butter Backup");
    
    perfectButterApp.clickAndWaitForNewWindow(); 
  }
  
  /**
   * Toggle through Rom Options
   */
  private static void romOptions() throws UiObjectNotFoundException {
    
  }
  
  /**
   * Toggle Backup Options
   */
  private static void backup() throws UiObjectNotFoundException {
    
  }
  
  /**
   * Toggle Restore options
   */
  private static void restore() throws UiObjectNotFoundException {
    
  }
}
