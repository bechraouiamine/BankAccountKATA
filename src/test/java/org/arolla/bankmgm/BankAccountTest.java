package org.arolla.bankmgm;

import org.arolla.bankmgm.domain.BankAccount;
import org.arolla.bankmgm.domain.TransactionTypeEnum;
import org.arolla.bankmgm.factory.BankAccountTestFactory;
import org.arolla.bankmgm.printers.impl.BankAccountPrinter;
import org.arolla.bankmgm.printers.Printer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm
 */
class BankAccountTest {

    private Printer<BankAccount> bankAccountPrinter = new BankAccountPrinter();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void beforeTests() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void afterTests() {
        System.setOut(originalOut);
        System.out.print(outContent);
    }

    @Test
    void should_retrieve_ten_as_the_first_deposit() {
        // Given
        BankAccount bankAccount = BankAccountTestFactory.a_bank_account_with_deposit_transaction_of_ten();

        // When
        BigDecimal balance = bankAccount.getBalance();

        // Then
        assertEquals(new BigDecimal(10), balance);
    }

    @Test
    void should_print_transactions_history() {
        // Given
        BankAccount bankAccount = BankAccountTestFactory.a_bank_account_with_deposit_transaction_of_ten();

        // When

        // Then
        bankAccountPrinter.print(bankAccount);
        assertNotNull(bankAccount);

        assertTrue(outContent.toString().contains(BankAccountTestFactory.AMOUNT.toString()));

        assertTrue(outContent.toString().contains(BankAccountTestFactory.AMINE));

        assertTrue(outContent.toString().contains(BankAccountTestFactory.BECHRAOUI));

        assertTrue(outContent.toString().contains(BankAccountTestFactory.IBAN));

        assertTrue(outContent.toString().contains(TransactionTypeEnum.DEPOSIT.toString()));
    }
}