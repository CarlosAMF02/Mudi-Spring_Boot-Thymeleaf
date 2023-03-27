package br.com.mudi.Controller;

import br.com.mudi.Model.Order;
import br.com.mudi.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/home")
    public ModelAndView home() {

        List<Order> orders = orderRepository.findAll();

        ModelAndView mv = new ModelAndView("home");

        mv.addObject("orders", orders);

        return mv;
    }
}
