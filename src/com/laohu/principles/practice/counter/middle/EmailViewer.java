package com.laohu.principles.practice.counter.middle;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: designmodel
 * @description: email展示类
 * @author: Holland
 * @create: 2021-08-11 10:50
 **/
public class EmailViewer implements StaViewer {

    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailViewer() {
        this.emailSender = new EmailSender();
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public EmailViewer(List<String> emailToAddresses) {
        this.emailSender = new EmailSender();
        this.toAddresses = emailToAddresses;
    }

    public void addToAddress(String address) {
        this.toAddresses.add(address);
    }

    @Override
    public void output(Map<String, RequestSta> requestStaMap, long startTimeInMillis, long endTimeInMills) {
        //format the requestStats to HTML style.
        //send it to email toAddresses.
    }
}
