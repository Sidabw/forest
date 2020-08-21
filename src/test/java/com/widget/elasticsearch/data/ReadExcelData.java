/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ReadExcelData
 * Author:   feiyi
 * Date:     2019/3/12 10:45 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.elasticsearch.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.widget.elasticsearch.ClientDemo;
import com.widget.elasticsearch.IndexDemo;
import com.widget.elasticsearch.util.EsUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.elasticsearch.client.transport.TransportClient;

import java.io.*;
import java.util.ArrayList;

/**
 * 〈一句话功能简述〉:
 * 〈从excel中读取数据〉
 *
 * @author feiyi
 * @create 2019/3/12
 * @since 1.0.0
 */
public class ReadExcelData {

    public static void main(String[] args) throws IOException {
        //read data from excel
        ArrayList<TianmaoData> result = new ArrayList<>();
        for (int i = 1; i < 29; i++) {
            ArrayList<TianmaoData> sheetData = poiExcel("/Users/feiyi/Downloads/es_tianmao_data_test.xls", 1);
            result.addAll(sheetData);
        }
        //驼峰转下划线
        JSONArray resultConverted = EsUtil.entityToEsRecord(result);
        //insert into es
        TransportClient client = ClientDemo.getClient();
        resultConverted.stream().forEach(e -> {
            IndexDemo.indexNewRecored(client, ClientDemo.indexName, ClientDemo.indexType, null, JSON.toJSONString(e));
        });
    }

    private static ArrayList<TianmaoData> poiExcel(String realPath, int sheetIndex) throws IOException {
        ArrayList<TianmaoData> data = new ArrayList<>();
        File fileDes = new File(realPath);
        InputStream str = new FileInputStream(fileDes);
        HSSFWorkbook xwb = new HSSFWorkbook(str);  //利用poi读取excel文件流
        HSSFSheet st = xwb.getSheetAt(sheetIndex);
        //读取sheet的第一个工作表
        int rows = st.getLastRowNum();//总行数
        int cols;//总列数
        for (int i = 3; i < rows; i++) {
            TianmaoData tianmaoData = new TianmaoData();
            HSSFRow row = st.getRow(i);//读取某一行数据
            //获取行中所有列数据
            cols = row.getLastCellNum();
            for (int j = 0; j < cols; j++) {
                HSSFCell cell = row.getCell(j);
                //判断单元格的数据类型
                CellType cellTypeEnum = cell.getCellTypeEnum();
                switch (cellTypeEnum) {
                    case NUMERIC: // 数字
                        double numericCellValue = cell.getNumericCellValue();
                        if (j == 3) {
                            tianmaoData.setDiscountPrice(Double.toString(numericCellValue));
                        } else if (j == 4) {
                            tianmaoData.setOriginalCost(Double.toString(numericCellValue));
                        } else if (j == 5) {
                            tianmaoData.setDiscount(Double.toString(numericCellValue));
                        }
                        break;
                    case STRING: // 字符串
                        String stringCellValue = cell.getStringCellValue();
                        if (j == 0) {
                            tianmaoData.setStoreName(stringCellValue);
                        } else if (j == 2) {
                            tianmaoData.setProductName(stringCellValue);
                        }
                        break;
                    default:
                        break;
                }
            }
            data.add(tianmaoData);
        }
        return data;
    }
}
