package org.store.clothstar.order.service;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.store.clothstar.order.domain.Order;
import org.store.clothstar.order.dto.CreateOrderRequest;
import org.store.clothstar.order.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

	@InjectMocks
	private OrderService orderService;

	@Mock
	private OrderRepository orderRepository;

	@DisplayName("주문 생성")
	@Test
	void saveOrder() {
		//given
		CreateOrderRequest request = createOrderRequest();

		BDDMockito.given(orderRepository.saveOrder(Mockito.any(Order.class))).willReturn(1);

		//when
		// CreateOrderRequest response = orderService.saveOrder(request);

		//then
		// assertThat(response.getOrderId()).isEqualTo(request.getOrderId());

		//verify
		verify(orderRepository, times(1)).saveOrder(any(Order.class));
	}

	private CreateOrderRequest createOrderRequest() {
		return CreateOrderRequest.builder().build();
	}

}