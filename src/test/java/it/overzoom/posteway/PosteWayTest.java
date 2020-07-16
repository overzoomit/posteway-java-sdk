package it.overzoom.posteway;

import it.overzoom.postway.PosteWay;
import it.overzoom.postway.model.UploadResponse;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PosteWayTest {

    @Test
    public void upload() throws Exception {

        PosteWay pw = new PosteWay("<<TOKEN>>");

        FileInputStream fis = new FileInputStream("src/test/assets/dummy.pdf");
        MockMultipartFile data = new MockMultipartFile("file","dummy.pdf", "application/pdf", fis);

        UploadResponse uploadResponse = pw.upload(data);
        assertNotNull(uploadResponse.getCid());
    }
}
