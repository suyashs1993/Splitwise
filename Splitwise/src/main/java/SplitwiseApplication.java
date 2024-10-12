import entity.Split;
import entity.User;
import enums.SplitType;
import service.BalanceManager;
import service.ExpenseManager;
import service.UserService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SplitwiseApplication {

    public static void main(String[] args){

        ExpenseManager expenseManager = new ExpenseManager();
        UserService userService = new UserService();

        User A = new User("A", "a@gmail.com", 25, "9XXXXXXXXX");
        User B = new User("B", "b@gmail.com", 25, "7XXXXXXXXX");
        User C = new User("C", "c@gmail.com", 25, "8XXXXXXXXX");
        User D = new User("D", "d@gmail.com", 25, "6XXXXXXXXX");
        userService.addUser(A);
        userService.addUser(B);
        userService.addUser(C);
        userService.addUser(D);
        List<Split> splitList = new ArrayList<>();
        splitList.add(new Split(A));
        splitList.add(new Split(B));
        splitList.add(new Split(C));
        splitList.add(new Split(D));
        expenseManager.addExpense(A, splitList, new BigDecimal(1000), SplitType.EQUAL);
        BalanceManager balanceManager = expenseManager.getBalanceManager();
        balanceManager.showAllBalances();
        splitList = new ArrayList<>();
        splitList.add(new Split(A, new BigDecimal(200)));
        splitList.add(new Split(B, new BigDecimal(400)));
        splitList.add(new Split(C, new BigDecimal(300)));
        splitList.add(new Split(D, new BigDecimal(500)));
        expenseManager.addExpense(B, splitList, new BigDecimal(1400), SplitType.EXACT);
        balanceManager.showAllBalances();

        splitList = new ArrayList<>();
        splitList.add(new Split(A, new BigDecimal(20)));
        splitList.add(new Split(B, new BigDecimal(40)));
        splitList.add(new Split(C, new BigDecimal(30)));
        splitList.add(new Split(D, new BigDecimal(10)));
        expenseManager.addExpense(C, splitList, new BigDecimal(1000), SplitType.PERCENT);
        balanceManager.showAllBalances();

        expenseManager.showBalancesForExpense("1");
    }
}
