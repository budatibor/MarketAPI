package co.syncee.testproject.services;
import co.syncee.testproject.model.Customer;
import co.syncee.testproject.model.CustomerOrder;
import co.syncee.testproject.model.OrderResponse;
import co.syncee.testproject.model.Product;
import co.syncee.testproject.repository.CustomerOrderRepository;
import co.syncee.testproject.repository.CustomerRepository;
import co.syncee.testproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

//@Component inject dependency in the API method.. or:
@Service
public class OrderService
{
    private final ProductRepository productRepository;
    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderService(ProductRepository productRepository, CustomerOrderRepository costumerOrderRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerOrderRepository = costumerOrderRepository;
        this.customerRepository = customerRepository;
    }

    public List<Customer> getOrders()
    {
        return customerRepository.findAll();
    }

    public OrderResponse addNewOrder(Customer customer)
    {

        for (CustomerOrder co: customer.getCustomerOrder()) {
            List<String> productNames = productRepository.findAll().stream().map(Product::getName).toList();
            if(productNames.contains(co.getName()))
                break;
            else
                throw new IllegalArgumentException("Theres no such product as " +co.getName());
        }
        customerRepository.save(customer);
        //customerOrderRepository.saveAll(customer.getCustomerOrder());
        OrderResponse orderResponse = new OrderResponse();


        for (CustomerOrder co: customer.getCustomerOrder()) {
            orderResponse.setDescription(orderResponse.getDescription() + " " +co.getName());
            Optional<Product> product = productRepository.findProductByName(co.getName());
            orderResponse.setPrice(orderResponse.getPrice() + product.get().getPrice()*co.getQuantity());

        }
        return orderResponse;
    }

    public void deleteOrderById(Long id) {
        if(customerRepository.existsById(id))
            customerRepository.deleteById(id);

    }

    public List<Customer> getOrdersByProductName(String productName) {
        List<Customer> customers = customerRepository.findAll();
        List<Customer> returnList = new ArrayList<Customer>();
        boolean hasProduct;
        if(customers.isEmpty())
        {
            return customers;
        }
        else
        {
            for (Customer c: customers) {
                hasProduct = false;
                for (CustomerOrder co: c.getCustomerOrder()) {
                    if (Objects.equals(productName, co.getName())) {
                        hasProduct = true;
                        break;
                    }

                }
                if(hasProduct)
                    returnList.add(c);
            }
            return returnList;
        }

    }

    @Transactional
    public void updateOrder(Long id, List<CustomerOrder> customerOrder) {
        if (customerRepository.existsById(id)) {
            customerOrderRepository.deleteAll(customerRepository.findById(id).get().getCustomerOrder());
            customerRepository.findById(id).get().setCustomerOrder(customerOrder);

        }

    }
}
