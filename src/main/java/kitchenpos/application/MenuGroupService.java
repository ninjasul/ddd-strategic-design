package kitchenpos.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kitchenpos.domain.MenuGroup;
import kitchenpos.domain.MenuGroupRepository;

@Service
public class MenuGroupService {
	private final MenuGroupRepository menuGroupRepository;

	public MenuGroupService(final MenuGroupRepository menuGroupRepository) {
		this.menuGroupRepository = menuGroupRepository;
	}

	@Transactional
	public MenuGroup create(final String name) {
		return menuGroupRepository.save(new MenuGroup(name));
	}

	@Transactional(readOnly = true)
	public List<MenuGroup> findAll() {
		return menuGroupRepository.findAll();
	}
}
