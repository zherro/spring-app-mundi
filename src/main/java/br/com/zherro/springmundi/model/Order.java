package br.com.zherro.springmundi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "tb_order")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String productName;
    private BigDecimal negotiatedValue;
    private LocalDate deliveryDate;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="default 'WAITING'" )
    private OrderStatus status;

    @Column(columnDefinition = "TEXT")
    private String productUri;

    @Column(columnDefinition = "TEXT")
    private String productImage;

    @Column(columnDefinition = "TEXT")
    private String description;
}
