/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: IpAddressGetTest
 * Author:   feiyi
 * Date:     2020/12/28 4:19 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.wx;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/12/28
 * @since 1.0.0
 */
public class IpAddressGetTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip4 = Inet4Address.getLocalHost();
        System.out.println(ip4.getHostAddress());
    }
}
