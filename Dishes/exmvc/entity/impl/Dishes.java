package exmvc.entity.impl;
//Dishes表的实体
public class Dishes {
	private String id;        //编号
	private String name;      //菜品名称
	private String type;      //类型（2套餐/1零售）
	private String describe;  //描述
	private String price;     //价格
	private String salesPrice;//促销价格
	private String VIPPrice;  //VIP价格
	private String remark;    //备注
	private String image;     //图片地址(多张图片以;号结尾)
	public Dishes() {
		super();
	}
	public Dishes(String id) {
		super();
		this.id = id;
	}
	public Dishes(String id, String name, String type, String describe,
			String price, String salesPrice, String vIPPrice, String remark,
			String image) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.describe = describe;
		this.price = price;
		this.salesPrice = salesPrice;
		this.VIPPrice = vIPPrice;
		this.remark = remark;
		this.image = image;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(String salesPrice) {
		this.salesPrice = salesPrice;
	}
	public String getVIPPrice() {
		return VIPPrice;
	}
	public void setVIPPrice(String vIPPrice) {
		this.VIPPrice = vIPPrice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Dishes [id=" + id + ", name=" + name + ", type=" + type
				+ ", describe=" + describe + ", price=" + price
				+ ", salesPrice=" + salesPrice + ", VIPPrice=" + VIPPrice
				+ ", remark=" + remark + ", image=" + image + "]";
	}
	
	
}
