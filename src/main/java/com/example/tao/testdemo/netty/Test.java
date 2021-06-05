package com.example.tao.testdemo.netty;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        HttpClient client= HttpClientBuilder.create().setRedirectStrategy(new MyLaxRedirectStrategy()).build();
        HttpPost get = new HttpPost("http://passport.mysteel.com/api_register.jsp");
        HttpResponse response = client.execute(get);
        String res = EntityUtils.toString(response.getEntity());
        System.out.println(res+"=================");

    }
}
