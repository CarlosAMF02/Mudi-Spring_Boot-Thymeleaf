package br.com.mudi.DTO;

import br.com.mudi.Model.Order;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class OrderDTO {
    @NotBlank(message = "O campo url do produto é obrigatório!")
    @Size(min = 2, max = 50, message = "O campo deve conter entre 2 e 50 caracteres!")
    private String productName;
    @NotBlank(message = "O campo url do produto é obrigatório!")
    private String productUrl;
    @NotBlank(message = "O campo url da imagem do produto é obrigatório!")
    private String imageUrl;
    private String description;

    public Order toOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setProductName(orderDTO.getProductName());
        order.setImageUrl(orderDTO.getImageUrl());
        order.setProductUrl(orderDTO.getProductUrl());
        order.setDescription(orderDTO.getDescription());

        return order;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
