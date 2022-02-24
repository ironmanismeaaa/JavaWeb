package vmall.po;

public class Cart {
	private Integer cartID;
	private Integer uid;
	private String id;
	private Integer num;
	public Cart() {
		super();
	}
	public Cart(Integer uid, String id, Integer num) {
		super();
		this.uid = uid;
		this.id = id;
		this.num = num;
	}
	public Integer getCartID() {
		return cartID;
	}
	public void setCartID(Integer cartID) {
		this.cartID = cartID;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

	
	
}
