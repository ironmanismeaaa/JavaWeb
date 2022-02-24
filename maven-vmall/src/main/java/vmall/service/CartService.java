package vmall.service;

import java.util.List;

import vmall.po.Cart;
import vmall.pojo.MyCart;

public interface CartService {
	public Cart findCart(Cart cart);
	public void addCart(Cart cart);
	public void updateCart(Cart cart);
	public List<MyCart> showcart(Integer user_id);
	public void updateBuyNum(Cart cart);
	public void delCart(Integer cartID);
	public MyCart findByCartID(Integer cartID);
}