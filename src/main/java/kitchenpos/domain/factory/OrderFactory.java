package kitchenpos.domain.factory;

import kitchenpos.domain.Order;
import kitchenpos.domain.OrderLineItems;
import kitchenpos.domain.OrderTable;

public interface OrderFactory {
    String INVALID_ORDER_TYPE_ERROR = "주문 유형이 유효하지 않습니다.";

    Order createOrder(OrderLineItems orderLineItems, OrderTable orderTable, String deliveryAddress);
}
