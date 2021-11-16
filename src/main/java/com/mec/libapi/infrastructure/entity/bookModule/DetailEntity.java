package com.mec.libapi.infrastructure.entity.bookModule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "details")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // new, used
    private String condition;
    private String buyType;

    // library provider
    private String provider;
    private String deliverySlip;

}
