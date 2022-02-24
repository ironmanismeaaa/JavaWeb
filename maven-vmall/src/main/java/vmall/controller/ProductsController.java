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
		//������Ʒ�������е���Ʒ���
		List<String> categories = productsService.allcategories();
		model.addAttribute("categories",categories);
		
		//Ϊ������������Ĭ��ֵ�������������Ƿ�Ϸ�
		double _minPrice=0; //Ĭ�ϴ�0�����ֵ
		double _maxPrice = Double.MAX_VALUE;
		
		String reg = "^\\d+$"; //ֻ����������
		if(minprice!=null && !"".equals(minprice.trim()) && minprice.matches(reg)){
			_minPrice = Double.parseDouble(minprice);
		}
		if(maxprice!=null && !"".equals(maxprice.trim()) && maxprice.matches(reg)){
			//��߼۸�������ڵ�����ͼ۸�
			if(Double.parseDouble(maxprice) >= _minPrice){
				_maxPrice = Double.parseDouble(maxprice);
			}
		}
		//����map,���ڴ�Ų�ѯ����
		Map<String,Object> map=new HashMap<>();
		map.put("name", name);
		map.put("category",category);
		map.put("minPrice",_minPrice);
		map.put("maxPrice",_maxPrice);
		//����������ѯ������������Ʒ��Ϣ
		List<Products> products = productsService.prodlist(map);
		model.addAttribute("name",name);
		model.addAttribute("minPrice",_minPrice);
		model.addAttribute("maxPrice",_maxPrice);
		//��ѯ�����¶��ǰ��
		model.addAttribute("products",products);
		//���ص�  /WEB-INF/jsp/prod_list.jsp
		return "prod_list";
	}
	@RequestMapping("/mongodbtest")
	public String mongodbtest(String name,String category,
			String minprice,String maxprice,Model model){
		
		System.out.println("in");
		//������Ʒ�������е���Ʒ���
		List<String> categories = productsService.allcategories();
		model.addAttribute("categories",categories);
		
		//Ϊ������������Ĭ��ֵ�������������Ƿ�Ϸ�
		double _minPrice=0; //Ĭ�ϴ�0�����ֵ
		double _maxPrice = Double.MAX_VALUE;
		Map<String,Object> map=new HashMap<>();
		map.put("name", name);
		map.put("category",category);
		map.put("minPrice",_minPrice);
		map.put("maxPrice",_maxPrice);
		//����������ѯ������������Ʒ��Ϣ
		List<Products> products = productsService.prodlist(map);
		model.addAttribute("name",name);
		model.addAttribute("minPrice",_minPrice);
		model.addAttribute("maxPrice",_maxPrice);
		//��ѯ�����¶��ǰ��
		model.addAttribute("products",products);
		//���ص�  /WEB-INF/jsp/prod_list.jsp
		return "mongodbtest";
	}

}
