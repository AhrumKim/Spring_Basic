package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.OrderCommand;
import com.model.OrderItem;

/*
하나의 요청 주소로 2개의 업무처리
/order/order.do
  
GET > 화면
POST> 처리해주세요 

*/
@Controller
@RequestMapping("/order/order.do")
public class OrderController {

	@GetMapping
	public String form() {
		return "order/OrderForm";
	}
	
	@PostMapping
	public String submit(OrderCommand ordercommand) {
		return "order/OrderCommitted";
	}
	
	/*
	1. 자동화된 코드 ...
	1.1  OrderCommand command = new  OrderCommand();
	1.2  자동매핑 >> member field >>  private List<OrderItem> orderItem; 자동주입
	  
	2.   List<OrderItem> itemlist = new ArrayList<>();
	     >> orderItem[0].itemid > 1
	     >> orderItem[0].number > 10
	     >> orderItem[0].remark > 파손주의
	     itemlist.add(new OrderItem(1,10,"파손주의")
	     
	     >> orderItem[1].itemid > 1
	     >> orderItem[1].number > 10
	     >> orderItem[1].remark > 파손주의
	     itemlist.add(new OrderItem(2,10,"파손주의")
	     ...
	     itemlist.add(new OrderItem(3,10,"파손주의")
	  
	 3.  command.setOrderItem(itemlist);
	
	 4. orderItem 은 itemlist 주소값을 주입 .....
	 
	 5. View 전달  
		자동 key , value 생성 forward 
		public String submit(OrderCommand ordercommand)  
		
		key > orderCommand  value OrderCommand 주소
		
	 */
}
