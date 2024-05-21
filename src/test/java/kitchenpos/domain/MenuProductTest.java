package kitchenpos.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import kitchenpos.application.FakePurgomalumClient;
import kitchenpos.infra.PurgomalumClient;

class MenuProductTest {

	private final PurgomalumClient purgomalumClient = new FakePurgomalumClient();

	@Test
	@DisplayName("유효한 값으로 메뉴 상품 객체를 생성하면 정상적으로 생성된다.")
	void createMenuProductWithValidArguments() {
		// Given
		Long seqValue = 1L;
		Product product = createProduct("유효한 상품", 1000);
		long quantityValue = 10;

		// When
		MenuProduct menuProduct = new MenuProduct(seqValue, product, quantityValue);

		// Then
		assertEquals(seqValue, menuProduct.getSeq());
		assertEquals(product, menuProduct.getProduct());
		assertEquals(quantityValue, menuProduct.getQuantity());
	}

	@ParameterizedTest
	@ValueSource(longs = {-1, -10, -100})
	@DisplayName("수량이 0 미만이면 메뉴 상품 객체를 생성할 수 없다.")
	void createMenuProductWithInvalidQuantity(long invalidQuantity) {
		// Given
		Long seqValue = 1L;
		Product product = createProduct("유효한 상품", 1000);

		// When & Then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new MenuProduct(seqValue, product, invalidQuantity))
			.withMessage(Quantity.INVALID_VALUE_ERROR);
	}

	private Product createProduct(String name, long price) {
		return new Product(UUID.randomUUID(), name, new BigDecimal(price), purgomalumClient);
	}
}
