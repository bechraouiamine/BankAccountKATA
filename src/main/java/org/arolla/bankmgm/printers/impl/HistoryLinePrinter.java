package org.arolla.bankmgm.printers.impl;

import org.arolla.bankmgm.domain.HistoryLine;
import org.arolla.bankmgm.printers.Printer;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm.printers.impl
 */
public class HistoryLinePrinter implements Printer<List<HistoryLine>> {

    public static final String AMOUNT = "AMOUNT";
    public static final String OPERATION = "OPERATION";
    public static final String BALANCE = "BALANCE";
    public static final String DATE = "DATE";

    public static final String YYYYMMDD_HH_MM = "YYYYMMDD HH:MM";

    @Override
    public void print(List<HistoryLine> historyLines) {
        System.out.println(String.format(PRINTING_PATTERN + PRINTING_PATTERN + PRINTING_PATTERN + PRINTING_PATTERN, OPERATION, DATE, AMOUNT, BALANCE));

        historyLines.forEach(historyLine -> {
            System.out.println(
                    String.format(
                            PRINTING_PATTERN + PRINTING_PATTERN + PRINTING_PATTERN + PRINTING_PATTERN,
                            historyLine.getTransaction().getTransactionTypeEnum(),
                            formatDate(historyLine.getTransaction().getCreatedDate()),
                            historyLine.getTransaction().getAmount(),
                            historyLine.getBalance()
                    ));
        });

    }

    private String formatDate(OffsetDateTime offsetDateTime) {
        return offsetDateTime.format(DateTimeFormatter.ofPattern(YYYYMMDD_HH_MM));
    }
}
