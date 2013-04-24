package com.perfectbutter.uiautomator;

import android.util.Log;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

public class Water {
  
  private static final String TAG = "Perfect Butter Ui Automator";
  
  public static void goIntoGame() throws UiObjectNotFoundException {
    Log.d(TAG, "Swipe left to go to main screen");
    UiDevice.getInstance().swipe(500, 500, 300, 500, 10);
    PhoneUtilities.delay(1);
    
    Log.d(TAG, "Clicking Start to go past Splash Screen");
    UiDevice.getInstance().click(360, 745);
    PhoneUtilities.delay(3);
    
    Log.d(TAG, "Clicking on first Set of Game");
    UiDevice.getInstance().click(360, 430);
    
    Log.d(TAG, "Delay to be able to view levels played");
    PhoneUtilities.delay(5);
    
    UiDevice.getInstance().pressHome();
  }
  
  public static void goIntoGameAfterReset() throws UiObjectNotFoundException {
    Log.d(TAG, "Clicking Start to go past Splash Screen");
    UiDevice.getInstance().click(360, 745);
    PhoneUtilities.delay(3);
    
    Log.d(TAG, "Delaying to allow game to load up");
    PhoneUtilities.delay(11);
    
    Log.d(TAG, "Clicking on first Set of Game");
    UiDevice.getInstance().click(360, 430);
    PhoneUtilities.delay(2);
    
    Log.d(TAG, "Clicking Screen Twice to Bypass Into");
    UiDevice.getInstance().click(360, 430);
    UiDevice.getInstance().click(360, 430);
    PhoneUtilities.delay(2);
    
    Log.d(TAG, "Clicking Pause Icon");
    UiDevice.getInstance().click(680, 50);
    PhoneUtilities.delay(1);
    
    Log.d(TAG, "Clicking Levels Button");
    UiDevice.getInstance().click(350, 475);
    
    Log.d(TAG, "Delay to be able to view no levels played");
    PhoneUtilities.delay(5);
    
    UiDevice.getInstance().pressHome();
  }
}
