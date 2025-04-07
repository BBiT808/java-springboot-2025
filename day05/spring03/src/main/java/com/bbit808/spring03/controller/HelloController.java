package com.bbit808.spring03.controller;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; // 로그를 남기기 위한 객체를 생성 !
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 넌 이제부터 SpringBoot에서 Controller 역할을 해 줄 거야 ! ; 라고 지칭해주는 주석(어노테이션)
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @GetMapping("/hello") // 웹서비스에서 사용할 길을 하나 만들 거야. 그 길 이름은 /hello !
    @ResponseBody // 이 메서드의 결과를 HTTP 응답 본문에 직접 넣어줄게 !
    public String hellloSpring() {

        Date date = new Date(); // 현재 날짜와 시간을 가져오는 객체를 생성 !
        logger.info("Hello URL 오픈 !"); // 로그를 남김 !!

        // 문제 발생 시 로그를 남길 때 !
        logger.debug("디버그 시 필요한 로그입니다 .");
        logger.trace("디버그 시 필요한 로그입니다 !");
        
        logger.warn("경고가 표시될 시 나타나는 로그입니다 !!");
        logger.error("에러가 발생했을 시 나타나는 로그입니다 !!!");
        return "Hello SpringBoot !";
            
       
    }

}
