package com.cui.controller;

import com.cui.aop.TestAop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cuiminglin on 2017/9/5.
 */
@RestController
public class HelloController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    public static ThreadLocal<String> temp = new ThreadLocal<>();
    @GetMapping(value = "/tupu")
    public String hi() {
        LOGGER.info("tupu");
//        try {
//            Thread.sleep(500*1000);
//        } catch (InterruptedException e) {
//        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("{")
                .append("\"status\":\"OK\"")
                .append("\"result\":{")
                .append("\"weight_nonsense\":0.1801,")
                .append("\"is_insult\":0,")
                .append("\"porn\":0.0852,")
                .append("\"forbidden\":0,")
                .append("\"reaction\":0.0144,")
                .append("\"is_ad\":0.35,")
                .append("\"politic\":0.0144,")
                .append("\"weight_ad\":0.9556,")
                .append(" \"is_nonsense\":0,")
                .append("\"weight_insult\":0.0904")
                .append("},")
                .append("\"request_id\":\"1520592827696595\"")
                .append("}");


        return buffer.toString();
    }
    @TestAop
    @GetMapping(value = "/daguan")
    public ResponseEntity<String> hi1() {
        LOGGER.info("daguan");
//        try {
//            Thread.sleep(500*1000);
//        } catch (InterruptedException e) {
//        }
        StringBuffer buffer = new StringBuffer();
       buffer.append("{\"json\":\"{\\\"59101e2540f7575536ab3144\\\":{\\\"fileList\\\":[{\\\"name\\\":\\\"http://f10.baidu.com/it/u=114725220,1711467603&fm=76\\\",\\\"objects\\\":[{\\\"relatives\\\":[],\\\"label\\\":3,\\\"similarity\\\":0,\\\"faceId\\\":\\\"\\\"}],\\\"relatives\\\":[],\\\"similarity\\\":0,\\\"label\\\":3,\\\"review\\\":false,\\\"faceId\\\":\\\"\\\"}]},\\\"56a8645b0c800bff40990cf1\\\":{\\\"reviewCount\\\":1,\\\"fileList\\\":[{\\\"rate\\\":0.725216805934906,\\\"label\\\":2,\\\"name\\\":\\\"http://f10.baidu.com/it/u=114725220,1711467603&fm=76\\\",\\\"review\\\":true}],\\\"statistic\\\":[0,0,1,0]},\\\"5808841f5e1778ef49219a99\\\":{\\\"reviewCount\\\":0,\\\"fileList\\\":[{\\\"rate\\\":0.893445611000061,\\\"label\\\":0,\\\"name\\\":\\\"http://f10.baidu.com/it/u=114725220,1711467603&fm=76\\\",\\\"review\\\":false}],\\\"statistic\\\":[1,0,0,0,0,0,0,0,0]},\\\"54bcfc6c329af61034f7c2fc\\\":{\\\"reviewCount\\\":0,\\\"fileList\\\":[{\\\"rate\\\":0.8929816285769144,\\\"label\\\":2,\\\"name\\\":\\\"http://f10.baidu.com/it/u=114725220,1711467603&fm=76\\\",\\\"review\\\":false}],\\\"statistic\\\":[0,0,1]},\\\"code\\\":0,\\\"message\\\":\\\"success\\\",\\\"nonce\\\":\\\"0.387212879582294\\\",\\\"timestamp\\\":1524559433501}\",\"signature\":\"DbFsQeKAqoomapyTce4NKUt2aW/ijxZ34snPeTDh8BED4FfvXh4EyBz7iNYU8z+b505vqzWpIi+/yuTVALvDpNLluMO9ErtH8mb/GbYlTBh7KEu3mSN9lNUqFAXnImDLTthwesOCWqBwAkjn+RwqfN4A3IOnKMDbdXTLayJ6U3o=\"}");


        return ResponseEntity.ok(buffer.toString());
    }
    @ModelAttribute
    public void test() {
        temp.set("33333");
      LOGGER.error("33333");
    }


    @ModelAttribute
    public void test1() {
        LOGGER.error(temp.get()+"====");
    }
    @GetMapping(value = "/hi")
    @ResponseBody
    public String hi12() {

        return "222";
    }

}
