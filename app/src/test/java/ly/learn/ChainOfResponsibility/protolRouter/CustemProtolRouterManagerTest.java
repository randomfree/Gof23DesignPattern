package ly.learn.ChainOfResponsibility.protolRouter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowLog;

import static org.mockito.Mockito.*;

import ly.learn.designpattern.MainActivity;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class CustemProtolRouterManagerTest {


    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Before
    public void setUp() throws Exception {
        ShadowLog.stream = System.out;
    }

    @Test
    public void test() {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().resume().get();
        ActivityImpl activityImpl = new ActivityImpl(activity);
        WebImpl webImpl = new WebImpl(activity);

        new CustemProtolRouterManager(activityImpl).addImpl(webImpl).start("web");
        assertNotNull(activityImpl.getNext());
        assertTrue(activityImpl.getNext() instanceof WebImpl);
        new CustemProtolRouterManager(new ActivityImpl(activity)).addImpl(webImpl).start("android");
        new CustemProtolRouterManager(new ActivityImpl(activity)).addImpl(webImpl).start("activity");

        ActivityImpl mockActivityImpl = spy(activityImpl);
        WebImpl mockWebImpl = spy(webImpl);

        new CustemProtolRouterManager(mockActivityImpl).addImpl(mockWebImpl).start("web");

        verify(mockActivityImpl).handleRequest("web");
        verify(mockActivityImpl).goNext("web");

        verify(mockWebImpl).handleRequest("web");
        verify(mockWebImpl).goWebActivity("web");
    }
}