package com.aprendendodomain.domain.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id") // especificar o nome da chave estrangeira
     private Client client; // variavel client do tipo Client (associacao para 1)

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items = new ArrayList<>();     // uma order tem varios order item
    public Order(){

    }

    public Order(Long id, Instant moment, OrderStatus status, Client client) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotal(){
        double sum = 0.0;
        for (OrderItem item : items) {
            sum = sum + item.getSubTotal();
            
        }

        return sum;
    }
}
