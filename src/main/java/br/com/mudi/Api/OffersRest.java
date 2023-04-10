package br.com.mudi.Api;

import br.com.mudi.DTO.OfferDTO;
import br.com.mudi.Model.Offer;
import br.com.mudi.Model.Order;
import br.com.mudi.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/offers")
public class OffersRest {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public Offer generateOffer(OfferDTO offerDTO) {
        Optional<Order> order = orderRepository.findById(offerDTO.getOrderId());
        if(order.isEmpty()) {
            return null;
        }

        Offer newOffer = offerDTO.toOffer(offerDTO);
        newOffer.setOrder(order.get());
        order.get().getOffers().add(newOffer);
        orderRepository.save(order.get());

        return newOffer;
    }
}
