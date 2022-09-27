package kg.megacom.file_service.controller;



import kg.megacom.file_service.response.UrlResponse;
import kg.megacom.file_service.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("file")
public class FileController {
    private final ResourceLoader resourceLoader;

    @Autowired
    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @Autowired
    private FileService fileService;

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public UrlResponse upload(@RequestPart MultipartFile file){
        String fileName = fileService.storeFile(file);

        String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("file/download")
                .path("//")
                .path(fileName)
                .toUriString();
        UrlResponse response = new UrlResponse();
        response.setFileUrl(downloadUri);
        return response;
    }
    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile( @PathVariable String fileName, HttpServletRequest request){
        Resource resource = fileService.getFileByName(fileName);

        String contentType =  null;

        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (contentType == null){
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);

    }
}
