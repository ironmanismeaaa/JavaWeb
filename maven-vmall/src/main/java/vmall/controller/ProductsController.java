package vmall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vmall.po.Products;
import vmall.service.ProductsService;

@Controller("productsController")
public class ProductsController {
	@Autowired
	private ProductsService productsService;
	
	@RequestMapping(value="/prodclass/{prodclass}") 
	public String prodclass(@PathVariable String prodclass, Model model) {
		List<Products> products = productsService.prodclass(prodclass);
		model.addAttribute("products", products);
		return "prod_list";
	}
	
	@RequestMapping("/prodInfo")
	public String prodInfo(String pid, Model model) {
		Products product = productsService.oneProduct(pid);
		model.addAttribute("product", product);
		return "prod_info";
	}
	
	@RequestMapping("/prodlist")
	public String prodlist(String name,String category,
			String minprice,String maxprice,Model model){
		
		System.out.println("in");
		//查找商品表中所有的商品类别
		List<String> categories = productsService.allcategories();
		model.addAttribute("categories",categories);
		
		//为搜索条件设置默认值，并检索条件是否合法
		double _minPrice=0; //默认从0到最大值
		double _maxPrice = Double.MAX_VALUE;
		
		String reg = "^\\d+$"; //只能输入数字
		if(minprice!=null && !"".equals(minprice.trim()) && minprice.matches(reg)){
			_minPrice = Double.parseDouble(minprice);
		}
		if(maxprice!=null && !"".equals(maxprice.trim()) && maxprice.matches(reg)){
			//最高价格如果大于等于最低价格
			if(Double.parseDouble(maxprice) >= _minPrice){
				_maxPrice = Double.parseDouble(maxprice);
			}
		}
		//创建map,用于存放查询条件
		Map<String,Object> map=new HashMap<>();
		map.put("name", name);
		map.put("category",category);
		map.put("minPrice",_minPrice);
		map.put("maxPrice",_maxPrice);
		//根据条件查询符合条件的商品信息
		List<Products> products = productsService.prodlist(map);
		model.addAttribute("name",name);
		model.addAttribute("minPrice",_minPrice);
		model.addAttribute("maxPrice",_maxPrice);
		//查询结果暴露给前端
		model.addAttribute("products",products);
		//返回到  /WEB-INF/jsp/prod_list.jsp
		return "prod_list";
	}
	@RequestMapping("/mongodbtest")
	public String mongodbtest(String name,String category,
			String minprice,String maxprice,Model model){
		
		System.out.println("in");
		//查找商品表中所有的商品类别
		List<String> categories = productsService.allcategories();
		model.addAttribute("categories",categories);
		
		//为搜索条件设置默认值，并检索条件是否合法
		double _minPrice=0; //默认从0到最大值
		double _maxPrice = Double.MAX_VALUE;
		Map<String,Object> map=new HashMap<>();
		map.put("name", name);
		map.put("category",category);
		map.put("minPrice",_minPrice);
		map.put("maxPrice",_maxPrice);
		//根据条件查询符合条件的商品信息
		List<Products> products = productsService.prodlist(map);
		model.addAttribute("name",name);
		model.addAttribute("minPrice",_minPrice);
		model.addAttribute("maxPrice",_maxPrice);
		//查询结果暴露给前端
		model.addAttribute("products",products);
		//返回到  /WEB-INF/jsp/prod_list.jsp
		return "mongodbtest";
	}

}
