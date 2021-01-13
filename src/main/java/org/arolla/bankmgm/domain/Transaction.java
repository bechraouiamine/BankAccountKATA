package org.arolla.bankmgm.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * Created by aminebechraoui, on 12/01/2021, in org.arolla.bankmgm
 */
public class Transaction {
    private TransactionTypeEnum transactionTypeEnum;
    private BigDecimal amount;
    private String label;
    private OffsetDateTime createdDate;

    public Transaction(TransactionTypeEnum transactionTypeEnum, BigDecimal amount, String label, OffsetDateTime createdDate) {
        this.transactionTypeEnum = transactionTypeEnum;
        this.amount = amount;
        this.label = label;
        this.createdDate = createdDate;
    }

    public TransactionTypeEnum getTransactionTypeEnum() {
        return transactionTypeEnum;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getLabel() {
        return label;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }
}
