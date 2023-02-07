package bean;

public class ProductBean 
{
	private int product_id;
	private String productName;
	private String productQty;
	private String productPrice;
	private String imgurl;
	
	public ProductBean(int product_id,String productName,String productQty,String productPrice,String imgurl) 
	{
		this.product_id = product_id;
		this.productName=productName;
		this.productPrice=productPrice;
		this.productQty=productQty;
		this.imgurl=imgurl;
	}
	
	public ProductBean(String productName,String productQty,String productPrice,String imgurl) 
	{
		this.productName=productName;
		this.productPrice=productPrice;
		this.productQty=productQty;
		this.imgurl=imgurl;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductQty() {
		return productQty;
	}

	public void setProductQty(String productQty) {
		this.productQty = productQty;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
}
