package factory;

import entity.Balance;
import entity.Expense;

import java.util.List;

public interface SplitMethod {

    public List<Balance> split(Expense expense);
}
