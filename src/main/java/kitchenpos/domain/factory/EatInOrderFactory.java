package kitchenpos.domain.factory;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import kitchenpos.domain.EatInOrder;
import kitchenpos.domain.Order;
import kitchenpos.domain.OrderLineItems;
import kitchenpos.domain.OrderStatus;
import kitchenpos.domain.OrderTable;

@Component
public class EatInOrderFactory implements OrderFactory {
    @Override
    public Order createOrder(OrderLineItems orderLineItems, OrderTable orderTable, String deliveryAddress) {
        return new EatInOrder(
            OrderStatus.WAITING,
            LocalDateTime.now(),
            orderLineItems,
            orderTable
        );
    }
}
