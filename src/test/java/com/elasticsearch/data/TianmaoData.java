/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: TianmaoData
 * Author:   feiyi
 * Date:     2019/3/18 11:57 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.elasticsearch.data;

/**
 * 〈一句话功能简述〉:
 * 〈对应es_tianmao_data_test.xls 文件〉
 *
 * @author feiyi
 * @create 2019/3/18
 * @since 1.0.0
 */
public class TianmaoData {

    private String storeName;

    private String productName;

    private String originalCost;

    private String discountPrice;

    private String discount;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(String originalCost) {
        this.originalCost = originalCost;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
