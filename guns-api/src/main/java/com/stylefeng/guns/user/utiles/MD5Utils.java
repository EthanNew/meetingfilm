package com.stylefeng.guns.user.utiles;

import org.slf4j.LoggerFactory;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    //对一个字符串获取MD5值
    public static String getMd5(String password){
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] bytes = md5.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte single : bytes) {
                //与运算，算出10进制的0~255之间的值
                int x = single & 0x00ff;
                //算成2位的16进制的值
                String s = Integer.toHexString(x);
                sb.append(s);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
             LoggerFactory.getLogger(MD5Utils.class).info(e.getMessage());
        }
        return "";
    }
    //增加MD5安全性，加盐
    public static String getMd5(String password,String sault){
        //加盐
        password = password + sault;
        String md5 = getMd5(password);
        return md5;
    }

    //获取文件的MD5值
    public static String getFileMd5(String filePath){
        File file = new File(filePath);
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");

            InputStream inputStream = new FileInputStream(file);
            byte[] read = new byte[1024];
            int length = -1;
            while ((length = inputStream.read(read,0,1024)) > 0){
                md5.update(read,0,length);
            }
            //这是16个byte
            byte[] digest = md5.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte single:digest) {
                //与运算 算出10进制的0~255之间的值
                int x = single&0x00ff;
                //算成2位的16进制的值
                String s = Integer.toHexString(x);
                stringBuffer.append(s);
            }
            return stringBuffer.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
