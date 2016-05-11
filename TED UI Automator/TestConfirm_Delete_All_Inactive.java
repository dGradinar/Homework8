package kdk.android.simplydo.test;

import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;

import android.widget.Button;
import android.widget.EditText;

public class TestConfirm_Delete_All_Inactive extends ActivityInstrumentationTestCase2<Activity> {

	private static final String LAUNCHER_ACTIVITY_CLASSNAME = "kdk.android.simplydo.SimplyDoActivity";
	private static Class<?> launchActivityClass;

	static {
		try {
			launchActivityClass = Class.forName(LAUNCHER_ACTIVITY_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private ExtSolo solo; // ExtSolo is an extension of Robotium Solo that helps collecting better test execution data during test runs

	@SuppressWarnings("unchecked")
	public TestConfirm_Delete_All_Inactive() {
		super((Class<Activity>) launchActivityClass);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		solo = new ExtSolo(getInstrumentation(), getActivity(), this.getClass().getCanonicalName(), getName());
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
		solo.tearDown();
		super.tearDown();
	}

	public void testRecorded() throws Exception {
		try {
			solo.waitForActivity("SimplyDoActivity");
			solo.sleep(12100);
			assertTrue("Wait for edit text (id: kdk.android.simplydo.R.id.AddListEditText) failed.",
					solo.waitForEditTextById("kdk.android.simplydo.R.id.AddListEditText", 20000));
			solo.enterText((EditText) solo.findViewById("kdk.android.simplydo.R.id.AddListEditText"), "test");
			assertTrue("Wait for button (id: kdk.android.simplydo.R.id.AddListButton) failed.",
					solo.waitForButtonById("kdk.android.simplydo.R.id.AddListButton", 20000));
			solo.clickOnButton((Button) solo.findViewById("kdk.android.simplydo.R.id.AddListButton"));
			solo.sleep(1100);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(1, 0);
			solo.sleep(5600);
			assertTrue("Wait for edit text (id: kdk.android.simplydo.R.id.AddItemEditText) failed.",
					solo.waitForEditTextById("kdk.android.simplydo.R.id.AddItemEditText", 20000));
			solo.enterText((EditText) solo.findViewById("kdk.android.simplydo.R.id.AddItemEditText"), "good");
			assertTrue("Wait for button (id: kdk.android.simplydo.R.id.AddItemButton) failed.",
					solo.waitForButtonById("kdk.android.simplydo.R.id.AddItemButton", 20000));
			solo.clickOnButton((Button) solo.findViewById("kdk.android.simplydo.R.id.AddItemButton"));
			solo.sleep(3000);
			assertTrue("Wait for edit text (id: kdk.android.simplydo.R.id.AddItemEditText) failed.",
					solo.waitForEditTextById("kdk.android.simplydo.R.id.AddItemEditText", 20000));
			solo.enterText((EditText) solo.findViewById("kdk.android.simplydo.R.id.AddItemEditText"), "bab");
			assertTrue("Wait for button (id: kdk.android.simplydo.R.id.AddItemButton) failed.",
					solo.waitForButtonById("kdk.android.simplydo.R.id.AddItemButton", 20000));
			solo.clickOnButton((Button) solo.findViewById("kdk.android.simplydo.R.id.AddItemButton"));
			solo.sleep(4600);
			assertTrue("Wait for edit text (id: kdk.android.simplydo.R.id.AddItemEditText) failed.",
					solo.waitForEditTextById("kdk.android.simplydo.R.id.AddItemEditText", 20000));
			solo.enterText((EditText) solo.findViewById("kdk.android.simplydo.R.id.AddItemEditText"), "wrong");
			assertTrue("Wait for button (id: kdk.android.simplydo.R.id.AddItemButton) failed.",
					solo.waitForButtonById("kdk.android.simplydo.R.id.AddItemButton", 20000));
			solo.clickOnButton((Button) solo.findViewById("kdk.android.simplydo.R.id.AddItemButton"));
			solo.sleep(1600);
			solo.clickOnScreen(solo.toScreenX(0.665f), solo.toScreenY(0.557f));
			solo.sleep(3200);
			solo.clickOnMenuItem("Settings", true);
			solo.waitForActivity("SettingsActivity");
			solo.sleep(6600);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(4, 0);
			solo.sleep(2100);
			solo.goBack();
			solo.waitForActivity("SimplyDoActivity");
			solo.sleep(4700);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(1, 0);
			solo.clickOnMenuItem("Delete All Inactive", true);
			solo.sleep(2500);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(3, 0);
			solo.sleep(600);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(2, 0);
			solo.sleep(1700);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(1, 0);
			solo.clickOnMenuItem("Delete All Inactive", true);
			solo.sleep(2400);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(2, 0);
			solo.clickOnMenuItem("Settings", true);
			solo.waitForActivity("SettingsActivity");
			solo.sleep(2000);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(4, 0);
			solo.sleep(1000);
			solo.goBack();
			solo.waitForActivity("SimplyDoActivity");
		} catch (AssertionFailedError e) {
			solo.fail("kdk.android.simplydo.test.TestConfirm_Delete_All_Inactive.testRecorded_scr_fail", e);
			throw e;
		} catch (Exception e) {
			solo.fail("kdk.android.simplydo.test.TestConfirm_Delete_All_Inactive.testRecorded_scr_fail", e);
			throw e;
		}
	}

}
