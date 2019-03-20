
package com.widget.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 * 
 * poi,适配wpd和word的table最大宽度是8300
 * 
 * @author Brew	
 * @date 2018年6月14日
 */
public class TableTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*XWPFDocument xdoc = new XWPFDocument();
		
		XWPFTable xTable = xdoc.createTable(1, 3);
		CTTblBorders borders = xTable.getCTTbl().getTblPr().addNewTblBorders();
		CTBorder hBorder = borders.addNewInsideH();
		// hBorder.setVal(STBorder.Enum.forString("dashed"));
		hBorder.setSz(new BigInteger("0"));
		// hBorder.setColor("0000FF");
		CTBorder addNewBottom = borders.addNewBottom();
		CTBorder addNewTop = borders.addNewTop();
		CTBorder addNewLeft = borders.addNewLeft();
		CTBorder addNewRight = borders.addNewRight();
		CTBorder addNewInsideV = borders.addNewInsideV();
		addNewBottom.setSz(new BigInteger("0"));
		addNewTop.setSz(new BigInteger("0"));
		addNewLeft.setSz(new BigInteger("0"));
		addNewRight.setSz(new BigInteger("0"));
		addNewInsideV.setSz(new BigInteger("0"));
		XWPFTableRow row = null;
		row = xTable.getRow(0);
		//row.setHeight(100);
		XWPFTableCell cell = null;
		cell = row.getCell(0);
		CTTc cttc = cell.getCTTc();
		CTTcPr cellPr = cttc.addNewTcPr();
		cellPr.addNewTcW().setW(BigInteger.valueOf(2000));
		XWPFParagraph pIO = cell.addParagraph();
		pIO.setAlignment(ParagraphAlignment.LEFT);
		cell.removeParagraph(0);
		XWPFRun rIO = pIO.createRun();
		rIO.setFontFamily("微软雅黑");
		rIO.setColor("000000");
		rIO.setFontSize(10);
		rIO.setText("hahahaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		XWPFTableCell cell1 = row.getCell(1);
		CTTc cttc1 = cell1.getCTTc();
		CTTcPr cellPr1 = cttc1.addNewTcPr();
		cellPr1.addNewTcW().setW(BigInteger.valueOf(1160));
		XWPFParagraph pIO1 = cell1.addParagraph();
		pIO1.setAlignment(ParagraphAlignment.RIGHT);
		cell1.removeParagraph(0);
		XWPFRun rIO1 = pIO1.createRun();
		rIO1.setFontFamily("微软雅黑");
		rIO1.setColor("000000");
		rIO1.setFontSize(10);
		rIO1.setText("hahah");
		
		
		XWPFTableCell cell2 = row.getCell(2);
		CTTc cttc2 = cell2.getCTTc();
		CTTcPr cellPr2 = cttc2.addNewTcPr();
		cellPr2.addNewTcW().setW(BigInteger.valueOf(3320));
		XWPFParagraph pIO2 = cell2.addParagraph();
		pIO2.setAlignment(ParagraphAlignment.RIGHT);
		cell2.removeParagraph(0);
		XWPFRun rIO2 = pIO2.createRun();
		rIO2.setFontFamily("微软雅黑");
		rIO2.setColor("000000");
		rIO2.setFontSize(10);
		rIO2.setText("hahah");
		
		for(int i = 0; i< 3 ; i++){
			XWPFTableCell cell = row.getCell(i);
			CTTc cttc = cell.getCTTc();
			CTTcPr cellPr = cttc.addNewTcPr();
			XWPFParagraph pIO;
			if(i == 0 ){
				cellPr.addNewTcW().setW(BigInteger.valueOf(3320));
				pIO = cell.addParagraph();
				pIO.setAlignment(ParagraphAlignment.LEFT);
				cell.removeParagraph(0);
				XWPFRun rIO = pIO.createRun();
				rIO.setFontFamily("微软雅黑");
				rIO.setColor("000000");
				rIO.setFontSize(16);
				rIO.setText("北京拓尔思信息科技股份有限公司  ");
			}else if(i == 2){
				cellPr.addNewTcW().setW(BigInteger.valueOf(3320));
				pIO = cell.addParagraph();
				pIO.setAlignment(ParagraphAlignment.RIGHT);
				cell.removeParagraph(0);
				XWPFRun rIO = pIO.createRun();
				rIO.setFontFamily("微软雅黑");
				rIO.setColor("000000");
				rIO.setFontSize(16);
				rIO.setText("2018年06月14日");
			}else{
				cellPr.addNewTcW().setW(BigInteger.valueOf(1660));
				pIO = cell.addParagraph();
				pIO.setAlignment(ParagraphAlignment.CENTER);
				cell.removeParagraph(0);
				XWPFRun rIO = pIO.createRun();
				rIO.setFontFamily("微软雅黑");
				rIO.setColor("000000");
				rIO.setFontSize(16);
				rIO.setText("");
			}
		}
		*/
		String pUnit="这是我的日报测试你造嘛你造嘛";
		XWPFDocument xdoc = new XWPFDocument();
		XWPFParagraph createParagraph = xdoc.createParagraph();
		createParagraph.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun createRun = createParagraph.createRun();
		createRun.setFontSize(33);
		//createRun.setColor("00B0F0");//176 B0 240 f0
		createRun.setColor("ff0000");//176 B0 240 f0
		createRun.setFontFamily("楷体GB2312");
		if(pUnit.length() > 8){
			createRun.setText(pUnit.substring(0, 8));
			createRun.addBreak();
			createRun.setText(pUnit.substring(8));
		}else{
			createRun.setText(pUnit);
		}
		/*XWPFParagraph createParagraph4 = xdoc.createParagraph();
		createParagraph4.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun createRun4 = createParagraph4.createRun();
		createRun4.setFontSize(16);
		//createRun4.setText("北京拓尔思信息科技股份有限公司" + countSpace("北京拓尔思信息科技股份有限公司") + dateHandle"2018年06月14日");
		int letterANDfigureCount = charCount(pUnit);
		int x = (pUnit.length() - letterANDfigureCount)* 2;
		if(x < 20 || x == 20){
			//正常显示
			createRun4.setText(pUnit + countSpace(pUnit) + "2018年06月14日");
		}else{
			//两行显示
			createRun4.setText(pUnit.substring(0, 10) + "               " + "2018年06月14日");
			createRun4.addBreak();
			createRun4.setText(pUnit.substring(10));
		}
		createRun4.setFontFamily("楷体_GB2312");*/
//		createRun.setText("这是我的日报测试");
		xdoc.write(new FileOutputStream("C:\\Users\\think\\Desktop\\poitest.docx"));
		xdoc.close();
	}
	private static String countSpace(String preparationUnits){
		int letterANDfigureCount = charCount(preparationUnits);
		String space = "";
		int spaceLength = 35  - ((preparationUnits.length() - letterANDfigureCount)* 2 + letterANDfigureCount);
		for(int i =0; i<spaceLength; i++){
			space += " ";
		}
//		System.out.println("preparationUnits.length  ::  " + preparationUnits.length());
//		System.out.println("spaceLength  ::  " + spaceLength);
		return space;
	}
	private static int charCount(String chaSquen){
		int letterANDfigureCount = 0;
		char[] charArray = chaSquen.toCharArray();
		for(char each : charArray){
			//根据ASCII判断
			if((Integer.valueOf(each) > 33) && (Integer.valueOf(each) < 127)){
				letterANDfigureCount ++ ;
			}
		}
		return letterANDfigureCount;
	}

}
