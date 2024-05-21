package kitchenpos.ui.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductCreationRequest(
	String name,
	BigDecimal price
) {
}
