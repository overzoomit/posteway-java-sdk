package it.overzoom.postway.model;

import java.util.ArrayList;
import java.util.List;

public class Submit {
    private SubmitKind kind;
    private Person sender;
    private List<Person> recipients = new ArrayList<>();
    private String cid;
    private Boolean foreign;
    private Options options;

    public SubmitKind getKind() {
        return kind;
    }

    public void setKind(SubmitKind kind) {
        this.kind = kind;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public List<Person> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Person> recipients) {
        this.recipients = recipients;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Boolean getForeign() {
        return foreign;
    }

    public void setForeign(Boolean foreign) {
        this.foreign = foreign;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }
}

class Options {
    private Boolean bw;
    private Boolean backSide;

    public Boolean getBw() {
        return bw;
    }

    public void setBw(Boolean bw) {
        this.bw = bw;
    }

    public Boolean getBackSide() {
        return backSide;
    }

    public void setBackSide(Boolean backSide) {
        this.backSide = backSide;
    }
}
