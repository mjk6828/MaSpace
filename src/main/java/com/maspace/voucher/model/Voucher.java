package com.maspace.voucher.model;

import com.maspace.postgres.BaseTimeEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Voucher")
public class Voucher extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String v_number;
    private String v_name;
    private String v_use_yn;
}
