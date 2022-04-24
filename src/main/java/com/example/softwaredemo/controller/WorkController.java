package com.example.softwaredemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.softwaredemo.pojo.History;
import com.example.softwaredemo.pojo.PendingFile;
import com.example.softwaredemo.service.HistoryService;
import com.example.softwaredemo.utils.CleanInputCache;
import com.example.softwaredemo.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

@RestController
public class WorkController {

    @Autowired
    HistoryService historyService;

    public void callProcess(String data, Integer port) throws IOException {
        String host = InetAddress.getLocalHost().getHostName();
        Socket socket = new Socket(host, port);

        OutputStream os = socket.getOutputStream();
        PrintStream out = new PrintStream(os);

        out.print(data);
        out.print("over");

        out.close();
        os.close();
        socket.close();
    }

    @RequestMapping("/targetExtraction")
    public void targetExtraction() {

    }

    @RequestMapping("/changeDetection")
    public void changeDetection(@RequestPart("any") MultipartFile[] files) throws IOException, InterruptedException {

        // 路径信息
        String IDPath = historyService.getMaxID() + 1 +"/";
        String path = Constants.UPLOAD_PATH + Constants.Functions[1]+ IDPath;
        String pathA = path + Constants.FILE_A_PATH + files[0].getOriginalFilename();
        String pathB = path + Constants.FILE_B_PATH + files[1].getOriginalFilename();
        String result = path + Constants.RESULT_FILE;

        //写入
        File fileA = new File(pathA.substring(0,pathA.lastIndexOf("/")));
        fileA.mkdirs();
        File fileB = new File(pathB.substring(0,pathB.lastIndexOf("/")));
        fileB.mkdirs();
        files[0].transferTo(new File(pathA));
        files[1].transferTo(new File(pathB));

        //发送JSON 启动Python进程
        PendingFile pendingFile = new PendingFile(pathA, pathB);
        String data = JSON.toJSONString(pendingFile);
        callProcess(data,Constants.PORTS[1]);

        //生成历史记录
        History history = new History(1, pathA, pathB, result);
        historyService.addHistory(history);

        // 检测是否完成
        File file = new File(result);
        while (!file.exists()){
            Thread.sleep(500);
        }
        System.out.println("变化检测已完成");

    }

    @RequestMapping("/targetDetection")
    public void targetDetection() {

    }

    @RequestMapping("/terrainClassification")
    public void terrainClassification() {

    }
}
