package kitchenpos;

import kitchenpos.application.FakePurgomalumClient;
import kitchenpos.domain.DeliveryOrder;
import kitchenpos.domain.EatInOrder;
import kitchenpos.domain.Menu;
import kitchenpos.domain.MenuGroup;
import kitchenpos.domain.MenuProduct;
import kitchenpos.domain.NullTypeOrder;
import kitchenpos.domain.Order;
import kitchenpos.domain.OrderLineItem;
import kitchenpos.domain.OrderStatus;
import kitchenpos.domain.OrderTable;
import kitchenpos.domain.OrderType;
import kitchenpos.domain.Product;
import kitchenpos.domain.TakeoutOrder;
import kitchenpos.infra.PurgomalumClient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
		return menu(price, true, menuProducts);
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

	public static Order order(OrderType type, UUID menuId) {
		List<OrderLineItem> orderLineItems = List.of(createOrderLineItemRequest(menuId, 19_000L, 3L));

		if (type == OrderType.TAKEOUT) {
			return new TakeoutOrder(
				OrderStatus.WAITING,
				LocalDateTime.now(),
				orderLineItems
			);
		}

		if (type == OrderType.DELIVERY) {
			return new DeliveryOrder(
				OrderStatus.WAITING,
				LocalDateTime.now(),
				orderLineItems,
				"서울시 송파구 위례성대로 2"
			);
		}

		if (type == OrderType.EAT_IN) {
			return new EatInOrder(
				OrderStatus.WAITING,
				LocalDateTime.now(),
				orderLineItems,
				orderTable(4, true)
			);
		}

		return new NullTypeOrder(
			OrderStatus.WAITING,
			LocalDateTime.now(),
			orderLineItems
		);
	}

	public static OrderLineItem createOrderLineItemRequest(final UUID menuId, final long price, final long quantity) {
		final OrderLineItem orderLineItem = new OrderLineItem();
		orderLineItem.setSeq(new Random().nextLong());
		orderLineItem.setMenuId(menuId);
		orderLineItem.setPrice(BigDecimal.valueOf(price));
		orderLineItem.setQuantity(quantity);
		return orderLineItem;
	}

	public static DeliveryOrder deliveryOrder(final OrderStatus status, final String deliveryAddress) {
		return new DeliveryOrder(
			status,
			LocalDateTime.of(2020, 1, 1, 12, 0),
			List.of(orderLineItem()),
			deliveryAddress
		);
	}

	public static EatInOrder eatInOrder(final OrderStatus status, final OrderTable orderTable) {
		return new EatInOrder(
			status,
			LocalDateTime.of(2020, 1, 1, 12, 0),
			List.of(orderLineItem()),
			orderTable
		);
	}

	public static TakeoutOrder takeoutOrder(final OrderStatus status) {
		return new TakeoutOrder(
			status,
			LocalDateTime.of(2020, 1, 1, 12, 0),
			List.of(orderLineItem())
		);
	}

	public static OrderLineItem orderLineItem() {
		final OrderLineItem orderLineItem = new OrderLineItem();
		orderLineItem.setSeq(new Random().nextLong());
		orderLineItem.setMenu(menu());
		return orderLineItem;
	}

	public static OrderTable orderTable() {
		return orderTable(0, false);
	}

	public static OrderTable orderTable(final int numberOfGuests, final boolean occupied) {
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

