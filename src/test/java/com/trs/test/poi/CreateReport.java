
package com.trs.test.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

public class CreateReport {
	public static void main(String[] args) throws Exception{
		dataList();
	}
	//@Test
	public void singleParagraph() throws FileNotFoundException, IOException{
		XWPFDocument xwpfDocument = new XWPFDocument();
		//一级标题统一字体16号、黑体、加粗
		XWPFParagraph createParagraph = xwpfDocument.createParagraph();
		createParagraph.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun createRun = createParagraph.createRun();
		createRun.setFontSize(16);	//
		//createRun.setColor("00B0F0");//176 B0 240 f0
		createRun.setText("一、标题1");
		createRun.setFontFamily("黑体");
		createRun.setBold(true);	//加粗
		//正文统一字体16号、仿宋、首行缩进
		XWPFParagraph createParagraph2 = xwpfDocument.createParagraph();
		createParagraph2.setAlignment(ParagraphAlignment.LEFT);
		createParagraph2.setIndentationFirstLine(600);
		XWPFRun createRun2 = createParagraph2.createRun();
		createRun2.setFontSize(16);	
		createRun2.setText("201X年X月X日X时X分至X月X日X时X分，XX舆情信息量共计XX条。其中，新闻XX篇、手机客户端文章XX篇、论坛主贴XX条、博客XX篇、微信公众号文章XX篇、微博XX条。");
		createRun2.setFontFamily("仿宋");
		
		xwpfDocument.write(new FileOutputStream("C:\\Users\\think\\Desktop\\1111111.docx"));
		xwpfDocument.close();
	}
	
	public static void dataList() throws Exception{
		XWPFDocument xdoc = new XWPFDocument();
		//一级标题统一字体16号、黑体、加粗
        XWPFParagraph headLine1 = xdoc.createParagraph();    
        headLine1.setAlignment(ParagraphAlignment.LEFT);  
        XWPFRun runHeadLine1 = headLine1.createRun();  
        runHeadLine1.setText("一、计划清单");  
        runHeadLine1.setFontSize(16);  
        runHeadLine1.setFontFamily("黑体");  
        runHeadLine1.setBold(true);
        
        /* XWPFParagraph headLine11 = xdoc.createParagraph();    
        headLine11.setAlignment(ParagraphAlignment.LEFT);  
        XWPFRun runHeadLine11 = headLine11.createRun();  
        runHeadLine11.setText("———————————————————————————");  
        runHeadLine11.setFontSize(14);  
        runHeadLine11.setFontFamily("微软雅黑");  
        runHeadLine11.setColor("fc9849");  */
        
        //实际需要根据数据量多少，数据类型来决定行数、列数
        XWPFTable dTable = xdoc.createTable(11, 4);  
//        dTable.setInsideHBorder(type, size, space, rgbColor);
        createTable(dTable, xdoc);  
       // setEmptyRow(xdoc,r1);  
        xdoc.write(new FileOutputStream("C:\\Users\\think\\Desktop\\1111111.docx"));
	}
	 public static void createTable(XWPFTable xTable,XWPFDocument xdoc) throws Exception{  
	        String bgColor="111111";  
	        CTTbl ttbl = xTable.getCTTbl();  
	        CTTblPr tblPr = ttbl.getTblPr() == null ? ttbl.addNewTblPr() : ttbl.getTblPr();  
	        
	        CTTblBorders borders=xTable.getCTTbl().getTblPr().addNewTblBorders();
			CTBorder hBorder=borders.addNewInsideH();
			//hBorder.setVal(STBorder.Enum.forString("dashed"));
			hBorder.setSz(new BigInteger("0"));
			//设置表格无边框
			//hBorder.setColor("0000FF");
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

			
			
	        CTTblWidth tblWidth = tblPr.isSetTblW() ? tblPr.getTblW() : tblPr.addNewTblW();  
	        tblWidth.setW(new BigInteger("8600"));  
	        tblWidth.setType(STTblWidth.DXA);  
	        setCellTitle(xdoc, getCellHight(xTable, 0, 0), "序号",bgColor,1000);  
	        setCellTitle(xdoc, getCellHight(xTable, 0, 1), "标题",bgColor,6400);  
	        setCellTitle(xdoc, getCellHight(xTable, 0, 2), "  来源",bgColor,2000);  
	        setCellTitle(xdoc, getCellHight(xTable, 0, 3), "时间",bgColor,3000);  
	        int number=0;  
	        for(int i=1;i<5;i++){  
	            number++;  
	            setCellText(xdoc, getCellHight(xTable, number,0), number+"",bgColor,1000);  
	            setCellText(xdoc, getCellHight(xTable, number,1), "国台办发言人回应\"公投法\",坚决反对\"台独\"，公开反对\"台独\"",bgColor,6400);  
	            setCellText(xdoc, getCellHight(xTable, number,2), "  中国新闻网",bgColor,2000);  
	            setCellText(xdoc, getCellHight(xTable, number,3), "2017-01-01 12:30",bgColor,3000);  
	        }  
	    }  
	    //设置表格高度  
	    private static XWPFTableCell getCellHight(XWPFTable xTable,int rowNomber,int cellNumber){  
	        XWPFTableRow row = null;  
	        row = xTable.getRow(rowNomber);  
	        row.setHeight(100);  
	        XWPFTableCell cell = null;  
	        cell = row.getCell(cellNumber);  
	        return cell;  
	    }  
	    private static void setCellText(XWPFDocument xDocxument, XWPFTableCell cell,  
	            String text, String bgcolor, int width) throws Exception {  
	        CTTc cttc = cell.getCTTc();  
	        CTTcPr cellPr = cttc.addNewTcPr();  
	        cellPr.addNewTcW().setW(BigInteger.valueOf(width));  
	        XWPFParagraph pIO =cell.addParagraph();  
	        cell.removeParagraph(0);  
	        XWPFRun rIO = pIO.createRun();  
	        //临时,测试序号列中添加图片
	        if(width == 1000){
	        	rIO.addPicture(new FileInputStream(new File("C:\\Users\\think\\Desktop\\111.png")), Document.PICTURE_TYPE_PNG, "111.png", 400000, 400000);
	        }else{
	        	rIO.setFontFamily("微软雅黑");  
	        	rIO.setColor("000000");  
	        	rIO.setFontSize(10);  
	        	rIO.setText(text);  
	        }
	       /* //设置文字底纹
	        CTRPr ctrpr = rIO.getCTR().getRPr() == null ? rIO.getCTR().addNewRPr() : rIO.getCTR().getRPr();
	        CTShd ctshd = ctrpr.isSetShd() ?  ctrpr.getShd() : ctrpr.addNewShd();
	        ctshd.setVal(STShd.Enum.forInt(10));
	        ctshd.setColor("CCA6EF");*/
	    }
	    private static void setCellTitle(XWPFDocument xDocxument, XWPFTableCell cell,  
	            String text, String bgcolor, int width) {  
	        CTTc cttc = cell.getCTTc();  
	        CTTcPr cellPr = cttc.addNewTcPr();  
	        cellPr.addNewTcW().setW(BigInteger.valueOf(width));  
	       /*  设置单元格居中，
	        *  cellPr.addNewVAlign().setVal(STVerticalJc.CENTER);
	        cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);*/
	        XWPFParagraph pIO =cell.addParagraph();  
	        cell.removeParagraph(0);  
	        XWPFRun rIO = pIO.createRun(); 
	        rIO.setFontFamily("黑体");  
	        rIO.setColor("000000");  
	        rIO.setFontSize(10);  
	        rIO.setText(text);  
	        rIO.setBold(true);
	       /* //设置文字底纹
	        CTRPr ctrpr = rIO.getCTR().getRPr() == null ? rIO.getCTR().addNewRPr() : rIO.getCTR().getRPr();
	        CTShd ctshd = ctrpr.isSetShd() ?  ctrpr.getShd() : ctrpr.addNewShd();
	        ctshd.setVal(STShd.Enum.forInt(10));
	        ctshd.setColor("CCA6EF");*/
	    }  
}
