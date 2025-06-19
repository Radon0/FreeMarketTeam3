package bean;

import java.util.Date;

public class Product {

	// 商品テーブルの情報
	// 商品ID
	private int productId;

	// 出品者のユーザーID
	private int sellerUserId;

	// カテゴリー
	private String category;

	// 出品地域
	private String location;

	// 商品名
	private String productName;

	// 個数
	private int quantity;

	// 価格
	private int price;

	// 備考
	private String remarks;

	// 出品日時
	private Date sellDate;

	// 更新日時
	private Date updateDate;

	// 在庫フラグ
	private int stockFlag;

	// 商品画像テーブルの情報
	// 商品画像ID
	private int imageId;

	// 画像の相対パス
	private String image;

	// 画像説明
	private String description;

	// ユーザーテーブルの情報
	// ニックネーム（商品詳細の表示に必要）
	private String nickName;

	// コンストラクタ
	public Product() {
		this.productId = 0;
		this.sellerUserId = 0;
		this.category = null;
		this.location = null;
		this.productName = null;
		this.quantity = 0;
		this.price = 0;
		this.remarks = null;
		this.sellDate = null;
		this.updateDate = null;
		this.stockFlag = 0;
		this.imageId = 0;
		this.image = null;
		this.description = null;
		this.nickName = null;
	}

	// ゲッターメソッド
	public int getProductId() {
		return productId;
	}

	public int getSellerUserId() {
		return sellerUserId;
	}

	public String getCategory() {
		return category;
	}

	public String getLocation() {
		return location;
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}

	public String getRemarks() {
		return remarks;
	}

	public Date getSellDate() {
		return sellDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public int getStockFlag() {
		return stockFlag;
	}

	public int getImageId() {
		return imageId;
	}

	public String getImage() {
		return image;
	}

	public String getDescription() {
		return description;
	}

	public String getNickName() {
		return nickName;
	}

	// セッターメソッド
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setSellerUserId(int sellerUserId) {
		this.sellerUserId = sellerUserId;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public void setStockFlag(int stockFlag) {
		this.stockFlag = stockFlag;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
