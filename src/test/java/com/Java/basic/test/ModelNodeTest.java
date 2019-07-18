/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ModelNodeTest
 * Author:   feiyi
 * Date:     2019/7/3 10:32 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

import java.util.*;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/7/3
 * @since 1.0.0
 */
public class ModelNodeTest {


    @Test
    public void test3() {
        ModelNode modelNodeA = new ModelNode("A", null, Arrays.asList("B", "C"));
        ModelNode modelNodeC = new ModelNode("C", "A", "E");
        ModelNode modelNodeD = new ModelNode("D", "B", "E");
        ModelNode modelNodeB = new ModelNode("B", "A", "D");
        ModelNode modelNodeE = new ModelNode("E", Arrays.asList("D", "C "), null);
        List<ModelNode> modelNodes = Arrays.asList(modelNodeA, modelNodeC, modelNodeB,  modelNodeD, modelNodeE);

        //先计算所有的fs 和 ps
        for (ModelNode modelNode : modelNodes) {
            Object curPMid = modelNode.getPreviousModelId();
            Object curFMid = modelNode.getForwardModelId();
            for (ModelNode modelNodeIn : modelNodes) {
                String curInModelId = modelNodeIn.getCurModelId();
                if (contained(curPMid, curInModelId)) modelNode.setPs(modelNode.getPs() + 1);
                if (contained(curFMid, curInModelId)) modelNode.setFs(modelNode.getFs() + 1);
            }
        }
        ModelNode first = new ModelNode(null,null,null);
        for (ModelNode modelNode : modelNodes) {
            if (modelNode.getPs() == 0) first = modelNode;
        }
        ArrayList<ModelNode> result = new ArrayList<>();
        Deque<ModelNode> deque = new ArrayDeque<>();
        deque.offer(first);//入队

        while (!deque.isEmpty()) {
            ModelNode cur = deque.poll();//出队
            result.add(cur);
            List<ModelNode> curForwards = getForwardsFromCur(cur, modelNodes);
            for (ModelNode modelNode : curForwards) {
                modelNode.setPs(modelNode.getPs() - 1);
                if (modelNode.getPs() == 0) {
                    deque.offer(modelNode);
                }
            }
        }
        System.out.println(JSONArray.toJSONString(result));

    }

    private List<ModelNode> getForwardsFromCur(ModelNode cur, List<ModelNode> modelNodes) {
        Object forwardModelId = cur.getForwardModelId();
        if (forwardModelId instanceof String) {
            for (ModelNode modelNode : modelNodes) {
                if (modelNode.getCurModelId().equals(forwardModelId)) return Arrays.asList(modelNode);
            }
        } else if (forwardModelId instanceof List) {
            List list = (List)forwardModelId;
            ArrayList<ModelNode> result = new ArrayList<>();
            for (Object objModelNode : list) {
                for (ModelNode modelNode : modelNodes) {
                    if (modelNode.getCurModelId().equals(objModelNode)) {
                        result.add(modelNode);
                        break;
                    }
                }
            }
            return result;
        }
        System.out.println("EMPTY from method {getForwardsFromCur}::" + JSONObject.toJSONString(cur));
        return new ArrayList<>();
    }

    //判断左边是否eq or contains 右边
    private boolean contained(Object left, String right) {
        if (left == null || right == null) return false;
        if (left instanceof String) {
            return left.equals(right);
        } else if (left instanceof List) {
            return ((List)left).contains(right);
        }
        return false;
    }

}
