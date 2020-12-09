package com.learn.java.utils;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import org.apache.poi.util.IOUtils;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class ResponseUtils {
    private static final Logger log = LoggerFactory.getLogger(ResponseUtils.class);

    public ResponseUtils() {
    }

    public static void exportDataByResponse(String fileName, InputStream inputStream, HttpServletResponse response) {
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8.name()));
            FileCopyUtils.copy(inputStream, outputStream);
        } catch (IOException var4) {
            log.error("文件导出失败", var4);
        }

    }

    public static void exportExcelByResponse(String fileName, Workbook workbook, HttpServletResponse response) {
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            Throwable var4 = null;

            try {
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8.name()));
                workbook.write(outputStream);
            } catch (Throwable var22) {
                var4 = var22;
                throw var22;
            } finally {
                if (outputStream != null) {
                    if (var4 != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable var21) {
                            var4.addSuppressed(var21);
                        }
                    } else {
                        outputStream.close();
                    }
                }

            }
        } catch (IOException var24) {
            log.error("Excel导出失败", var24);
        } finally {
            IOUtils.closeQuietly(workbook);
        }

    }

    public static void responseDataCode(Object data, HttpServletResponse response) {
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            Throwable var3 = null;

            try {
                response.setContentType("application/json;charset=UTF-8");
                outputStream.write(JSON.toJSONString(data).getBytes());
            } catch (Throwable var13) {
                var3 = var13;
                throw var13;
            } finally {
                if (outputStream != null) {
                    if (var3 != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable var12) {
                            var3.addSuppressed(var12);
                        }
                    } else {
                        outputStream.close();
                    }
                }

            }
        } catch (IOException var15) {
            log.error("responseErrorCode", var15);
        }

    }
}
