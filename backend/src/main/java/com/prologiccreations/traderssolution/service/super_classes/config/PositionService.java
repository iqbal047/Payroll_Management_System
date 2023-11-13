package com.prologiccreations.traderssolution.service.super_classes.config;

import com.prologiccreations.traderssolution.dto.Response;
import com.prologiccreations.traderssolution.model.config.Position;
import com.prologiccreations.traderssolution.service.super_classes.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PositionService extends CrudService<Position, Long> {

    Response storeData(Position data);

    Response<Page<Position>> getAll(Pageable pageable);

    Response<Position> getById(Long id);

    Response delete(Long id);

    String validate(Position data);

    String checkDuplicate(Position data);
}
