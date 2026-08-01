
USE dashboarddb;
CREATE TABLE notification (
 id INT PRIMARY KEY AUTO_INCREMENT,
 claim_id INT NOT NULL,
 message VARCHAR(255)
);


CREATE TABLE fraud_check (
id INT PRIMARY KEY AUTO_INCREMENT,
claim_id INT NOT NULL,
status VARCHAR(50)
);

CREATE TABLE payment (
id INT PRIMARY KEY AUTO_INCREMENT,
claim_id INT NOT NULL,
status VARCHAR(50),
amount DECIMAL(10,2)
);


CREATE TABLE claim (
 id INT PRIMARY KEY AUTO_INCREMENT,
 customer_id INT NOT NULL,
 status VARCHAR(50),
 created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



CREATE TABLE dashboard_summary (
                                   id INT PRIMARY KEY AUTO_INCREMENT,
                                   claim_id INT NOT NULL,
                                   claim_status VARCHAR(50),
                                   fraud_status VARCHAR(50),
                                   payment_status VARCHAR(50),
                                   notification VARCHAR(255),
                                   created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);