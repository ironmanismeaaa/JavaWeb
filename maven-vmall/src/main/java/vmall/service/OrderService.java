package vmall.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import vmall.po.OrderItem;
import vmall.po.Orders;
import vmall.pojo.OrderInfo;

public interface OrderService {

	public void addOrder(String cartIds, Orders myOrder);
	public List<Orders> findOrderByUserId(Integer userId);
	public List<OrderItem> orderitem(String order_id);
	public void delorder(String id);
	public void payorder(String id);
}
