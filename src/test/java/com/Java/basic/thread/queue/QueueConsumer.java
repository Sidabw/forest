/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: QueueConsumer
 * Author:   feiyi
 * Date:     2020/2/2 5:22 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread.queue;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/2/2
 * @since 1.0.0
 */
public class QueueConsumer implements Runnable {

    LinkedBlockingQueue<Object> blockingQueue;

    private Boolean consumed = Boolean.FALSE;

    public QueueConsumer(LinkedBlockingQueue<Object> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                Object take = blockingQueue.take();
                consumed = Boolean.FALSE;
                //模拟算法模块时间消耗，0～10s
                int i = new Random().nextInt(10);
                Thread.sleep(i * 1000);
                consumed = Boolean.TRUE;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
