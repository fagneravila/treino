package com.avila.curso.entities.pk;

import com.avila.curso.entities.Order;
import com.avila.curso.entities.Product;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable  // classe de apoi
public class OrdemItemPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrdemItemPK that)) return false;
        return Objects.equals(getOrder(), that.getOrder()) && Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder(), getProduct());
    }
}
