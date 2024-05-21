package kitchenpos.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kitchenpos.domain.Menu;
import kitchenpos.domain.MenuGroup;
import kitchenpos.domain.MenuGroupRepository;
import kitchenpos.domain.MenuProduct;
import kitchenpos.domain.MenuRepository;
import kitchenpos.domain.Product;
import kitchenpos.domain.ProductRepository;
import kitchenpos.infra.PurgomalumClient;
import kitchenpos.ui.dto.MenuCreationRequest;

@Service
public class MenuService {
	private final MenuRepository menuRepository;
	private final MenuGroupRepository menuGroupRepository;
	private final ProductRepository productRepository;
	private final PurgomalumClient purgomalumClient;

	public MenuService(
		final MenuRepository menuRepository,
		final MenuGroupRepository menuGroupRepository,
		final ProductRepository productRepository,
		final PurgomalumClient purgomalumClient
	) {
		this.menuRepository = menuRepository;
		this.menuGroupRepository = menuGroupRepository;
		this.productRepository = productRepository;
		this.purgomalumClient = purgomalumClient;
	}

	@Transactional
	public Menu create(final MenuCreationRequest request) {
		final MenuGroup menuGroup = menuGroupRepository.findById(request.menuGroupId())
			.orElseThrow(() -> new NoSuchElementException("메뉴 그룹을 찾을 수 없습니다."));

		final Map<UUID, Product> products =
			productRepository.findAllByIdIn(new ArrayList<>(request.menuProductQuantities().keySet()))
				.stream()
				.collect(Collectors.toMap(Product::getId, product -> product));

		Menu menu = new Menu(
			request.name(),
			request.price(),
			menuGroup,
			buildMenuProducts(request, products),
			request.displayed(),
			purgomalumClient
		);

		return menuRepository.save(menu);
	}

	private List<MenuProduct> buildMenuProducts(MenuCreationRequest request, Map<UUID, Product> productMap) {
		return request.menuProductQuantities()
			.entrySet()
			.stream()
			.map(entry -> {
				Product product = productMap.get(entry.getKey());
				if (product == null) {
					throw new NoSuchElementException("상품을 찾을 수 없습니다.");
				}
				return new MenuProduct(product, entry.getValue());
			})
			.toList();
	}

	@Transactional
	public Menu changePrice(final UUID menuId, final BigDecimal requestPrice) {
		final Menu menu = menuRepository.findById(menuId).orElseThrow(NoSuchElementException::new);
		menu.changePrice(requestPrice);
		return menu;
	}

	@Transactional
	public Menu display(final UUID menuId) {
		final Menu menu = menuRepository.findById(menuId).orElseThrow(NoSuchElementException::new);
		menu.display(true);
		return menu;
	}

	@Transactional
	public Menu hide(final UUID menuId) {
		final Menu menu = menuRepository.findById(menuId).orElseThrow(NoSuchElementException::new);
		menu.display(false);
		return menu;
	}

	@Transactional(readOnly = true)
	public List<Menu> findAll() {
		return menuRepository.findAll();
	}
}
