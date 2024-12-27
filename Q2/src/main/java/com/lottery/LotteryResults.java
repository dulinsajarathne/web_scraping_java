package com.lottery;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LotteryResults {
    public static void main(String[] args) {
        try {
            // URL of the lottery result page
            String url = "https://results.govdoc.lk/results/jayoda-2087";

            // Fetch and parse the HTML document from the URL
            Document doc = Jsoup.connect(url).get();

            // Select the result blocks inside the container with class 'results-wrp'
            Elements resultBlocks = doc.select(".results-wrp .result-block");

            // Check if any results were found
            if (resultBlocks.isEmpty()) {
                System.out.println("No lottery results found.");
            } else {
                // Display the lottery results
                System.out.print("Lottery Results: ");
                for (Element block : resultBlocks) {
                    System.out.print(block.text() + ", ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Error fetching the lottery results.");
            e.printStackTrace();
        }
    }
}
