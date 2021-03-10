/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: QRCodesGenerator
 * Author:   feiyi
 * Date:     2020/12/24 3:05 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.wx.qrcodes;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * 〈一句话功能简述〉:
 * 〈二维码生成器。
 *  也可以在线生成：https://www.thonky.com/qrcode/?advopt=1#qr-container
 * 〉
 *
 * @author feiyi
 * @create 2020/12/24
 * @since 1.0.0
 */
public class QRCodesGenerator {


    private static final String QR_CODE_IMAGE_PATH = "/Users/feiyi/Documents/feiyiGitProject/forest/MyQRCode.png";

    @Test
    public void generateQRCodeImage() throws WriterException, IOException {
        String text = "weixin://wxpay/bizpayurl?pr=AMBYDX7zz";
//        String text = "weixin://wxpay/bizpayurl/up?pr=NwY5Mz9&groupid=00";
//        String text = "Merry Christmas";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 350, 350);
        Path path = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

}
