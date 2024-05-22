package kitchenpos.domain.factory;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import kitchenpos.domain.DeliveryOrder;
import kitchenpos.domain.Order;
import kitchenpos.domain.OrderLineItems;
import kitchenpos.domain.OrderStatus;
import kitchenpos.domain.OrderTable;

@Component
public class DeliveryOrderFactory implements OrderFactory {

    @Override
    public Order createOrder(OrderLineItems orderLineItems, OrderTable orderTable, String deliveryAddress) {
        return new DeliveryOrder(
            OrderStatus.WAITING,
            LocalDateTime.now(),
            orderLineItems,
            deliveryAddress
        );
    }
}

