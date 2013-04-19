package com.perfectbutter.uiautomator;

import android.os.RemoteException;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import junit.framework.Assert;

/**
 * The PerfectButterBackupApp will handle all the events that can be
 * done within the application
 * @author ctugangui
 *
 */

public class PerfectButterBackupApp {
  
  private static final String TAG = "Perfect Butter Ui Automator";
  private static final String BATTERY = "Battery Status Mod";
  private static final String VOLUME = "Volume Manager Mod";
  private static final String BOOT = "Custom Boot Animation Mod";
  
  public static void toggleBatteryStatus() throws UiObjectNotFoundException {
    selectTab("ROM OPTIONS");
    Log.d(TAG, "Toggling Battery Status Mod");
    toggleCheckbox(BATTERY);
    Log.d(TAG, "Delay for 5 seconds for visual to change");
    PhoneUtilities.delay(5);
    
    toggleCheckbox(BATTERY);
    Log.d(TAG, "Delay for 5 seconds for visual to change");
    PhoneUtilities.delay(5);
  }
  
  public static void toggleVolumeManager() throws UiObjectNotFoundException {
    Log.d(TAG, "Toggling " + VOLUME);
    toggleCheckbox(VOLUME);
    
    Log.d(TAG, "Checking if checkbox is checked");
     
    if(isCheckBoxChecked(VOLUME)) {
      Log.d(TAG, "Turn Volume Up");
      UiDevice.getInstance().pressKeyCode(24);
      PhoneUtilities.delay(1);
      Log.d(TAG, "");
      UiDevice.getInstance().click(642,312);
      PhoneUtilities.delay(1);
      
      Log.d(TAG, "Toggle the Phone Volume up & down");
      UiDevice.getInstance().swipe(525, 300, 175, 300, 25);
      UiDevice.getInstance().swipe(175,  300, 525, 300, 25);
      
      Log.d(TAG, "Toggle the Media Volume up & down");
      UiDevice.getInstance().swipe(525, 420, 175, 420, 50);
      UiDevice.getInstance().swipe(175, 420, 525, 420, 25);
      
      Log.d(TAG, "Toggle Sound Volume up & down");
      UiDevice.getInstance().swipe(300, 540, 525, 540, 10);
      UiDevice.getInstance().swipe(525, 540, 300, 540, 10);
      
      Log.d(TAG, "Toggle Alarm Volume up & down");
      UiDevice.getInstance().swipe(525, 660, 175, 660, 10);
      UiDevice.getInstance().swipe(175, 660, 525, 660, 10);
    } else {
      Log.d(TAG, "Volume Mod not enabled. Only main Phone Volume Shown");
      UiDevice.getInstance().pressKeyCode(24);
      
      Log.d(TAG, "Toggle the Phone Volume up & down");
      UiDevice.getInstance().swipe(525, 300, 175, 300, 10);
      UiDevice.getInstance().swipe(175,  300, 525, 300, 10);
    }
  }
  
  public static void toggleCustomBootAni() throws UiObjectNotFoundException, RemoteException {
    Log.d(TAG, "Toggling " + BOOT);
    toggleCheckbox(BOOT);
    
    Log.d(TAG, "Launch Terminal Emulator to preview Boot Animation");
    PhoneUtilities.launchApp("Terminal Emulator");
    
    Log.d(TAG, "Entering su in Terminal Emulator");
    UiObject terminalCommand = new UiObject(new UiSelector().className(android.view.View.class));
    terminalCommand.setText("su");
    UiDevice.getInstance().pressEnter();
    
    Log.d(TAG, "Entering bootanimation to preview bootanimation");
    terminalCommand.setText("bootanimation");
    UiDevice.getInstance().pressEnter();
    
    Log.d(TAG, "Delay 10 seconds to allow preview of bootanimation");
    PhoneUtilities.delay(10);
    UiObject closeWindow = new UiObject(new UiSelector().description("Close window"));
    closeWindow.click();
    
    Log.d(TAG, "Killing process to stop Bootanimation");
    UiObject clickOK = new UiObject(new UiSelector().text("OK"));
    clickOK.clickAndWaitForNewWindow();
    
    PhoneUtilities.restorePerfectButter();
  }
  
  public static void toggleNavBar() throws UiObjectNotFoundException {
    Log.d(TAG, "Toggling the Navigation Bar sizes");
    UiObject navBarSmall = new UiObject(new UiSelector().text("Small")
        .className(android.widget.RadioButton.class));
    UiObject navBarMedium = new UiObject(new UiSelector().text("Medium")
        .className(android.widget.RadioButton.class));
    UiObject navBarLarge = new UiObject(new UiSelector().text("Large")
        .className(android.widget.RadioButton.class));
    
    Log.d(TAG, "Changing Navigation Bar to Small");
    navBarSmall.click();
    PhoneUtilities.delay(5);
    
    Log.d(TAG, "Changing Navigation Bar to Medium");
    navBarMedium.click();
    PhoneUtilities.delay(5);
    
    Log.d(TAG, "Changing Navigation Bar to Large");
    navBarLarge.click();
    PhoneUtilities.delay(5);
  }
  
  private static void toggleBackupItems() throws UiObjectNotFoundException {
    Log.d(TAG, "Turn Backup MMS checkbox off and on");
    //Turn MMS checkbox off and on
    toggleCheckbox("Backup MMS");
    toggleCheckbox("Backup MMS");
    
    Log.d(TAG, "Toggle Backup Phone Log off and on");
    //toggle Backup phone log off and on
    toggleCheckbox("Backup Phone Log");
    toggleCheckbox("Backup Phone Log");
    
    Log.d(TAG, "Toggle Backup Apps off and on");
    //toggle Backup Apps off and on
    toggleCheckbox("Backup Apps");
    toggleCheckbox("Backup Apps");
    
    Log.d(TAG, "Toggle Backup App Data off and on");
    //Toggle backup app data off and on
    toggleCheckbox("Backup App Data");
    toggleCheckbox("Backup App Data");
  }
  
  private static void toggleRestoreItems() throws UiObjectNotFoundException {
    Log.d(TAG, "Toggle Restore MMS checkbox off and on");
    toggleCheckbox("Restore MMS");
    toggleCheckbox("Restore MMS");
    
    Log.d(TAG, "Toggle Restore Phone Log checkbox off and on");
    toggleCheckbox("Restore Phone Log");
    toggleCheckbox("Restore Phone Log");
    
    Log.d(TAG, "Toggle Restore Apps checkbox off and on");
    toggleCheckbox("Restore Apps");
    toggleCheckbox("Restore Apps");
    
    Log.d(TAG, "Toggle Restore App Data checkbox off and on");
    toggleCheckbox("Restore App Data");
    toggleCheckbox("Restore App Data");
  }
  
  public static void toggleBackUpToSD() throws UiObjectNotFoundException {
    selectTab("BACKUP");
    toggleBackupItems();
    
    UiObject sdCardRadio = new UiObject(new UiSelector().text("SD Card")
        .className(android.widget.RadioButton.class));
    sdCardRadio.click();
    
    Log.d(TAG, "Running Backup to SD Card");
    runBackup();
  }
  
  public static void toggleBackupToDropbox() throws UiObjectNotFoundException, RemoteException {
    selectTab("BACKUP");
    toggleBackupItems();
    
    UiObject dropboxRadio = new UiObject(new UiSelector().text("Dropbox"));
    dropboxRadio.click();
    
    Log.d(TAG, "Running Backup to Dropbox");
    runBackup();
    
    Log.d(TAG, "Dropbox Will Prompt where to upload. Click Upload for Default Folder");
    UiObject dropboxUploadButton = new UiObject(new UiSelector().text("Upload")
        .className(android.widget.Button.class));
    dropboxUploadButton.clickAndWaitForNewWindow();
    
    Log.d(TAG, "File may already exist in Folder. Will Click Replace to overwrite current file");
    UiObject fileAlreadyExists = new UiObject(new UiSelector().text("File already exists"));
    if(fileAlreadyExists.exists()) {
      UiObject replaceButton = new UiObject(new UiSelector().text("Replace")
      .className(android.widget.Button.class));
      replaceButton.clickAndWaitForNewWindow();
    }
    Log.d(TAG, "Open Notification Shade to view file being uploaded");
    
    PhoneUtilities.openNotificationShade();
    
    UiObject dropboxUploading = new UiObject(new UiSelector().text("Uploading to Dropbox").
        className(android.widget.TextView.class));
    
    Assert.assertTrue(dropboxUploading.exists());
    
    Log.d(TAG, "Going into Dropbox to verify the File exists");
    dropboxUploading.clickAndWaitForNewWindow();
    
    Assert.assertTrue("Not In Dropbox", Dropbox.isInDropbox());
    Assert.assertTrue("Fie does not exist, Maybe an upload error", Dropbox.doesFileExist());
    
    PhoneUtilities.restorePerfectButter();
  }
  
  public static void toggleBackupToEmail() throws UiObjectNotFoundException, RemoteException {
    selectTab("BACKUP");
    toggleBackupItems();
    
    UiObject emailRadio = new UiObject(new UiSelector().text("Email"));
    emailRadio.click();
    
    Log.d(TAG, "Running Backup to Email");
    runBackup();
    PhoneUtilities.delay(2);
    
    Log.d(TAG, "Select Gmail as email app");
    UiObject selectGmail = new UiObject(new UiSelector().text("Gmail")
        .className(android.widget.TextView.class));
    selectGmail.clickAndWaitForNewWindow();
    
    Log.d(TAG, "Verify in Gmail App");
    Assert.assertTrue(Gmail.isInGmail());
    
    Log.d(TAG, "Entering perfectbutterbackup@gmail.com for email address");
    Gmail.enterEmailAddress("perfectbutterbackup@gmail.com");
    
    Assert.assertTrue("File was not attached", Gmail.isFileAttached());
    
    Log.d(TAG, "Sending email with PerfectButterBackup.tar");
    Gmail.submitEmail();
    
    Log.d(TAG, "Restoring Perfect Butter Backup app");
    PhoneUtilities.restorePerfectButter();
  }
  
  public static void toggleRestoreFromSD() throws UiObjectNotFoundException {
    selectTab("RESTORE");
    toggleRestoreItems();
    
  }
  
  public static void toggleRestoreFromDropbox() throws UiObjectNotFoundException {
    
  }
  
  public static void toggleRestoreFromEmail() throws UiObjectNotFoundException {
    
  }
  
  private static void swipeToScreen(String screenName) throws UiObjectNotFoundException {
    
    Log.d(TAG, "Swiping to screen " + screenName);
    
    UiScrollable screenViews = new UiScrollable(new UiSelector().scrollable(true));
    screenViews.setAsHorizontalList();
    
    UiObject theScreen = screenViews.getChildByText(new UiSelector()
    .className(TextView.class), screenName);
    Log.d(TAG, "Which Screen: " + theScreen);
    
    theScreen.click();
    Log.d(TAG, "Enabled? " + theScreen.isSelected());
  }
  
  /**
   * Click on specific tab
   * @param tabName the tab we want to click on
   * @throws UiObjectNotFoundException
   */
  public static void selectTab(String tabName) throws UiObjectNotFoundException {
    UiObject selectTab = new UiObject(new UiSelector().text(tabName));
    selectTab.click();
  }
  
  private static boolean isCheckBoxChecked(String theOption) throws UiObjectNotFoundException {
    UiObject checkBox = new UiObject(new UiSelector().text(theOption).
        className(android.widget.CheckBox.class));
    return checkBox.isChecked();
  }
  
  private static void toggleCheckbox(String theOption) throws UiObjectNotFoundException {
    UiObject checkBox = new UiObject(new UiSelector().text(theOption)
        .className(android.widget.CheckBox.class));
    checkBox.click();
  }
  
  private static void runBackup() throws UiObjectNotFoundException {
    UiObject backupButton = new UiObject(new UiSelector().text("Run Backup!")
        .className(android.widget.Button.class));
    backupButton.click();
  }

}
