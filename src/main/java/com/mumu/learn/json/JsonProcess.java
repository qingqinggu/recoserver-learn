package com.mumu.learn.json;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;

@Slf4j
public class JsonProcess {

    @Trace
    public String Json1() {

        List<Student> list = new ArrayList<>();

        Student s1 = new Student("bob", 20);
        Student s2 = new Student("lily", 24);
        list.add(s1);
        list.add(s2);

        System.out.println("----- javaBean to jsonString -----");
        String str1 = JSON.toJSONString(s1);
        //System.out.println(s1);

        log.info("json:{}", s1);

        String traceId = TraceContext.traceId();
        log.info("trace_id:{}", traceId);

        return str1;
    }
}
