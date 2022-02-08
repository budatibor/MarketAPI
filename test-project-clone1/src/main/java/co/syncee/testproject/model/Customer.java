package co.syncee.testproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name ="customer_sequence",
            sequenceName ="customer_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private long id;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "customerId",
            referencedColumnName = "id"
    )
    private List<CustomerOrder> customerOrder;

    public Customer(List<CustomerOrder> customerOrder){
        this.customerOrder = customerOrder;
    }

    public Customer() {

    }

    public long getId() {
        return id;
    }

    public List<CustomerOrder> getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(List<CustomerOrder> customerOrder)
    {
        this.customerOrder = customerOrder;
    }
}
