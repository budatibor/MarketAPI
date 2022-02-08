package co.syncee.testproject.model;

import javax.persistence.*;

@Entity
@Table
public class CustomerOrder {
    @Id
    @SequenceGenerator(
            name ="customer_order_sequence",
            sequenceName ="customer_order_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
            generator = "customer_order_sequence"
    )
    private long id;
    private String name;
    private int quantity;


    public CustomerOrder(long id, long orderId, String product, int quantity) {

        this.id = id;
        this.name = product;
        this.quantity = quantity;
    }

    public CustomerOrder(long orderId, String product, int quantity) {
        this.id = orderId;
        this.name = product;
        this.quantity = quantity;
    }
    public CustomerOrder(String product, int quantity) {
        this.name = product;
        this.quantity = quantity;
    }

    public CustomerOrder() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
