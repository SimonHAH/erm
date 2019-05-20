package com.erp.production.ssm.service;

import com.erp.production.ssm.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public Map<String,Object> uploadFile(MultipartFile uploadFile) {

        Map<String,Object> resultMap = new HashMap<>();
        try {
            if(uploadFile!=null && uploadFile.getOriginalFilename()!=null && uploadFile.getOriginalFilename().length()>0){
                //生成一个新的文件名
                //取原始文件名
                String fileName = uploadFile.getOriginalFilename();


                String filePath = "E:\\develop\\repository\\GitHub\\file\\";
                FileUtil fu = new FileUtil();
                String newName = fu.newFile(filePath, fileName);

                //新文件
                File file = new java.io.File(filePath+newName);
                //将内存中的文件写入磁盘
                uploadFile.transferTo(file);
                //图片上传成功后，将图片的地址写回
                resultMap.put("error", 0);
                resultMap.put("url", "/file/" + newName);
                return resultMap;

            }else{
                //返回结果
                resultMap.put("error", 1);
                resultMap.put("message", "文件异常");
                return resultMap;
            }
        } catch (Exception e) {
            resultMap.put("error", 1);
            resultMap.put("message", "文件上传发生异常");
            return resultMap;
        }
    }

    @Override
    public boolean deleteFile(String fileName) {
        fileName = fileName.substring(fileName.lastIndexOf("/")+1);
        fileName = "E:\\develop\\repository\\GitHub\\file\\"+fileName;
        FileUtil.deleteFile(fileName);
        return true;
    }
}
