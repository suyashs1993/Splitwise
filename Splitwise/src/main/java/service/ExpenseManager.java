package service;

import entity.Balance;
import entity.Expense;
import entity.Split;
import entity.User;
import enums.SplitType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ExpenseManager {


    Map<String, List<Expense>> userExpenseMap;

    public BalanceManager getBalanceManager() {
        return balanceManager;
    }

    private BalanceManager balanceManager;

    SplitMethodFactory splitMethodFactory;

    AtomicInteger expenseCounter;

    Map<String, List<Balance>> expenseBalanceMap;

     public ExpenseManager(){
         this.balanceManager = new BalanceManager();
         this.userExpenseMap = new HashMap<>();
         this.expenseBalanceMap = new HashMap<>();
         this.splitMethodFactory = new SplitMethodFactory();
         expenseCounter = new AtomicInteger();
     }

    public void addExpense(User createdBy, List<Split> splits, BigDecimal amount, SplitType splitType){
         String id = String.valueOf(expenseCounter.incrementAndGet());
         Expense expense = new Expense(id,createdBy, splits, amount, splitType);
        System.out.println(" entity.Expense created with id " + id);
         addExpenseToUser(expense);
        SplitMethod splitMethod = splitMethodFactory.getSplitMethod(splitType);
        List<Balance> balances = splitMethod.split(expense);
        balanceManager.updateUserBalance(balances, createdBy.getName());
        updateExpenseBalanceMap(balances, id);
    }

    public void updateExpenseBalanceMap(List<Balance> balances, String expenseId){
         expenseBalanceMap.put(expenseId, balances);

    }

    public void showBalancesForExpense(String expenseId){
        List<Balance> balances = expenseBalanceMap.get(expenseId);
        balances.forEach(System.out::println);

    }
    public void addExpenseToUser(Expense expense){
        List<Expense> expenseList = userExpenseMap.getOrDefault(expense.getCreatedBy().getName(), new ArrayList<>());
        expenseList.add(expense);
        userExpenseMap.put(expense.getCreatedBy().getName(), expenseList);
    }



//    public List<entity.Balance>getBalancesForExpense(String expenseId){
//
//
//    }

}
