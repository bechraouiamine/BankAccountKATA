package org.arolla.bankmgm.printers.impl;

import org.arolla.bankmgm.domain.BankAccount;
import org.arolla.bankmgm.domain.Client;
import org.arolla.bankmgm.domain.Transaction;
import org.arolla.bankmgm.domain.TransactionTypeEnum;
import org.arolla.bankmgm.domain.HistoryLine;
import org.arolla.bankmgm.printers.Printer;
import org.arolla.bankmgm.utils.TransformBankAccountToHistoryLine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm.printers
 */
public class BankAccountPrinter implements Printer<BankAccount> {

    public static final String IBAN = "IBAN : ";

    private final Printer<Client> clientPrinter;
    private final Printer<List<HistoryLine>> historyLinePrinterPrinter;

    public BankAccountPrinter() {
        clientPrinter = new ClientPrinter();
        historyLinePrinterPrinter = new HistoryLinePrinter();
    }

    @Override
    public void print(BankAccount bankAccount) {

        clientPrinter.print(bankAccount.getClient());

        System.out.println();

        System.out.println(IBAN + bankAccount.getIBAN());

        System.out.println();

        historyLinePrinterPrinter.print(TransformBankAccountToHistoryLine.transform(bankAccount));
    }


}
