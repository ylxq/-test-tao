package com.example.tao.testdemo.dubbo;

import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TaoTestTestImpl implements TaoTestTest {

    @Override
    public Map<String,String> findUserById(JSONObject jsonObject) {
        Map<String,String> temp = new HashMap<>();
        temp.put("ad","adc");
        return temp;
    }
}
