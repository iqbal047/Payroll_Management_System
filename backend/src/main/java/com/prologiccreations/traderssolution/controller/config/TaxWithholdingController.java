package com.prologiccreations.traderssolution.controller.config;

import com.prologiccreations.traderssolution.controller.super_classes.CrudController;
import com.prologiccreations.traderssolution.dto.Response;
import com.prologiccreations.traderssolution.model.config.TaxWithholding;
import com.prologiccreations.traderssolution.service.super_classes.config.TaxWithholdingService;
import com.prologiccreations.traderssolution.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("taxWithholding/")
public class TaxWithholdingController implements CrudController<TaxWithholding, Long> {
    private final TaxWithholdingService taxWithholdingService;

    @Override
    public ResponseEntity<Response> storeData(TaxWithholding data) {
        Response response = taxWithholdingService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<TaxWithholding>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<TaxWithholding>> response = taxWithholdingService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<TaxWithholding>> getOne(Long id) {
        Response<TaxWithholding> response = taxWithholdingService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = taxWithholdingService.delete(id);
        return ResponseEntity.ok(response);
    }
}
