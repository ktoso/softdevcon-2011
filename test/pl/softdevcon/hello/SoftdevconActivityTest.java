package pl.softdevcon.hello;

import android.os.Bundle;
import android.widget.TextView;
import com.google.inject.Inject;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
//@RunWith(InjectingRobolectricTestRunner.class) // todo injected runner must be used
public class SoftdevconActivityTest {

    @Inject
    SoftdevconActivity softdevconActivity;

    @Before
    public void setUp() throws Exception {
        softdevconActivity.onCreate(Bundle.EMPTY);
    }

    @Test
    public void should_haveHelloWorldMessage() throws Exception {
        // given
        String expectedText = "Hello Softdevcon!";

        // when
        TextView hello = softdevconActivity.hello;
        String text = hello.getText().toString();

        // then
        // todo, fest assert will fail!!!
//        assertThat(text).containsIgnoringCase("hello");
        assertEquals(expectedText, text);
    }
}
