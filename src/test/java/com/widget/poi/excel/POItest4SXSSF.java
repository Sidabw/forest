package com.widget.poi.excel;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class POItest4SXSSF {
    /***
     * excel生成图表测试
     * @param args
     * @throws Exception
     */
	public static void main(String[] args) throws Exception{

		/*SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
		SXSSFSheet sheet1 = sxssfWorkbook.createSheet("sheet1");
		//创建样式 并设置居中
		CellStyle cellStyle = sxssfWorkbook.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		//第0行数据填充
		SXSSFRow row0 = sheet1.createRow(0);
		for(int i=0 ;i <7 ;i++){
			SXSSFCell cell = row0.createCell(i);
			if(i==0){
				cell.setCellValue("");
				cell.setCellStyle(cellStyle);
			}else{
				cell.setCellValue("系列 "+i);
				cell.setCellStyle(cellStyle);
			}
		}
		//第1行添加数据
		SXSSFRow row1 = sheet1.createRow(1);
		for(int i= 0; i<7;i++){
			SXSSFCell cell1 = row1.createCell(i);
			if(i==0){
				cell1.setCellValue("类别1");
				cell1.setCellStyle(cellStyle);
			}else{
				cell1.setCellValue(new Random().nextInt(20)+1);
				cell1.setCellStyle(cellStyle);
			}
		}
		FileOutputStream fileOutputStream = new FileOutputStream("111.docx");
		
		sxssfWorkbook.write(fileOutputStream);
		sxssfWorkbook.close();*/
		//开始生成柱状图
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//dataset.setValue(value, rowKey, columnKey);
		dataset.addValue(0.8, "济南", "城市");
		dataset.addValue(1.1, "淄博", "城市");
		dataset.addValue(0.3, "潍坊", "城市");
		dataset.addValue(0.5, "日照", "城市");
		dataset.addValue(0.7, "烟台", "城市");
		JFreeChart chart = ChartFactory.createBarChart("主标题", "x轴标题", "y轴标题", 
										dataset, //数据集合
										PlotOrientation.VERTICAL,//图形的显示方式(水平/垂直)
										true,
										true, 
										true);
		BufferedImage createBufferedImage = chart.createBufferedImage(1000, 500);
		ImageIO.write(createBufferedImage, "png", new FileOutputStream("11.png"));
	}
}
