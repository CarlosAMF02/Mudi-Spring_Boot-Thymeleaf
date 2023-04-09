package br.com.mudi.Controller;

import br.com.mudi.Model.Order;
import br.com.mudi.Model.Status;
import br.com.mudi.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

        Sort sort = Sort.by("deliveryDate").descending();

        PageRequest pageable = PageRequest.of(0, 10, sort);

        List<Order> orders = orderRepository.findByStatus(Status.ENTREGUE, pageable);

        ModelAndView mv = new ModelAndView("home");

        mv.addObject("orders", orders);

        return mv;
    }
}
