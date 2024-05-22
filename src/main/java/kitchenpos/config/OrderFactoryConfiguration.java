package kitchenpos.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kitchenpos.domain.OrderType;
import kitchenpos.domain.factory.DefaultOrderFactoryProvider;
import kitchenpos.domain.factory.DeliveryOrderFactory;
import kitchenpos.domain.factory.EatInOrderFactory;
import kitchenpos.domain.factory.OrderFactory;
import kitchenpos.domain.factory.OrderFactoryProvider;
import kitchenpos.domain.factory.TakeoutOrderFactory;

@Configuration
public class OrderFactoryConfiguration {

    @Bean
    public OrderFactoryProvider orderFactoryProvider() {
        final Map<OrderType, OrderFactory> factories = Map.of(
            OrderType.DELIVERY, new DeliveryOrderFactory(),
            OrderType.EAT_IN, new EatInOrderFactory(),
            OrderType.TAKEOUT, new TakeoutOrderFactory()
        );

        return new DefaultOrderFactoryProvider(factories);
    }
}

