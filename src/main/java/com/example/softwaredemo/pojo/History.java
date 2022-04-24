package com.example.softwaredemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {
    private Integer operationType;
    private String fileA;
    private String fileB;
    private String result;
}
