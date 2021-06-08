package com.example.tao.testdemo.dubbo;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public interface TaoTestTest {
     Map<String,String> findUserById(JSONObject jsonObject);
}
