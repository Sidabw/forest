
package com.widget.poi.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;

public class CreateReport2 {
    public static void main(String[] args) throws Exception {
        preoduceDocx();
        //readPages();
    }

    public static void preoduceDocx() throws IOException, Exception {
        XWPFDocument xwpfDocument = new XWPFDocument();
        //第三.1段：大面空白解决方案：
        //临时性完美解决方案：添加一个看见不见的图片，循环；这样行间距照样生效
        for (int i = 0; i < 7; i++) {
            XWPFParagraph createParagraph22 = xwpfDocument.createParagraph();
            createParagraph22.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun createRun22 = createParagraph22.createRun();
            createRun22.setText(" ");
            createRun22.setFontSize(20);
            createRun22.setTextPosition(120);
            createRun22.addPicture(new FileInputStream(new File("C:\\Users\\think\\Desktop\\1.png")), Document.PICTURE_TYPE_PNG, "111.png", 50, 50);
        }
        XWPFParagraph createParagraph33 = xwpfDocument.createParagraph();
        XWPFRun createRun33 = createParagraph33.createRun();
        createRun33.addPicture(new FileInputStream(new File("C:\\Users\\think\\Desktop\\111.png")), Document.PICTURE_TYPE_PNG, "111.png", 4500000, 28000000);

        xwpfDocument.write(new FileOutputStream(new File("C:\\Users\\think\\Desktop\\testOUT.docx")));
        xwpfDocument.close();
    }

    /***
     * //TODO   好像不能给每页加页码？
     * @throws Exception
     */
    public static void readPages() throws Exception {
        XWPFDocument xwpfDocument = new XWPFDocument(new FileInputStream("C:\\Users\\think\\Desktop\\网察周报&月报模板.docx"));
        int pages = xwpfDocument.getProperties().getExtendedProperties().getPages();
        System.out.println(pages);
        List<XWPFParagraph> paragraphs = xwpfDocument.getParagraphs();
        for (XWPFParagraph xWPFParagraph : paragraphs) {
            //xWPFParagraph.get
            String text = xWPFParagraph.getText();
            List<XWPFRun> runs = xWPFParagraph.getRuns();
            for (XWPFRun xwpfRun : runs) {
                System.out.println("textPosition:::" + xwpfRun.getTextPosition());
            }
            System.out.println(text);
        }
        xwpfDocument.close();
    }

    /***
     * 跳到下一页
     * @param document
     * @param breakType
     */
    public void addNewPage(XWPFDocument document, BreakType breakType) {
        XWPFParagraph xp = document.createParagraph();
        xp.createRun().addBreak(breakType);
    }

}
