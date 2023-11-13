package com.prologiccreations.traderssolution.controller.config;

import com.prologiccreations.traderssolution.controller.super_classes.CrudController;
import com.prologiccreations.traderssolution.dto.Response;
import com.prologiccreations.traderssolution.model.config.PayrollTransaction;
import com.prologiccreations.traderssolution.service.super_classes.config.PayrollTransactionService;
import com.prologiccreations.traderssolution.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("payrollTransaction/")
public class PayrollTransactionController implements CrudController<PayrollTransaction, Long> {
    private final PayrollTransactionService payrollTransactionService;

    @Override
    public ResponseEntity<Response> storeData(PayrollTransaction data) {
        Response response = payrollTransactionService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<PayrollTransaction>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<PayrollTransaction>> response = payrollTransactionService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<PayrollTransaction>> getOne(Long id) {
        Response<PayrollTransaction> response = payrollTransactionService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = payrollTransactionService.delete(id);
        return ResponseEntity.ok(response);
    }
}
