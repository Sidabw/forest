/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/3/20 8:58 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.poi.template;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/3/20
 * @since 1.0.0
 */
public class Demo {

    /**
     * //TODO   读模版操作
     * 尝试读到周报封页中的内容，但读到的格式是XWPFSDT
     *
     * @throws Exception
     */
    public static void test() throws Exception {
        XWPFDocument xwpfDocument = new XWPFDocument(new FileInputStream("C:\\Users\\think\\Desktop\\ReportTemplate3.docx"));
        List<IBodyElement> bodyElements = xwpfDocument.getBodyElements();
        System.out.println(bodyElements.size());
        for (int i = 0; i < bodyElements.size(); i++) {
            if (bodyElements.get(i) instanceof XWPFTable) {
                System.out.println("哈哈哈哈");
            } else if (bodyElements.get(i) instanceof XWPFParagraph) {
                System.out.println("呵呵呵");
            } else if (bodyElements.get(i) instanceof XWPFSDT) {
                XWPFSDT abc = (XWPFSDT) bodyElements.get(i);
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
}
