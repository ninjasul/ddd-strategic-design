package kitchenpos.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("")
public class NullTypeOrder extends Order {
	protected NullTypeOrder() {
		super();
	}

	public NullTypeOrder(
		OrderStatus status,
		LocalDateTime orderDateTime,
		List<OrderLineItem> orderLineItems
	) {
		super(null, status, orderDateTime, orderLineItems, null);
	}
}
