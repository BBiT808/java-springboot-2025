package com.pknu.backboard.service;

import java.util.List;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu.backboard.entity.Board;
import com.pknu.backboard.repository.BoardRepository;

// import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
// @NoArgsConstructor
public class BoardService {

    // @Autowired
    private final BoardRepository boardRepository;

    public List<Board> getBoardList() {
        return this.boardRepository.findAll(); // SELECT *

    }

    // 자동으로 생성자를 만들어주는 기능도 있음 !
    // public BoardService(BoardRepository boardRepository) {
    // this.boardRepository = boardRepository;
    // }

    // // 생성자가 없는 코드
    // public BoardService() {}

    public Board getBoardOne(Long bno) {
        Optional<Board> opBoard = this.boardRepository.findById(bno);
        if (opBoard.isPresent()) {
            return opBoard.get();
        } else {
            throw new RuntimeException("board not found");
        }
    }

}
