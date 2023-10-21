package com.lastexam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String item;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "personId")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "place_for_orders_id")
    private Place place;

    private String personName;
    private String personInfo;

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", price=" + price +
                ", personInfo='" + personInfo + '\'' +
                '}';
    }


}
