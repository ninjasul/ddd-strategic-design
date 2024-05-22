package kitchenpos.domain.factory;

import kitchenpos.domain.OrderType;

public interface OrderFactoryProvider {
    OrderFactory getFactory(OrderType type);
}
