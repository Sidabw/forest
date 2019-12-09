/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: CollectionsTest
 * Author:   feiyi
 * Date:     2019/12/9 11:17 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/12/9
 * @since 1.0.0
 */
public class CollectionsTest {

    @Test
    public void testShuffle(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        System.out.println(integers);
        Collections.shuffle(integers);
        System.out.println(integers);
    }

}
