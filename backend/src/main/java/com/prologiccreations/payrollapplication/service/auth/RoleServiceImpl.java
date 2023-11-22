package com.prologiccreations.payrollapplication.service.auth;

import com.prologiccreations.payrollapplication.dao.auth.RoleRepository;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.auth.Role;
import com.prologiccreations.payrollapplication.service.super_classes.auth.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.prologiccreations.payrollapplication.PayrollApplication.*;
import static com.prologiccreations.payrollapplication.constants.enums.OperationStatus.FAILURE;
import static com.prologiccreations.payrollapplication.constants.enums.OperationStatus.SUCCESS;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Override
    public Response storeData(Role data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            repository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Role>> getAll(Pageable pageable) {
        Page<Role> page = repository.findByActive(true, pageable);
        return new Response<>(SUCCESS, null, page);
    }


    @Override
    public Response<Role> getById(Long id) {
        Role role = repository.findById(id).orElse(new Role());
        return new Response<>(SUCCESS, null, role);
    }

    @Override
    public Response delete(Long id) {
        repository.softDeleteById(id, getCurrentUsername(), LocalDateTime.now());
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Role data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Role data) {
//        boolean rolenameExists;
//        if (data.hasId()) {
//            rolenameExists = roleRepository.existsByRolename(data.getRolename(), data.getId());
//        } else {
//            rolenameExists = roleRepository.existsByRolename(data.getRolename());
//        }
//        return rolenameExists ? "Failed to register. Role already exists" : null;
        return null;
    }

}
