package vmall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import vmall.po.Cart;
import vmall.pojo.MyCart;

@Repository
@Mapper
public interface CartDao {
	public Cart findCart(Cart cart);
	public void addCart(Cart cart);
	public void updateCart(Cart cart);
	public List<MyCart> showcart(Integer user_id);
	public void updateBuyNum(Cart cart);
	public void delCart(Integer cartID);
	public MyCart findByCartID(Integer cartID);
}
