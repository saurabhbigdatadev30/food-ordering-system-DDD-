package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.BaseEntity;
import com.food.ordering.system.domain.valueobject.Money;
import com.food.ordering.system.domain.valueobject.ProductId;

/**
 1. Set the Identifier of Product Entity by calling the setId() method of BaseEntity.
 2. So we don't need to override the equals and hashcode method here, since they are implemented in BaseEntity
    & compares the identifier of the entity.
 */
public class Product extends BaseEntity<ProductId> {
    private String name;
    private Money price;

    /**
     Need of overloaded constructor: Since Product is used in both Order service and Restaurant service,
     they have different contexts for Product.

     1.When creating an OrderItem from order-service , you only know the ProductId from the request—you don't yet have name or price.
     2.These fields are later populated via updateWithConfirmedNameAndPrice(...) after querying the Restaurant service.
     3. Restaurant service, however, has full Product details when creating its Product entities.
     4.Thus, we provide two constructors: one for creating a Product with just an ID,
       and another for creating a Product with all details.
     */
    public Product(ProductId productId, String name, Money price) {
        super.setId(productId);
        this.name = name;
        this.price = price;
    }

    public Product(ProductId productId) {
        super.setId(productId);
    }

    public void updateWithConfirmedNameAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }
}
