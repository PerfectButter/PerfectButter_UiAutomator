package com.perfectbutter.uiautomator;

import android.graphics.Rect;
import android.os.RemoteException;
import android.util.Log;
import android.widget.FrameLayout;

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
  
  private static final String TAG = "Perfect Butter Ui Automator";
  
  /**
   * Method to open notification shade with swiping motion
   */
  public static void openNotificationShade() {
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
    UiDevice.getInstance().pressHome();
    
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
  
  public static void waitforRestart() throws UiObjectNotFoundException {
    Log.d(TAG, "Delay 35 seconds for phone to reboot");
    delay(35);
  }
  
  public static void unlockPhone() throws UiObjectNotFoundException {
    if(!doesLockScreenExist()) {
      delay(10);
    }
    
    UiObject slideArea = new UiObject(
        new UiSelector().description("Slide area."));
    Rect slideAreaBounds = slideArea.getBounds();
    int fromX = slideAreaBounds.centerX();
    int fromY = slideAreaBounds.centerY();
    int toX = slideAreaBounds.right;
    int toY = fromY;
    UiDevice.getInstance().swipe(fromX, fromY, toX, toY, 5);
  }
  
  private static boolean doesLockScreenExist() throws UiObjectNotFoundException {
    UiObject slideArea = new UiObject(
        new UiSelector().description("Slide area."));
    return slideArea.exists();
  }
  
  /**
   * Launch App
   * @param appName name of App to launch
   * @throws UiObjectNotFoundException
   */
  public static void launchApp(String appName) throws UiObjectNotFoundException {
    
    Log.d(TAG, "Launch PerfectButterBackup App");
    PhoneUtilities.goToAppDrawer();
        
    UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
    appViews.setAsHorizontalList();
    
    UiObject theApp = appViews.getChildByText(new UiSelector()
    .className(android.widget.TextView.class.getName()), appName);
    
    theApp.clickAndWaitForNewWindow(); 
  }
  
  public static void restorePerfectButter() throws UiObjectNotFoundException, RemoteException {
    UiDevice.getInstance().pressRecentApps();
    
    UiObject perfectButterApp = new UiObject(new UiSelector().description("Perfect Butter Backup").
        className(FrameLayout.class));
    
    perfectButterApp.clickAndWaitForNewWindow();
    
  }
}
