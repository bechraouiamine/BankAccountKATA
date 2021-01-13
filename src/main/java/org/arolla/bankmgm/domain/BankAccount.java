package org.arolla.bankmgm.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Created by aminebechraoui, on 12/01/2021, in org.arolla.bankmgm
 */
public class BankAccount {
    private String IBAN;
    private Client client;
    private List<Transaction> transactions;

    public BankAccount(String IBAN, Client client, List<Transaction> transactions) {
        this.IBAN = IBAN;
        this.client = client;
        this.transactions = transactions;
    }

    public BigDecimal getBalance() {
        return transactions.stream().map(t -> t.getAmount()).reduce(BigDecimal.ZERO, (total, element) -> total.add(element));
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Client getClient() {
        return client;
    }

    public String getIBAN() {
        return IBAN;
    }
}
