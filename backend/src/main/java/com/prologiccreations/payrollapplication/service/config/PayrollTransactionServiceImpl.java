package com.prologiccreations.payrollapplication.service.config;

import com.prologiccreations.payrollapplication.dao.config.PayrollTransactionRepository;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.PayrollTransaction;
import com.prologiccreations.payrollapplication.service.super_classes.config.PayrollTransactionService;
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
public class PayrollTransactionServiceImpl implements PayrollTransactionService {

    private final PayrollTransactionRepository repository;

    @Override
    public Response storeData(PayrollTransaction data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            repository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<PayrollTransaction>> getAll(Pageable pageable) {
        Page<PayrollTransaction> page = repository.findByActive(true, pageable);
        return new Response<>(SUCCESS, null, page);
    }

    @Override
    public Response<PayrollTransaction> getById(Long id) {
        PayrollTransaction payrollTransaction = repository.findById(id).orElse(new PayrollTransaction());
        return new Response<>(SUCCESS, null, payrollTransaction);
    }

    @Override
    public Response delete(Long id) {
        repository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(PayrollTransaction data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(PayrollTransaction data) {
//        boolean payrollTransactionnameExists;
//        if (data.hasId()) {
//            payrollTransactionnameExists = repository.existsByPayrollTransactionname(data.getPayrollTransactionname(), data.getId());
//        } else {
//            payrollTransactionnameExists = repository.existsByPayrollTransactionname(data.getPayrollTransactionname());
//        }
//        return payrollTransactionnameExists ? "Failed to register. PayrollTransaction already exists" : null;
        return null;
    }

}
