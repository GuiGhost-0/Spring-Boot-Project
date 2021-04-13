package com.guighost;

import com.guighost.pojo.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class Springboot09TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件
         SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("java发送邮件");
        simpleMailMessage.setText("hello world");
//        simpleMailMessage.setTo("GuiGhost@yeah.net");//接收的邮箱地址
        simpleMailMessage.setTo("15576376316@163.com");
        simpleMailMessage.setFrom("1418733754@qq.com");//发送的邮箱地址

        mailSender.send(simpleMailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装：通过MimeMessageHelper组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //正文
        helper.setSubject("Java发送邮件：复杂版");
        helper.setText("<h1 style='color:red'>java复杂邮件发送</h1>",true);
        //附件
        helper.addAttachment("640.webp",new File("F:\\笔记\\Java\\SpringBoot\\images\\640.webp"));
        helper.addAttachment("2.jpg",new File("F:\\笔记\\Java\\SpringBoot\\images\\66.png"));

        helper.setTo("GuiGhost@yeah.net");//接收的邮箱地址
        helper.setFrom("1418733754@qq.com");//发送的邮箱地址
        mailSender.send(mimeMessage);
    }


    //将邮件发送，封装为方法


    /**
     * @Author GuiGhost
     * @Description //TODO 封装为一个方法
     * @Date 2021/03/30 18:13
     * @param email
     * @return void
     * @throws
    */
    public void sendMail(Email email) throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装：通过MimeMessageHelper组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,email.getHtml());
        //正文
        helper.setSubject(email.getSubject());
        helper.setText(email.getText(),email.getHtml());
        //附件
        Map<String, File> files = email.getFiles();
        Set<String> keySet = files.keySet();
        for (String s : keySet) {
            helper.addAttachment(s,files.get(s));
        }

        helper.setTo(email.getToAddress());//接收的邮箱地址
        helper.setFrom(email.getFromAddress());//发送的邮箱地址
        mailSender.send(mimeMessage);
    }


    @Test
    void contextLoads3() throws MessagingException {
        Email email = new Email();
        email.setSubject("Java发送复杂邮件");
        email.setText("<h1>I'm GuiGhost</h1>");
        email.setHtml(true);
        Map<String,File> map = new HashMap<>();
        map.put("640.webp",new File("F:\\笔记\\Java\\SpringBoot\\images\\640.webp"));
        map.put("51.png",new File("F:\\笔记\\Java\\SpringBoot\\images\\51.png"));
        email.setFiles(map);
        email.setFromAddress("1418733754@qq.com");
        email.setToAddress("GuiGhost@yeah.net");

        sendMail(email);
    }

}

