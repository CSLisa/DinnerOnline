package exmvc.entity.impl;

public class Orders {
    private String id;

    private String usersId;

    private String amount;

    private String quantity;

    private String time;

    private String status1;

    private String status2;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Orders(String id) {
		super();
		this.id = id;
	}


	public Orders(String id, String usersId) {
		super();
		this.id = id;
		this.usersId = usersId;
	}

	public Orders(String id, String usersId, String amount, String quantity, String time, String status1,
			String status2) {
		super();
		this.id = id;
		this.usersId = usersId;
		this.amount = amount;
		this.quantity = quantity;
		this.time = time;
		this.status1 = status1;
		this.status2 = status2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsersId() {
		return usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getStatus2() {
		return status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", usersId=" + usersId + ", amount=" + amount + ", quantity=" + quantity + ", time="
				+ time + ", status1=" + status1 + ", status2=" + status2 + "]";
	}
    
}