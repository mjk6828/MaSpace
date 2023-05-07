package com.maspace.voucher;

import com.maspace.voucher.service.VoucherService;
import com.maspace.voucher.vo.VoucherCreateRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @GetMapping("/voucher/list")
    @ApiOperation(value = "할인권 목록조회", notes = "할인권 목록조회 API")
    public Object vouchers() {
        return voucherService.voucherList();
    }

    @PostMapping("/voucher")
    @ApiOperation(value = "할인권 등록", notes = "할인권 등록 API")
    public Object createVoucher(@RequestBody VoucherCreateRequest request) {
        return voucherService.createVoucher(request);
    }
}
