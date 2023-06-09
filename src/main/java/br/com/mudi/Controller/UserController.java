package br.com.mudi.Controller;

import br.com.mudi.Model.Order;
import br.com.mudi.Model.Status;
import br.com.mudi.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("order")
    public ModelAndView home(Principal principal) {

        List<Order> orders = orderRepository.findAllByUser(principal.getName());

        ModelAndView mv = new ModelAndView("user/home");

        mv.addObject("orders", orders);

        return mv;
    }

    @GetMapping("order/{status}")
    public ModelAndView status(@PathVariable("status") String status, Principal principal) {



        List<Order> orders = orderRepository.findAllByUserAndStatus(principal.getName(), Status.valueOf(status.toUpperCase()));

        ModelAndView mv = new ModelAndView("user/home");

        mv.addObject("orders", orders);
        mv.addObject("status", status);

        return mv;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String onArgumentException() {
        return "forward:/user/home";
    }
}
