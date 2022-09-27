package kg.megacom.file_service.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String storeFile(MultipartFile file);

    Resource getFileByName(String fileName);
}
