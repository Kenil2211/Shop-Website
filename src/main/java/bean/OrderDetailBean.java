package bean;

public class OrderDetailBean 
{
	private String orderDetailid;
	private String oid;
	private String uid;
	private String pid;
	private String pname;
	private String pqty;
	private String price;
	private String total;
	
	public OrderDetailBean(String oid, String uid, String pid, String pname, String pqty,
			String price, String total) {
		
		this.oid = oid;
		this.uid = uid;
		this.pid = pid;
		this.pname = pname;
		this.pqty = pqty;
		this.price = price;
		this.total = total;
	}

	public String getOrderDetailid() {
		return orderDetailid;
	}

	public void setOrderDetailid(String orderDetailid) {
		this.orderDetailid = orderDetailid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPqty() {
		return pqty;
	}

	public void setPqty(String pqty) {
		this.pqty = pqty;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	
		
}
