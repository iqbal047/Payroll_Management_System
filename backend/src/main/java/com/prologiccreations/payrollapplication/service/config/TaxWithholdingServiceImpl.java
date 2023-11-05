package com.prologiccreations.payrollapplication.service.config;

import com.prologiccreations.payrollapplication.dao.config.TaxWithholdingRepository;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.TaxWithholding;
import com.prologiccreations.payrollapplication.service.super_classes.config.TaxWithholdingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.prologiccreations.payrollapplication.PayrollApplication.getCurrentUsername;
import static com.prologiccreations.payrollapplication.constants.enums.OperationStatus.FAILURE;
import static com.prologiccreations.payrollapplication.constants.enums.OperationStatus.SUCCESS;

@Service
@RequiredArgsConstructor
public class TaxWithholdingServiceImpl implements TaxWithholdingService {

    private final TaxWithholdingRepository repository;

    @Override
    public Response storeData(TaxWithholding data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            repository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<TaxWithholding>> getAll(Pageable pageable) {
        Page<TaxWithholding> page = repository.findByActive(true, pageable);
        return new Response<>(SUCCESS, null, page);
    }

    @Override
    public Response<TaxWithholding> getById(Long id) {
        TaxWithholding taxWithholding = repository.findById(id).orElse(new TaxWithholding());
        return new Response<>(SUCCESS, null, taxWithholding);
    }

    @Override
    public Response delete(Long id) {
        repository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(TaxWithholding data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(TaxWithholding data) {
//        boolean taxWithholdingnameExists;
//        if (data.hasId()) {
//            taxWithholdingnameExists = repository.existsByTaxWithholdingname(data.getTaxWithholdingname(), data.getId());
//        } else {
//            taxWithholdingnameExists = repository.existsByTaxWithholdingname(data.getTaxWithholdingname());
//        }
//        return taxWithholdingnameExists ? "Failed to register. TaxWithholding already exists" : null;
        return null;
    }

}
