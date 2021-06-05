package com.example.tao.testdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
@Controller
@CrossOrigin
public class TestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestDemoApplication.class, args);
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public boolean test(HttpServletRequest request) throws InterruptedException {
        throw new HttpServerErrorException(HttpStatus.BAD_GATEWAY,"sdfsa");
//        Thread.sleep(100000);
//        System.out.println(isChormeLowVersion(request));
//        return getBrowserName(request.getHeader("User-Agent"));
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public RedirectView test1() throws Exception {
        // return "redirect:";
        RedirectView view = new RedirectView("/test");
        return view;
    }


    public boolean getBrowserName(String agent) {
        System.out.println(agent);
        if (agent.indexOf("chrome") > 0) {

            return true;
        }
        return false;
    }

    private static Pattern pattern = Pattern.compile("chrome/(\\d+)");

    private static boolean isChormeLowVersion(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        if (userAgent != null) {
            userAgent = userAgent.toLowerCase();
            Matcher matcher = pattern.matcher(userAgent);
            if (matcher.find(1)) {
                int version = Integer.parseInt(matcher.group(1));
                System.out.println(version);
                if (version >= 51 && version <= 66) {
                    return true;
                }
            }
        }
        return false;
    }

}
