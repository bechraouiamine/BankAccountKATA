package org.arolla.bankmgm.services;

import org.arolla.bankmgm.domain.BankAccount;
import org.arolla.bankmgm.domain.Transaction;
import org.arolla.bankmgm.domain.TransactionTypeEnum;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm.services
 */
public abstract class AbstractMakeTransaction {
    public void makeTransaction(BankAccount bankAccount, BigDecimal amout, String label) {
        Transaction transaction = new Transaction(getTransactionType(), amout, label, OffsetDateTime.now());
        bankAccount.getTransactions().add(transaction);
    };

    public abstract TransactionTypeEnum getTransactionType();
}
