package com.example.springclassdemo.logSample;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// class 변수로 선언하여 쓰는 방식
//public class logSample {
//    private static final Logger log = LoggerFactory.getLogger(logSample.class);
//
//    public static void main(String[] args) {
//        log.info("------------Log test------------");
//    }
//}

// Slf4j 어노테이션 -> logger 객체 생성 없이 자동으로 log 변수를 선언해줌 but 변수명이 log로 고정
@Slf4j
public class Slf4jSample {

    public static void namelogger(String s) {
        log.info("---------- Query Parameter Log ---------");
        log.info("name: {}", s);
        log.info("---------- Log END ---------");
    }

}