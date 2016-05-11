package kdk.android.simplydo.test;

import android.test.ActivityInstrumentationTestCase2;
import android.app.Activity;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;

import android.widget.Button;
import android.widget.EditText;

public class TestAdding_and_deleting_stars_for_items extends ActivityInstrumentationTestCase2<Activity> {

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
	public TestAdding_and_deleting_stars_for_items() {
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
			solo.sleep(6000);
			assertTrue("Wait for edit text (id: kdk.android.simplydo.R.id.AddListEditText) failed.",
					solo.waitForEditTextById("kdk.android.simplydo.R.id.AddListEditText", 20000));
			solo.enterText((EditText) solo.findViewById("kdk.android.simplydo.R.id.AddListEditText"), "test");
			assertTrue("Wait for button (id: kdk.android.simplydo.R.id.AddListButton) failed.",
					solo.waitForButtonById("kdk.android.simplydo.R.id.AddListButton", 20000));
			solo.clickOnButton((Button) solo.findViewById("kdk.android.simplydo.R.id.AddListButton"));
			solo.sleep(2900);
			assertTrue("Wait for list (index: 0) failed.", solo.waitForList(0, 20000));
			solo.clickInList(1, 0);
			solo.sleep(6700);
			assertTrue("Wait for edit text (id: kdk.android.simplydo.R.id.AddItemEditText) failed.",
					solo.waitForEditTextById("kdk.android.simplydo.R.id.AddItemEditText", 20000));
			solo.enterText((EditText) solo.findViewById("kdk.android.simplydo.R.id.AddItemEditText"), "spider");
			assertTrue("Wait for button (id: kdk.android.simplydo.R.id.AddItemButton) failed.",
					solo.waitForButtonById("kdk.android.simplydo.R.id.AddItemButton", 20000));
			solo.clickOnButton((Button) solo.findViewById("kdk.android.simplydo.R.id.AddItemButton"));
			assertTrue("Wait for button (id: kdk.android.simplydo:id/ieText1) failed.",
					solo.waitForButtonById("kdk.android.simplydo:id/ieText1", 20000));
			solo.clickLongOnButton((Button) solo.findViewById("kdk.android.simplydo:id/ieText1"));
			assertTrue("Wait for button (id: android:id/title) failed.",
					solo.waitForButtonById("android:id/title", 20000));
			solo.clickOnButton((Button) solo.findViewById("android:id/title"));
			assertTrue("Wait for button (id: kdk.android.simplydo:id/ieText1) failed.",
					solo.waitForButtonById("kdk.android.simplydo:id/ieText1", 20000));
			solo.clickLongOnButton((Button) solo.findViewById("kdk.android.simplydo:id/ieText1"));
			solo.clickOnButton((Button) solo.findViewById("android:id/title"));
			assertTrue("Wait for button (id: android:id/title) failed.",
					solo.waitForButtonById("android:id/title", 20000));
		} catch (AssertionFailedError e) {
			solo.fail("kdk.android.simplydo.test.TestAdding_and_deleting_stars_for_items.testRecorded_scr_fail", e);
			throw e;
		} catch (Exception e) {
			solo.fail("kdk.android.simplydo.test.TestAdding_and_deleting_stars_for_items.testRecorded_scr_fail", e);
			throw e;
		}
	}

}
