package com.prologiccreations.payrollapplication.controller.config;

import com.prologiccreations.payrollapplication.controller.super_classes.CrudController;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.Department;
import com.prologiccreations.payrollapplication.service.super_classes.config.DepartmentService;
import com.prologiccreations.payrollapplication.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("department/")
public class DepartmentController implements CrudController<Department, Long> {
    private final DepartmentService departmentService;

    @Override
    public ResponseEntity<Response> storeData(Department data) {
        Response response = departmentService.storeData(data);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Page<Department>>> getAll(Integer pageNumber, Integer pageSize, String sortDirection, String sortColumns) {
        Pageable pageable = PageUtil.getPageable(pageNumber, pageSize, sortDirection, sortColumns);
        Response<Page<Department>> response = departmentService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Department>> getOne(Long id) {
        Response<Department> response = departmentService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        Response response = departmentService.delete(id);
        return ResponseEntity.ok(response);
    }
}
