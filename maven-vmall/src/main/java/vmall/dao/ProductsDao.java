package vmall.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import vmall.po.Products;

@Repository
@Mapper
public interface ProductsDao {
	public List<String> allcategories();
	public List<Products> prodlist(Map<String, Object>map); 
	public Products oneProduct(String pid);
	public List<Products> prodclass(String category);
	public Object findByImgurl(String imgurl);
	public void save(Products products);
	public List<Products> allprods();
	public void updateSaleStatus(Map<String, Object> map);
	public void updateSoldNum(Map<String,Object>map);
}
