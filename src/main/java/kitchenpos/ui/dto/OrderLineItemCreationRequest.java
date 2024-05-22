package kitchenpos.ui.dto;

import java.math.BigDecimal;
import java.util.UUID;

import kitchenpos.domain.OrderType;

public record OrderLineItemCreationRequest(
    OrderType orderType,
    UUID menuId,
    BigDecimal price,
    long quantity
) {
}
