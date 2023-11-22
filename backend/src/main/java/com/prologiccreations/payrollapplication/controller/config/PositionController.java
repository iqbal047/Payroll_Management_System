package com.prologiccreations.payrollapplication.controller.config;

import com.prologiccreations.payrollapplication.controller.super_classes.CrudController;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.Position;
import com.prologiccreations.payrollapplication.service.super_classes.config.PositionService;
import com.prologiccreations.payrollapplication.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("position/")
public class PositionController implements CrudController<Position, Long> {
    private final PositionService positionService;

    @Override
    public ResponseEntity<Response> storeData(Position data) {
        Response response = positionService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<Position>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<Position>> response = positionService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Position>> getOne(Long id) {
        Response<Position> response = positionService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = positionService.delete(id);
        return ResponseEntity.ok(response);
    }
}
