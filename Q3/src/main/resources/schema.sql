CREATE TABLE lottery_results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    draw_date DATE NOT NULL,
    winning_numbers VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
