/*claim*/
INSERT INTO claim (customer_id, status) VALUES (101, 'SUBMITTED');
INSERT INTO claim (customer_id, status) VALUES (102, 'VALIDATED');
INSERT INTO claim (customer_id, status) VALUES (103, 'SUBMITTED');
INSERT INTO claim (customer_id, status) VALUES (104, 'REJECTED');
INSERT INTO claim (customer_id, status) VALUES (105, 'VALIDATED');
INSERT INTO claim (customer_id, status) VALUES (106, 'SUBMITTED');
INSERT INTO claim (customer_id, status) VALUES (107, 'VALIDATED');
INSERT INTO claim (customer_id, status) VALUES (108, 'REJECTED');
INSERT INTO claim (customer_id, status) VALUES (109, 'SUBMITTED');
INSERT INTO claim (customer_id, status) VALUES (110, 'VALIDATED');

/*Payment*/
INSERT INTO payment (claim_id, status, amount) VALUES (1, 'COMPLETED', 5000);
INSERT INTO payment (claim_id, status, amount) VALUES (2, 'HOLD', 3000);
INSERT INTO payment (claim_id, status, amount) VALUES (3, 'COMPLETED', 4500);
INSERT INTO payment (claim_id, status, amount) VALUES (4, 'FAILED', 2000);
INSERT INTO payment (claim_id, status, amount) VALUES (5, 'COMPLETED', 6000);
INSERT INTO payment (claim_id, status, amount) VALUES (6, 'HOLD', 3500);
INSERT INTO payment (claim_id, status, amount) VALUES (7, 'COMPLETED', 7000);
INSERT INTO payment (claim_id, status, amount) VALUES (8, 'FAILED', 1500);
INSERT INTO payment (claim_id, status, amount) VALUES (9, 'COMPLETED', 8000);
INSERT INTO payment (claim_id, status, amount) VALUES (10, 'HOLD', 4000);

/*fraud*/
INSERT INTO fraud_check (claim_id, status) VALUES (1, 'PASSED');
INSERT INTO fraud_check (claim_id, status) VALUES (2, 'AWAITING_RESPONSE');
INSERT INTO fraud_check (claim_id, status) VALUES (3, 'PASSED');
INSERT INTO fraud_check (claim_id, status) VALUES (4, 'FAILED');
INSERT INTO fraud_check (claim_id, status) VALUES (5, 'PASSED');
INSERT INTO fraud_check (claim_id, status) VALUES (6, 'AWAITING_RESPONSE');
INSERT INTO fraud_check (claim_id, status) VALUES (7, 'PASSED');
INSERT INTO fraud_check (claim_id, status) VALUES (8, 'FAILED');
INSERT INTO fraud_check (claim_id, status) VALUES (9, 'PASSED');
INSERT INTO fraud_check (claim_id, status) VALUES (10, 'AWAITING_RESPONSE');

/*notification*/
INSERT INTO notification (claim_id, message) VALUES (1, 'Payment completed email sent');
INSERT INTO notification (claim_id, message) VALUES (2, 'Payment on hold email sent');
INSERT INTO notification (claim_id, message) VALUES (3, 'Claim submitted email sent');
INSERT INTO notification (claim_id, message) VALUES (4, 'Claim rejected email sent');
INSERT INTO notification (claim_id, message) VALUES (5, 'Payment completed email sent');
INSERT INTO notification (claim_id, message) VALUES (6, 'Payment on hold email sent');
INSERT INTO notification (claim_id, message) VALUES (7, 'Claim validated email sent');
INSERT INTO notification (claim_id, message) VALUES (8, 'Fraud check failed email sent');
INSERT INTO notification (claim_id, message) VALUES (9, 'Payment completed email sent');
INSERT INTO notification (claim_id, message) VALUES (10, 'Fraud check awaiting response email sent');