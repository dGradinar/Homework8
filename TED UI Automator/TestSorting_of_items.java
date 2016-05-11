package kdk.android.simplydo.test;

import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;

import android.widget.Button;
import android.widget.EditText;

public class TestSorting_of_items extends ActivityInstrumentationTestCase2<Activity> {

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
	public TestSorting_of_items() {
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
			solo.sleep(6200);
			assertTrue("Wait for edit text (id: kdk.android.simplydo.R.id.AddListEditText) failed.",
					solo.waitForEditTextById("kdk.android.simplydo.R.id.AddListEditText", 20000));
			solo.enterText((EditText) solo.findViewById("kdk.android.simplydo.R.id.AddListEditText"), "test");
			assertTrue("Wait for button (id: kdk.android.simplydo.R.id.AddListButton) failed.",
					solo.waitForButtonById("kdk.android.simplydo.R.id.AddListButton", 20000));
			solo.clickOnButton((Button) solo.findViewById("kdk.android.simplydo.R.id.AddListButton"));
			solo.sleep(3000);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(1, 0);
			solo.sleep(4800);
			assertTrue("Wait for edit text (id: kdk.android.simplydo.R.id.AddItemEditText) failed.",
					solo.waitForEditTextById("kdk.android.simplydo.R.id.AddItemEditText", 20000));
			solo.enterText((EditText) solo.findViewById("kdk.android.simplydo.R.id.AddItemEditText"), "spider");
			assertTrue("Wait for button (id: kdk.android.simplydo.R.id.AddItemButton) failed.",
					solo.waitForButtonById("kdk.android.simplydo.R.id.AddItemButton", 20000));
			solo.clickOnButton((Button) solo.findViewById("kdk.android.simplydo.R.id.AddItemButton"));
			solo.sleep(11600);
			assertTrue("Wait for edit text (id: kdk.android.simplydo.R.id.AddItemEditText) failed.",
					solo.waitForEditTextById("kdk.android.simplydo.R.id.AddItemEditText", 20000));
			solo.enterText((EditText) solo.findViewById("kdk.android.simplydo.R.id.AddItemEditText"), "root");
			assertTrue("Wait for button (id: kdk.android.simplydo.R.id.AddItemButton) failed.",
					solo.waitForButtonById("kdk.android.simplydo.R.id.AddItemButton", 20000));
			solo.clickOnButton((Button) solo.findViewById("kdk.android.simplydo.R.id.AddItemButton"));
			solo.sleep(4200);
			assertTrue("Wait for edit text (id: kdk.android.simplydo.R.id.AddItemEditText) failed.",
					solo.waitForEditTextById("kdk.android.simplydo.R.id.AddItemEditText", 20000));
			solo.enterText((EditText) solo.findViewById("kdk.android.simplydo.R.id.AddItemEditText"), "dog");
			assertTrue("Wait for button (id: kdk.android.simplydo.R.id.AddItemButton) failed.",
					solo.waitForButtonById("kdk.android.simplydo.R.id.AddItemButton", 20000));
			solo.clickOnButton((Button) solo.findViewById("kdk.android.simplydo.R.id.AddItemButton"));
			solo.sleep(15200);
			assertTrue("Wait for edit text (id: kdk.android.simplydo.R.id.AddItemEditText) failed.",
					solo.waitForEditTextById("kdk.android.simplydo.R.id.AddItemEditText", 20000));
			solo.enterText((EditText) solo.findViewById("kdk.android.simplydo.R.id.AddItemEditText"), "apple");
			assertTrue("Wait for button (id: kdk.android.simplydo.R.id.AddItemButton) failed.",
					solo.waitForButtonById("kdk.android.simplydo.R.id.AddItemButton", 20000));
			solo.clickOnButton((Button) solo.findViewById("kdk.android.simplydo.R.id.AddItemButton"));
			solo.sleep(6900);
			assertTrue("Wait for edit text (id: kdk.android.simplydo.R.id.AddItemEditText) failed.",
					solo.waitForEditTextById("kdk.android.simplydo.R.id.AddItemEditText", 20000));
			solo.enterText((EditText) solo.findViewById("kdk.android.simplydo.R.id.AddItemEditText"), "glass");
			assertTrue("Wait for button (id: kdk.android.simplydo.R.id.AddItemButton) failed.",
					solo.waitForButtonById("kdk.android.simplydo.R.id.AddItemButton", 20000));
			solo.clickOnButton((Button) solo.findViewById("kdk.android.simplydo.R.id.AddItemButton"));
			solo.sleep(1500);
			solo.clickOnScreen(solo.toScreenX(0.762f), solo.toScreenY(0.519f));
			solo.sleep(2800);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(3, 0);
			solo.sleep(1500);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(3, 0);
			solo.sleep(1200);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(4, 0);
			solo.sleep(900);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(4, 0);
			solo.sleep(700);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(5, 0);
			solo.sleep(800);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(5, 0);
			solo.sleep(1900);
			solo.clickOnMenuItem("Sort Now", true);
		} catch (AssertionFailedError e) {
			solo.fail("kdk.android.simplydo.test.TestSorting_of_items.testRecorded_scr_fail", e);
			throw e;
		} catch (Exception e) {
			solo.fail("kdk.android.simplydo.test.TestSorting_of_items.testRecorded_scr_fail", e);
			throw e;
		}
	}

}
