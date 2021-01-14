package org.arolla.bankmgm.printers.impl;

import org.arolla.bankmgm.printers.BankAccountHistoryLine;
import org.arolla.bankmgm.printers.Printer;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm.printers.impl
 */
public class HistoryLinePrinter implements Printer<BankAccountHistoryLine> {

    public static final String AMOUNT = "Amount : ";
    public static final String TRANSACTION_TYPE = "Transaction Type : ";
    public static final String BANK_IBAN = "Bank Iban : ";

    private static final String PRINTING_PATTERN = "%s      \t#            %s            #      %s #  %s";
    public static final String YYYYMMDD_HH_MM_SS = "YYYYMMDD HH:MM:SS";

    @Override
    public void print(BankAccountHistoryLine bankAccountHistoryLine) {
        System.out.println(
                String.format(
                        PRINTING_PATTERN,
                        bankAccountHistoryLine.getTransaction().getTransactionTypeEnum(),
                        formatDate(bankAccountHistoryLine.getTransaction().getCreatedDate()),
                        bankAccountHistoryLine.getTransaction().getAmount(),
                        bankAccountHistoryLine.getBalance()
                ));
    }

    private String formatDate(OffsetDateTime offsetDateTime) {
        return offsetDateTime.format(DateTimeFormatter.ofPattern(YYYYMMDD_HH_MM_SS));
    }
}
