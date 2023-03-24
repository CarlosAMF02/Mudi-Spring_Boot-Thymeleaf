package br.com.mudi.Controller;

import br.com.mudi.Model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        Order order = new Order();
        order.setDealValue(new BigDecimal(2500));
        order.setDescription("Bicicletas Trek");
        order.setProductName("Bicicleta");
        order.setDeliveryDate(LocalDate.now().plusDays(15));
        order.setProductUrl("https://www.amazon.com.br/Bicicleta-SPACELINE-C%C3%A2mbio-Shimano-Preto-Cinza/dp/B091B1GXRB/ref=asc_df_B091B1GXRB/?tag=googleshopp00-20&linkCode=df0&hvadid=395139869934&hvpos=&hvnetw=g&hvrand=5815051066708411831&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1001773&hvtargid=pla-1231866162185&psc=1");
        order.setImageUrl("https://trek.scene7.com/is/image/TrekBicycleProducts/Marlin8_21_34649_A_Primary?$responsive-pjpg$&cache=on,on&wid=800&hei=600");

        List<Order> orders = Arrays.asList(order, order, order);

        model.addAttribute("orders", orders);

        return "home";
    }
}
