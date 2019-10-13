package dto;

public class SellerOrientedItem {
    private int id;
    private int sellerId;
    private String sellerName;
    private String name;
    private float price;
    private int stock;
    private String description;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getSellerId() {
    	return sellerId;
    }
    
    public void setSellerId(int sellerId) {
    	this.sellerId = sellerId;
    }
    
    public String getSellerName() {
    	return sellerName;
    }
    
    public void setSellerName(String sellerName) {
    	this.sellerName = sellerName;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
