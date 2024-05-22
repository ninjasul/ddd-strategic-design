package kitchenpos.order.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import kitchenpos.order.infra.KitchenridersClient;
import kitchenpos.order.domain.Order;
import kitchenpos.order.domain.OrderLineItems;
import kitchenpos.order.domain.OrderStatus;
import kitchenpos.order.infra.OrderRepository;

@Entity
@DiscriminatorValue("")
public class NullTypeOrder extends Order {
	protected NullTypeOrder() {
		super();
	}

	@Override
	public Order accepted(KitchenridersClient kitchenridersClient) {
		return null;
	}

	@Override
	public Order served() {
		return null;
	}

	@Override
	public Order delivering() {
		return null;
	}

	@Override
	public Order delivered() {
		return null;
	}

	@Override
	public Order completed(OrderRepository orderRepository) {
		return null;
	}

	public NullTypeOrder(
		OrderStatus status,
		OrderLineItems orderLineItems
	) {
		super(null, status, orderLineItems, null);
	}
}
