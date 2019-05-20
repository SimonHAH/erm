package com.erp.production.ssm.controller;

import com.erp.production.ssm.service.FileService;
import com.erp.production.ssm.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value="/file/upload", method= RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(MultipartHttpServletRequest request) {
        Iterator<String> iterator = request.getFileNames();
        String json = null;
        while (iterator.hasNext()) {
            String fileName = iterator.next();
            MultipartFile multipartFile = request.getFile(fileName);
            Map<String,Object> result = fileService.uploadFile(multipartFile);
            json = JsonUtils.objectToJson(result);
        }
        return json;
    }

    @RequestMapping(value="/file/delete")
    @ResponseBody
    public String handleFileDelete(@RequestParam String fileName){
        fileService.deleteFile(fileName);
        Map<String,Object> result = new HashMap<>();
        result.put("data", "success");
        String json = JsonUtils.objectToJson(result);
        return json;
    }
}
