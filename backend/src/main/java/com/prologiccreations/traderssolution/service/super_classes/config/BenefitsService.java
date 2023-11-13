package com.prologiccreations.traderssolution.service.super_classes.config;

import com.prologiccreations.traderssolution.dto.Response;
import com.prologiccreations.traderssolution.model.config.Benefits;
import com.prologiccreations.traderssolution.service.super_classes.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BenefitsService extends CrudService<Benefits, Long> {

    Response storeData(Benefits data);

    Response<Page<Benefits>> getAll(Pageable pageable);

    Response<Benefits> getById(Long id);

    Response delete(Long id);

    String validate(Benefits data);

    String checkDuplicate(Benefits data);
}
