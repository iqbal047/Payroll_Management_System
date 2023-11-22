package com.prologiccreations.payrollapplication.service.super_classes.config;

import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.Attendance;
import com.prologiccreations.payrollapplication.service.super_classes.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AttendanceService extends CrudService<Attendance, Long> {

    Response storeData(Attendance data);

    Response<Page<Attendance>> getAll(Pageable pageable);

    Response<Attendance> getById(Long id);

    Response delete(Long id);

    String validate(Attendance data);

    String checkDuplicate(Attendance data);
}
