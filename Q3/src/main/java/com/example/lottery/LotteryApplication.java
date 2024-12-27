package com.example.lottery;
import com.example.lottery.service.LotteryResultService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@SpringBootApplication
public class LotteryApplication implements CommandLineRunner {

    @Autowired
    private LotteryResultService lotteryResultService;

    public static void main(String[] args) {
        SpringApplication.run(LotteryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            String url = "https://results.govdoc.lk/results/jayoda-2087";

            // Fetch and parse the HTML document from the URL
            Document doc = Jsoup.connect(url).get();

            // Extract the <h1> element text for the draw date
            Element h1 = doc.selectFirst("h1.mb-0");
            String text = h1.text();  // Example: "Jayoda 18-12-2024 (2087) Draw Numbers"

            // Extract the date part from the string (assuming it's always in the format DD-MM-YYYY)
            String dateString = text.split(" ")[1]; // "18-12-2024"

            // Parse the extracted date string into LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate drawDate = LocalDate.parse(dateString, formatter);

            // Extract the winning numbers
            Elements winningNumbersElement = doc.select(".results-wrp .result-block");
            String winningNumbers = winningNumbersElement.text();

            System.out.println(winningNumbers);

            // Save the result to the database
            lotteryResultService.saveLotteryResult(drawDate,winningNumbers);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
