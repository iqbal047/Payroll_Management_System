package com.prologiccreations.payrollapplication.service.config;

import com.prologiccreations.payrollapplication.dao.config.PositionRepository;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.config.Position;
import com.prologiccreations.payrollapplication.service.super_classes.config.PositionService;
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
public class PositionServiceImpl implements PositionService {

    private final PositionRepository repository;

    @Override
    public Response storeData(Position data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            repository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Position>> getAll(Pageable pageable) {
        Page<Position> page = repository.findByActive(true, pageable);
        return new Response<>(SUCCESS, null, page);
    }

    @Override
    public Response<Position> getById(Long id) {
        Position position = repository.findById(id).orElse(new Position());
        return new Response<>(SUCCESS, null, position);
    }

    @Override
    public Response delete(Long id) {
        repository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Position data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Position data) {
//        boolean positionnameExists;
//        if (data.hasId()) {
//            positionnameExists = repository.existsByPositionname(data.getPositionname(), data.getId());
//        } else {
//            positionnameExists = repository.existsByPositionname(data.getPositionname());
//        }
//        return positionnameExists ? "Failed to register. Position already exists" : null;
        return null;
    }

}
