package vmall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vmall.dao.CartDao;
import vmall.dao.OrderDao;
import vmall.dao.OrderItemDao;
import vmall.dao.ProductsDao;
import vmall.po.OrderItem;
import vmall.po.Orders;
import vmall.pojo.MyCart;
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private CartDao cartDao;
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ProductsDao productsDao;
	@Override
	@Transactional
	public void addOrder(String cartIds, Orders myOrder) {
		String[] arrCartIds = cartIds.split(",");
		Double sum = 0.0;
		for (String cartID : arrCartIds) {
			Integer cid = Integer.parseInt(cartID);
			MyCart mycart = cartDao.findByCartID(cid);
			String pid = mycart.getId();
			int buynum = mycart.getNum();
			Double price = mycart.getPrice();
			sum += buynum * price;
			OrderItem orderitem = new OrderItem();
			orderitem.setOrder_id(myOrder.getId());
			orderitem.setProduct_id(pid);
			orderitem.setBuynum(buynum);
			orderItemDao.addOrderItem(orderitem);
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("pid", pid);
			map.put("buynum", buynum);
			productsDao.updateSoldNum(map);
			cartDao.delCart(cid);
		}
		myOrder.setMoney(sum);
		orderDao.addOrder(myOrder);
	}

	@Override
	public List<Orders> findOrderByUserId(Integer userId) {
		return orderDao.findOrderByUserId(userId);
	}

	@Override
	public List<OrderItem> orderitem(String order_id) {
		return orderItemDao.orderitem(order_id);
	}

	@Override
	public void delorder(String id) {
		List<OrderItem>orderitems=orderItemDao.orderitem(id);
		for(OrderItem orderItem:orderitems) {
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("pid", orderItem.getProduct_id());
			map.put("buynum",-orderItem.getBuynum());
			productsDao.updateSoldNum(map);
		}
		orderDao.delorder(id);
		orderItemDao.delorderitem(id);
		
	}

	@Override
	public void payorder(String id) {
		orderDao.payorder(id);
		
	}

}
