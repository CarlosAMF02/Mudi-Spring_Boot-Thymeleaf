package br.com.mudi.Controller;

import br.com.mudi.DTO.OrderDTO;
import br.com.mudi.Model.Order;
import br.com.mudi.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("form")
    public String form() {
        return "order/form";
    }

    @PostMapping("new")
    public String newProduct(OrderDTO orderDTO) {
        Order order = orderDTO.toOrder(orderDTO);
        orderRepository.save(order);

        return "order/form";
    }
}
