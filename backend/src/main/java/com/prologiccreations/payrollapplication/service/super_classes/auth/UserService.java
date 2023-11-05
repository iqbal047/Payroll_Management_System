package com.prologiccreations.payrollapplication.service.super_classes.auth;

import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.model.auth.User;
import com.prologiccreations.payrollapplication.service.super_classes.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends CrudService<User, Long> {

    Response storeData(User data);

    Response<Page<User>> getAll(Pageable pageable);

    Response<User> getById(Long id);

    Response delete(Long id);

    String validate(User data);

    String checkDuplicate(User data);
}
