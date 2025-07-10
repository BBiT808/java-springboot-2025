package com.pknu.backboard.repository;

import org.springframework.stereotype.Repository;

import com.pknu.backboard.entity.About;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AboutRepository extends JpaRepository<About, Long> {

}
