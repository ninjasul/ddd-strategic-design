package kitchenpos.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class MenuGroupNameTest {
	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("메뉴 그룹 이름이 null이거나 비어있으면 메뉴 그룹 이름 객체를 생성할 수 없다.")
	void menuGroupNameOfNullOrEmpty(String invalidName) {
		// When & Then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> new MenuGroupName(invalidName))
			.withMessage(MenuGroupName.NULL_OR_EMPTY_NAME_ERROR);
	}

	@Test
	@DisplayName("유효한 메뉴 그룹 이름을 입력하면 메뉴 그룹 이름 객체가 정상적으로 생성된다.")
	void menuGroupName() {
		// Given
		String validName = "유효한 메뉴 그룹 이름";

		// When
		MenuGroupName menuGroupName = new MenuGroupName(validName);

		// Then
		assertEquals(validName, menuGroupName.getValue());
	}
}