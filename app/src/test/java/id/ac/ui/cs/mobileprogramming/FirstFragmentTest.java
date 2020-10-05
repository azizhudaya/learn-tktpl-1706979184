package id.ac.ui.cs.mobileprogramming;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import android.app.Activity;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 25)
public class FirstFragmentTest {
    private Button button_first;
    private TextView textView_first;
    private MainActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class).create().visible().get();
        button_first = (Button) activity.findViewById(R.id.button_first);
        textView_first = (TextView) activity.findViewById(R.id.textview_first);
    }

    @Test
    public void haveTextSaysHelloWorld() {

    }

    @Test
    public void haveButtonRedirectToSecondFragment() {
        assertNotNull(textView_first);
        assertNotNull(button_first);
        assertNotNull(activity);
        String resultText = "test";
        textView_first.setText(resultText);
        button_first.performClick();

        Intent startedIntent = shadowOf(activity).peekNextStartedActivity();
        assertEquals(resultText, (startedIntent.getStringExtra("result")));
        assertEquals(startedIntent.getComponent().getClassName(), SecondFragment.class.getName());

    }

    @After
    public void tearDown() throws Exception {
    }
}