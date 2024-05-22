package kitchenpos.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EAT_IN")
public class EatInOrder extends Order {

	public EatInOrder() {
		super(OrderType.EAT_IN);
	}

	public EatInOrder(
		OrderStatus status,
		LocalDateTime orderDateTime,
		List<OrderLineItem> orderLineItems,
		OrderTable orderTable
	) {
		super(OrderType.EAT_IN, status, orderDateTime, orderLineItems, orderTable);
	}
}
