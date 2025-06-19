package bean;

public class Mail {
	private int mailId; //取引メールID
	private int productId; //商品ID
	private int planBuyUserId; //購入予定者ユーザーID
	private String message; //本文
	private String sendDate; //送信日時
	private int sendFlag; //送信フラグ(0.出品者送信、1.購入予定者送信)
	private int readFlag; //既読フラグ(0.未読,1.既読)
	private int deleteFlag; //削除フラグ(0.通常,1.削除済)

	// アクセサメソッド
	public int getMailId() {
		return mailId;
	}

	public void setMailId(int mailId) {
		this.mailId = mailId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getPlanBuyUserId() {
		return planBuyUserId;
	}

	public void setPlanBuyUserId(int planBuyUserId) {
		this.planBuyUserId = planBuyUserId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	
	public int getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(int sendFlag) {
		this.sendFlag = sendFlag;
	}

	public int getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(int readFlag) {
		this.readFlag = readFlag;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
