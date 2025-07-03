package com.pknu.backboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pknu.backboard.entity.Member;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    // SELECT * FROM member WHERE username = ?
    List<Member> findByUsername(String username); // 사용자 이름으로 조회

    Optional<Member> findByEmail(String emial); // 이메일로 사용자 조회
}
