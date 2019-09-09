package com.xian.lessonsix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/9/9  10:23
 * @Version: 0.0.1-SHAPSHOT
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file, HttpServletRequest request) {
        try {
            // 上传文件地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            // 如果文件不存在,就自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            // 上传文件名
            String filename = file.getOriginalFilename();
            // 服务端保存的文件对象
            File serverFile = new File(uploadDir + filename);
            // 将上传的文件写入服务器端文件内
            file.transferTo(serverFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传成功";
    }

    @RequestMapping(value = "uploads", method = RequestMethod.POST)
    @ResponseBody
    public String uploads(MultipartFile[] files, HttpServletRequest request) {
        try {
            // 上传目录
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            // 如果目录不存在,自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            for (MultipartFile file: files) {
                // 遍历文件数组执行上传
                executeUpload(uploadDir, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传成功!";
    }

    /**
     * 提取上传文件为公共方法
     * @param uploadDir 上传文件目录
     * @param file 上传对象
     * @throws Exception
     */
    private void executeUpload(String uploadDir, MultipartFile file) throws Exception {
        // 获取文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        // 获取文件名字
        String fileName = UUID.randomUUID() + suffix;
        // 服务器端保存的文件对象
        File serverFile = new File(uploadDir + fileName);
        // 将上传的文件写入服务器端文件内
        file.transferTo(serverFile);
    }
}
