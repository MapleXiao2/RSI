package com.example.softwaredemo.utils;

public class Constants {
    public static final String UPLOAD_PATH = "D:/temp/upload/";
    public static final String[] Functions = {"targetExtraction/", "changeDetection/", "targetDetection/", "terrainClassification/"};
    public static final String FILE_A_PATH = "fileA/";
    public static final String FILE_B_PATH = "fileB/";
    public static final String RESULT_FILE = "out/result.png";
    /*
    # 20300 目标提取端口
    # 20302 变化检测端口
    # 20304 目标检测端口
    # 20306 地物分类端口

     */
    public static final Integer[] PORTS = {20300, 20302, 20304, 20306};
}
