package com.food.ordering.system.domain.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private final BigDecimal amount;
    public static final Money ZERO = new Money(BigDecimal.ZERO);

   /*
       public Money(BigDecimal amount)
       {
        this.amount = amount;
    }*/

    public Money(BigDecimal amount) {
        this.amount = setScale(Objects.requireNonNull(amount, "amount must not be null"));
    }

    // Check if the amount is greater than zero , so first check if amount is not null and then compare it to > ZERO
    public boolean isGreaterThanZero() {
        return this.amount != null && this.amount.compareTo(BigDecimal.ZERO) > 0;
    }


    // Check if the amount is greater than the amount of another Money object
    public boolean isGreaterThan(Money money) {
        // Ensure the money object &  its amount are not null
        Objects.requireNonNull(money, "Money must not be null");
        Objects.requireNonNull(money.getAmount(), "Money amount must not be null");
        return this.amount != null && this.amount.compareTo(money.getAmount()) >= 0;
    }


    public Money add(Money money) {
        Objects.requireNonNull(money, "Money  must not be null");
        Objects.requireNonNull(money.getAmount(), "Money amount must not be null");
        return new Money(setScale(this.amount.add(money.getAmount())));
    }

    public Money subtract(Money money) {
        Objects.requireNonNull(money, "Money must not be null");
        if (!isGreaterThan(money)) {
            throw new IllegalArgumentException("Cannot subtract " + money.getAmount() + ": result would be negative. Current amount: " + this.amount);
        }
        return new Money(setScale(this.amount.subtract(money.getAmount())));
    }

    public Money debitAmount(Money money) {
        if (this.amount.compareTo(money.getAmount()) < 0) {
            throw new IllegalArgumentException(
                    "Debit amount %s exceeds current balance %s".formatted(money.getAmount(), this.amount)
            );

        }
        return new Money(setScale(this.amount.subtract(money.getAmount())));
    }

    public Money multiply(int multiplier) {
        return new Money(setScale(this.amount.multiply(new BigDecimal(multiplier))));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    private BigDecimal setScale(BigDecimal input) {
        return input.setScale(2, RoundingMode.HALF_EVEN);
    }
}
