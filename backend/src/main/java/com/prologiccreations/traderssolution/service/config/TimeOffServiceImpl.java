package com.prologiccreations.traderssolution.service.config;

import com.prologiccreations.traderssolution.dao.config.TimeOffRepository;
import com.prologiccreations.traderssolution.dto.Response;
import com.prologiccreations.traderssolution.model.config.TimeOff;
import com.prologiccreations.traderssolution.service.super_classes.config.TimeOffService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.prologiccreations.traderssolution.PayrollApplication.getCurrentUsername;
import static com.prologiccreations.traderssolution.constants.enums.OperationStatus.FAILURE;
import static com.prologiccreations.traderssolution.constants.enums.OperationStatus.SUCCESS;

@Service
@RequiredArgsConstructor
public class TimeOffServiceImpl implements TimeOffService {

    private final TimeOffRepository repository;

    @Override
    public Response storeData(TimeOff data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            repository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<TimeOff>> getAll(Pageable pageable) {
        Page<TimeOff> page = repository.findByActive(true, pageable);
        return new Response<>(SUCCESS, null, page);
    }

    @Override
    public Response<TimeOff> getById(Long id) {
        TimeOff taxWithholding = repository.findById(id).orElse(new TimeOff());
        return new Response<>(SUCCESS, null, taxWithholding);
    }

    @Override
    public Response delete(Long id) {
        repository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(TimeOff data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(TimeOff data) {
//        boolean taxWithholdingnameExists;
//        if (data.hasId()) {
//            taxWithholdingnameExists = repository.existsByTimeOffname(data.getTimeOffname(), data.getId());
//        } else {
//            taxWithholdingnameExists = repository.existsByTimeOffname(data.getTimeOffname());
//        }
//        return taxWithholdingnameExists ? "Failed to register. TimeOff already exists" : null;
        return null;
    }

}
