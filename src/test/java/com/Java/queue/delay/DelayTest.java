package com.Java.queue.delay;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author shaogz
 */
@Slf4j
public class DelayTest {

    @Test
    public void test() throws InterruptedException {
        DelayQueue<ReplayDelayItem> replayDelayItems = new DelayQueue<>();
        replayDelayItems.put(new ReplayDelayItem(1, 1, 10, TimeUnit.SECONDS));
        replayDelayItems.put(new ReplayDelayItem(1, 2, 10, TimeUnit.SECONDS));
        replayDelayItems.put(new ReplayDelayItem(1, 11, 11, TimeUnit.SECONDS));

        while (true) {
            log.warn("try take from delay queue");
            Thread.sleep(30000);
            ReplayDelayItem take = replayDelayItems.take();
            log.warn("msg:{}", take);
        }
    }
}
