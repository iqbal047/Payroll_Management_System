package com.prologiccreations.payrollapplication.service.config;

import com.prologiccreations.payrollapplication.dao.config.LeaveRepository;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.Leave;
import com.prologiccreations.payrollapplication.service.super_classes.config.LeaveService;
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
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository repository;

    @Override
    public Response storeData(Leave data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            repository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Leave>> getAll(Pageable pageable) {
        Page<Leave> page = repository.findByActive(true, pageable);
        return new Response<>(SUCCESS, null, page);
    }

    @Override
    public Response<Leave> getById(Long id) {
        Leave benefits = repository.findById(id).orElse(new Leave());
        return new Response<>(SUCCESS, null, benefits);
    }

    @Override
    public Response delete(Long id) {
        repository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Leave data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Leave data) {
//        boolean benefitsnameExists;
//        if (data.hasId()) {
//            benefitsnameExists = repository.existsByLeavename(data.getLeavename(), data.getId());
//        } else {
//            benefitsnameExists = repository.existsByLeavename(data.getLeavename());
//        }
//        return benefitsnameExists ? "Failed to register. Leave already exists" : null;
        return null;
    }

}
