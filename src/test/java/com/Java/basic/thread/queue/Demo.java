/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2020/2/2 4:57 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/2/2
 * @since 1.0.0
 */
public class Demo {

    public static void main(String[] args) {
//        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        List<Integer> integers = simulationData();
        LinkedBlockingQueue<Object> blockingQueue = new LinkedBlockingQueue<>(5);
        //producer
        new Thread(() -> {
            for (int i = 0; i < integers.size(); i++) {
                try {
                    blockingQueue.put(integers.get(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //consumer
        new Thread(new QueueConsumer(blockingQueue)).start();
        new Thread(new QueueConsumer(blockingQueue)).start();
        new Thread(new QueueConsumer(blockingQueue)).start();
        new Thread(new QueueConsumer(blockingQueue)).start();
        new Thread(new QueueConsumer(blockingQueue)).start();
        //校验数据
//        System.exit(0);
//        System.out.println("out");
    }

    public static List<Integer> simulationData(){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10000; i ++) {
            result.add(i);
        }
        return result;
    }

}
