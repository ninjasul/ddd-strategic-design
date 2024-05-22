package kitchenpos.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TAKEOUT")
public class TakeoutOrder extends Order {
	protected TakeoutOrder() {
		super(OrderType.TAKEOUT);
	}

	public TakeoutOrder(
		OrderStatus status,
		LocalDateTime orderDateTime,
		List<OrderLineItem> orderLineItems
	) {
		super(OrderType.TAKEOUT, status, orderDateTime, orderLineItems, null);
	}
}
