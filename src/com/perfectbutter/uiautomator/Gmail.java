package com.perfectbutter.uiautomator;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class Gmail {
    
  public static boolean isInGmail() throws UiObjectNotFoundException {
    UiObject gmailValidation = new UiObject(new UiSelector().packageName("com.google.android.gm"));
    return gmailValidation.exists();
  }
  
  public static void enterEmailAddress(String emailAddress) throws UiObjectNotFoundException {
    UiObject theEmail = new UiObject(new UiSelector().description("To")
        .className(android.widget.MultiAutoCompleteTextView.class));
    theEmail.setText(emailAddress);
    
    UiDevice.getInstance().pressBack(); //Close Keyboard
  }
  
  public static void submitEmail() throws UiObjectNotFoundException {
    UiObject send = new UiObject(new UiSelector().description("Send")
        .className(android.widget.TextView.class));
    send.clickAndWaitForNewWindow();
  }
  
  public static boolean isFileAttached() throws UiObjectNotFoundException {
    UiObject fileAttached = new UiObject(new UiSelector().text("perfectButterBackup.tar").
        className(android.widget.TextView.class));
    
    return fileAttached.exists();
  }
  
  public static void checkEmailFromNotification() throws UiObjectNotFoundException {
    
  }

}
