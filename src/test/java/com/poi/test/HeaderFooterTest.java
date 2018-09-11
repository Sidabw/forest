package com.poi.test;

import com.alibaba.druid.util.StringUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.*;
import java.math.BigInteger;

/***
 *  Created by shao.guangze on 2018/8/30
 *  / 代表根目录，可能是跟配置文件有关？这里/ 代表E://
 */
public class HeaderFooterTest {
    public static void main(String[] args) throws Exception {
        XWPFDocument xwpfDocument = new XWPFDocument();
        createHeader(xwpfDocument, "orgFullName", "jiade");
        createFooter(xwpfDocument, "123", "12");
        xwpfDocument.write(new FileOutputStream("/headerFooterTest.docx"));
        xwpfDocument.close();
    }
    public static void createHeader(XWPFDocument doc, String orgFullName, String logoFilePath) throws Exception {
        /*
         * 对页眉段落作处理，使公司logo图片在页眉左边，公司全称在页眉右边
         * */
        CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(doc,     sectPr);
        XWPFHeader header = headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);

        XWPFParagraph paragraph = header.createParagraph();
        //XWPFParagraph paragraph = header.getParagraphArray(0);
        paragraph.setAlignment(ParagraphAlignment.LEFT);
        paragraph.setBorderBottom(Borders.THICK);

        CTTabStop tabStop = paragraph.getCTP().getPPr().addNewTabs().addNewTab();
        tabStop.setVal(STTabJc.RIGHT);
        int twipsPerInch =  1440;
        tabStop.setPos(BigInteger.valueOf(6 * twipsPerInch));

        XWPFRun run = paragraph.createRun();
        setXWPFRunStyle(run,"新宋体",10);

        /*
         * 根据公司logo在ftp上的路径获取到公司到图片字节流
         * 添加公司logo到页眉，logo在左边
         * */
        if (!StringUtils.isEmpty(logoFilePath)) {
            InputStream is = new FileInputStream(new File("E:\\workspaces\\JavaHighClass\\forest\\handsome_guy.jpg"));

            XWPFPicture picture = run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, "haha", Units.toEMU(80), Units.toEMU(45));

            String blipID = "";
            for(XWPFPictureData picturedata : header.getAllPackagePictures()) { //这段必须有，不然打开的logo图片不显示
                blipID = header.getRelationId(picturedata);
            }
            picture.getCTPicture().getBlipFill().getBlip().setEmbed(blipID);
            run.addTab();
            is.close();
        }

        /*
         * 添加字体页眉，公司全称
         * 公司全称在右边
         * */
        if (!StringUtils.isEmpty(orgFullName)) {
            run = paragraph.createRun();
            run.setText(orgFullName);
            setXWPFRunStyle(run,"新宋体",10);
        }
    }
    public static void createFooter(XWPFDocument document, String telephone, String orgAddress) throws Exception {
        /*
         * 生成页脚段落
         * 给段落设置宽度为占满一行
         * 为公司地址和公司电话左对齐，页码右对齐创造条件
         * */
        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(document, sectPr);
        XWPFFooter footer =  headerFooterPolicy.createFooter(STHdrFtr.DEFAULT);
        XWPFParagraph paragraph = footer.createParagraph();
//        XWPFParagraph paragraph = footer.getParagraphArray(0);
        paragraph.setAlignment(ParagraphAlignment.LEFT);
        paragraph.setVerticalAlignment(TextAlignment.CENTER);
        paragraph.setBorderTop(Borders.THICK);
        CTTabStop tabStop = paragraph.getCTP().getPPr().addNewTabs().addNewTab();
        tabStop.setVal(STTabJc.RIGHT);
        int twipsPerInch =  1440;
        tabStop.setPos(BigInteger.valueOf(6 * twipsPerInch));

        /*
         * 给段落创建元素
         * 设置元素字面为公司地址+公司电话
         * */
        XWPFRun run = paragraph.createRun();
        run.setText((!StringUtils.isEmpty(orgAddress) ? orgAddress : "") + (!StringUtils.isEmpty(telephone) ? "  " + telephone: ""));
        setXWPFRunStyle(run,"仿宋",10);
        run.addTab();

        /*
         * 生成页码
         * 页码右对齐
         * */
        run = paragraph.createRun();
        run.setText("第");
        setXWPFRunStyle(run,"仿宋",10);

        run = paragraph.createRun();
        CTFldChar fldChar = run.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("begin"));

        run = paragraph.createRun();
        CTText ctText = run.getCTR().addNewInstrText();
        ctText.setStringValue("PAGE  \\* MERGEFORMAT");
        ctText.setSpace(SpaceAttribute.Space.Enum.forString("preserve"));
        setXWPFRunStyle(run,"仿宋",10);

        fldChar = run.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("end"));

        run = paragraph.createRun();
        run.setText("页 总共");
        setXWPFRunStyle(run,"仿宋",10);

        run = paragraph.createRun();
        fldChar = run.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("begin"));

        run = paragraph.createRun();
        ctText = run.getCTR().addNewInstrText();
        ctText.setStringValue("NUMPAGES  \\* MERGEFORMAT ");
        ctText.setSpace(SpaceAttribute.Space.Enum.forString("preserve"));
        setXWPFRunStyle(run,"仿宋",10);

        fldChar = run.getCTR().addNewFldChar();
        fldChar.setFldCharType(STFldCharType.Enum.forString("end"));

        run = paragraph.createRun();
        run.setText("页");
        setXWPFRunStyle(run,"仿宋",10);

    }

    /**
     * 设置页脚的字体样式
     *
     * @param r1 段落元素
     */
    private static void setXWPFRunStyle(XWPFRun r1,String font,int fontSize) {
        r1.setFontSize(fontSize);
        CTRPr rpr = r1.getCTR().isSetRPr() ? r1.getCTR().getRPr() : r1.getCTR().addNewRPr();
        CTFonts fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
        fonts.setAscii(font);
        fonts.setEastAsia(font);
        fonts.setHAnsi(font);
    }
}
