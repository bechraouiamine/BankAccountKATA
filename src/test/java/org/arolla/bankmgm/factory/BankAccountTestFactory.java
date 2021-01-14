package org.arolla.bankmgm.factory;

import org.arolla.bankmgm.domain.BankAccount;
import org.arolla.bankmgm.domain.Client;
import org.arolla.bankmgm.domain.Transaction;
import org.arolla.bankmgm.domain.TransactionTypeEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm
 */
public class BankAccountTestFactory {


    public static final BigDecimal AMOUNT = new BigDecimal(10);
    public static final String FIRST_DEPOSIT = "First deposit";
    public static final String IBAN = "GB68BARC20040163953777";
    public static final String AMINE = "Amine";
    public static final String BECHRAOUI = "Bechraoui";

    private BankAccountTestFactory() {
        // Do nothing
    }

    public static BankAccount a_bank_account_with_deposit_transaction_of_ten() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction(
                TransactionTypeEnum.DEPOSIT,
                AMOUNT,
                FIRST_DEPOSIT,
                OffsetDateTime.now()));
        return new BankAccount(
                IBAN,
                new Client(AMINE, BECHRAOUI, OffsetDateTime.now()),
                transactions
        );
    }

    public static BankAccount a_bank_account_with_multiple_transaction() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction(
                TransactionTypeEnum.DEPOSIT,
                new BigDecimal(100),
                FIRST_DEPOSIT,
                OffsetDateTime.now()));

        transactions.add(new Transaction(
                TransactionTypeEnum.WITHDRAWAL,
                new BigDecimal(20),
                FIRST_DEPOSIT,
                OffsetDateTime.now()));

        transactions.add(new Transaction(
                TransactionTypeEnum.WITHDRAWAL,
                new BigDecimal(35),
                FIRST_DEPOSIT,
                OffsetDateTime.now()));

        transactions.add(new Transaction(
                TransactionTypeEnum.DEPOSIT,
                new BigDecimal(12),
                FIRST_DEPOSIT,
                OffsetDateTime.now()));
        return new BankAccount(
                IBAN,
                new Client(AMINE, BECHRAOUI, OffsetDateTime.now()),
                transactions
        );
    }


}
