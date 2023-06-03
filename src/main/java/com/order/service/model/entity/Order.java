package com.order.service.model.entity;


import com.order.service.model.dto.PaymentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="order_id")
    private String orderId;
    private String country;
    private String total;
    private String shipping;
    private String tax;
    private String status;
    @Column(name="client_id")
    private Long clientId;
    @Column(name="create_at")
    private Date createAt;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="order_id")
    private List<DetailOrder>details;
    @Transient
    private List<PaymentDto>payments;
}
