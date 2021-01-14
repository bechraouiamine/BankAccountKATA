package org.arolla.bankmgm.domain;

import org.arolla.bankmgm.domain.Transaction;

import java.math.BigDecimal;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm.printers
 */
public class HistoryLine {
    private Transaction transaction;
    private BigDecimal balance;

    public HistoryLine(Transaction transaction, BigDecimal balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
