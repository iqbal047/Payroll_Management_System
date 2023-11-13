package com.prologiccreations.traderssolution.service.super_classes.config;

import com.prologiccreations.traderssolution.dto.Response;
import com.prologiccreations.traderssolution.model.config.TimeOff;
import com.prologiccreations.traderssolution.service.super_classes.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TimeOffService extends CrudService<TimeOff, Long> {

    Response storeData(TimeOff data);

    Response<Page<TimeOff>> getAll(Pageable pageable);

    Response<TimeOff> getById(Long id);

    Response delete(Long id);

    String validate(TimeOff data);

    String checkDuplicate(TimeOff data);
}
