package com.example.springdemo.test;

import com.openhtmltopdf.extend.FSSupplier;
import com.openhtmltopdf.java2d.api.BufferedImagePageProcessor;
import com.openhtmltopdf.java2d.api.FSPage;
import com.openhtmltopdf.java2d.api.FSPageProcessor;
import com.openhtmltopdf.java2d.api.Java2DRendererBuilder;
import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author GLNC-taowenchen
 */
public class DemoService {
    void print(String content) {
        System.out.println(content);
    }


    public static void main(String[] args) throws IOException {
        TemplateEngine templateEngine = new TemplateEngine();
        Context context = new Context();
        final InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("test.html");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        String tempHtml;
        StringBuilder htmlStringBuilder = new StringBuilder();
        while ((tempHtml = bufferedReader.readLine()) != null) {
            htmlStringBuilder.append(tempHtml);
        }
        final String process = templateEngine.process(htmlStringBuilder.toString(), context);
        Java2DRendererBuilder builder = new Java2DRendererBuilder();
        builder.withHtmlContent(process, "");
        builder.useDefaultPageSize(2.4f * 3.355f,2.4f * 4, BaseRendererBuilder.PageSizeUnits.INCHES);
        builder.useFastMode();
        BufferedImagePageProcessor bufferedImagePageProcessor = new BufferedImagePageProcessor(
                BufferedImage.TYPE_INT_RGB, 1);
        builder.toSinglePage(bufferedImagePageProcessor);
        builder.useFont(() -> ClassLoader.getSystemClassLoader().getResourceAsStream("PingFangSC.ttf"), "PingFangSC");

        try {
            builder.runFirstPage();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to render resource");
        }
        new FileOutputStream("D:/testkx.jpg");
        ImageIO.write(bufferedImagePageProcessor.getPageImages().get(0), "jpg", new FileOutputStream("D:/testkx1111.jpg"));
    }
}
