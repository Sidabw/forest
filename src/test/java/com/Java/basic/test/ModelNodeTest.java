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

import org.junit.Test;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void test(){
        ModelNode2 modelNodeA = new ModelNode2("A", null, Arrays.asList("B", "C"));
//        ModelNode modelNodeC = new ModelNode("C", "A", "E");
//        ModelNode modelNodeD = new ModelNode("D", "B", "E");
//        ModelNode modelNodeB = new ModelNode("B", "A", "D");
//        ModelNode modelNodeE = new ModelNode("E", Arrays.asList("D", "C "), null);
//        List<ModelNode> modelNodes = Arrays.asList(modelNodeA, modelNodeC, modelNodeB,  modelNodeD, modelNodeE);
//        ModelNode firstModelNode = null;
//        ModelNode lastModelNode = null;
//        for (ModelNode modelNode : modelNodes) {
//            if (modelNode.getPrevious
// ModelId() == null) firstModelNode = modelNode;
//            else if (modelNode.getForwardModelId() == null) lastModelNode = modelNode;
//        }
//        if (firstModelNode == null || lastModelNode == null) return;
//        List<ModelNode> modelNodesSorted = new ArrayList<>();
//        modelNodesSorted.add(firstModelNode);
//        modelNodesSorted.add(lastModelNode);
//        int indexOffset = 1;
//
//        int modelNodesSize = modelNodes.size();
//        ModelNode previous = firstModelNode;
//        for (int i = 0; i< modelNodesSize; i ++) {
//            if (modelNodesSize == modelNodesSorted.size()) break;
//            ModelNode cur = modelNodes.get(i);
//            String curModelId = cur.getCurModelId();
//            Object curPreviousModelId = cur.getPreviousModelId();
//            Object curForwardModelId = cur.getForwardModelId();
//            Object forwardModelId = previous.getForwardModelId();
//            if (curForwardModelId == null || curPreviousModelId == null) continue;
//            if (forwardModelId instanceof String ) {
//                if (forwardModelId.equals(curModelId)) {
//                    if (curPreviousModelId instanceof String) {
//                        modelNodesSorted.add(indexOffset, cur);
//                        indexOffset++;
//                        previous = cur;
//                        continue;
//                    } else if (curPreviousModelId instanceof List) {
//                        //判断汇聚的情况下是否插入
//                        boolean allIn = true;
//                        for (Object each : (List)curPreviousModelId) {
//                            String eachStr = each.toString();
//                            boolean b1 = false;
//                            for (ModelNode modelNode : modelNodesSorted) {
//                                if (modelNode.getCurModelId().equals(eachStr)) {
//                                    b1 =true;
//                                    break;
//                                }
//                            }
//                            if (!b1) {
//                                allIn = false;
//                                break;
//                            }
//                        }
//                        if (allIn) {
//                            modelNodesSorted.add(indexOffset, cur);
//                            indexOffset++;
//                            previous = cur;
//                            continue;
//                        } else continue;
//                    } else continue;
//                } else continue;
//
//            } else if (forwardModelId instanceof List) {
//                for (Object eachForwardModelId : (List)forwardModelId){
//                    if (eachForwardModelId.equals(curModelId)) {
//                        if (curPreviousModelId instanceof String) {
//                            modelNodesSorted.add(indexOffset, cur);
//                            indexOffset++;
//                            previous = cur;
//                            break;
//                        } else if (curPreviousModelId instanceof List) {
//                            boolean allIn = true;
//                            for (Object each : (List)curPreviousModelId) {
//                                String eachStr = each.toString();
//                                boolean b1 = false;
//                                for (ModelNode modelNode : modelNodesSorted) {
//                                    if (modelNode.getCurModelId().equals(eachStr)) {
//                                        b1 =true;
//                                        break;
//                                    }
//                                }
//                                if (!b1) {
//                                    allIn = false;
//                                    break;
//                                }
//                            }
//                            if (allIn) {
//                                modelNodesSorted.add(indexOffset, cur);
//                                indexOffset++;
//                                previous = cur;
//                                break;
//                            } else continue;
//                        } else continue;
//                    } else continue;
//                }
//            }
//        }
//        int modelNodeSortedSize = modelNodesSorted.size();
//        while (modelNodeSortedSize != modelNodesSize) {
//            for (ModelNode modelNode : modelNodes) {
//                String curModelId = modelNode.getCurModelId();
//                boolean contained = false;
//                for (ModelNode node : modelNodesSorted) {
//                    if (node.getCurModelId().equals(curModelId)) {
//                        contained = true;
//                        break;
//                    }
//                }
//                if (contained) continue;
//
//            }
//            modelNodeSortedSize = modelNodesSorted.size();
//        }
//        for (ModelNode modelNode : modelNodesSorted) {
//            System.out.println(modelNode.getCurModelId());
//        }




//        //切面列表中放进第一个切面和最后一个切面
//        ArrayList<ModelCut> modelNodesSorted = new ArrayList<>();
//        ModelCut firstCut = new ModelCut(firstModelNode);
//        ModelCut lastCut = new ModelCut(lastModelNode);
//        modelNodesSorted.add(firstCut);
//        modelNodesSorted.add(lastCut);
//        indexOffset = 1;
//
//        int modelsSize = modelNodes.size();
//        ModelCut modelCut = firstCut;
//        for (int i = 0; i < modelsSize ; i++) {
//            ModelNode[] cutModelNodes = modelCut.getModelNodes();
//            //当前切面的所有forwardNodes
//            ArrayList<String> forwardNodesAll = new ArrayList<>();
//            for (ModelNode mn : cutModelNodes) {
//                Object forwardModelId = mn.getForwardModelId();
//                if (forwardModelId instanceof String) forwardNodesAll.add(forwardModelId.toString());
//                else if (forwardModelId instanceof List) forwardNodesAll.addAll((List)forwardModelId);
//            }
//            //拿所有node的previousNode进行判断
//            ArrayList<ModelNode> modelNodesIn = new ArrayList<>();
//            for (int j = 0 ; j < modelsSize ; j++) {
//                ModelNode cur = modelNodes.get(j);
//                Object curPreviousModelId = cur.getPreviousModelId();
//                if (curPreviousModelId == null) continue;
//                if (curPreviousModelId instanceof String) {
//                    String m1 = curPreviousModelId.toString();
//                    if (forwardNodesAll.contains(m1)) {
//                        modelNodesIn.add(cur);
//                        continue;
//                    }
//                } else if (curPreviousModelId instanceof List) {
//
//                }
//            }
//        }
    }

    @Test
    public void test1(){
        int[][] arr = new int[][]{{1,2,3},{1,5},{2}};
        System.out.println(arr[0][1]);
        System.out.println(arr[1][0]);
        System.out.println(arr[2][0]);
    }
}
