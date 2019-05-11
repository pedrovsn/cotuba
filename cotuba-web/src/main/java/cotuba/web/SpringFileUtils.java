package cotuba.web;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SpringFileUtils {

    public static ResponseEntity<ByteArrayResource> montaResponseArquivo(Path path, String type){
        try{
            byte[] data = Files.readAllBytes(path);
            ByteArrayResource resource = new ByteArrayResource(data);

            String fileName = path.getFileName().toString();

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, type);
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+ fileName);

            return ResponseEntity.ok().headers(headers).contentLength(data.length).body(resource);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
