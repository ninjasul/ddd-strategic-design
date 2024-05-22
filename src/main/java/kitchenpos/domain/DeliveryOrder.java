package kitchenpos.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DELIVERY")
public class DeliveryOrder extends Order {
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "value", column = @Column(name = "delivery_address", nullable = false))
	})
	private DeliveryAddress deliveryAddress;

	protected DeliveryOrder() {
		super(OrderType.DELIVERY);
	}

	public DeliveryOrder(
		OrderStatus status,
		LocalDateTime orderDateTime,
		List<OrderLineItem> orderLineItems,
		String deliveryAddress
	) {
		super(OrderType.DELIVERY, status, orderDateTime, orderLineItems, null);
		this.deliveryAddress = new DeliveryAddress(deliveryAddress);
	}


	public String getDeliveryAddress() {
		return deliveryAddress.getValue();
	}
}

