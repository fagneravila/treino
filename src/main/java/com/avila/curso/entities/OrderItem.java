package com.avila.curso.entities;

import com.avila.curso.entities.pk.OrdemItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    //ID COMPOSTO
    @EmbeddedId
    private OrdemItemPK id = new OrdemItemPK();

    private Integer qantity;

    private Double price;

    public OrderItem( ){
    }

    public OrderItem(Order order, Product product, Integer qantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.qantity = qantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
       id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQantity() {
        return qantity;
    }

    public void setQantity(Integer qantity) {
        this.qantity = qantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem ordemItem)) return false;
        return Objects.equals(id, ordemItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
