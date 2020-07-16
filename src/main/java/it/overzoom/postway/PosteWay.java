package it.overzoom.postway;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.overzoom.postway.model.*;
import it.overzoom.postway.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PosteWay {

    private final Logger log = Logger.getLogger(PosteWay.class);

    private static final String PW_ENDPOINT = "https://api.posteway.it";

    private String PW_TOKEN;

    public PosteWay(String token) {
        this.PW_TOKEN = token;
    }

    public UploadResponse upload(MultipartFile pdf) throws Exception {
        log.info("Uploading new pdf file");

        Map<String, String> headers = new HashMap<>();
        headers.put("PW-AccessToken", PW_TOKEN);
        headers.put("Content-Type", "multipart/form-data");

        String res = HttpUtil.upload(PW_ENDPOINT + "/upload", pdf, headers);
        return new ObjectMapper().readValue(res, UploadResponse.class);
    }

    public SubmitResponse send(Submit submit) throws Exception {
        log.info("Send new " + submit.getKind());

        Map<String, String> headers = new HashMap<>();
        headers.put("PW-AccessToken", PW_TOKEN);

        String res = HttpUtil.call(PW_ENDPOINT + "/send", submit, "POST", headers);
        return new ObjectMapper().readValue(res, SubmitResponse.class);
    }

    public StatusResponse status(SubmitKind kind, String requestId) throws Exception {
        log.info("Check status of the " + kind);

        Map<String, String> headers = new HashMap<>();
        headers.put("PW-AccessToken", PW_TOKEN);

        String res = HttpUtil.call(PW_ENDPOINT + "/status/" + kind + "/" + requestId, null, "GET", headers);
        return new ObjectMapper().readValue(res, StatusResponse.class);
    }

    public ConfirmResponse confirm(SubmitKind kind, String requestId) throws Exception {
        log.info("Confirm requestId " + requestId + " of the a " + kind);

        Map<String, String> headers = new HashMap<>();
        headers.put("PW-AccessToken", PW_TOKEN);

        String res = HttpUtil.call(PW_ENDPOINT + "/confirm", new ConfirmRequest(kind, requestId), "POST", headers);
        return new ObjectMapper().readValue(res, ConfirmResponse.class);
    }

    public void cancel(SubmitKind kind, String requestId) throws Exception {
        log.info("Delete a request of the " + kind + " by requestId " + requestId);

        Map<String, String> headers = new HashMap<>();
        headers.put("PW-AccessToken", PW_TOKEN);

        HttpUtil.call(PW_ENDPOINT + "/cancel/" + kind + "/" + requestId, null, "DELETE", headers);
    }

    public TrackResponse track(SubmitKind kind, String orderId) throws Exception {
        log.info("Tracking a request of the " + kind + " by orderId " + orderId);

        Map<String, String> headers = new HashMap<>();
        headers.put("PW-AccessToken", PW_TOKEN);

        String res = HttpUtil.call(PW_ENDPOINT + "/track/" + kind + "/" + orderId, null, "GET", headers);
        return new ObjectMapper().readValue(res, TrackResponse.class);
    }

    public List<RecipientResponse> recipients(SubmitKind kind, String requestId) throws Exception {
        log.info("Get list of the recipients of the " + kind + " by requestId " + requestId);

        Map<String, String> headers = new HashMap<>();
        headers.put("PW-AccessToken", PW_TOKEN);

        String res = HttpUtil.call(PW_ENDPOINT + "/recipients/" + kind + "/" + requestId, null, "GET", headers);
        return new ObjectMapper().readValue(res, new TypeReference<List<RecipientResponse>>(){});
    }
}
