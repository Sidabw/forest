
package com.trs.test.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.ISDTContent;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFSDT;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;

public class POItest4XWPF {
	public static void main(String[] args) throws Exception{
		preoduceDocx();
		//readPages();
		//test();
	}
	/**
	 * 尝试读到周报封页中的内容，但读到的格式是XWPFSDT
	 * @throws Exception
	 */
	public static void test()throws Exception{
		XWPFDocument xwpfDocument = new XWPFDocument(new FileInputStream("C:\\Users\\think\\Desktop\\ReportTemplate3.docx"));
		List<IBodyElement> bodyElements = xwpfDocument.getBodyElements();
		System.out.println(bodyElements.size());
		for(int i =0 ; i< bodyElements.size(); i++){
			if(bodyElements.get(i) instanceof XWPFTable){
				System.out.println("哈哈哈哈");
			}else if(bodyElements.get(i) instanceof XWPFParagraph){
				System.out.println("呵呵呵");
			}else if (bodyElements.get(i) instanceof XWPFSDT){
				XWPFSDT abc = (XWPFSDT)bodyElements.get(i);
				/*XWPFDocument document = abc.getDocument();
				List<XWPFParagraph> paragraphs = document.getParagraphs();
				System.out.println("XWPFSDT paragraph size : "+ paragraphs.size());
				for(XWPFParagraph para: paragraphs){
					System.out.println(para.getText());
					System.out.println(para.get);
					List<XWPFRun> runs = para.getRuns();
					for(XWPFRun run : runs){
						System.out.println(run.get);
					}
				}*/
				ISDTContent content = abc.getContent();
				String text = content.getText();
				System.out.println(text);
				System.out.println("oooo");
				//读取文档格式，并在新的Document中设置；还要再paragraph中设置
				CTStyles style = xwpfDocument.getStyle();
				XWPFDocument xwpfDocument2 = new XWPFDocument();
				XWPFStyles createStyles = xwpfDocument2.createStyles();
				createStyles.setStyles(style);
				
				XWPFParagraph createParagraph = xwpfDocument2.createParagraph();
				createParagraph.setStyle("1");
				XWPFRun createRun = createParagraph.createRun();
				createRun.setText(text);
				xwpfDocument2.write(new FileOutputStream("C:\\Users\\think\\Desktop\\1111111.docx"));
				xwpfDocument2.close();
			}
		}
		List<XWPFParagraph> paragraphs = xwpfDocument.getParagraphs();
		System.out.println(paragraphs.size());
		/*for(XWPFParagraph paragraph : paragraphs){
			System.out.println(paragraph.getText());
			System.out.println(paragraph.getParagraphText());
			List<XWPFRun> runs = paragraph.getRuns();
			paragraph.get
			System.out.println("run size:"+runs.size());
			for(XWPFRun run : runs){
				System.out.println(run);
			}
			paragraph.getText();
		}*/
		xwpfDocument.close();
	}
	public static void preoduceDocx() throws IOException, Exception{
		XWPFDocument xwpfDocument = new XWPFDocument();
		//第一段：蓝色 28号字 楷体 居中
		XWPFParagraph createParagraph = xwpfDocument.createParagraph();
		createParagraph.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun createRun = createParagraph.createRun();
		createRun.setFontSize(42);
		//createRun.setColor("00B0F0");//176 B0 240 f0
		createRun.setColor("ff0000");//176 B0 240 f0
		createRun.setText("XXXXXXX");
		createRun.setFontFamily("仿宋");
		createRun.setBold(true);
		//第二段：黑色 22号字 隶书 居中
		XWPFParagraph createParagraph2 = xwpfDocument.createParagraph();
		createParagraph2.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun createRun2 = createParagraph2.createRun();
		createRun2.setFontSize(42);
		createRun2.setText("舆情周报/月报");
		createRun2.setFontFamily("仿宋");
		createRun2.setColor("ff0000");
		createRun2.setBold(true);
		//第三段：
		XWPFParagraph createParagraph3 = xwpfDocument.createParagraph();
		createParagraph3.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun createRun3 = createParagraph3.createRun();
		createRun3.setFontSize(16);
		createRun3.setText("（201X年第X期  总第XX期）");
		createRun3.setFontFamily("仿宋");
		createRun3.setBold(true);
		
		for(int i=0; i<7; i++){
			XWPFParagraph createParagraph22 = xwpfDocument.createParagraph();
			createParagraph22.setAlignment(ParagraphAlignment.CENTER);
			XWPFRun createRun22 = createParagraph22.createRun();
			createRun22.setText(" ");
			createRun22.setFontSize(20);
			createRun22.setTextPosition(120);
			createRun22.addPicture(new FileInputStream(new File("C:\\Users\\think\\Desktop\\1.png")), Document.PICTURE_TYPE_PNG, "111.png", 50, 50);
		}
		
		//第四段：
		XWPFParagraph createParagraph4 = xwpfDocument.createParagraph();
		createParagraph4.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun createRun4 = createParagraph4.createRun();
		createRun4.setFontSize(16);
		createRun4.setText("XX单位");
		createRun4.setFontFamily("仿宋");
		createRun4.setBold(true);
		
		//第五段
		XWPFParagraph createParagraph5 = xwpfDocument.createParagraph();
		createParagraph5.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun createRun5 = createParagraph5.createRun();
		createRun5.setFontSize(16);
		createRun5.setText("XX单位");
		createRun5.setFontFamily("仿宋");
		createRun5.setBold(true);
		
		/*createParagraph3.setAlignment(ParagraphAlignment.RIGHT);
		XWPFRun createRun4 = createParagraph3.createRun();
		createRun4.setFontSize(16);
		createRun4.setText("201X年X月X日 ");
		createRun4.setFontFamily("隶书体");*/
		
		
		//第三段：
		//临时性完美解决方案：添加一个看见不见的图片，循环；这样行间距照样生效
		
		//第四段，表格 即列表类信息
		/*XWPFTable createTable = xwpfDocument.createTable(21, 3);
		CTTbl ttbl = createTable.getCTTbl();  
        CTTblPr tblPr = ttbl.getTblPr() == null ? ttbl.addNewTblPr() : ttbl  
                .getTblPr(); 
		for(int i=0; i<21; i++){
			XWPFTableRow row = createTable.getRow(0);
			
		}*/
		/*XWPFTableRow createRow = createTable.createRow();
		createTable.removeRow(0);
		for(int i=0; i<4; i++){
			XWPFTableCell createCell = createRow.createCell();
			if(i == 0){
				//createRow.removeCell(0);
			}
			XWPFParagraph addParagraph = createCell.addParagraph();
			createCell.removeParagraph(0);
			XWPFRun createRun3 = addParagraph.createRun();
			createRun3.setText("abc");
			createRun3.setFontSize(20);
		}
		createRow.removeCell(0);
		System.out.println(createRow.getCell(0).getText());
		System.out.println(createRow.getCell(1).getText());*/
		
		
		XWPFParagraph createParagraph33 = xwpfDocument.createParagraph();
		XWPFRun createRun33 = createParagraph33.createRun();
		createRun33.addPicture(new FileInputStream(new File("C:\\Users\\think\\Desktop\\111.png")), Document.PICTURE_TYPE_PNG, "111.png", 4500000, 28000000);
		
		xwpfDocument.write(new FileOutputStream(new File("C:\\Users\\think\\Desktop\\testOUT.docx")));
		xwpfDocument.close();
	}
	
	
	
	
	public static void readDocx() throws IOException{
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\think\\Desktop\\test000.docx");
		XWPFDocument xwpfDocument = new XWPFDocument(fileInputStream);
		List<XWPFParagraph> paragraphs = xwpfDocument.getParagraphs();
		for(XWPFParagraph xWPFParagraph : paragraphs){
			String text = xWPFParagraph.getText();
			System.out.println(text);
		}
		xwpfDocument.close();
	}
	public static void readPages() throws Exception{
		XWPFDocument xwpfDocument = new XWPFDocument(new FileInputStream("C:\\Users\\think\\Desktop\\网察周报&月报模板.docx"));
		int pages = xwpfDocument.getProperties().getExtendedProperties().getPages();
		System.out.println(pages);
		List<XWPFParagraph> paragraphs = xwpfDocument.getParagraphs();
		for(XWPFParagraph xWPFParagraph : paragraphs){
			//xWPFParagraph.get
			String text = xWPFParagraph.getText();
			List<XWPFRun> runs = xWPFParagraph.getRuns();
			for(XWPFRun xwpfRun : runs){
				System.out.println("textPosition:::"+xwpfRun.getTextPosition());
			}
			System.out.println(text);
		}
		xwpfDocument.close();
	}
}
