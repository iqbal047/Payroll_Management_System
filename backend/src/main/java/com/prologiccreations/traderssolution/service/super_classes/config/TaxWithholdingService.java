package com.prologiccreations.traderssolution.service.super_classes.config;

import com.prologiccreations.traderssolution.dto.Response;
import com.prologiccreations.traderssolution.model.config.TaxWithholding;
import com.prologiccreations.traderssolution.service.super_classes.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaxWithholdingService extends CrudService<TaxWithholding, Long> {

    Response storeData(TaxWithholding data);

    Response<Page<TaxWithholding>> getAll(Pageable pageable);

    Response<TaxWithholding> getById(Long id);

    Response delete(Long id);

    String validate(TaxWithholding data);

    String checkDuplicate(TaxWithholding data);
}
