package com.danielairinei.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue
    private int id;
    private String status;
    private int price;
    private int productId;
    private String userEmail;
    private String phoneNumber;
}
