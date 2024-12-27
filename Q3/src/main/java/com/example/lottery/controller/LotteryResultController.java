package com.example.lottery.controller;

import com.example.lottery.service.LotteryResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/lottery")
public class LotteryResultController {

    @Autowired
    private LotteryResultService service;

    @PostMapping("/save")
    public String saveLotteryResult(@RequestParam String drawDate, @RequestParam String winningNumbers) {
        service.saveLotteryResult(LocalDate.parse(drawDate), winningNumbers);
        return "Lottery Result Saved Successfully!";
    }
}

