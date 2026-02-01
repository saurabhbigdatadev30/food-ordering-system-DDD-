package com.food.ordering.system.order.service.domain.valueobject;

import com.food.ordering.system.domain.valueobject.BaseId;

/**
   1. Instead of defining variable Long value in the OrderItemId class, we are inheriting it from the BaseId class.
   2. This removes redundancy of defining the field in the subclasses  and following DRY principle.
   3. We initialize it using the constructor of the BaseId class by calling super(value).
   4. This way, we can reuse the same logic for different identifier types across our domain .

 */
public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
