# Test cases for Fintech Payment Module 



Let's break down how to tackle  Fintech Payment Module Testing Challenge



### clear documentation * 

Test Case ID: (e.g., TC 001 )
Test Title: (e.g., Successful USD to EUR Transaction)
Description: (Briefly describe the test's purpose)
Preconditions: (e.g., User logged in, sufficient funds, valid payment details)
Test Steps: (Detailed steps to execute)
Expected Result: (What should happen if the test passes)
Actual Result: 
Status: (Pass/Fail)


------------------------------------------------------------------------------------------


Successful Multi-Currency Transaction

Test Case ID: TC001

Test Title: Successful EGP to BHD Transaction

**Description** : Verify a successful transaction from EGP  to BHD
Preconditions: User logged in with sufficient EGP balance, valid payment details, and BHD account.

    Test Steps:
1. Select EGP as the source currency and BHD as the target currency
2. Enter a valid amount in EGP
3. Confirm the displayed BHD amount 
4. Initiate the transaction
5. Verify the transaction confirmation
6. Check the user's BHD account balance

# Expected Result: Transaction successful, correct BHD amount credited to the user's account, and EGP amount debited


# Actual Result: 
# Status: (Pass/Fail)


--------------------------------------------------------------------------------------------


Invalid Payment Details

Test Case ID: TC002

Test Title: Invalid Card Number

**Description** : Verify the system handles an invalid card number
Preconditions: User logged in, attempting a transaction

    Test Steps:
1. Enter an invalid card number 
2. Enter valid expiry date and CVV
3. Initiate the transaction


# Expected Result: System displays an error message indicating an invalid card number

# Actual Result: 
# Status: (Pass/Fail)


--------------------------------------------------------------------------------------------
Network Failure Simulation

Test Case ID: TC003 

Test Title: Network Failure During Transaction


**Description** : Simulate a network failure during a transaction
Preconditions: User logged in, attempting a transaction


    Test Steps:
1. Initiate a transaction
2. Simulate a network failure 
3. Observe the system's behavior
4. Restore network connection
5. Check the transaction status



# Expected Result: System handles the network failure gracefully, and transaction is either rolled back or retried upon network restoration
# Actual Result: 
# Status: (Pass/Fail)

--------------------------------------------------------------------------------------------

Unauthorized User Access

Test Case ID: TC004 

Test Title: Unauthorized User Transaction

**Description**: Verify an unauthorized user cannot initiate a transaction
Preconditions: User logged in with a role that does not have transaction permissions


    Test Steps:
1. Attempt to initiate a transaction

# Expected Result: System displays an error message indicating insufficient permissions
# Actual Result: 
# Status: (Pass/Fail)

--------------------------------------------------------------------------------------------

Expired Token

Test Case ID: TC005 

Test Title: Expired Token transaction

**Description**: Verify the system handle expired tokens
Preconditions: User logged in, and the token is expired


    Test Steps:
1. Attempt to initiate a transaction


# Expected Result: System redirects to the login page, or displays an error message that the session has expired
# Actual Result: 
# Status: (Pass/Fail)


--------------------------------------------------------------------------------------------


Insufficient Funds

Test Case ID: TC006

Test Title: Insufficient Funds Transaction

**Description**: Verify the system handles a transaction with insufficient funds
Preconditions: User logged in with insufficient funds for the requested transaction


    Test Steps:
1. Enter an amount exceeding the available balance
2. Initiate the transaction


# Expected Result: System displays an error message indicating insufficient funds.
# Actual Result: 
# Status: (Pass/Fail)


--------------------------------------------------------------------------------------------


Zero Amount Transaction

Test Case ID: TC007 

Test Title: Zero Amount Transaction

**Description**: Verify the system handles a transaction with a zero amount
Preconditions: User logged in


    Test Steps:
1. Enter "0" as the transaction amount
2. Initiate the transaction

# Expected Result: System displays an error message indicating that the amount must be greater than zero.
# Actual Result:
# Status: (Pass/Fail)


--------------------------------------------------------------------------------------------


Negative Amount Transaction

Test Case ID: TC007

Test Title: Negative Amount Transaction

**Description**: Verify the system handles a transaction with a negative amount.
Preconditions: User logged in


    Test Steps:
1. Enter a negative amount : -422
2. Initiate the transaction

# Expected Result: System displays an error message indicating that the amount must be positive.
# Actual Result: 
# Status: (Pass/Fail)



--------------------------------------------------------------------------------------------

Currency Conversion Rate Validation

Test Case ID: TC009

Test Title: Currency Conversion Rate Accuracy

**Description**: Verify that the currency conversion rate matches an external source
Preconditions: User logged in, attempting a multi-currency transaction



    Test Steps:
1. Select two different currencies
2. Note the displayed conversion rate
3. Compare the rate with an external source 


# Expected Result: The displayed conversion rate matches the external source within an acceptable tolerance
# Actual Result: 
# Status: (Pass/Fail)


--------------------------------------------------------------------------------------------



Refund Processing

Test Case ID: TC010

Test Title: Successful Refund

**Description**: Verify a successful refund
Preconditions: A successful transaction has been completed



    Test Steps:
1. Initiate a refund for the transaction
2. Confirm the refund
3. Check the user's account balance


# Expected Result: Refund successful, the refunded amount is credited to the user's account
# Actual Result:
# Status: (Pass/Fail)

--------------------------------------------------------------------------------------------


Partial Refund

Test Case ID: TC011

Test Title: Partial Refund

**Description**: Verify a partial refund
Preconditions: A successful transaction has been completed


    Test Steps:
1. Initiate a partial refund for the transaction
2. Confirm the refund
3. Check the user's account balance


# Expected Result: Partial refund successful, the refunded amount is credited to the user's account and the balance is correct.
# Actual Result: 
# Status: (Pass/Fail)

--------------------------------------------------------------------------------------------

API Error Handling

Test Case ID: TC012

Test Title: API Error Response

**Description**: Simulate an error response from an external payment API
Preconditions: User logged in, attempting a transaction



    Test Steps:
1. Configure the API to return an error response
2. Initiate the transaction
3. Check the system's error message


# Expected Result: System displays a user-friendly error message indicating the API error
# Actual Result:
# Status: (Pass/Fail)


--------------------------------------------------------------------------------------------

Session Timeout

Test Case ID: TC013

Test Title: Session Timeout

**Description** : Verify that the system logs out the user after a session timeout
Preconditions: User logged in


    Test Steps:
1. Leave the application idle for the session timeout duration
2. Attempt to perform an action 

# Expected Result: System logs out the user and redirects to the login page
# Actual Result: 
# Status: (Pass/Fail)


--------------------------------------------------------------------------------------------


Data Encryption

Test Case ID: TC014

Test Title: Data Encryption Verification

**Description**: Verify that sensitive data is encrypted
Preconditions: User logged in, performing a transaction


    Test Steps:
Capture network traffic during a transaction.
Inspect the captured data for sensitive information 



# Expected Result: Sensitive data is encrypted and not visible in plain text
# Actual Result: 
# Status: (Pass/Fail)

