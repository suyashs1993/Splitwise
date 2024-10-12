package service;

import entity.Balance;
import entity.User;

import java.math.BigDecimal;
import java.util.*;

public class BalanceManager {

    List<Balance> balanceList;

    Map<String, Map<String, BigDecimal>> userBalanceMap;

   public BalanceManager(){

       userBalanceMap = new HashMap<>();
       balanceList = new ArrayList<>();
   }

   public  void addBalance(List<Balance> balances){
        balanceList.addAll(balances);

    }

    public void updateUserBalance(List<Balance> balances, String name){
       addBalance(balances);
       Map<String, BigDecimal> payerBalanceMap = userBalanceMap.getOrDefault(name, new HashMap<>());
       for(Balance balance : balances){
            BigDecimal amount = payerBalanceMap.getOrDefault(balance.getReceiver().getName(), new BigDecimal(0));
            amount = amount.add(balance.getAmount()).setScale(2);
            payerBalanceMap.put(balance.getReceiver().getName(), amount);
            Map<String, BigDecimal> receiverBalanceMap = userBalanceMap.getOrDefault(balance.getReceiver().getName(), new HashMap<>());
            amount = receiverBalanceMap.getOrDefault(name, new BigDecimal(0));
            amount = amount.subtract(balance.getAmount()).setScale(2);
            receiverBalanceMap.put(name, amount);
            userBalanceMap.put(balance.getReceiver().getName(), receiverBalanceMap);
       }
       userBalanceMap.put(name, payerBalanceMap);
    }


    public void showUserBalances(User user){
        Map<String, BigDecimal> payerBalanceMap = userBalanceMap.get(user.getName());
        if(payerBalanceMap == null || payerBalanceMap.isEmpty()){
            System.out.println("No balances to show for user");
            return;
        }
        for(Map.Entry<String, BigDecimal> entry : payerBalanceMap.entrySet()){
            if(entry.getValue().compareTo(new BigDecimal(0)) == 0){
                continue;
            }else if(entry.getValue().compareTo(new BigDecimal(0)) >= 0){
                System.out.println("entity.User "+ entry.getKey() + " owes entity.User "+user.getName() + " Rs "+ entry.getValue());
            }else{
                System.out.println("entity.User "+ user.getName() + " owes entity.User "+entry.getKey() + " Rs "+ entry.getValue().negate());
            }

        }
    }

    public void showBalanceForPair(User userOne, User userTwo){
        Map<String, BigDecimal> payerBalanceMap = userBalanceMap.get(userOne.getName());
        if(payerBalanceMap == null || payerBalanceMap.isEmpty() || !payerBalanceMap.containsKey(userTwo.getName())){
            System.out.println("No entity.Balance between these users");
            return;
        }
        BigDecimal pairBalanceAmount = payerBalanceMap.get(userTwo.getName());

        if(pairBalanceAmount.compareTo(new BigDecimal(0)) == 0){
            System.out.println("No balance between these users");
        }else if(pairBalanceAmount.compareTo(new BigDecimal(0)) >= 0){
            System.out.println("entity.User "+ userTwo.getName()  + " owes entity.User "+userOne.getName() + " Rs "+ pairBalanceAmount);
        }else{
            System.out.println("entity.User "+ userOne.getName()  + " owes entity.User "+userTwo.getName() + " Rs "+ pairBalanceAmount.negate());
        }

   }

    public void showAllBalances(){
       Set<String> userPairSet = new HashSet<>();
       if( userBalanceMap == null || userBalanceMap.isEmpty()){
           System.out.println(" No balances to show");
       }

        for(Map.Entry<String, Map<String, BigDecimal>> entry : userBalanceMap.entrySet()){
            Map<String, BigDecimal> payerBalanceMap = entry.getValue();
            String payer = entry.getKey();
            for(Map.Entry<String, BigDecimal> innerEntry : payerBalanceMap.entrySet()) {
                if(!(userPairSet.contains(payer + "~" + innerEntry.getKey()) || userPairSet.contains(innerEntry.getKey() +
                        "~" + payer))) {
                    if (innerEntry.getValue().compareTo(new BigDecimal(0)) == 0) {
                        continue;
                    } else if (innerEntry.getValue().compareTo(new BigDecimal(0)) >= 0) {
                        System.out.println("entity.User " + innerEntry.getKey() + " owes entity.User " + payer + " Rs " + innerEntry.getValue());
                    } else {
                        System.out.println("entity.User " + payer + " owes entity.User " + innerEntry.getKey() + " Rs " + innerEntry.getValue().negate());
                    }
                  userPairSet.add(payer + "~" + innerEntry.getKey());
                }
            }

        }

    }

}



