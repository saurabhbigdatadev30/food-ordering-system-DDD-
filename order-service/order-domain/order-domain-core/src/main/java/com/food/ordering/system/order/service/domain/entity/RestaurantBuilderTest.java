package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.AggregateRoot;
import com.food.ordering.system.domain.valueobject.RestaurantId;

import java.util.List;

public class RestaurantBuilderTest extends AggregateRoot<RestaurantId>
{
    private boolean active;
    private List<Product> products;

    private RestaurantBuilderTest(Builder builder) {
        super.setId(builder.id);
        active = builder.active;
        products = builder.products;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder
    {
        private RestaurantId id;
        private boolean active;
        private List<Product> products;

        public Builder() {
        }

        public Builder id(RestaurantId val) {
            id = val;
            return this;
        }

        public Builder active(boolean val) {
            active = val;
            return this;
        }

        public Builder products(List<Product> val) {
            products = val;
            return this;
        }

        public RestaurantBuilderTest build()
        {
            return new RestaurantBuilderTest(this);
        }
    }
}
