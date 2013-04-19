package com.perfectbutter.uiautomator;

import android.util.Log;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

/**
 * The Angry Birds class will allow us to view currently saved games.
 * We will then clear data for the application, restore the data from 
 * the Perfect Butter Backup app, and check if the data has been restored 
 * to the game.
 * @author ctugangui
 *
 */
public class CutTheRope {
  
  private static final String TAG = "Perfect Butter Ui Automator";
  
  public static void goIntoGame() throws UiObjectNotFoundException {
    Log.d(TAG, "Clicking Start to go past Splash Screen");
    UiDevice.getInstance().click(380, 720);
    PhoneUtilities.delay(2);
    
    Log.d(TAG, "Clicking on first Set of Game which will take us into Games completed");
    UiDevice.getInstance().click(370, 630);
    
    Log.d(TAG, "Delaying 10 seconds to allow to view the amount of levels played");
    PhoneUtilities.delay(10);
    
    UiDevice.getInstance().pressHome();
  }
}
