package it.overzoom.postway.model;

import java.util.ArrayList;
import java.util.List;

public class ConfirmResponse {
    private String orderId;
    private List<Recipient> recipients = new ArrayList<>();

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Recipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
    }
}

class Recipient {
    private String receiptId;
    private String number;
    private String epm;

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEpm() {
        return epm;
    }

    public void setEpm(String epm) {
        this.epm = epm;
    }
}
