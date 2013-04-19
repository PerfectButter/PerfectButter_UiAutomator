package com.perfectbutter.uiautomator;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class Dropbox {
  
  private static final String TAG = "Perfect Butter Ui Automator";
  
  public static boolean isInDropbox() throws UiObjectNotFoundException {
    UiObject dropboxValidation = new UiObject(new UiSelector().packageName("com.dropbox.android"));
    return dropboxValidation.exists();
  }
  public static boolean doesFileExist() throws UiObjectNotFoundException {
    UiObject backupFile = new UiObject(new UiSelector().text("perfectButterBackup.tar")
        .className(android.widget.TextView.class));
    return backupFile.exists();
  }
  

}
