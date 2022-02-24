package vmall.po;

public class pro {
	private String id;
	private String name;
	private String price;
	private String category;
	private String pnum;
	private String imgurl;
	private String description;
	private String soldnum;
	public pro(){}
	public pro(String id, String name, String price, String category, String pnum, String imgurl,
			String description, String soldnum) {
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
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
	public String getSoldnum() {
		return soldnum;
	}
	public void setSoldnum(String soldnum) {
		this.soldnum = soldnum;
	}
	@Override
	public String toString() {
		return "Mongodbpro [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", pnum="
				+ pnum + ", imgurl=" + imgurl + ", description=" + description + ", soldnum=" + soldnum + "]";
	}
	
}
