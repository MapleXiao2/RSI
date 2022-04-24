package com.example.softwaredemo.service;

import com.example.softwaredemo.pojo.History;


public interface HistoryService {
    boolean addHistory(History history);

    int getMaxID();
}
