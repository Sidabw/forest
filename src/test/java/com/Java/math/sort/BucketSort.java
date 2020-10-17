/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: BucketSort
 * Author:   feiyi
 * Date:     2020/10/17 12:28 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.math.sort;

import com.Java.math.sort.quick.QuickSort;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 〈一句话功能简述〉:
 * 〈桶排〉
 *
 * @author feiyi
 * @create 2020/10/17
 * @since 1.0.0
 */
public class BucketSort {

    public static void main(String[] args) {
        //构建一个大小为100000的数组。该数组的最大值不会超过300000
        int[] testData = buildTestData();
        //获取最大值。最小值的话默认就是0
        int max = getMaxVal(testData);
        //由数组大小得到划分的桶个数：100
        int bucketNum = 50;
        //由数据的最大值得到每个桶的值范围：
        // 第一个桶 0 ~ max/bucketNum
        // 第二个桶 max/100 + 1 ～ 2*（max/100）
        // ...
        //99*（max/100） + 1 ~ 100*（max/100）
        int eachBucketSiz = testData.length/bucketNum;
        int[][] result = new int[bucketNum][eachBucketSiz];
        int[] resultIndexes = new int[bucketNum];//记录每个桶的当前索引
        for (int each : testData) {
            //找到应该放到哪个桶里
            int bucketIndex = getBucketIndex(each, max, bucketNum);
            //拿到这个桶
            int[] curBucket = result[bucketIndex];
            //拿到应该放到这个桶的哪个位置上去
            int index = resultIndexes[bucketIndex];
            //放上去
            curBucket[index++] = each;
            //更新索引
            resultIndexes[bucketIndex] = index;
            //校验当前桶是否要扩容(当然正规应该是继续往下分桶)
            if (index == curBucket.length) {
                int[] copyArr = Arrays.copyOf(curBucket, 2 * curBucket.length);
                result[bucketIndex] = copyArr;
            }
        }
        //对每个桶进行快排
        //输出结果
        for (int i = 0; i < result.length; i++) {
            int[] eachBucket = result[i];
            int resultIndex = resultIndexes[i];
            int[] resultRange = Arrays.copyOfRange(eachBucket, 0, resultIndex - 1);
            QuickSort.quickSort2(resultRange,0, resultRange.length - 1);
            for (int j = 0; j < resultRange.length; j++) {
                System.out.println(resultRange[j]);
            }
        }
    }


    //每个桶的最大值分别是max/100、2*（max/100）···100*（max/100）
    //使用折半查找，找的第一个小于当前值的值。时间复杂度log n
    //这里就顺序查找了，先简单实现下。。
    //...
    //不需要... 假设每个桶的最大值分别是100、200、300...
    //进来一个101，应该在哪个桶里？当然是第二个桶。也就是角标为1的桶。
    private static int getBucketIndex(int each, int max, int bucketNum) {
        int result = each/(max/bucketNum);
        return result == bucketNum ? result -1 : result;
    }

    private static int getMaxVal(int[] testData) {
        int  max = 0;
        for (int each : testData) {
            if (each > max) {
                max = each;
            }
        }
        return max;
    }

    private static int[] buildTestData() {
        int maxLen = 1000;
        int maxVal = 3000;
        int[] arr = new int[maxLen];
        for (int i = 0; i< maxLen; i++) {
            int random;
            while ((random = new Random().nextInt(maxVal)) == 0) {

            }
            arr[i] = random;
        }
        return arr;
    }
}
