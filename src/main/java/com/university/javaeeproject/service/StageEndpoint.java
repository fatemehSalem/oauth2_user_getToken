/*package com.university.javaeeproject.service;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint
public class StageEndpoint {

    Map<String , Stage> stageList = new ConcurrentHashMap<>();
    @ReadOperation
    public Map<String , Stage> getStage(){
        return  stageList;
    }
        public class Stage{
        String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}*/
