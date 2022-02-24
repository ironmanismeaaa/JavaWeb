package vmall.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vmall.dao.ProductsDao;
import vmall.po.Products;
import vmall.pojo.MyProducts;

@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductsDao productsDao;

	@Override
	public List<String> allcategories() {
		return productsDao.allcategories();
	}

	@Override
	public List<Products> prodlist(Map<String, Object> map) {
		return productsDao.prodlist(map);
	}

	@Override
	public Products oneProduct(String pid) {
		return productsDao.oneProduct(pid);
	}

	@Override
	public List<Products> prodclass(String prodclass) {
		return productsDao.prodclass(prodclass);
	}
	@Override
	public String save(MyProducts myproducts, HttpServletRequest request) {
		// 1.�жϺ�׺�Ƿ�Ϸ�
		// ��ȡͼ���ƣ���׺����
		String originName = myproducts.getImgurl().getOriginalFilename();
			
		// ��ȡ��׺substring split (".png" ".jgp")
		String extName = originName.substring(originName.lastIndexOf("."));

		if (!(extName.equalsIgnoreCase(".jpg") || extName.equalsIgnoreCase(".png")
						|| extName.equalsIgnoreCase(".gif"))) {// ͼƬ��׺���Ϸ�
			return "ͼƬ��׺���Ϸ�!";
		}
		// �ж�ľ��(java�����ж��Ƿ���ͼƬ���ԣ�Ҳ�������������jar���ж�)
		try {
			BufferedImage bufImage = ImageIO.read(myproducts.getImgurl().getInputStream());
			bufImage.getHeight();
			bufImage.getWidth();
		} catch (Exception e) {
			return "���ļ�����ͼƬ��";
		}
		// 2.����upload��ʼ��һ��·��
		// ���ɶ༶·��
		String imgurl = "";
		// /a/2/e/a/2/3/j/p
		for (int i = 0; i < 8; i++) {
			imgurl += "/" + Integer.toHexString(new Random().nextInt(16));
		}
		String realpath = request.getServletContext().getRealPath("/WEB-INF");
		realpath += "/upload";
		// D:\java\Workspace\.metadata\.plugins\org.eclipse.wst.server.core
		// \tmp0\wtpwebapps\EasyMall18\WEB-INF/upload/2/6/2/7/2/d/2/1
		
		File file = new File(realpath + imgurl, originName);
		if (!file.exists()) {
			file.mkdirs();
		}
		// �ϴ��ļ�
		try {
			myproducts.getImgurl().transferTo(file);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// ƴ��ͼƬ�������ݿ��·��
		System.out.println(imgurl+"-------");
		imgurl = "/upload" + imgurl + "/" + originName;
		System.out.println(imgurl);
		String id = UUID.randomUUID().toString();
		Products products = new Products();
		products.setId(id);
		products.setName(myproducts.getName());
		products.setCategory(myproducts.getCategory());
		products.setPrice(myproducts.getPrice());
		products.setPnum(myproducts.getPnum());
		products.setImgurl(imgurl);
		products.setDescription(myproducts.getDescription());
		if (productsDao.findByImgurl(products.getImgurl()) == null) {
			productsDao.save(products);		
		}else{
			String fname = imgurl.substring(0,imgurl.lastIndexOf("."));
			imgurl=fname+System.currentTimeMillis()+extName;
			System.out.println(imgurl);
			products.setImgurl(imgurl);
			System.out.println(products.getImgurl());
			productsDao.save(products);	
		}
		return "��Ʒ��ӳɹ�";
	}
	@Override
	public List<Products> allprods() {
		
		return productsDao.allprods();
	}

	@Override
	public void updateSaleStatus(Map<String, Object> map) {
		productsDao.updateSaleStatus(map);
		
	} 


}
