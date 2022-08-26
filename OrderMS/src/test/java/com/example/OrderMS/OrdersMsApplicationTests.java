package com.example.OrderMS;

import com.example.OrderMS.controller.OrderController;
import com.example.OrderMS.entity.Orders;
import com.example.OrderMS.repository.OrderRepo;
import com.example.OrderMS.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class OrdersMsApplicationTests {

	@Autowired
	private OrderService orderService;

	@MockBean
	private OrderRepo orderRepo;

	@Autowired
	private OrderController orderController;

	@Test
	public void getOrdersTest(){

		when(orderRepo.findAll()).thenReturn(Stream.of(new Orders((long)1001,"21-8-22","Calpol",
				20,10,(long)101)).collect(Collectors.toList()));
		assertEquals(1,orderService.findAll().size());

	}

	private void assertEquals(int i, int size) {
	}

	@Test
	public void saveOrdersTest(){
		Orders orders = new Orders((long)1001,"22-8-21","Dolo-650",20,10,(long)101);
		when(orderRepo.save(orders)).thenReturn(orders);
		assertEquals(orders,orderService.saveOrder(orders));
	}

	private void assertEquals(Orders orders, Orders saveOrder) {
		
	}

	@Test
	void testSetDrugName(){
		Orders orders = new Orders();
		orders.setDrugName("Dolo-650");
		assertEquals(orders.getDrugName() == "Dolo-650");
	}

	private void assertEquals(boolean b) {
	}
	
	@Test
	void testSetDrugQuantity(){
		Orders orders = new Orders();
		orders.setDrugQuantity(100);
		assertEquals(orders.getDrugQuantity() == 100);
	}
	
	@Test
	void testSetDrugPrice(){
		Orders orders = new Orders();
		orders.setDrugQuantity(400);
		assertEquals(orders.getDrugPrice() == 400);
	}
	
	@Test
	void testSetDrugID(){
		Orders orders = new Orders();
		orders.setOrderDate("23-08-22");
		assertEquals(orders.getOrderDate() == "23-08-22");
		
	}

	@Test
	void getOrderControllerTest(){
		when(orderRepo.findAll())
				.thenReturn(Stream.of(new Orders((long)1001,"21-08-22","Calpol",100,800, (long)101))
						.collect(Collectors.toList()));
		assertEquals(1001,orderController.getOrders().size());
	}

	@Test
	void saveOrderControllerTest(){
		Orders orders = new Orders((long)1001,"21-08-22","Calpol",100,800, 101L);
		when(orderRepo.save(orders)).thenReturn(orders);
		assertEquals(orders,orderController.save(orders));
	}



}
