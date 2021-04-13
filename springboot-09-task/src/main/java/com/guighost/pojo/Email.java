package com.guighost.pojo;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author GuiGhost
 * @date 2021/03/30
 * @className Email()
 * 描述：
 */
public class Email {
    private String subject;//邮件主题
    private String text;//内容
    private Map<String,File> files;//附件
    private String toAddress;//收件人地址
    private String fromAddress;//发件人地址
    private Boolean html;//是否支持html


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, File> getFiles() {
        return files;
    }

    public void setFiles(Map<String, File> files) {
        this.files = files;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public Boolean getHtml() {
        return html;
    }

    public void setHtml(Boolean html) {
        this.html = html;
    }
}
