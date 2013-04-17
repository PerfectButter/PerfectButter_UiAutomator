package com.perfectbutter.uiautomator;

import android.util.Log;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class UiTester extends UiAutomatorTestCase {
  
  private static String TAG = "Perfect Butter Ui Automator";
  private int numTests = 100;
  
  /**
   * Main method that will execute the test
   * @throws UiObjectNotFoundException
   */
  public void testPerectButter() throws UiObjectNotFoundException {
    
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
    
    Log.d(TAG, "Opening notification shade");
    openNotificationShade();
    
    UiObject quickSettings = new UiObject(new UiSelector().description("Quick settings."));
    quickSettings.clickAndWaitForNewWindow();
    
    UiObject settings = new UiObject(new UiSelector().text("Settings"));
    settings.clickAndWaitForNewWindow();
    
    UiScrollable settingsView = new UiScrollable(new UiSelector().scrollable(true));
    
    UiObject aboutPhone = settingsView.getChildByText(new UiSelector()
    .className(android.widget.TextView.class.getName()), "About phone");
    
    aboutPhone.clickAndWaitForNewWindow();
    
    UiScrollable aboutPhoneView = new UiScrollable(new UiSelector().scrollable(true));
    
    aboutPhoneView.scrollToEnd(1);
    delay(5);
    
  }
  
  /**
   * Launch PerfectButterBackup application
   */
  private static void launchPerfectButter() {
    
  }
  
  /**
   * Toggle through Rom Options
   */
  private static void romOptions() {
    
  }
  
  /**
   * Toggle Backup Options
   */
  private static void backup() {
    
  }
  
  /**
   * Toggle Restore options
   */
  private static void restore() {
    
  }
  
  /**
   * Method to open notification shade with swiping motion
   */
  private void openNotificationShade() {
    int deviceWidth = UiDevice.getInstance().getDisplayWidth();
    int deviceHeight = UiDevice.getInstance().getDisplayHeight();
    
    UiDevice.getInstance().swipe(deviceWidth / 2, 0, deviceWidth / 2, deviceHeight, 20); 
  }
  
  /**
   * Allow to delay new actions from being done.
   * This is strictly for demo purpose as we would like certain parts to be
   * viewied for a certain amount of time before proceeding to next method.
   * @param seconds
   */
  private static void delay(int seconds) {
    try {
      Thread.sleep(seconds * 1000); //sleep is in milliseconds. convert to seconds
      } catch (InterruptedException ie) {
      ie.printStackTrace();
    }
  }
}
