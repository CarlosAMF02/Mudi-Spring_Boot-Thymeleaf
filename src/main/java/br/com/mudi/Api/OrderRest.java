package br.com.mudi.Api;

import br.com.mudi.Model.Order;
import br.com.mudi.Model.Status;
import br.com.mudi.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderRest {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping()
    public List<Order> getOrders() {

        Sort sort = Sort.by("deliveryDate").descending();
        PageRequest pageable = PageRequest.of(0, 10, sort);

        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    @GetMapping("{status}")
    public List<Order> getWaitingOrders(@PathVariable String status) {

        Sort sort = Sort.by("deliveryDate").descending();
        PageRequest pageable = PageRequest.of(0, 10, sort);
        List<Order> orders = new ArrayList<Order>();
        try {
            orders = orderRepository.findByStatus(Status.valueOf(status.toUpperCase()), pageable);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

}
