package vmall.pojo;

import java.util.Map;

import vmall.po.Orders;
import vmall.po.Products;

public class OrderInfo {
	private Orders order;//������Ϣ
	private Map<Products, Integer> map;//�ö����е����ж�������Ϣ
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Map<Products, Integer> getMap() {
		return map;
	}
	public void setMap(Map<Products, Integer> map) {
		this.map = map;
	}
	
}
