package it.overzoom.postway.model;

public class ConfirmRequest {
    private SubmitKind kind;
    private String requestId;

    public ConfirmRequest(SubmitKind kind, String requestId) {
        this.kind = kind;
        this.requestId = requestId;
    }

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
}
