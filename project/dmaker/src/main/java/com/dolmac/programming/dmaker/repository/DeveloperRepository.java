package com.dolmac.programming.dmaker.repository;

import com.dolmac.programming.dmaker.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Optional<Developer> findByMemberId(String memberId); //맴버 id로 developer를 검색할 수 있게 해줌
}
