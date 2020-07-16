package it.overzoom.postway.model;

import java.util.ArrayList;
import java.util.List;

public class SubmitResponse {
    private Boolean ok;
    private Request request;
    private List<Bad> bad = new ArrayList<>();

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public List<Bad> getBad() {
        return bad;
    }

    public void setBad(List<Bad> bad) {
        this.bad = bad;
    }
}

class Bad {
    private Person recipient;
    private Error error;

    public Person getRecipient() {
        return recipient;
    }

    public void setRecipient(Person recipient) {
        this.recipient = recipient;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}

class Error {
    private String code;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
