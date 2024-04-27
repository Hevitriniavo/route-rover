package com.tantely.routerover.files.impl;

import com.tantely.routerover.exceptions.InternalServerException;
import com.tantely.routerover.files.FileService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    private final String uploadDirectory = "static/";

    public String saveFile(MultipartFile file) {
        try {
            var fileName = generateRandomFileName(file);
            var classPathResource = new ClassPathResource(uploadDirectory);
            var uploadDirFile = classPathResource.getFile();
            var folderPath = uploadDirFile.getAbsolutePath();
            var folder = new File(folderPath);
            if (!folder.exists()) {
                var created = folder.mkdirs();
                if (!created) {
                    throw new InternalServerException("Failed to create directory: " + folderPath);
                }
            }
            var filePath = Paths.get(folderPath, fileName).toString();
            var dest = new File(filePath);
            file.transferTo(dest);
            return ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/" + fileName)
                    .toUriString();
        } catch (IOException e) {
            throw new InternalServerException("Failed to save file", e);
        }
    }

    @Override
    public boolean deleteFile(String url) {
        try {
            var fileName = url.substring(url.lastIndexOf('/') + 1);
            var classPathResource = new ClassPathResource(uploadDirectory);
            var uploadDirFile = classPathResource.getFile();
            var folderPath = uploadDirFile.getAbsolutePath();
            var filePath = Paths.get(folderPath, fileName).toString();
            var file = new File(filePath);
            return file.delete();
        } catch (IOException e) {
            throw new InternalServerException("Failed to delete file", e);
        }
    }

    private String generateRandomFileName(MultipartFile file) {
        var timestamp = System.currentTimeMillis();
        var uuid = UUID.randomUUID().toString();
        return timestamp + "_" + uuid + "_" + StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
    }
}
