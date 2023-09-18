package com.maspace.voucher;

import com.maspace.voucher.model.Voucher;
import com.maspace.voucher.service.VoucherService;
import com.maspace.voucher.vo.VoucherCreateRequest;
import com.maspace.voucher.vo.VoucherDeleteRequest;
import com.maspace.voucher.vo.VoucherUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @GetMapping("/voucher/list")
    @Operation(summary = "할인권 목록조회", description = "할인권 목록조회 API")
    public List<Voucher> vouchers() {
        return voucherService.voucherList();
    }

    @PostMapping("/voucher")
    @Operation(summary = "할인권 등록", description = "할인권 등록 API")
    public Voucher createVoucher(@RequestBody VoucherCreateRequest request) {
        return voucherService.createVoucher(request);
    }

    @PutMapping("/voucher")
    @Operation(summary = "할인권 수정", description = "할인권 수정 API")
    public Voucher updateVoucher(@RequestBody VoucherUpdateRequest request) {
        return voucherService.updateVoucher(request);
    }

    @DeleteMapping("/voucher")
    @Operation(summary = "할인권 삭제", description = "할인권 삭제 API")
    public List<Voucher> deleteVoucher(@RequestBody VoucherDeleteRequest request) {
        return voucherService.deleteVoucher(request);
    }
}
