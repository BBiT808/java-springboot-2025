package com.pknu.backboard.controller;

import com.pknu.backboard.entity.Member;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknu.backboard.entity.Board;
import com.pknu.backboard.service.BoardService;
import com.pknu.backboard.service.MemberService;
import com.pknu.backboard.service.ReplyService;
import com.pknu.backboard.validation.ReplyForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private final BoardService boardService;

    @Autowired
    private final ReplyService replyService;

    @Autowired
    private final MemberService memberService;

    // form 태그에서 post 액션이 발생하니까 PostMapping을 사용
    @PreAuthorize("isAuthenticated()") // 로그인한 사용자만 접근 가능
    @PostMapping("/create/{bno}")
    public String setReply(Model model, @PathVariable("bno") Long bno,
            @Valid ReplyForm replyForm, BindingResult bindingResult, Principal principal) {
        Board board = this.boardService.getBoardOne(bno);
        Member member = this.memberService.getMember(principal.getName());

        if (bindingResult.hasErrors()) { // 입력 검증이 실패하면 ..!!
            model.addAttribute("board", board);
            return "board/board_detail";
        }
        this.replyService.setReply(board, replyForm.getContent(), member);
        return String.format("redirect:/board/detail/%d", bno);
    }

}
