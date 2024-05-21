package kitchenpos;

import kitchenpos.application.FakePurgomalumClient;
import kitchenpos.domain.Menu;
import kitchenpos.domain.MenuGroup;
import kitchenpos.domain.MenuProduct;
import kitchenpos.domain.Order;
import kitchenpos.domain.OrderLineItem;
import kitchenpos.domain.OrderStatus;
import kitchenpos.domain.OrderTable;
import kitchenpos.domain.OrderType;
import kitchenpos.domain.Product;
import kitchenpos.infra.PurgomalumClient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Fixtures {

	public static final PurgomalumClient purgomalumClient = new FakePurgomalumClient();

	public static final UUID INVALID_ID = new UUID(0L, 0L);

	public static Menu menu() {
		return menu(19_000L, true, menuProduct());
	}

	public static Menu menu(final long price, final MenuProduct... menuProducts) {
		return menu(price, false, menuProducts);
	}

	public static Menu menu(final long price, final boolean displayed, final MenuProduct... menuProducts) {
		return new Menu(
			"후라이드+후라이드",
			BigDecimal.valueOf(price),
			menuGroup(),
			List.of(menuProducts),
			displayed,
			purgomalumClient
		);
	}

	public static MenuGroup menuGroup() {
		return menuGroup("두마리메뉴");
	}

	public static MenuGroup menuGroup(final String name) {
		return new MenuGroup(UUID.randomUUID(), name);
	}

	public static MenuProduct menuProduct() {
		return new MenuProduct(new Random().nextLong(), product(), 2L);
	}

	public static MenuProduct menuProduct(final Product product, final long quantity) {
		return new MenuProduct(new Random().nextLong(), product, quantity);
	}

	public static Order order(final OrderStatus status, final String deliveryAddress) {
		final Order order = new Order();
		order.setId(UUID.randomUUID());
		order.setType(OrderType.DELIVERY);
		order.setStatus(status);
		order.setOrderDateTime(LocalDateTime.of(2020, 1, 1, 12, 0));
		order.setOrderLineItems(Arrays.asList(orderLineItem()));
		order.setDeliveryAddress(deliveryAddress);
		return order;
	}

	public static Order order(final OrderStatus status) {
		final Order order = new Order();
		order.setId(UUID.randomUUID());
		order.setType(OrderType.TAKEOUT);
		order.setStatus(status);
		order.setOrderDateTime(LocalDateTime.of(2020, 1, 1, 12, 0));
		order.setOrderLineItems(Arrays.asList(orderLineItem()));
		return order;
	}

	public static Order order(final OrderStatus status, final OrderTable orderTable) {
		final Order order = new Order();
		order.setId(UUID.randomUUID());
		order.setType(OrderType.EAT_IN);
		order.setStatus(status);
		order.setOrderDateTime(LocalDateTime.of(2020, 1, 1, 12, 0));
		order.setOrderLineItems(Arrays.asList(orderLineItem()));
		order.setOrderTable(orderTable);
		return order;
	}

	public static OrderLineItem orderLineItem() {
		final OrderLineItem orderLineItem = new OrderLineItem();
		orderLineItem.setSeq(new Random().nextLong());
		orderLineItem.setMenu(menu());
		return orderLineItem;
	}

	public static OrderTable orderTable() {
		return orderTable(false, 0);
	}

	public static OrderTable orderTable(final boolean occupied, final int numberOfGuests) {
		return new OrderTable(
			UUID.randomUUID(),
			"1번",
			numberOfGuests,
			occupied
		);
	}

	public static Product product() {
		return product("후라이드", 16_000L);
	}

	public static Product product(final String name, final long price) {
		return new Product(name, BigDecimal.valueOf(price), purgomalumClient);
	}
}
