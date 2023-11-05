package com.prologiccreations.payrollapplication.controller.config;

import com.prologiccreations.payrollapplication.controller.super_classes.CrudController;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.TimeOff;
import com.prologiccreations.payrollapplication.service.super_classes.config.TimeOffService;
import com.prologiccreations.payrollapplication.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("timeOff/")
public class TimeOffController implements CrudController<TimeOff, Long> {
    private final TimeOffService timeOffService;

    @Override
    public ResponseEntity<Response> storeData(TimeOff data) {
        Response response = timeOffService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<TimeOff>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<TimeOff>> response = timeOffService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<TimeOff>> getOne(Long id) {
        Response<TimeOff> response = timeOffService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = timeOffService.delete(id);
        return ResponseEntity.ok(response);
    }
}
