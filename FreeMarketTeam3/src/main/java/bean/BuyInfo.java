package bean;

public class BuyInfo {
	
	//購入ID
	private int orderId;
	
	//商品ID
	private int productId;
	
	//購入者のユーザーID
	private int buyerUserId;
	
	//出品者のユーザーID
	private int sellerUserId;
	
	//購入数
	private int orderQuantity;
	
	//購入状況
	//未購入の場合：0　購入済の場合：1
	private int orderStatus;
	
	//購入日時
	private String orderedDate;
	
	//発送フラグ
	//未発送の場合：0　発送済の場合：1
	private int shippingFlag;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getBuyerUserId() {
		return buyerUserId;
	}

	public void setBuyerUserId(int buyerUserId) {
		this.buyerUserId = buyerUserId;
	}

	public int getSellerUserId() {
		return sellerUserId;
	}

	public void setSellerUserId(int sellerUserId) {
		this.sellerUserId = sellerUserId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(String orderedDate) {
		this.orderedDate = orderedDate;
	}

	public int getShippingFlag() {
		return shippingFlag;
	}

	public void setShippingFlag(int shippingFlag) {
		this.shippingFlag = shippingFlag;
	}
	
	
	
	
}
