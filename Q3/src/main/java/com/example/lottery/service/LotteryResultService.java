package com.example.lottery.service;

import com.example.lottery.entity.LotteryResult;
import com.example.lottery.repository.LotteryResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class LotteryResultService {

    @Autowired
    private LotteryResultRepository repository;

    public void saveLotteryResult(LocalDate drawDate, String winningNumbers) {
        LotteryResult result = new LotteryResult();
        result.setDrawDate(drawDate);
        result.setWinningNumbers(winningNumbers);
        repository.save(result);
    }
}

