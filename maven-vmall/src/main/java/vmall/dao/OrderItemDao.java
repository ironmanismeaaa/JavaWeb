package vmall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import vmall.po.OrderItem;
@Repository
@Mapper
public interface OrderItemDao {
	public void addOrderItem(OrderItem orderItem);
	public List<OrderItem> orderitem(String order_id);
	public void delorderitem(String id);
}
