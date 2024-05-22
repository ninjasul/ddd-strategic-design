package kitchenpos.application;

import static kitchenpos.domain.factory.OrderFactory.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import kitchenpos.domain.factory.DeliveryOrderFactory;
import kitchenpos.domain.factory.EatInOrderFactory;
import kitchenpos.domain.factory.OrderFactory;
import kitchenpos.domain.factory.OrderFactoryProvider;
import kitchenpos.domain.factory.TakeoutOrderFactory;
import kitchenpos.domain.OrderType;

public class InMemoryOrderFactoryProvider implements OrderFactoryProvider {
    private final Map<OrderType, OrderFactory> factories = new HashMap<>();

    public InMemoryOrderFactoryProvider() {
        factories.put(OrderType.DELIVERY, new DeliveryOrderFactory());
        factories.put(OrderType.EAT_IN, new EatInOrderFactory());
        factories.put(OrderType.TAKEOUT, new TakeoutOrderFactory());
    }

    @Override
    public OrderFactory getFactory(OrderType type) {
        return Optional.ofNullable(factories.get(type))
            .orElseThrow(() -> new IllegalArgumentException(INVALID_ORDER_TYPE_ERROR));
    }
}
