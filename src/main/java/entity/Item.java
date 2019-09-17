package entity;

public class Item {
    private int id;
    private int userId;
    private String name;
    private String category;
    private float price;
    private int stock;
    private String description;
    
    /*public Items(String id, String userId, String name, String category, float price, int stock, String description) {
    	this.id = id;
    	this.userId = userId;
    	this.name = name;
    	this.category = category;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }*/
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getUserId() {
    	return userId;
    }
    
    public void setUserId(int userId) {
    	this.userId = userId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
