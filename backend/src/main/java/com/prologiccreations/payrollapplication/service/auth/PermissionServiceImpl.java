package com.prologiccreations.payrollapplication.service.auth;

import com.prologiccreations.payrollapplication.dao.auth.PermissionRepository;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.auth.Permission;
import com.prologiccreations.payrollapplication.service.super_classes.auth.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.prologiccreations.payrollapplication.constants.enums.OperationStatus.FAILURE;
import static com.prologiccreations.payrollapplication.constants.enums.OperationStatus.SUCCESS;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repository;

    @Override
    public Response storeData(Permission data) {
        String validationMsg = validate(data);
        if (validationMsg == null) {
            repository.save(data);
            return new Response(SUCCESS, "Successfully stored data", null);
        } else {
            return new Response(FAILURE, validationMsg, null);
        }
    }

    @Override
    public Response<Page<Permission>> getAll(Pageable pageable) {
        Page<Permission> page = repository.findByActive(true, pageable);
        return new Response<>(SUCCESS, null, page);
    }

    @Override
    public Response<Permission> getById(Long id) {
        Permission role = repository.findById(id).orElse(new Permission());
        return new Response<>(SUCCESS, null, role);
    }

    @Override
    @Transactional
    public Response delete(Long id) {
        repository.softDeleteById(id);
        return new Response(SUCCESS, "Deleted successfully", null);
    }

    @Override
    public String validate(Permission data) {
        return checkDuplicate(data);
    }

    @Override
    public String checkDuplicate(Permission data) {
//        boolean rolenameExists;
//        if (data.hasId()) {
//            rolenameExists = permissionRepository.existsByPermissionname(data.getPermissionname(), data.getId());
//        } else {
//            rolenameExists = permissionRepository.existsByPermissionname(data.getPermissionname());
//        }
//        return rolenameExists ? "Failed to register. Permission already exists" : null;
        return null;
    }

}
