package vmall.po;

public class Products {
	private String id;
	private String name;
	private Double price;
	private String category;
	private Integer pnum;
	private String imgurl;
	private String description;
	private Integer soldnum;
	public Products(){}
	public Products(String id, String name, Double price, String category, Integer pnum, String imgurl,
			String description, Integer soldnum) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.pnum = pnum;
		this.imgurl = imgurl;
		this.description = description;
		this.soldnum = soldnum;
	}
	public Integer getSoldnum() {
		return soldnum;
	}
	public void setSoldnum(Integer soldnum) {
		this.soldnum = soldnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", pnum="
				+ pnum + ", imgurl=" + imgurl + ", description=" + description + "]";
	}
	
	
}
