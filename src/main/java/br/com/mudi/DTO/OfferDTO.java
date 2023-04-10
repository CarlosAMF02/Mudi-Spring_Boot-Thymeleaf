package br.com.mudi.DTO;

import br.com.mudi.Model.Offer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OfferDTO {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long orderId;
    private String value;
    private String deliveryDate;
    private String comment;

    public Offer toOffer(OfferDTO offerDTO) {
        Offer offer = new Offer();
        offer.setComment(offerDTO.comment);
        offer.setDeliveryDate(LocalDate.parse(offerDTO.deliveryDate, formatter));
        offer.setValue(new BigDecimal(this.value));

        return offer;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
