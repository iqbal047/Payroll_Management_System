package com.prologiccreations.payrollapplication.service.super_classes.config;

import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.PaymentHistory;
import com.prologiccreations.payrollapplication.service.super_classes.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentHistoryService extends CrudService<PaymentHistory, Long> {

    Response storeData(PaymentHistory data);

    Response<Page<PaymentHistory>> getAll(Pageable pageable);

    Response<PaymentHistory> getById(Long id);

    Response delete(Long id);

    String validate(PaymentHistory data);

    String checkDuplicate(PaymentHistory data);
}
