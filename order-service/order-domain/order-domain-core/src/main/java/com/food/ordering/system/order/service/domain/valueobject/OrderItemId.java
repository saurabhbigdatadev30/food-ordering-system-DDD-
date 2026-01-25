package com.food.ordering.system.order.service.domain.valueobject;

import com.food.ordering.system.domain.valueobject.BaseId;

/**
   Instead of defining variable Long value in the OrderItemId class, we are inheriting it from the BaseId class.
    Removing redundancy and following DRY principle.

   We initialize it using the constructor of the BaseId class by calling super(value).
    This way, we can reuse the same logic for different identifier types across our domain
 */
public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
