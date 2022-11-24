package chapter06.model;

import java.math.BigDecimal;

public class OrderLine {
    private Long id;
    private OrderLineType type;
    private long productId;
    private int quantity;
    private BigDecimal amount;

    public enum OrderLineType {
        PURCHASE,
        DISCOUNT
    }

    public OrderLine setId(Long id) {
        this.id = id;
        return this;
    }

    public OrderLine setType(OrderLineType type) {
        this.type = type;
        return this;
    }

    public OrderLine setProductId(long productId) {
        this.productId = productId;
        return this;
    }

    public OrderLine setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderLine setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OrderLineType getType() {
        return type;
    }

    public long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
