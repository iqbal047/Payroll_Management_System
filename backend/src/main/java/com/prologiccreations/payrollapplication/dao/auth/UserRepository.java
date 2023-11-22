package com.prologiccreations.payrollapplication.dao.auth;

import com.prologiccreations.payrollapplication.dao.super_classes.CrudDao;
import com.prologiccreations.payrollapplication.model.auth.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudDao<User, Long> {

    Page<User> findByActive(boolean isActive, Pageable pageable);

    boolean existsByUsername(String username);

    @Query(value = "SELECT case when count(e) > 0 then true else false end " +
            "FROM User e " +
            "where e.username = :username and e.id <> :id")
    boolean existsByUsername(@Param("username") String username, @Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE User e " +
            "SET e.active = false, e.modifiedBy = :modifiedBy, e.modifiedDate = :modifiedDate " +
            "where e.id = :id")
    int softDeleteById(@Param("id") Long id, @Param("modifiedBy") String modifiedBy, @Param("modifiedDate") LocalDateTime modifiedDate);

    Page<User> findAllByActive(boolean isActive, Pageable pageable);

    Optional<User> findByUsernameAndActive(@NonNull String username, boolean isActive);


    @Query(value = "" +
            "select u.username " +
            "from api a " +
            "         join user u on a.user_id = u.id " +
            "where MD5(concat(:randomStr, a.api_private, :publicKey)) = :hash", nativeQuery = true)
    String retrieveUsernameByPublicKeyAndPrivateKey(@Param("randomStr") String randomStr,
                                                    @Param("publicKey") String publicKey,
                                                    @Param("hash") String hash);
}