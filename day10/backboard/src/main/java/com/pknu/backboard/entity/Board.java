package com.pknu.backboard.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

// Java 동일한 패키지에서 많이 추가되면 *로 생략 가능
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter // Lombok으로 Getter/Setter 자동화
@Entity // JPA 테이블 매핑 선언
@AllArgsConstructor // 이거 있으면 this.컬럼명 이런거 안 써줘도됨
@NoArgsConstructor
@Builder // 객체 생성을 간단하게, 체인 메서드 사용 가능 !!
public class Board {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bno; // board 테이블의 PK, bno

    // @Column(name = "subject", length = 250)
    @Column(length = 250)
    private String title; // 게시판 제목

    @Column(length = 8000)
    private String content; // 게시글 내용

    // 작성자 추가
    @ManyToOne // 사용자가 여러개의 글을 작성 가능
    private Member writer; // 작성자 정보

    @CreatedDate
    @Column(updatable = false) // 한번 작성 후 수정하지 않음
    private LocalDateTime createDate; // 게시글 작성일

    @LastModifiedDate
    private LocalDateTime modifyData; // 게시글 수정일

    // ERD 1:N를 만드는 법
    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Reply> replyList;
}
