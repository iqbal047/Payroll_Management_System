package com.prologiccreations.payrollapplication.service.config;

import com.prologiccreations.payrollapplication.dao.config.AttendanceRepository;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.Attendance;
import com.prologiccreations.payrollapplication.service.super_classes.config.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.prologiccreations.payrollapplication.PayrollApplication.getCurrentUsername;
import static com.prologiccreations.payrollapplication.constants.enums.OperationStatus.FAILURE;
import static com.prologiccreations.payrollapplication.constants.enums.OperationStatus.SUCCESS;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository repository;

    @Override
    public Response storeData(Attendance data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            repository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Attendance>> getAll(Pageable pageable) {
        Page<Attendance> page = repository.findByActive(true, pageable);
        return new Response<>(SUCCESS, null, page);
    }

    @Override
    public Response<Attendance> getById(Long id) {
        Attendance benefits = repository.findById(id).orElse(new Attendance());
        return new Response<>(SUCCESS, null, benefits);
    }

    @Override
    public Response delete(Long id) {
        repository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Attendance data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Attendance data) {
//        boolean benefitsnameExists;
//        if (data.hasId()) {
//            benefitsnameExists = repository.existsByAttendancename(data.getAttendancename(), data.getId());
//        } else {
//            benefitsnameExists = repository.existsByAttendancename(data.getAttendancename());
//        }
//        return benefitsnameExists ? "Failed to register. Attendance already exists" : null;
        return null;
    }

}
