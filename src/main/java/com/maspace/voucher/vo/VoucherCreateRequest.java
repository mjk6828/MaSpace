package com.maspace.voucher.vo;

import lombok.Data;

@Data
public class VoucherCreateRequest {
    private String v_number;
    private String v_name;
    private String v_use_yn;
}
