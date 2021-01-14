package org.arolla.bankmgm;

import org.arolla.bankmgm.domain.BankAccount;
import org.arolla.bankmgm.factory.BankAccountTestFactory;
import org.arolla.bankmgm.services.AbstractMakeTransaction;
import org.arolla.bankmgm.services.GetAccountBalance;
import org.arolla.bankmgm.services.MakeDeposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm
 */
public class MakeDepositTest {
    private MakeDeposit makeDeposit;

    @BeforeEach
    void beforeEach() {
        makeDeposit = new MakeDeposit();
    }


    @Test
    void should_calculate_new_balance_after_deposit_transaction() {
        // Given
        BankAccount bankAccount = BankAccountTestFactory.a_bank_account_with_deposit_transaction_of_ten();

        // When
        makeDeposit.makeTransaction(bankAccount, new BigDecimal(25), "Deposit 25 dollar");

        // Then
        assertEquals(new BigDecimal(35), GetAccountBalance.getAccountBalance(bankAccount));
    }

    @Test
    void should_throw_exception_when_negative_amount() {
        // Given
        BankAccount bankAccount = BankAccountTestFactory.a_bank_account_with_deposit_transaction_of_ten();

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> makeDeposit.makeTransaction(bankAccount, new BigDecimal(25).negate(), "Deposit 25 dollar"));

        // Then
        assertTrue(exception instanceof IllegalArgumentException);

        assertEquals(exception.getMessage(), AbstractMakeTransaction.ERROR_MESSAGE);

    }


}
