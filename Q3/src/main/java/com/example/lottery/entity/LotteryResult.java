package com.example.lottery.entity;



import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "lottery_dulinsa")
public class LotteryResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "draw_date", nullable = false)
    private LocalDate drawDate;

    @Column(name = "winning_numbers", nullable = false)
    private String winningNumbers;


    public void setDrawDate(LocalDate drawDate) {
        this.drawDate = drawDate;
    }

    public void setWinningNumbers(String winningNumbers) {
        this.winningNumbers = winningNumbers;
    }




}

