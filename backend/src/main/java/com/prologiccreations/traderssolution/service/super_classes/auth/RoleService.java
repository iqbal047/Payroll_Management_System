package com.prologiccreations.traderssolution.service.super_classes.auth;

import com.prologiccreations.traderssolution.dto.Response;
import com.prologiccreations.traderssolution.model.auth.Role;
import com.prologiccreations.traderssolution.service.super_classes.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService extends CrudService<Role, Long> {

    Response storeData(Role data);

    Response<Page<Role>> getAll(Pageable pageable);

    Response<Role> getById(Long id);

    Response delete(Long id);

    String validate(Role data);

    String checkDuplicate(Role data);
}
