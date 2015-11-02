package my.app;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class my.app.MyAppActivityTest \
 * my.app.tests/android.test.InstrumentationTestRunner
 */
public class MyAppActivityTest extends ActivityInstrumentationTestCase2<MyAppActivity> {

    public MyAppActivityTest() {
        super("my.app", MyAppActivity.class);
    }

}
