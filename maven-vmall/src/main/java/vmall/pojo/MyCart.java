package vmall.pojo;

public class MyCart {
	private Integer cartID;
	private String id;
	private String name;
	private String imgurl;
	private Double price;
	private Integer num;
	
	
	public MyCart() {
		super();
	}
	
	public MyCart(Integer cartID, String id, String name, String imgurl, Double price, Integer num) {
		super();
		this.cartID = cartID;
		this.id = id;
		this.name = name;
		this.imgurl = imgurl;
		this.price = price;
		this.num = num;
	}

	public Integer getCartID() {
		return cartID;
	}
	public void setCartID(Integer cartID) {
		this.cartID = cartID;
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
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}
