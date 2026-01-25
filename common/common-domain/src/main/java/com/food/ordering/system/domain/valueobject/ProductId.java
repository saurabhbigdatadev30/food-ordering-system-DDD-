package com.food.ordering.system.domain.valueobject;

import java.util.UUID;

/**
 ProductId initializes the UUID field in the superclass rather than defining it locally.
 1. It extends BaseId<UUID>, which already has a final T value field (where T = UUID).
 2. The constructor calls super(value) to initialize that inherited field in the base class.
 3. This avoids duplicating the field declaration in every value object (ProductId, OrderId, CustomerId, etc.).

 */
public class ProductId extends BaseId<UUID> {
    public ProductId(UUID value) {
        super(value);
    }
}
