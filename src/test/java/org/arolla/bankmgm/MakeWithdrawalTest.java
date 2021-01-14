package org.arolla.bankmgm;

import org.arolla.bankmgm.domain.BankAccount;
import org.arolla.bankmgm.factory.BankAccountTestFactory;
import org.arolla.bankmgm.services.GetAccountBalance;
import org.arolla.bankmgm.services.MakeWithdrawal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm
 */
public class MakeWithdrawalTest {
    private MakeWithdrawal makeWIthdrawal;

    @BeforeEach
    void beforeEach() {
        makeWIthdrawal = new MakeWithdrawal();
    }


    @Test
    void should_calculate_new_balance_after_deposit_transaction() throws Exception {
        // Given
        BankAccount bankAccount = BankAccountTestFactory.a_bank_account_with_deposit_transaction_of_ten();

        // When
        makeWIthdrawal.makeTransaction(bankAccount, new BigDecimal(35), "Withdrawal 35 dollar");

        // Then
        assertEquals(new BigDecimal(-25), GetAccountBalance.getAccountBalance(bankAccount));
    }
}
