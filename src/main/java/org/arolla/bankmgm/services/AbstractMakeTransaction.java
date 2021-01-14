package org.arolla.bankmgm.services;

import org.arolla.bankmgm.domain.BankAccount;
import org.arolla.bankmgm.domain.Transaction;
import org.arolla.bankmgm.domain.TransactionTypeEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm.services
 */
public abstract class AbstractMakeTransaction {
    public static String ERROR_MESSAGE = "Unauthorized Value";

    public void makeTransaction(BankAccount bankAccount, BigDecimal amout, String label) throws IllegalArgumentException {
        if (amout.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        Transaction transaction = new Transaction(getTransactionType(), amout, label, OffsetDateTime.now());
        bankAccount.getTransactions().add(transaction);
    };

    public abstract TransactionTypeEnum getTransactionType();

    public abstract boolean isNegativeValuePossible();

}
