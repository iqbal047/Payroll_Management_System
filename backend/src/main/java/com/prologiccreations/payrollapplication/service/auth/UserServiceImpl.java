package com.prologiccreations.payrollapplication.service.auth;

import com.prologiccreations.payrollapplication.dao.auth.UserRepository;
import com.prologiccreations.payrollapplication.dto.Response;
import com.prologiccreations.payrollapplication.dto.auth.LoginResponse;
import com.prologiccreations.payrollapplication.model.auth.Permission;
import com.prologiccreations.payrollapplication.model.auth.Role;
import com.prologiccreations.payrollapplication.model.auth.User;
import com.prologiccreations.payrollapplication.service.super_classes.auth.UserService;
import com.prologiccreations.payrollapplication.utils.auth.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static com.prologiccreations.payrollapplication.PayrollApplication.getCurrentUsername;
import static com.prologiccreations.payrollapplication.constants.Constants.*;
import static com.prologiccreations.payrollapplication.constants.enums.OperationStatus.FAILURE;
import static com.prologiccreations.payrollapplication.constants.enums.OperationStatus.SUCCESS;
import static com.prologiccreations.payrollapplication.utils.auth.CookieUtil.addCookieToHttpHeader;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final JwtUtil jwtUtil;

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

    @Override
    @Cacheable(value = "loggedInUsers", key = "#username")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository
                .findByUsernameAndActive(username, true)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password"));
    }

    @Override
    public String getUserameByRandomStringAndPublicKeyAndHash(String randomStr, String publicKey, String hash) {
        return repository.retrieveUsernameByPublicKeyAndPrivateKey(randomStr, publicKey, hash);
    }

    @Override
    public ResponseEntity<LoginResponse> getLoginResponse(User user) {
        HttpHeaders responseHeaders = new HttpHeaders();
        String accessToken = jwtUtil.createAccessToken(user);
        String refreshToken = jwtUtil.createRefreshToken(user.getUsername());
        addCookieToHttpHeader(responseHeaders, ACCESS_TOKEN_NAME, accessToken, ACCESS_TOKEN_DURATION_MILLISECONDS);
        addCookieToHttpHeader(responseHeaders, REFRESH_TOKEN_NAME, refreshToken, REFRESH_TOKEN_DURATION_MILLISECONDS);
        List<Role> roles = user.getRoles();
        List<String> authorities = new LinkedList<>();
        List<String> permissions = new LinkedList<>();
        for (Role role : roles) {
            authorities.add(role.getName());
            permissions.addAll(role.getPermissions().stream().map(Permission::getComponentKey).toList());
        }
        LoginResponse loginResponse = new LoginResponse(
                user.getUsername(),
                authorities,
                permissions,
                accessToken,
                SUCCESS.toString(),
                "Login successful.");
        return ResponseEntity.ok().headers(responseHeaders).body(loginResponse);
    }

    @Override
    public ResponseEntity<LoginResponse> refreshAuthTokens(String refreshToken) {
        Claims claimsSet = jwtUtil.verifyToken(refreshToken);
        User user = (User) loadUserByUsername(claimsSet.getSubject());
        return getLoginResponse(user);
    }

}
