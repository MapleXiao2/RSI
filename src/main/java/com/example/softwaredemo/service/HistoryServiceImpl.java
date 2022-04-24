package com.example.softwaredemo.service;

import com.example.softwaredemo.dao.HistoryDAO;
import com.example.softwaredemo.pojo.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryDAO historyDAO;

    @Override
    public boolean addHistory(History history) {
        return historyDAO.addHistory(history) > 0;
    }

    @Override
    public int getMaxID() {
        return historyDAO.getMaxID();
    }
}
