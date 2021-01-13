package org.arolla.bankmgm.printers.impl;

import org.arolla.bankmgm.domain.BankAccount;
import org.arolla.bankmgm.domain.Client;
import org.arolla.bankmgm.printers.Printer;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm.printers
 */
public class ClientPrinter implements Printer<Client> {


    public static final String NAME = "Name";
    public static final String LAST = "Last";
    public static final String BIRTH_DATE = "Birth Date";
    public static final String YYYYMMDD = "YYYYMMDD";

    @Override
    public void print(Client toPrint) {
        System.out.println(String.format(PRINTING_PATTERN, NAME, LAST, BIRTH_DATE));
        System.out.println(
                        String.format(
                                PRINTING_PATTERN,
                                toPrint.getName(),
                                toPrint.getLastName(),
                                formatDate(toPrint.getBirthDate())
                        )
        );
    }

    private String formatDate(OffsetDateTime offsetDateTime) {
        return offsetDateTime.format(DateTimeFormatter.ofPattern(YYYYMMDD));
    }
}
