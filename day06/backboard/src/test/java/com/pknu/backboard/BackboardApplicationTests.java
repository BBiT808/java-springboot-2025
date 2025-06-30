package com.pknu.backboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pknu.backboard.entity.Board;
import com.pknu.backboard.repository.BoardRepository;

@SpringBootTest
class BackboardApplicationTests {

	@Autowired
	private BoardRepository boardRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testInsertJpa() {
		Board board1 = new Board();
		board1.setTitle("첫번째 게시글입니다."); // @Setter에서 자동 생성해주는 메서드 !!
		board1.setContent("내용은 없습니다.");
		board1.setCreateDate(LocalDateTime.now());

		Board board2 = new Board();
		board2.setTitle("두번째 게시글이예요 ! ^_^");
		board2.setContent("내용은 없어요~");
		board2.setCreateDate(LocalDateTime.now());

		this.boardRepository.save(board1); // INSERT 실행
		this.boardRepository.save(board2); // INSERT 실행
	}

	@Test // SELECT * 테스트
	void testSelectJpa() {
		List<Board> all = this.boardRepository.findAll();

		// 기대하는 값과 뽑아내는 값이 같은가?
		assertEquals(2, all.size());

		Board board = all.get(0);
		assertEquals("첫번째 게시글입니다.", board.getTitle());
	}

	@Test // SELECT FROM WHERE 테스트
	void testSelectOneJpa() {
		// Optional -> Null을 허용
		Optional<Board> opboard = this.boardRepository.findById(1L);
		if (opboard.isPresent()) {
			Board board = opboard.get();
			assertEquals("내용은 없습니다.", board.getContent());
		}
	}

	@Test
	void testSelectByTitle() {
		Board board = this.boardRepository.findByTitle("두번째 게시글이예요 ! ^_^");
		assertEquals(2L, board.getBno());
	}

	@Test // SELECT FORM LIKE
	void testSelectByTitleLike() {
		List<Board> boards = this.boardRepository.findByTitleLike("%게시글%");
		assertEquals(4, boards.size());

		Board board = boards.get(0); // 첫 번째 게시글!
		assertEquals("첫번째 게시글입니다.", board.getTitle());
	}

	@Test // 삭제
	void testDeleteLastOne() {
		assertEquals(4, boardRepository.count());
		Optional<Board> opBoard = this.boardRepository.findById(2L);
		assertTrue(opBoard.isPresent());

		Board board = opBoard.get();
		this.boardRepository.delete(board);
		assertEquals(3, boardRepository.count()); // 한칸 지워서 3건 남음 !
	}

}
