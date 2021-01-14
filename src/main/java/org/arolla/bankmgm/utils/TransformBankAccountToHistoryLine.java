package org.arolla.bankmgm.utils;

import org.arolla.bankmgm.domain.BankAccount;
import org.arolla.bankmgm.domain.HistoryLine;
import org.arolla.bankmgm.domain.Transaction;
import org.arolla.bankmgm.domain.TransactionTypeEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by BECHRAOUI, 14/01/2021
 */
public class TransformBankAccountToHistoryLine {

    public static List<HistoryLine> transform(BankAccount bankAccount) {
        Iterator<Transaction> iterator = bankAccount.getTransactions().iterator();

        BigDecimal balance = BigDecimal.ZERO;

        List<HistoryLine> historyLines = new ArrayList<HistoryLine>();

        while (iterator.hasNext()) {
            Transaction transaction = iterator.next();
            balance = transaction.getTransactionTypeEnum()
                    .equals(TransactionTypeEnum.DEPOSIT) ?
                    balance.add(transaction.getAmount()) :
                    balance.subtract(transaction.getAmount());
            historyLines.add(new HistoryLine(transaction, balance));

        }

        return historyLines;
    }
}
