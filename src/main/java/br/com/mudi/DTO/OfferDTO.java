package br.com.mudi.DTO;

import br.com.mudi.Model.Offer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OfferDTO {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Long orderId;
    @NotNull(message = "O campo de valor é obrigatório")
    @Pattern(regexp = "^\\d+(\\.\\d{2})?$", message = "O campo de valor deve estar no formato 0.00")
    private String value;
    @NotNull(message = "O campo de data de entrega é obrigatório")
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}", message = "O formato da data de entrega deve ser dd/MM/aaaa")
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
