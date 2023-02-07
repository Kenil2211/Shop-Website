package bean;

public class OrderHistoryBean 
{
	//orderdate , orderid , product name , qty , price ,total
	
	private String orderdate;
	private int oid;
	private String pname;
	private String qty;
	private String price;
	private String total;
	
	public OrderHistoryBean(String orderdate, int oid, String pname, String qty, String price, String total) {
		this.orderdate = orderdate;
		this.oid = oid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.total = total;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
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
