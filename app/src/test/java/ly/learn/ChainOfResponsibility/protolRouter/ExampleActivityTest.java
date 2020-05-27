package ly.learn.ChainOfResponsibility.protolRouter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import ly.learn.designpattern.BuildConfig;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class ExampleActivityTest {

    @Test
    public void test() {
        ShadowLog.stream = System.out;
        ExampleActivity activity = Robolectric.buildActivity(ExampleActivity.class).create().resume().get();
        ActivityImpl test1 = new ActivityImpl(activity);
        new CustemProtolRouterManager(test1).addWebImpl(activity).start("web");
        assertNotNull(test1.getNext());
        assertTrue(test1.getNext() instanceof WebImpl);
        new CustemProtolRouterManager(new ActivityImpl(activity)).addWebImpl(activity).start("android");
        new CustemProtolRouterManager(new ActivityImpl(activity)).addWebImpl(activity).start("activity");
    }
}