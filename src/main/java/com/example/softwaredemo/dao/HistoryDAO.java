package com.example.softwaredemo.dao;

import com.example.softwaredemo.pojo.History;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryDAO {
    int addHistory(History history);

    int deleteHistoryById(Integer id);

    List<History> getHistories();

    int getMaxID();
}
