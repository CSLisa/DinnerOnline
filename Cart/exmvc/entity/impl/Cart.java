package exmvc.entity.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable{
    /**
	 * 购物车
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String name;

    private String originalPrice; //原价

    private String quantity;    //数量

    private String price;   //单价
    
    private List<Dishes> items=new ArrayList<Dishes>();
    
  
	public List<Dishes> getItems() {
		return items;
	}

	public void setItems(List<Dishes> items) {
		this.items = items;
	}

	public Cart() {
		super();
	}

	public Cart(String id) {
		super();
		this.id = id;
	}

	public Cart(String id, String name, String originalPrice, String quantity, String price) {
		super();
		this.id = id;
		this.name = name;
		this.originalPrice = originalPrice;
		this.quantity = quantity;
		this.price = price;
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

	public String getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", name=" + name + ", originalPrice=" + originalPrice + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
    

    
}