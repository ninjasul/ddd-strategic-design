package kitchenpos.domain.factory;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import kitchenpos.domain.Order;
import kitchenpos.domain.OrderLineItems;
import kitchenpos.domain.OrderStatus;
import kitchenpos.domain.OrderTable;
import kitchenpos.domain.TakeoutOrder;

@Component
public class TakeoutOrderFactory implements OrderFactory {
    @Override
    public Order createOrder(OrderLineItems orderLineItems, OrderTable orderTable, String deliveryAddress) {
        return new TakeoutOrder(
            OrderStatus.WAITING,
            LocalDateTime.now(),
            orderLineItems
        );
    }
}
