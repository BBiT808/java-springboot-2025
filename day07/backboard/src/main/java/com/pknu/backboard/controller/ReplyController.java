package com.pknu.backboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknu.backboard.entity.Board;
import com.pknu.backboard.service.BoardService;
import com.pknu.backboard.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequestMapping("/reply")
@Controller
@RequiredArgsConstructor
@Log4j2
public class ReplyController {

    private final BoardService boardService; // @Autowired 제거! final과 @RequiredArgsConstructor가 알아서 주입함
    private final ReplyService replyService; // 동일

    // form태그에서 post 액션이 발생하기 때문! ; PostMapping 사용!
    @PostMapping("/create/{bno}")
    public String setReply(Model model, @PathVariable("bno") Long bno,
            @RequestParam(value = "content") String content) {
        Board board = this.boardService.getBoardOne(bno);
        this.replyService.setReply(board, content);

        return String.format("redirect:/board/detail/%s", bno);
    }

}
