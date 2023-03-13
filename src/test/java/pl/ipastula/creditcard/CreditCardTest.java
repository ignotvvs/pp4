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
        card.assignLimit(BigDecimal.valueOf(1000));

        //Assert
        assert card.getBalance().equals(BigDecimal.valueOf(1000));
    }

    @Test
    void itAllowsToAssignDifferentCreditLimits() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5679");

        //Act
        card1.assignLimit(BigDecimal.valueOf(1000));
        card2.assignLimit(BigDecimal.valueOf(1000));

        //Assert
        assert card1.getBalance().equals(BigDecimal.valueOf(1000));
        assert card2.getBalance().equals(BigDecimal.valueOf(1000));

    }

    @Test
    void itCantAssignLimitBelow100() {
        CreditCard card = new CreditCard("1234-5678");
        try {
        card.assignLimit(BigDecimal.valueOf(50));
        fail("Should throw exception");
        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }

        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.assignLimit(BigDecimal.valueOf(10)));

        assertThrows(
                CreditBelowThresholdException.class,
                () -> card.assignLimit(BigDecimal.valueOf(99)));

    }



    @Test
    void testDoubleAndFloats() {
        /*double x1 = 0.03;
        double x2 = 0.01;
        double result = x1 - x2;

        System.out.println(result);*/

    }
}
