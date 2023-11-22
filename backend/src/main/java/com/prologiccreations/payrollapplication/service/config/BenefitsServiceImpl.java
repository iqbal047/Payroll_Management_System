package com.prologiccreations.payrollapplication.service.config;

import com.prologiccreations.payrollapplication.dao.config.BenefitsRepository;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.Benefits;
import com.prologiccreations.payrollapplication.service.super_classes.config.BenefitsService;
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
public class BenefitsServiceImpl implements BenefitsService {

    private final BenefitsRepository repository;

    @Override
    public Response storeData(Benefits data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            repository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Benefits>> getAll(Pageable pageable) {
        Page<Benefits> page = repository.findByActive(true, pageable);
        return new Response<>(SUCCESS, null, page);
    }

    @Override
    public Response<Benefits> getById(Long id) {
        Benefits benefits = repository.findById(id).orElse(new Benefits());
        return new Response<>(SUCCESS, null, benefits);
    }

    @Override
    public Response delete(Long id) {
        repository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Benefits data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Benefits data) {
//        boolean benefitsnameExists;
//        if (data.hasId()) {
//            benefitsnameExists = repository.existsByBenefitsname(data.getBenefitsname(), data.getId());
//        } else {
//            benefitsnameExists = repository.existsByBenefitsname(data.getBenefitsname());
//        }
//        return benefitsnameExists ? "Failed to register. Benefits already exists" : null;
        return null;
    }

}
