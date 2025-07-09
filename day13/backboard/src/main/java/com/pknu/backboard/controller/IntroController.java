package com.pknu.backboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/intro") // intro로 시작하는 requestmapping을 전부 여기서 처리!!
@Controller
public class IntroController {

    @GetMapping("/about")
    public String aboutPage(Model Model) {
        // DB에서 동적으로 들고 올 데이터 가져오기

        return "intro/about"; // intro/about.html을 리턴하겠으~~
    }

    @GetMapping("/admissions")
    public String admissionsPage() {

        // Static 페이지로 대체!!
        return "intro/admissions"; // intro/admissions.html 리턴
    }

    @GetMapping("/academics")
    public String academicsPage() {

        // Static 페이지로 대체!!
        return "intro/academics"; // intro/academics.html 리턴
    }

    @GetMapping("/events")
    public String eventsPage() {

        // Static 페이지로 대체!!
        return "intro/events"; // intro/events.html 리턴
    }

    @GetMapping("/contact")
    public String contactPage() {

        // Static 페이지로 대체!!
        return "intro/contact"; // intro/contact.html 리턴
    }

}
