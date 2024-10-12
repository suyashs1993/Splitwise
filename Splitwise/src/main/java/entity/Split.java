package entity;

import java.math.BigDecimal;

public class Split {

    User participant;
    BigDecimal amount;

    public Split(User participant, BigDecimal amount) {
        this.participant = participant;
        this.amount = amount;
    }

    public Split(User participant) {
        this.participant = participant;
    }

    public User getParticipant() {
        return participant;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
