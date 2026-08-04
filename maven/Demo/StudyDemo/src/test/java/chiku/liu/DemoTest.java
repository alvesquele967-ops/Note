package chiku.liu;

import org.junit.Assert;
import org.junit.Test;

public class DemoTest {

    @Test
    public void test() {
        Main d = new Main();
        String ret = d.say("chiku");
        Assert.assertEquals("Hello chiku",ret);
    }
}
