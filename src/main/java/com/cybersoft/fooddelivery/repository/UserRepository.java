package com.cybersoft.fooddelivery.repository;

import com.cybersoft.fooddelivery.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    List<Users> findByEmail(String email);
    List<Users> findByEmailAndPassword(String email, String password);

    //Câu query sẽ tương tác với lại Entity và biến của entity
    @Query("select e from users e where e.email = :email and e.password = :password")
    List<Users> getUserByEmailPassword(@Param("email") String email,@Param("password") String password);

    @Query(value = "select * from users", nativeQuery = true)
    List<Map<?,Object>> getRoleUser();
}
