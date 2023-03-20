package pl.ipastula.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private BigDecimal credit;

    public CreditCard(String cardNumber) {
    }

    public void assignCredit(BigDecimal creditAmount) {
        if (isBelowCreditThreshold(creditAmount)) {
            throw new CreditBelowThresholdException();
        }
        if (isCreditAlreadyAssigned()) {
            throw new CreditAssignedTwiceException();
        }
        this.balance = creditAmount;
        this.credit = creditAmount;

    }

    public void withdraw(BigDecimal withdrawAmount) {
        if (withdrawAmount.compareTo(this.balance) > 0 ) {
            throw new WithdrawalAmountOverBalanceException();
        }

        this.balance = balance.subtract(withdrawAmount);
    }

    private boolean isCreditAlreadyAssigned() {
        return credit != null;
    }

    private boolean isBelowCreditThreshold(BigDecimal creditAmount) {
        return creditAmount.compareTo(BigDecimal.valueOf(100)) < 0;
    }

    public BigDecimal getBalance() {
        return balance;
    }


}
