package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.BaseEntity;
import com.food.ordering.system.domain.valueobject.Money;
import com.food.ordering.system.domain.valueobject.OrderId;
import com.food.ordering.system.order.service.domain.valueobject.OrderItemId;

/*
 1. OrderItem extends BaseEntity<ID> , sets the ID field to = OrderItemId . So the setId(..) method will accept OrderItemId type.
 2. So the OrderItem class inherits the equals and hashcode methods from BaseEntity class which compares the identifier of the entity.
    on OrderItemId.
 3. The OrderItem class has a method initializeOrderItem(..) which sets the orderId and also calls the setId(..) method
     of BaseEntity to set the OrderItemId.
 */
public class OrderItem extends BaseEntity<OrderItemId> {
    private  OrderId orderId;
    private final Product product;
    private final int quantity;
    private final Money price;
    private final Money subTotal;

    void initializeOrderItem(OrderId orderId, OrderItemId orderItemId) {
        this.orderId = orderId;
        super.setId(orderItemId);
    }

    boolean isPriceValid() {
        return price.isGreaterThanZero() &&
                price.equals(product.getPrice()) &&
                price.multiply(quantity).equals(subTotal);
    }

    /**
     1.Constructor is private and can only be called from the Builder
     2.We use the Builder pattern to create instances of OrderItem class.
     3.The Id of the BaseEntity is set using the setId method from the BaseEntity class & passed the OrderItemId from the Builder.
     */
    private OrderItem(Builder builder) {
        // Initialize the BaseEntity's id with OrderItemId from the builder
        super.setId(builder.orderItemId);
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.subTotal = builder.subTotal;
    }

    public static Builder builder() {
        return new Builder();
    }


    public OrderId getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getPrice() {
        return price;
    }

    public Money getSubTotal() {
        return subTotal;
    }

    public static final class Builder {
        private OrderItemId orderItemId;
        private Product product;
        private int quantity;
        private Money price;
        private Money subTotal;

        private Builder() {
        }

        public Builder orderItemId(OrderItemId val) {
            orderItemId = val;
            return this;
        }

        public Builder product(Product val) {
            product = val;
            return this;
        }

        public Builder quantity(int val) {
            quantity = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Builder subTotal(Money val) {
            subTotal = val;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
