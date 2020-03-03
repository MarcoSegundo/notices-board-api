package com.marco.noticesboardapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marco.noticesboardapi.model.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{

}
