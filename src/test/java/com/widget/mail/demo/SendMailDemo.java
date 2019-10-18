package com.widget.mail.demo;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/***
 *  Created by shao.guangze on 2018/8/10
 *  经过测试，最好使用 HOST:qq, from:qq, to:*
 *  邮件中的换行需要使用<br>，而不是\r\n
 */
public class SendMailDemo {
    public static final String HOST = "smtp.qq.com";
    public static final String USER = "sidabw"; //QQ: sidabw(授权码：etmsllaxoxrgbbcj)    163: mab2hf
    public static final String TO = "mab2hf@163.com";
    public static final String FROM = "sidabw@qq.com";

    public static void main(String[] args) throws Exception {
        //1.发送简单纯文本邮件
        sendTextMail();
        //2.发送文本+图片的邮件
        //sendImageMail();
        //3.发送文本+图片+附件的邮件+html文本(font 标签)
//        sendMixedMail();
    }
    public static void sendTextMail()  throws Exception {
        Properties prop = new Properties();
        prop.setProperty("mail.host",HOST);    //smtp服务器就是由邮箱服务器提供的代发服务器地址
        prop.setProperty("mail.transport.protocol","smtp");
        prop.setProperty("mail.smtp.auth","true");
        //使用Java Mail 发送邮件的5个步骤
        //1.创建seesion
        Session seesion = Session.getInstance(prop);
        seesion.setDebug(true); //开启debug模式可以看到邮件发送的运行状态
        //2.获得transport对象
        Transport transport = seesion.getTransport();
        //3.连接transport
        transport.connect(HOST,USER,getPasswordFromDB(USER));
        //4.获取mail
        MimeMessage message = createSimpleMail(seesion);
        transport.sendMessage(message, message.getAllRecipients());
        //transport.
        transport.close();
    }

    public static void sendImageMail() throws Exception{
        Properties prop = new Properties();
        prop.setProperty("mail.host",HOST);    //smtp服务器就是由邮箱服务器提供的代发服务器地址
        prop.setProperty("mail.transport.protocol","smtp");
        prop.setProperty("mail.smtp.auth","true");
        //使用Java Mail 发送邮件的5个步骤
        //1.创建seesion
        Session seesion = Session.getInstance(prop);
        seesion.setDebug(true); //开启debug模式可以看到邮件发送的运行状态
        //2.获得transport对象
        Transport transport = seesion.getTransport();
        //3.连接transport
        transport.connect(HOST,USER,getPasswordFromDB(USER));
        //4.获取mail
        MimeMessage message = createImageMail(seesion);
        transport.sendMessage(message, message.getAllRecipients());
        //transport.
        transport.close();
    }

    public static void sendMixedMail() throws Exception{
        Properties prop = new Properties();
        prop.setProperty("mail.host",HOST);    //smtp服务器就是由邮箱服务器提供的代发服务器地址
        prop.setProperty("mail.transport.protocol","smtp");
        prop.setProperty("mail.smtp.auth","true");
        //使用Java Mail 发送邮件的5个步骤
        //1.创建seesion
        Session seesion = Session.getInstance(prop);
        seesion.setDebug(true); //开启debug模式可以看到邮件发送的运行状态
        //2.获得transport对象
        Transport transport = seesion.getTransport();
        //3.连接transport
        transport.connect(HOST,USER,getPasswordFromDB(USER));
        //4.获取mail
        MimeMessage message = createAttachMail(seesion);
        transport.sendMessage(message, message.getAllRecipients());
        //transport.
        transport.close();
    }
    /***
     * 创建包含 text image attachment 的邮件
     * @param session
     * @return
     * @throws MessagingException
     * @throws IOException
     */
    public static MimeMessage createAttachMail(Session session) throws MessagingException, IOException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(FROM));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        message.setSubject("This is a MIME MAIL contained img and attachment content.");

        //正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是一封邮件正文带图片<img src = 'cid:sida.jpg' style='width:30%;'>的邮件。除此之外还包括了回<br>车，空   格he <font size= \"15\" color = \"red\" > hahah </font> 的字体","text/html;charset=UTF-8");

        //正文：图片
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dataHandler = new DataHandler(new FileDataSource("src/main/resources/mystaticdir/1.jpg"));
        image.setDataHandler(dataHandler);
        image.setContentID("sida.jpg");

        //描述关系，正文和图片
        MimeMultipart mp1 = new MimeMultipart();
        mp1.addBodyPart(text);
        mp1.addBodyPart(image);
        mp1.setSubType("related");

        //附件1
        MimeBodyPart attachment1 = new MimeBodyPart();
        DataHandler dh1 = new DataHandler(new FileDataSource("src/main/resources/mystaticdir/1.jpg"));
        attachment1.setDataHandler(dh1);
        attachment1.setFileName(MimeUtility.encodeText(dh1.getName()));

        //附件2
        MimeBodyPart attachment2 = new MimeBodyPart();
        DataHandler dh2 = new DataHandler(new FileDataSource("src/main/resources/mystaticdir/1.jpg"));
        attachment2.setDataHandler(dh2);
        attachment2.setFileName(MimeUtility.encodeText(dh1.getName()));

        //将正文和图片转为MimeBodyPart
        MimeBodyPart content = new MimeBodyPart();
        content.setContent(mp1);

        //描述关系：MimeBodyPart之间的关系
        MimeMultipart mp2 = new MimeMultipart();
        mp2.addBodyPart(attachment1);
        mp2.addBodyPart(attachment2);
        mp2.addBodyPart(content);
        mp2.setSubType("mixed");

        //保存 message
        message.setContent(mp2);
        message.saveChanges();
        message.writeTo(new FileOutputStream("E:\\11212.eml"));//保存创建好的邮件
        return message;
    }

    /***
     * 生成一封包含图片和文字的邮件；
     * ps:这其中还包括了回车符。
     * @param session
     * @return
     * @throws MessagingException
     * @throws IOException
     */
    public static MimeMessage createImageMail(Session session) throws MessagingException, IOException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(FROM));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        message.setSubject("This is a MIME MAIL contained img content.");
        //放图片
        MimeBodyPart body = new MimeBodyPart();
        body.setContent("这是一封邮件正文带图片<img src = 'cid:sida.jpg' style='width:30%;'>的邮件。除此之外还包括了回<br>车，空   格","text/html;charset=UTF-8");

        //正文：图片
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dataHandler = new DataHandler(new FileDataSource("src/main/resources/mystaticdir/1.jpg"));
        image.setDataHandler(dataHandler);
        image.setContentID("sida.jpg");
        //描述关系：related；
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(body);
        mimeMultipart.addBodyPart(image);
        mimeMultipart.setSubType("related");

        message.setContent(mimeMultipart);
        message.saveChanges();
        message.writeTo(new FileOutputStream("E:\\11212.eml"));
        return message;
    }

    public static MimeMessage createSimpleMail(Session session) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(FROM));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        message.setSubject("罗蕾啊");//你说你你昨晚真是把我折腾的够呛，就那么点小事，你闹半天！不过我也有错。
        message.setContent("你说你你昨晚真是把我折腾的够呛，就那么点小事，你闹半天！不过我也有错。","text/html;charset=UTF-8");
        return message;
    }

    /***
     *
     * @param user  用户名
     * @return  密码
     */
    public static String getPasswordFromDB(String user) throws Exception {
        String URL="jdbc:mysql://127.0.0.1:3306/ego?useUnicode=true&amp;characterEncoding=utf-8";
        String USER="root";
        String PASSWORD="root";
//        String PASSWORD="123456";
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from user_password_secret_storage where user = \"" + user +"\"");
        //4.处理数据库的返回结果(使用ResultSet类)
        String password = "";
        while(rs.next()){
            password = rs.getString("password");
            System.out.println(rs.getString("user")+" "
                    +rs.getString("password"));
        }
        //关闭资源
        rs.close();
        st.close();
        conn.close();
        return password;
    }
}
