/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ModelCut
 * Author:   feiyi
 * Date:     2019/7/3 11:14 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.test;

import com.sun.xml.internal.ws.policy.sourcemodel.ModelNode;

import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/7/3
 * @since 1.0.0
 */
public class ModelCut {

    private ModelNode2[] modelNodes;

    public ModelCut(ModelNode2... modelNodes) {
        this.modelNodes = modelNodes;
    }

    public ModelNode2[] getModelNodes() {
        return modelNodes;
    }

    public void setModelNodes(ModelNode2... modelNodes) {
        this.modelNodes = modelNodes;
    }
}
