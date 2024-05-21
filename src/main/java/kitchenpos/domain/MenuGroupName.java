package kitchenpos.domain;

import org.apache.logging.log4j.util.Strings;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MenuGroupName {
	public static final String NULL_OR_EMPTY_NAME_ERROR = "메뉴 그룹 이름은 비워 둘 수 없습니다.";

	@Column(name = "name", nullable = false)
	private String value;

	protected MenuGroupName() {
	}

	public MenuGroupName(String value) {
		if (Strings.isEmpty(value)) {
			throw new IllegalArgumentException(NULL_OR_EMPTY_NAME_ERROR);
		}

		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
