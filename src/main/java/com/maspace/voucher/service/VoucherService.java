package com.maspace.voucher.service;

import com.maspace.voucher.model.Voucher;
import com.maspace.voucher.repository.VoucherRepository;
import com.maspace.voucher.vo.VoucherCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoucherService {
    private final VoucherRepository voucherRepository;

    public List<Voucher> voucherList() {
        return voucherRepository.findAll();
    }

    public Voucher createVoucher(VoucherCreateRequest request) {
        Voucher voucher = new Voucher();
        BeanUtils.copyProperties(request, voucher);
        return voucherRepository.save(voucher);
    }
}
