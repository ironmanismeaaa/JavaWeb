package vmall.pojo;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class MyProducts {
//	@NotBlank(message="��Ʒ���Ʋ���Ϊ��")
	private String name;
//	@NotBlank(message="��Ʒ�۸���Ϊ��")
	private Double price;
	private String category;
	private Integer pnum;
	private MultipartFile imgurl;		
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPnum() {
		return pnum;
	}
	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}
	public MultipartFile getImgurl() {
		return imgurl;
	}
	public void setImgurl(MultipartFile imgurl) {
		this.imgurl = imgurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
