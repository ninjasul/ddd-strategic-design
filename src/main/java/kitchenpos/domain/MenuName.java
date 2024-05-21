package kitchenpos.domain;

import org.springframework.util.StringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import kitchenpos.infra.PurgomalumClient;

@Embeddable
public class MenuName {
	public static final String NULL_OR_EMPTY_NAME_ERROR = "메뉴 이름은 비워 둘 수 없습니다.";
	public static final String NAME_WITH_PROFANITY_ERROR = "메뉴 이름에 비속어가 포함될 수 없습니다.";

	@Column(name = "name", nullable = false)
	private String value;

	protected MenuName() {
	}

	public MenuName(String value, PurgomalumClient purgomalumClient) {
		if (!StringUtils.hasText(value)) {
			throw new IllegalArgumentException(NULL_OR_EMPTY_NAME_ERROR);
		}

		if (purgomalumClient.containsProfanity(value)) {
			throw new IllegalArgumentException(NAME_WITH_PROFANITY_ERROR);
		}

		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
