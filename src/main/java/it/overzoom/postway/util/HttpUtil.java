package it.overzoom.postway.util;

import org.apache.log4j.Logger;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public class HttpUtil {

    private static final Logger log = Logger.getLogger(HttpUtil.class);

    public static String call(final String path, Object body, String method, Map<String, String> headersMap) {

        log.info("[" + method + "] " + path);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headersMap.forEach((k, v) -> headers.add(k, v));

        HttpEntity<?> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate
                .exchange(path, HttpMethod.valueOf(method), request, String.class);

        return response.getBody();
    }

    public static String upload(final String path, MultipartFile file, Map<String, String> headersMap) throws Exception {

        log.info("[FILE] " + path);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headersMap.forEach((k, v) -> headers.add(k, v));

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();

        map.add("name", file.getName());
        map.add("filename", file.getOriginalFilename());
        ByteArrayResource contentsAsResource = new ByteArrayResource(file.getBytes()){
            @Override
            public String getFilename(){
                return file.getOriginalFilename();
            }
        };
        map.add("file", contentsAsResource);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate
                .postForEntity(path, requestEntity, String.class);

        return response.getBody();
    }
}
