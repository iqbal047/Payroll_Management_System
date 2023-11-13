package com.prologiccreations.traderssolution.service.super_classes.config;

import com.prologiccreations.traderssolution.dto.Response;
import com.prologiccreations.traderssolution.model.config.PaymentHistory;
import com.prologiccreations.traderssolution.service.super_classes.CrudService;
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
