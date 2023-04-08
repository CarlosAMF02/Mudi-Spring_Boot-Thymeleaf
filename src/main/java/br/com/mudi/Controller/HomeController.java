package br.com.mudi.Controller;

import br.com.mudi.Model.Order;
import br.com.mudi.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public ModelAndView home(Principal principal) {

        List<Order> orders = orderRepository.findAllByUser(principal.getName());

        ModelAndView mv = new ModelAndView("user/order");

        mv.addObject("orders", orders);

        return mv;
    }
}
