package factory;

import entity.Balance;
import entity.Expense;
import entity.Split;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class ExactSplitMethod implements SplitMethod{

    @Override
    public List<Balance> split(Expense expense) {
        List<Balance> balanceList = new ArrayList<>();
        List<Split> splits = expense.getSplitList();
        User payer = expense.getCreatedBy();
        for(Split split : splits){
            if(split.getParticipant().getName().equals(payer.getName())) continue;
            Balance balance = new Balance(payer, split.getParticipant(), split.getAmount(), expense);
            balanceList.add(balance);
        }
        return balanceList;
    }
}
