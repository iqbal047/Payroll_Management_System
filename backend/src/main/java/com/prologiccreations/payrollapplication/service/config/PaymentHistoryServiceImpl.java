package com.prologiccreations.payrollapplication.service.config;

import com.prologiccreations.payrollapplication.dao.config.PaymentHistoryRepository;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.PaymentHistory;
import com.prologiccreations.payrollapplication.service.super_classes.config.PaymentHistoryService;
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
public class PaymentHistoryServiceImpl implements PaymentHistoryService {

    private final PaymentHistoryRepository repository;

    @Override
    public Response storeData(PaymentHistory data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            repository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<PaymentHistory>> getAll(Pageable pageable) {
        Page<PaymentHistory> page = repository.findByActive(true, pageable);
        return new Response<>(SUCCESS, null, page);
    }

    @Override
    public Response<PaymentHistory> getById(Long id) {
        PaymentHistory paymentHistory = repository.findById(id).orElse(new PaymentHistory());
        return new Response<>(SUCCESS, null, paymentHistory);
    }

    @Override
    public Response delete(Long id) {
        repository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(PaymentHistory data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(PaymentHistory data) {
//        boolean paymentHistorynameExists;
//        if (data.hasId()) {
//            paymentHistorynameExists = repository.existsByPaymentHistoryname(data.getPaymentHistoryname(), data.getId());
//        } else {
//            paymentHistorynameExists = repository.existsByPaymentHistoryname(data.getPaymentHistoryname());
//        }
//        return paymentHistorynameExists ? "Failed to register. PaymentHistory already exists" : null;
        return null;
    }

}
