package com.prologiccreations.payrollapplication.controller.config;

import com.prologiccreations.payrollapplication.controller.super_classes.CrudController;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.Leave;
import com.prologiccreations.payrollapplication.service.super_classes.config.LeaveService;
import com.prologiccreations.payrollapplication.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("leave/")
public class LeaveController implements CrudController<Leave, Long> {
    private final LeaveService leaveService;

    @Override
    public ResponseEntity<Response> storeData(Leave data) {
        Response response = leaveService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<Leave>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<Leave>> response = leaveService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Leave>> getOne(Long id) {
        Response<Leave> response = leaveService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = leaveService.delete(id);
        return ResponseEntity.ok(response);
    }
}
