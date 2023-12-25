import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendSimpleMail {

    public static void main(String[] args) {
        // 收件人电子邮箱
        String to = "2364160303@qq.com";

        // 发件人电子邮箱
        String from = "2561394933@qq.com";

        // 指定发送邮件的主机
        String host = "smtp.qq.com";

        //	账号信息
        final String username = "2561394933@qq.com";//	邮箱发送账号
        final String password = "cqpymtczaqkcebhe";//	邮箱授权码

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");//	主机端口号
        properties.put("mail.smtp.auth", "true");//	是否需要用户认证
        properties.put("mail.smtp.starttls.enable", "true");//	启用TlS加密
        properties.put("mail.smtp.timeout", 2000);//	超市

        // 获取默认session对象
        //	创建session会话
        //	参数1:smtp服务器连接参数
        //	参数2:账号和密码的授权认证对象
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("This is the Subject Line!");

            // 设置消息体
            message.setText("This is actual message");

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}