package com.example.softwaredemo;

import com.example.softwaredemo.utils.CleanInputCache;
import com.example.softwaredemo.utils.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SpringBootTest
class SoftwaredemoApplicationTests {

    @Test
    public void socket1(){
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostName();
            System.out.println(host);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            Socket socket = new Socket(host, 6010);
            System.out.println("sss");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
