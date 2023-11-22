package com.prologiccreations.payrollapplication.controller.config;

import com.prologiccreations.payrollapplication.controller.super_classes.CrudController;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.PaymentHistory;
import com.prologiccreations.payrollapplication.service.super_classes.config.PaymentHistoryService;
import com.prologiccreations.payrollapplication.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("paymenthistory/")
public class PaymentHistoryController implements CrudController<PaymentHistory, Long> {
    private final PaymentHistoryService paymentHistoryService;

    @Override
    public ResponseEntity<Response> storeData(PaymentHistory data) {
        Response response = paymentHistoryService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<PaymentHistory>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<PaymentHistory>> response = paymentHistoryService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<PaymentHistory>> getOne(Long id) {
        Response<PaymentHistory> response = paymentHistoryService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = paymentHistoryService.delete(id);
        return ResponseEntity.ok(response);
    }
}
