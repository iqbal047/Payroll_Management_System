package com.prologiccreations.payrollapplication.service.super_classes.config;

import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.PayrollTransaction;
import com.prologiccreations.payrollapplication.service.super_classes.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PayrollTransactionService extends CrudService<PayrollTransaction, Long> {

    Response storeData(PayrollTransaction data);

    Response<Page<PayrollTransaction>> getAll(Pageable pageable);

    Response<PayrollTransaction> getById(Long id);

    Response delete(Long id);

    String validate(PayrollTransaction data);

    String checkDuplicate(PayrollTransaction data);
}
