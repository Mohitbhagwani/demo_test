package com.ecommerce.ecommerce.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "order")
@Data
@TypeDef(name = "json", typeClass = JsonType.class)
public class OrderEntity {


        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long oId;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "created_date", nullable = false, updatable = false)
        private Date createdDate = new Date();

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "modified_date", nullable = false)
        private Date modifiedDate = new Date();

        @Column(name = "product_id")
        private Long productId;

        @Column(name = "product_name")
        private String productName;

        @Column(name = "category")
        private String category;
        @Column(name = " product_colour_variant")
        private String  productColourVariant;

        @Column(name = "buyer_name")
        private String buyerName;
        @Column(name = "customer_id")
        private String customerId;

        @Column(name = "contact_number")
        private Long contactNumber;
        @Column(name = "buyer_address")
        private String buyerAddress;


}
