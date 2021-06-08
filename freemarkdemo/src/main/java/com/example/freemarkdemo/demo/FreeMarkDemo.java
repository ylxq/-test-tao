package com.example.freemarkdemo.demo;

import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkDemo {


    private static Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);

    static {
        cfg.setClassForTemplateLoading(ClassPathResource.class,"/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    public static void main(String[] args) throws IOException, TemplateException {
        Template template = cfg.getTemplate("test.ftl");

        Map<String, Object> root = new HashMap<>();
        root.put("user", "Big Joe");
        Map<String, Object> latest = new HashMap<>();
        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");

        Writer out = new OutputStreamWriter(System.out);
        template.process(root, out);

    }
}
