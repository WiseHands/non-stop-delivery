package ua.lviv.wdelivery.auth.repository;

import ua.lviv.wdelivery.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
