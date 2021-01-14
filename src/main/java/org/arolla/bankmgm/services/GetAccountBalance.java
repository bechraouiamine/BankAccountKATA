package org.arolla.bankmgm.services;

import org.arolla.bankmgm.domain.BankAccount;
import org.arolla.bankmgm.domain.TransactionTypeEnum;

import java.math.BigDecimal;

/**
 * Created by BECHRAOUI, 14/01/2021
 */
public class GetAccountBalance {

    public static BigDecimal getAccountBalance(BankAccount bankAccount) {
        BigDecimal result = bankAccount.getTransactions()
                .stream()
                .map(transaction -> {
                    if (transaction.getTransactionTypeEnum().equals(TransactionTypeEnum.WITHDRAWAL)) {
                        return transaction.getAmount().negate();
                    }
                    return transaction.getAmount();
                })
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

        return result;
    }
}
