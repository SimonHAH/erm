package com.erp.production.ssm.util;

import java.io.File;

public class FileUtil {

    public static void deleteFile(String fileName) {
        File f2 = new File(fileName);
        f2.delete(); //del file
        f2 = null;
    }


    /* 目录下已经有同名文件,则文件重命名,增加文件序号 */
    public String newFile(String sPath, String sFile){
        String newFileName = new String();
        String withoutExt = new String();
        File curFile = new File(sPath + "\\" + sFile);
        if (curFile.exists()) {
            for(int counter = 1; curFile.exists(); counter++){
                withoutExt = this.getNameWithoutExtension(curFile.getName());
                if(withoutExt.endsWith(counter-1 + ")")){
                    withoutExt = withoutExt.substring(0,withoutExt.indexOf("("));		//idea
                }
                newFileName = withoutExt + "(" + counter + ")" + "." + getFileExt(curFile.getName());
                curFile = new File(sPath + "\\" + newFileName);
            }
        }else{
            newFileName = curFile.getName();
        }
        return newFileName;
    }

    private String getNameWithoutExtension(String fileName){
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    public String getFileExt(String s){
        String s1 = new String();
        int i = 0;
        int j = 0;
        if(s == null)
            return null;
        i = s.lastIndexOf(46) + 1;
        j = s.length();
        s1 = s.substring(i, j);
        if(s.lastIndexOf(46) > 0)
            return s1.toLowerCase();
        else
            return "";
    }
}
