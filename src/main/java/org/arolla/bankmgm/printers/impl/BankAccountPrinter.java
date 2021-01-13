package org.arolla.bankmgm.printers.impl;

import org.arolla.bankmgm.domain.BankAccount;
import org.arolla.bankmgm.domain.Client;
import org.arolla.bankmgm.domain.Transaction;
import org.arolla.bankmgm.printers.Printer;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm.printers
 */
public class BankAccountPrinter implements Printer<BankAccount> {

    public static final String IBAN = "IBAN : ";

    private static final String PRINTING_PATTERN = "%s      \t#            %s            #      %s";
    public static final String OPERATION = "OPERATION";
    public static final String DATE = "       DATE      ";
    public static final String AMOUNT = "AMOUNT";

    public static final String ENTER = "\n";

    private final Printer<Client> clientPrinter;
    private final Printer<Transaction> transactionPrinter;

    public BankAccountPrinter() {
        clientPrinter = new ClientPrinter();
        transactionPrinter = new TransactionPrinter();
    }

    @Override
    public void print(BankAccount bankAccount) {
        AtomicReference<BigDecimal> atomicSum = new AtomicReference<BigDecimal>(new BigDecimal(0));
        clientPrinter.print(bankAccount.getClient());
        System.out.println(ENTER);
        System.out.println(IBAN + bankAccount.getIBAN());
        System.out.println(ENTER);
        System.out.println(String.format(PRINTING_PATTERN, OPERATION, DATE, AMOUNT));
        bankAccount.getTransactions().stream()
                .forEach(t -> transactionPrinter.print(t));

    }


}