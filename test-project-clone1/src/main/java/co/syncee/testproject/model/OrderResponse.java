package co.syncee.testproject.model;

public class OrderResponse {

    private String description;
    private int price;

    public OrderResponse()
    {
        this.description = "";
        this.price = 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
