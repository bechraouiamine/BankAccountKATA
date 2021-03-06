package org.arolla.bankmgm.services;

import org.arolla.bankmgm.domain.BankAccount;
import org.arolla.bankmgm.domain.TransactionTypeEnum;

import java.math.BigDecimal;

/**
 * Created by aminebechraoui, on 13/01/2021, in org.arolla.bankmgm.services
 */
public class MakeDeposit extends AbstractMakeTransaction{

    @Override
    public TransactionTypeEnum getTransactionType() {
        return TransactionTypeEnum.DEPOSIT;
    }

    @Override
    public boolean isNegativeValuePossible() {
        return false;
    }


}
