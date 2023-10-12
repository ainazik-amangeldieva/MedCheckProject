package hospital.service;

import hospital.entity.Role;

import java.util.List;

public interface RoleService {

    void createRole(Role role);

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    void updateRole(Long id, Role role);

    String deleteRoleById(Long id);
}
