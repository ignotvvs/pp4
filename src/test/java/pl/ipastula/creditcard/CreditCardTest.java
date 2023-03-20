package pl.ipastula.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {

    @Test
    void itAllowsToAssignCreditLimit() {
        //Arrange
        CreditCard card = new CreditCard("1234-5678");

        //Act
        card.assignCredit(BigDecimal.valueOf(1000));

        //Assert
        //assertEquals(BigDecimal);
        assert card.getBalance().equals(BigDecimal.valueOf(1000));
    }

    @Test
    void itAllowsToAssignDifferentCreditLimits() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5679");

        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(1000));

        //Assert
        assert card1.getBalance().equals(BigDecimal.valueOf(1000));
        assert card2.getBalance().equals(BigDecimal.valueOf(1000));

    }

    @Test
    void itCantAssignLimitBelow100V1() {
        CreditCard card = new CreditCard("1234-5678");
        try {
        card.assignCredit(BigDecimal.valueOf(50));
        fail("Should throw exception");
        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }
    }

    @Test
    void itCantAssignLimitBelow100() {
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5678");
        CreditCard card3 = new CreditCard("1234-5678");

        assertThrows(CreditBelowThresholdException.class,
                () -> card1.assignCredit(BigDecimal.valueOf(10)));

        assertThrows(CreditBelowThresholdException.class,
                () -> card2.assignCredit(BigDecimal.valueOf(99)));

        assertDoesNotThrow(() -> card3.assignCredit(BigDecimal.valueOf(100)));

    }

    @Test
    void itCantAssignLimitTwice() {
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5678");
        CreditCard card3 = new CreditCard("1234-5678");

        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(1000));
        assertThrows(CreditAssignedTwiceException.class,
                () -> card1.assignCredit(BigDecimal.valueOf(1000)));

        assertThrows(CreditAssignedTwiceException.class,
                () -> card2.assignCredit(BigDecimal.valueOf(1000)));

        assertDoesNotThrow(() -> card3.assignCredit(BigDecimal.valueOf(1000)));
    }

    @Test
    void itAllowsToWithDraw () {
        CreditCard card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(900), card.getBalance());
    }

    @Test
    void itCantWithdrawAboveBalance () {
        CreditCard card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));

        assertThrows(WithdrawalAmountOverBalanceException.class,
                () -> card.withdraw(BigDecimal.valueOf(1200)));
    }

    @Test
    void testDoubleAndFloats() {
        /*double x1 = 0.03;
        double x2 = 0.01;
        double result = x1 - x2;

        System.out.println(result);*/

    }
}
