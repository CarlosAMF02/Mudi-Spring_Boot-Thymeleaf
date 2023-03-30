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

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public ModelAndView home() {

        List<Order> orders = orderRepository.findAll();

        ModelAndView mv = new ModelAndView("home");

        mv.addObject("orders", orders);

        return mv;
    }

    @GetMapping("/{status}")
    public ModelAndView status(@PathVariable("status") String status) {



        List<Order> orders = orderRepository.findByStatus(Status.valueOf(status.toUpperCase()));

        ModelAndView mv = new ModelAndView("home");

        mv.addObject("orders", orders);
        mv.addObject("status", status);

        return mv;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String onArgumentException() {
        return "redirect:/home";
    }
}
