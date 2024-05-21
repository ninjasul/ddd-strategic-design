package kitchenpos.application;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.flywaydb.core.internal.util.CollectionsUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import kitchenpos.domain.Menu;
import kitchenpos.domain.MenuProduct;
import kitchenpos.domain.MenuRepository;
import kitchenpos.domain.Product;
import kitchenpos.domain.ProductRepository;
import kitchenpos.infra.PurgomalumClient;
import kitchenpos.ui.dto.ProductCreationRequest;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final MenuRepository menuRepository;
	private final PurgomalumClient purgomalumClient;

	public ProductService(
		final ProductRepository productRepository,
		final MenuRepository menuRepository,
		final PurgomalumClient purgomalumClient
	) {
		this.productRepository = productRepository;
		this.menuRepository = menuRepository;
		this.purgomalumClient = purgomalumClient;
	}

	@Transactional
	public Product create(final ProductCreationRequest request) {
		final Product product = new Product(
			UUID.randomUUID(),
			request.name(),
			request.price(),
			purgomalumClient
		);

		return productRepository.save(product);
	}

	@Transactional
	public Product changePrice(final UUID productId, final BigDecimal price) {
		final Product product = productRepository.findById(productId)
			.orElseThrow(NoSuchElementException::new);

		product.changePrice(price);

		final List<Menu> menus = menuRepository.findAllByProductId(productId);

		if (!CollectionUtils.isEmpty(menus)) {
			menus.forEach(Menu::displayBasedOnProductsPrice);
		}

		return product;
	}

	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return productRepository.findAll();
	}
}
