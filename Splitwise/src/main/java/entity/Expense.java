package entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Expense {

    public String getId() {
        return id;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    String id;
    User createdBy;
    LocalDateTime createdTime;
    List<Split> splitList;
    BigDecimal amount;
    SplitType splitType;


    public Expense(String id, User createdBy, List<Split> splits, BigDecimal amount, SplitType splitType) {
        this.id = id;
        this.createdBy = createdBy;
        this.splitList = splits;
        this.amount = amount;
        this.splitType = splitType;
    }


    public SplitType getSplitType() {
        return splitType;
    }
}
