package bean;

public class CartBean 
{
	private String cid;
	private String uid;
	private String pid;
	private String pname;
	private String price;
	private String qty;
	
	public CartBean(String uid,String pid,String pname,String price,String qty)
	{
		this.uid=uid;
		this.pid=pid;
		this.pname=pname;
		this.price=price;
		this.qty=qty;
	}
	public CartBean(String cid,String uid,String pid,String pname,String price,String qty)
	{
		this.cid=cid;
		this.uid=uid;
		this.pid=pid;
		this.pname=pname;
		this.price=price;
		this.qty=qty;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}

	
}
