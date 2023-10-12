package hospital.service.impl;

import hospital.entity.Role;
import hospital.repository.RoleRepository;
import hospital.service.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public void createRole(Role role) {
        roleRepository.save(role);

    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        Role role = roleRepository.findById(id).get();
        return role;
    }

    @Override
    public void updateRole(Long id, Role role) {

        Role role1 = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role with id: " + id + " not found!"));
        role1.setName(role.getName());

        roleRepository.save(role1);
    }

    @Override
    public String deleteRoleById(Long id) {
        roleRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Role with id: " + " not found!"));

        roleRepository.deleteById(id);
        return "Role with id: " + id + " successfully deleted!";
    }
}
