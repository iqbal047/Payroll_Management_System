package com.prologiccreations.traderssolution.service.super_classes.config;

import com.prologiccreations.traderssolution.dto.Response;
import com.prologiccreations.traderssolution.model.config.Leave;
import com.prologiccreations.traderssolution.service.super_classes.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LeaveService extends CrudService<Leave, Long> {

    Response storeData(Leave data);

    Response<Page<Leave>> getAll(Pageable pageable);

    Response<Leave> getById(Long id);

    Response delete(Long id);

    String validate(Leave data);

    String checkDuplicate(Leave data);
}
