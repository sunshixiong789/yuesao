package com.yuesao.yuesao.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author sunshixiong
 * @date 2019/3/16 11:03
 */
@RestController
@RequestMapping(value = "/file")
public class FilesController {

  private  static final String LOCAL_URL = "/usr/local/cuit";
  /**
   * 文件上传
   *
   * @param file
   * @throws IOException
   */
  @PostMapping(value = "/upload")
  public String uploadFile(MultipartFile file) throws IOException {
    String name = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    String fileUrl = "";
    if (file != null) {
      String fileName = file.getOriginalFilename();
      if (fileName != null) {
        //上传文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String loadFileName = UUID.randomUUID() + suffix;
        File uploadfile = new File(LOCAL_URL + File.separator + name);
        if (!uploadfile.exists() && !uploadfile.isDirectory()) {
          uploadfile.mkdirs();
        }
        File loadfile = new File(LOCAL_URL + File.separator + name + File.separator + loadFileName);
        file.transferTo(loadfile);
        fileUrl ="/file/download?fileName="+ URLEncoder.encode(File.separator + name + File.separator + loadFileName,"gb2312");
      }

    }
    return fileUrl;
  }

  /**
   * 图片下载
   *
   * @param fileName
   * @param response
   * @throws UnsupportedEncodingException
   */
  @GetMapping(value = "/download")
  public void download(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {

    File file = new File(LOCAL_URL  + URLDecoder.decode(fileName,"gb2312"));

    response.reset();
    response.setHeader("Content-Disposition",
            "attachment; filename=\"" + new String(fileName.getBytes("gbk"), "iso-8859-1") + "\"");
    response.addHeader("Content-Length", "" + file.length());
    response.setContentType("application/octet-stream;charset=UTF-8");
    try {
      InputStream inputStream = new FileInputStream(file);

      OutputStream outputStream = response.getOutputStream();
      IOUtils.copy(inputStream, outputStream);
      outputStream.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  @GetMapping(value = "/downloadByName")
  public void downloadByName(String name, HttpServletResponse response) throws IOException {
    String path = "/usr/local/cuit";

    File file = new File(path + File.separator + name + File.separator);
    String[] filelist = file.list();
    File fileout = new File(path + File.separator + name + File.separator + filelist[1]);

    response.reset();
    response.setHeader("Content-Disposition",
            "attachment; filename=\"" + new String(filelist[1].getBytes("gbk"), "iso-8859-1") + "\"");
    response.addHeader("Content-Length", "" + fileout.length());
    response.setContentType("application/octet-stream;charset=UTF-8");

    InputStream inputStream = new FileInputStream(fileout);

    OutputStream outputStream = response.getOutputStream();
    IOUtils.copy(inputStream, outputStream);
    outputStream.flush();
  }

}