package com.maspace.voucher.service;

import com.maspace.voucher.model.Voucher;
import com.maspace.voucher.repository.VoucherRepository;
import com.maspace.voucher.vo.VoucherCreateRequest;
import com.maspace.voucher.vo.VoucherDeleteRequest;
import com.maspace.voucher.vo.VoucherUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public Voucher updateVoucher(VoucherUpdateRequest request) {
        Voucher voucher = voucherRepository.findById(request.getId()).get();
        voucher.setV_name(request.getV_name());
        voucher.setV_use_yn(request.getV_use_yn());
        voucher.setV_number(request.getV_number());
        return voucher;
    }

    public List<Voucher> deleteVoucher(VoucherDeleteRequest request) {
        voucherRepository.deleteById(request.getId());
        return voucherRepository.findAll();
    }
}
