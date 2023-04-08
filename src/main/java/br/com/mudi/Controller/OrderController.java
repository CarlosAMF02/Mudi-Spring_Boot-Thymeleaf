package br.com.mudi.Controller;

import br.com.mudi.DTO.OrderDTO;
import br.com.mudi.Model.Order;
import br.com.mudi.Model.User;
import br.com.mudi.Repository.OrderRepository;
import br.com.mudi.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("form")
    public String form(OrderDTO orderDTO) {
        return "order/form";
    }

    @PostMapping("new")
    public String newProduct(@Valid OrderDTO newOrder, BindingResult result) {
        if(result.hasErrors()) {
            return "order/form";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Order order = newOrder.toOrder(newOrder);

        User currentUser = userRepository.findByUsername(username);

        order.setUser(currentUser);

        orderRepository.save(order);

        return "redirect:/home";
    }
}
