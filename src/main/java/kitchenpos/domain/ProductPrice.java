package kitchenpos.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductPrice {
	public static final String INVALID_PRICE_ERROR = "상품 가격은 0원 이상이어야 합니다.";

	@Column(name = "price", nullable = false)
	private BigDecimal value;

	protected ProductPrice() {
	}

	public ProductPrice(BigDecimal value) {
		if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException(INVALID_PRICE_ERROR);
		}

		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}
}
