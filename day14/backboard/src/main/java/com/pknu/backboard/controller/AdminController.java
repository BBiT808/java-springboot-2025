package com.pknu.backboard.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknu.backboard.entity.About;
import com.pknu.backboard.entity.History;
import com.pknu.backboard.service.AboutService;
import com.pknu.backboard.service.HistoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AboutService aboutService;
    private final HistoryService historyService;

    @GetMapping("/manage")
    public String managePage(About about) {
        About opAbout = aboutService.getAbout();

        about.setTitle(opAbout.getTitle());
        about.setSubtitle(opAbout.getSubtitle());
        about.setOurMission(opAbout.getOurMission());
        about.setOurVision(opAbout.getOurVision());
        about.setSchoolImgPath(opAbout.getSchoolImgPath());

        // 히스토리 할당 !
        List<History> historyList = opAbout.getHistoryList();
        historyList.sort(Comparator.comparing(History::getYear));
        about.setHistoryList(opAbout.getHistoryList());

        // PK로 전달 필요
        about.setId(opAbout.getId());

        // model.addAttribute("about", about);
        return "/admin/manage"; // admin/manage.html
    }

    @PostMapping("/about")
    public String postAbout(About about, Principal principal) {

        About originAbout = aboutService.getAbout();

        originAbout.setTitle(about.getTitle());
        originAbout.setSubtitle(about.getSubtitle());
        originAbout.setOurMission(about.getOurMission());
        originAbout.setOurVision(about.getOurVision());
        originAbout.setSchoolImgPath(about.getSchoolImgPath());

        // 서비스로 넘기는 파라미터가 하나 !!(간결!)
        aboutService.putAbout(originAbout);
        return "redirect:/admin/manage";
    }

    @PostMapping("/history/{id}")
    public String postHistory(@PathVariable("id") Long id, @RequestParam(value = "year") String year,
            @RequestParam(value = "description") String description) {

        About about = aboutService.getAbout();

        // 서비스로 넘기는 파라미터가 세 개!!, 새 파라미터가 추가되면 매서드도 변경되어야 함 !!
        historyService.setHistory(about, year, description);

        // History history = new History();
        // history.setYear(year);
        // history.setDescription(description);
        // history.setAbout(about);

        return "redirect:/admin/manage";
    }

}
