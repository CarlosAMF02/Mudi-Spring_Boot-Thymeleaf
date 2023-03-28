package br.com.mudi.DTO;

import br.com.mudi.Model.Order;

public class OrderDTO {

    private String productName;
    private String productUrl;
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
