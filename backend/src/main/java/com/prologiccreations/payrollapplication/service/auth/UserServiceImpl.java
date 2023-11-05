package com.prologiccreations.payrollapplication.service.auth;

import com.prologiccreations.payrollapplication.dao.auth.UserRepository;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.auth.User;
import com.prologiccreations.payrollapplication.service.super_classes.auth.UserService;
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
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Response storeData(User data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            repository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }


    @Override
    public Response<Page<User>> getAll(Pageable pageable) {
        Page<User> page = repository.findByActive(true, pageable);
        return new Response<>(SUCCESS, null, page);
    }

    @Override
    public Response<User> getById(Long id) {
        User user = repository.findById(id).orElse(new User());
        return new Response<>(SUCCESS, null, user);
    }

    @Override
    public Response delete(Long id) {
        repository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(User data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(User data) {
        boolean usernameExists;
        if (data.hasId()) {
            usernameExists = repository.existsByUsername(data.getUsername(), data.getId());
        } else {
            usernameExists = repository.existsByUsername(data.getUsername());
        }
        return usernameExists ? "Failed to register. User already exists" : null;
    }

}
