package kitchenpos.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Table(name = "orders")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "order_type")
public abstract class Order {
    @Column(name = "id", columnDefinition = "binary(16)")
    @Id
    private UUID id;

    @Column(name = "type", nullable = false, columnDefinition = "varchar(255)")
    @Enumerated(EnumType.STRING)
    private OrderType type;

    @Column(name = "status", nullable = false, columnDefinition = "varchar(255)")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "order_date_time", nullable = false)
    private LocalDateTime orderDateTime;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
        name = "order_id",
        nullable = false,
        columnDefinition = "binary(16)",
        foreignKey = @ForeignKey(name = "fk_order_line_item_to_orders")
    )
    private List<OrderLineItem> orderLineItems;

    @ManyToOne
    @JoinColumn(name = "order_table_id", columnDefinition = "binary(16)", foreignKey = @ForeignKey(name = "fk_orders_to_order_table"))
    private OrderTable orderTable;

    @Transient
    private UUID orderTableId;

    protected Order() {
    }

    protected Order(OrderType type) {
        this.type = type;
    }

    protected Order(OrderType type, OrderStatus status, List<OrderLineItem> orderLineItems) {
        this(UUID.randomUUID(), type, status, LocalDateTime.now(), orderLineItems, null);
    }

    protected Order(OrderType type, OrderStatus status, List<OrderLineItem> orderLineItems, OrderTable orderTable) {
        this(UUID.randomUUID(), type, status, LocalDateTime.now(), orderLineItems, orderTable);
    }

    protected Order(OrderType type, OrderStatus status, LocalDateTime orderDateTime, List<OrderLineItem> orderLineItems, OrderTable orderTable) {
        this(UUID.randomUUID(), type, status, orderDateTime, orderLineItems, orderTable);
    }

    protected Order(UUID id, OrderType type, OrderStatus status, LocalDateTime orderDateTime, List<OrderLineItem> orderLineItems, OrderTable orderTable) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.orderDateTime = orderDateTime;
        this.orderLineItems = orderLineItems;
        this.orderTable = orderTable;
        this.orderTableId = extractOrderTableId(orderTable);
    }

    private static UUID extractOrderTableId(OrderTable orderTable) {
        return Objects.isNull(orderTable) ? null : orderTable.getId();
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(final OrderType type) {
        this.type = type;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(final OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(final LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public List<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(final List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }


    public OrderTable getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(OrderTable orderTable) {
        this.orderTable = orderTable;
        this.orderTableId = orderTable.getId();
    }

    public UUID getOrderTableId() {
        return orderTableId;
    }

    public void setOrderTableId(UUID orderTableId) {
        this.orderTableId = orderTableId;
    }
}
