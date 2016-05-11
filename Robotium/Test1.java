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
 
public class Test1 extends UiAutomatorTestCase {
 
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
 UiObject searchTEDButton = new UiObject(new UiSelector()
   .className(android.widget.TextView.class.getName())
   .text("").index(2));
 // Edit field to enter new Text
 UiObject searchTEDText = new UiObject(new UiSelector().className(
   android.widget.EditText.class.getName()).text("Search Talks").index(0));
 
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
 
  assertTrue("Search TED Button is not found", searchTEDButton.exists());
  // click on 'Add Note' button
  searchTEDButton.click();
 
  // Add note button in menu
  assertTrue("Search TED Button is not found", searchTEDButton.exists());
  searchTEDButton.setText("Google");
 
  // Read the text enetered in Text box
  assertEquals("Google", searchTEDButton.getText());
 
  // Click on Menu button
  myDevice.pressMenu();
 
 }
 
 
 @After
 public void closeNotesApp() {
  getUiDevice().pressBack();
 }
 
}