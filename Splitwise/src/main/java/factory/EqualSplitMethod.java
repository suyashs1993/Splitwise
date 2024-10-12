package factory;

import entity.Balance;
import entity.Expense;
import entity.Split;
import entity.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EqualSplitMethod implements SplitMethod{
    @Override
    public List<Balance> split(Expense expense) {
        List<Balance> balanceList = new ArrayList<>();
        List<Split> splits = expense.getSplitList();
        BigDecimal amount = expense.getAmount().divide(new BigDecimal(splits.size())).setScale(2);
        User payer = expense.getCreatedBy();
        for(Split split : splits){
            if(split.getParticipant().getName().equals(payer.getName())) continue;
            Balance balance = new Balance(payer, split.getParticipant(), amount, expense);
            balanceList.add(balance);
        }
        return balanceList;
    }
}
