package cn.boommanpro.calc;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * HasGlobalTimeout
 *
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/5/23 19:51
 * @from https://github.com/junit-team/junit4/wiki/Timeout-for-tests
 * @since 1.0.0
 */
public class HasGlobalTimeout {
    public static String log;
    private final CountDownLatch latch = new CountDownLatch(1);

    @Rule
    public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per method tested

    @Test
    public void testSleepForTooLong() throws Exception {
        log += "ran1";
        TimeUnit.SECONDS.sleep(100); // sleep for 100 seconds
    }

    @Test
    public void testBlockForever() throws Exception {
        log += "ran2";
        latch.await(); // will block
    }
}