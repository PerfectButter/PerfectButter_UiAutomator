package com.perfectbutter.uiautomator;

import android.os.RemoteException;
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
   * @throws RemoteException 
   */
  public void testPerfectButter() throws UiObjectNotFoundException, RemoteException {
    
    UiDevice.getInstance().pressHome();
    
    while(numTests != 0) {
      goToAboutPhone();
      PhoneUtilities.launchApp("Perfect Butter Backup");
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
   * Toggle through UI Options
   * @throws RemoteException 
   */
  private static void romOptions() throws UiObjectNotFoundException, RemoteException {
    PerfectButterBackupApp.selectTab("ROM OPTIONS");
    PerfectButterBackupApp.toggleNavBar();
    PerfectButterBackupApp.toggleCustomBootAni();
    PerfectButterBackupApp.toggleCustomBootAni();
    
    PerfectButterBackupApp.toggleBatteryStatus();
    
    PerfectButterBackupApp.toggleVolumeManager();
    PerfectButterBackupApp.toggleVolumeManager();
  }
  
  /**
   * Toggle Backup Options
   */
  private static void backup() throws UiObjectNotFoundException {
    PerfectButterBackupApp.toggleBackUpToSD();
    //PerfectButterBackupApp.toggleBackupToDropbox();
    //PerfectButterBackupApp.toggleBackupToEmail();
  }
  
  /**
   * Toggle Restore options
   */
  private static void restore() throws UiObjectNotFoundException {
    PerfectButterBackupApp.toggleRestoreFromSD();
    //PerfectButterBackupApp.toggleRestoreFromDropbox();
    //PerfectButterBackupApp.toggleRestoreFromEmail();
  }
}
