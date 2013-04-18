package com.perfectbutter.uiautomator;

import android.util.Log;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

/**
 * The PhoneUtilities class will handle all the basic functions a user
 * can do on the phone through the OS.
 * User will be able to do the following:
 * - Pull down notification shade
 * - Launch App Drawer
 * 
 * @author ctugangui
 *
 */
public class PhoneUtilities {
  
  private static final String TAG = "PhoneUtilies";
  
  /**
   * Method to open notification shade with swiping motion
   */
  private static void openNotificationShade() {
    int deviceWidth = UiDevice.getInstance().getDisplayWidth();
    int deviceHeight = UiDevice.getInstance().getDisplayHeight();
    
    UiDevice.getInstance().swipe(deviceWidth / 2, 0, deviceWidth / 2, deviceHeight, 20); 
  }
  
  /**
   * This will launch the OS Settings app through the Notification Shade
   * @throws UiObjectNotFoundException
   */
  public static void goToSettings() throws UiObjectNotFoundException {
    openNotificationShade();
    
    UiObject quickSettings = new UiObject(new UiSelector().description("Quick settings."));
    quickSettings.clickAndWaitForNewWindow();
    
    UiObject settings = new UiObject(new UiSelector().text("Settings"));
    settings.clickAndWaitForNewWindow();
  }
  
  /**
   * Launch app drawer
   * @throws UiObjectNotFoundException
   */
  public static void goToAppDrawer() throws UiObjectNotFoundException {
    Log.d(TAG, "Launching App Drawer");
    UiObject appDrawer = new UiObject(new UiSelector().description("Apps"));
    appDrawer.click();
  }
  
  /**
   * Allow to delay new actions from being done.
   * This is strictly for demo purpose as we would like certain parts to be
   * viewied for a certain amount of time before proceeding to next method.
   * @param seconds
   */
  public static void delay(int seconds) {
    try {
      Thread.sleep(seconds * 1000); //sleep is in milliseconds. convert to seconds
      } catch (InterruptedException ie) {
      ie.printStackTrace();
    }
  }
  
  private static void goToAppsInSettings(String nameOfApp) throws UiObjectNotFoundException {
    UiScrollable settingsViews = new UiScrollable(new UiSelector().scrollable(true));
    UiObject settingsApps = settingsViews.getChildByText(new UiSelector()
    .className(android.widget.TextView.class.getName()), "Apps");
    
    settingsApps.clickAndWaitForNewWindow();
    
    UiScrollable appsViews = new UiScrollable(new UiSelector().scrollable(true));
    
    UiObject theApp = appsViews.getChildByText(new UiSelector()
    .className(android.widget.TextView.class.getName()), nameOfApp);
    
    theApp.clickAndWaitForNewWindow(); 
  }
  
  /**
   * Clear the data of the application
   * @param name is the name of the App we will clear data for
   * @throws UiObjectNotFoundException
   */
  public static void clearAppData(String nameOfApp) throws UiObjectNotFoundException {
    openNotificationShade();
    goToSettings();
    goToAppsInSettings(nameOfApp);
    
  }
}
