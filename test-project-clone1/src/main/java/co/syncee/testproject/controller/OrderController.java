package co.syncee.testproject.controller;
import co.syncee.testproject.model.Customer;
import co.syncee.testproject.model.CustomerOrder;
import co.syncee.testproject.model.OrderResponse;
import co.syncee.testproject.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path="api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired //for dependency injection purposes
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Customer> getOrders()
    {
        return orderService.getOrders();
    }

    @GetMapping(path = "/{productName}")
    public List<Customer> getOrdersByProductName(@PathVariable String productName)
    {
        return orderService.getOrdersByProductName(productName);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public OrderResponse addCustomerOrder(@RequestBody List<CustomerOrder> customerOrder){;
        return orderService.addNewOrder(new Customer(customerOrder));
    }

    @PutMapping(path="/{id}")
    public void updateOrder(@PathVariable("id") Long id,
                            @RequestBody List<CustomerOrder> customerOrder){
        orderService.updateOrder(id, customerOrder);
    }

    @DeleteMapping(path="/{id}")
    public void deleteOrder(@PathVariable Long id)
    {
        orderService.deleteOrderById(id);
    }
}
