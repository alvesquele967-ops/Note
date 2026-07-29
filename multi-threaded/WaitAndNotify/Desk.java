package WaitAndNotify;

import java.io.ObjectStreamException;

public class Desk {
    public static int foodFlag = 0;

    public static int foodCount = 10;

    public static Object lock = new Object();

}
