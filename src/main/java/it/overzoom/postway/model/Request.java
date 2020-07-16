package it.overzoom.postway.model;

public class Request {
    private SubmitKind kind;
    private String requestId;
    private String guid;

    public SubmitKind getKind() {
        return kind;
    }

    public void setKind(SubmitKind kind) {
        this.kind = kind;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
