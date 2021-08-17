package com.Java.queue.delay;

import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 回放api静态化延迟处理元素类
 *
 * @author shaogz
 */
@ToString
public class ReplayDelayItem implements Delayed {

    /**
     * 回放id
     */
    @Getter
    private final int recordId;
    /**
     * 视频时长
     */
    @Getter
    private final int duration;
    /**
     * 过期时间
     */
    private final long expire;

    public ReplayDelayItem(int recordId, int videoDuration, int delay, TimeUnit unit) {
        this.recordId = recordId;
        this.duration = videoDuration;
        //按照给定的时间单位 和 delay 得到1个delayMillis, 再就是expire
        this.expire = System.currentTimeMillis() + (delay > 0 ? unit.toMillis(delay) : 0);
    }

    /**
     * 延迟队列内部比较排序使用
     * @param unit 时间单位
     * @return: long 正数 负数 0
     * @Author: shaogz
     * @Date: 2021/7/20 2:05 PM
     **/
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }


    @Override
    public int compareTo(Delayed o) {
        return (int)(this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }
}
