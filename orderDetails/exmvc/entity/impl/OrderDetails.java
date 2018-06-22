package exmvc.entity.impl;

public class OrderDetails {
    private String id;

    private String name;

    private String subtotal;

    private String quantity;

    private String price;

    private String status;
    

    public OrderDetails() {
		super();
	}
    
	public OrderDetails(String id) {
		super();
		this.id = id;
	}

	public OrderDetails(String id, String name, String subtotal, String quantity, String price, String status) {
		super();
		this.id = id;
		this.name = name;
		this.subtotal = subtotal;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal == null ? null : subtotal.trim();
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity == null ? null : quantity.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", name=" + name + ", subtotal=" + subtotal + ", quantity=" + quantity
				+ ", price=" + price + ", status=" + status + "]";
	}
    
}