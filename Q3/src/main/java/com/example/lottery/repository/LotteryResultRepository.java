package com.example.lottery.repository;

import com.example.lottery.entity.LotteryResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotteryResultRepository extends JpaRepository<LotteryResult, Long> {
}

