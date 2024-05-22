package kitchenpos.domain.factory;

import static kitchenpos.domain.factory.OrderFactory.*;

import java.util.Map;
import java.util.Optional;

import kitchenpos.domain.OrderType;

public class DefaultOrderFactoryProvider implements OrderFactoryProvider {
    private final Map<OrderType, OrderFactory> factories;

    public DefaultOrderFactoryProvider(Map<OrderType, OrderFactory> factories) {
        this.factories = factories;
    }

    public OrderFactory getFactory(OrderType type) {
        return Optional.ofNullable(factories.get(type))
            .orElseThrow(() -> new IllegalArgumentException(INVALID_ORDER_TYPE_ERROR));
    }
}
