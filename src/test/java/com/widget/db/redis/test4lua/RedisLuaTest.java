/**
 * Copyright (C), 2018-2021, zenki.ai FileName: RedisLuaTest Author:   feiyi Date:     2021/3/31 3:26 PM Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.db.redis.test4lua;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;
import java.util.UUID;

/**
 * 〈一句话功能简述〉:
 * 〈lua的基础操作：分布式锁〉
 *
 * @author feiyi
 * @create 2021/3/31
 * @since 1.0.0
 */
public class RedisLuaTest {

    private final Jedis jedis = new Jedis("127.0.0.1", 6379);

    public static void main(String[] args) throws InterruptedException {
        //能够看到一个线程能拿到锁，此时另外一个线程拿锁失败一直沦陷尝试
        //线程把锁释放后，另外一个线程成功获取到锁
        new Thread(() -> new RedisLuaTest().testLockAndUnlock()).start();
        new Thread(() -> new RedisLuaTest().testLockAndUnlock()).start();
        Thread.sleep(10000L);
    }

    public void testLockAndUnlock(){
        String lockName = "XXX:romId:123456";
        //保证我获取到的锁我来解锁
        String lockOwner = UUID.randomUUID().toString();
        try {
            boolean lockSuccess = tryLock(lockName, lockOwner);
            if (lockSuccess) {
                //do something 业务操作
                //...
                Thread.sleep(1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //保证业务出现异常时也会释放锁
            boolean unLockSuccess = unLock(lockName, lockOwner);
        }
    }

    private boolean unLock(String lockName, String lockOwner) {
        //保证我获取到的锁我来解锁
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then" +
                        "   return redis.call('del',KEYS[1]) " +
                        "else" +
                        "   return 0 " +
                        "end";
        Object unlockRes = jedis.eval(script, Collections.singletonList(lockName), Collections.singletonList(lockOwner));
        if ("1".equals(unlockRes.toString())) {
            System.out.printf("%s unlock success%n", Thread.currentThread().getId());
            return true;
        }
        System.out.printf("%s unlock failed%n", Thread.currentThread().getId());
        return false;
    }


    private boolean tryLock(String lockName, String lockOwner) throws InterruptedException {
        //阻塞2秒获取锁，获取不到则return false
        //锁本身的超时时间设置为10
        int timeout = 2000;
        for (;;) {
            System.out.printf("%s try to get lock%n", Thread.currentThread().getId());
            String setRes = jedis.set(lockName, lockOwner, SetParams.setParams().ex(10).nx());
            if ("OK".equals(setRes)) {
                System.out.printf("%s get lock success%n", Thread.currentThread().getId());
                return true;
            }
            Thread.sleep(100L);
            timeout = timeout - 100;
            if (timeout <= 0) {
                System.out.printf("%s get lock failed%n", Thread.currentThread().getId());
                return false;
            }
        }
    }

}
