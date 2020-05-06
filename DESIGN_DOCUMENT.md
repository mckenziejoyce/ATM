# ATM
# Explanation of Classes

Following is a list of classes that were used and an explanation of why
they were created and what functions they serve.

* `Account`: This class is Represents the superclass of all the accounts. It's attibutes include the money stored in the balance, account number, and type of account. It's functions include setBalance() which makes the balance a specific amount, withdraw() which takes away money from the account and deposit() which adds money to the account balance.
  * `Checking`: This subclass represents the Checking account. It's type is "Checking".
  * `Saving`: This subclass represents the Savings account. It's type is "Savings".
  * `Security`: This subclass represents the Security account. It's type is "Security".
* `Loan`: This class represents loans by giving it the attributes, money which represents the amount that still needs to get paid to the bank, interest which represents the interest added on to the loan every month, and the date in which the loan is taken out. It's functions include getYear(), getDay(), and getMonth() which retrieve the year, day or month of when the loan was taken out. The functions increaseLoan() and decreaseLoan() increase the loan to be paid every month, and decrease when a payment is made. monthPass() returns true if a full month passed from the last loan increase. 
* `Stock`: This class represent the stocks in the stock market with the attributes of name of the stock and money for the current price of the stock.
* `Customer`: This class represents the customers or the users of the bank, these attributes include the name of the customer, transactions which is an ArrayList of actions done to the accounts, accounts which is an ArrayList of the customer's accounts, realized profit, unrealized profit, loan, cur for type of currency, and the boolean rich which indicates whether the customer is classified as a rich customer in the eyes of the bank manager. The functions include, makeSavingsAccount() which adds a savings account to the accounts list, makeCheckingAccount() which adds a checking account to the accounts list, makeSecurityAccount() which adds a security account to the accounts list, closeAccount() removes an account from the list, applyLoan() which makes a new loan, isRich() returns true is customer is rich which means they have a savings account greater than 5000, exchangeRate() changes the balance to match which currency the customer wants to use, buyStock() buys a stock and sellStock() sells a stock. 
* `Manager`: This class represents the bank manager with the attribute of money in the balance. The functions include accountFee() which adds money to the balance everytime an account is opened or closed and increaseLoans() loops through all the customers and increases the loans if the if a month has passed when from when they last paid or applied


#### *Note: We used Student 1\'s code mainly as Student 2 had created the Quest1 using Java swing*

## Authors - Group Number 2
* Anthony Vargas U58026559
* McKenzie Joyce
* Qing Zhao