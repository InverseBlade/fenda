package com.zzw.fenda.controller;

import com.zzw.fenda.util.JsonR;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("file")
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public JsonR upload(@RequestParam("file") MultipartFile zipFile) {
        try {
            //get upload path
            String targetFilePath = getUploadPath();
            //upload file
            String fileName = UUID.randomUUID().toString().replace("-", "");
            String fileSuffix = getFileSuffix(zipFile);
            if (fileSuffix != null) {   // 拼接后缀
                fileName += fileSuffix;
            }
            String fileFullName = targetFilePath + File.separator + fileName;
            File targetFile = new File(fileFullName);
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(targetFile);
                IOUtils.copy(zipFile.getInputStream(), fileOutputStream);
            } catch (IOException e) {
                e.printStackTrace();
                return JsonR.createFail(e.getMessage());
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
//            return JsonR.createSuccess(fileFullName);
            return JsonR.createSuccess(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonR.createFail(e.getMessage());
        }
    }

    private String getUploadPath() throws IOException {
        File path = new File("");
        //如果上传目录为/static/upload/，则可以如下获取：
        File upload = new File(path.getAbsolutePath(), "static/upload/");
        if (!upload.exists() && !upload.mkdirs()) {
            throw new IOException("创建上传文件夹失败,服务端无法储存静态资源");
        }
        return upload.getAbsolutePath();
    }

    private String getFileSuffix(MultipartFile file) {
        if (file == null) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        int suffixIndex = fileName.lastIndexOf(".");
        if (suffixIndex == -1) {    // 无后缀
            return null;
        } else {                    // 存在后缀
            return fileName.substring(suffixIndex);
        }
    }

}
