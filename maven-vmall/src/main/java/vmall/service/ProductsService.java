package vmall.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import vmall.po.Products;
import vmall.pojo.MyProducts;

@Service
public interface ProductsService {
	public List<String> allcategories();
	public List<Products> prodlist(Map<String, Object>map);
	public Products oneProduct(String pid);
	public List<Products> prodclass(String prodclass);
	public String save(MyProducts myproducts, HttpServletRequest request);
	public List<Products> allprods();
	public void updateSaleStatus(Map<String, Object> map);
}
