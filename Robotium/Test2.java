import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
 
import android.os.RemoteException;
 
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
 
public class Test2 extends UiAutomatorTestCase {
 
 // ----------------Global variables------------------------------
 
 // Get the device properties
 UiDevice myDevice = getUiDevice();
 // All App Tray Button
 UiObject AppTrayButton = new UiObject(new UiSelector().description("Apps"));
 
 // Get AppTray container
 UiScrollable appView = new UiScrollable(new UiSelector().className(
   "android.view.View").scrollable(true));
 // Apps Tab
 UiObject AppsTab = new UiObject(new UiSelector().className(
   "android.widget.TextView").description("Apps"));
 // Verify the launched application by it's Package name
 UiObject TEDValidation = new UiObject(
   new UiSelector().packageName("com.sec.android.app.launcher"));
 // Add Note menu button
 UiObject videoButton = new UiObject(new UiSelector()
   .className(android.widget.CheckedTextView.class.getName())
   .text("Lisa Nip: How humans could evolve to survive in space").index(2));
 // Edit field to enter new Text
 UiObject bookmarkButton = new UiObject(new UiSelector().className(
		 android.widget.ImageView.class.getName()).index(3));
 UiObject backButton = new UiObject(new UiSelector().className(
		 android.widget.LinearLayout.class.getName()).index(0));
 UiObject mytalksButton = new UiObject(new UiSelector().className(
		 android.widget.CheckedTextView.class.getName()).text("My Talks").index(3));
 UiObject booklmarksButton = new UiObject(new UiSelector().className(
		 android.widget.CheckedTextView.class.getName()).text("Bookmarks").index(18));
 // Actual Tests starts here
 
 @Before
 public void verifyTEDApp() {
  assertTrue("TED App not launched", TEDValidation.exists());
 }
 
 // Launch Notes Application
 public void testLaunchTestApp() throws RemoteException,
   UiObjectNotFoundException {
 
  // wakeup the device if the screen is Off
  if (!myDevice.isScreenOn())
   myDevice.wakeUp();
  // Press Home button
  myDevice.pressHome();
 
  // Launch Notes Application
  assertTrue("AppTray Button not found", AppTrayButton.exists());
  AppTrayButton.clickAndWaitForNewWindow();
 
  assertTrue("All Apps Tab not found", AppsTab.exists());
  // Set the swiping mode to horizontal (the default is vertical)
  appView.setAsHorizontalList();
 
  // Look for the Notes application
  UiObject TEDApp = appView.getChildByText(new UiSelector()
    .className(android.widget.TextView.class.getName()), "TED",
    true);
 
  // Validate Notebook App by it's package name
  assertTrue("Notes App not launched", TEDValidation.exists());
 
  TEDApp.clickAndWaitForNewWindow();
 
 }
 
 // Add Note1
 public void testSearchTED() throws RemoteException,
   UiObjectNotFoundException {
 
  // Click on Menu button
  myDevice.pressMenu();
 
  assertTrue("Lisa Nip: How humans could evolve to survive in space not found", videoButton.exists());
  // click on 'Add Note' button
  videoButton.click();
 
  // Add note button in menu
  assertTrue("bookmar kButton is not found", bookmarkButton.exists());
  bookmarkButton.click();
  
  assertTrue("Back Button is not found", backButton.exists());
  backButton.click();
  
  assertTrue("My Talks Button is not found", mytalksButton.exists());
  mytalksButton.click();
  
  assertTrue("Booklmarks Button is not found", booklmarksButton.exists());
  booklmarksButton.click();
 
  // Read the text enetered in Text box
  assertEquals("Lisa Nip: How humans could evolve to survive in space not found", videoButton.getText());
 
  // Click on Menu button
  myDevice.pressMenu();
 
 }
 
 
 @After
 public void closeNotesApp() {
  getUiDevice().pressBack();
 }
 
}