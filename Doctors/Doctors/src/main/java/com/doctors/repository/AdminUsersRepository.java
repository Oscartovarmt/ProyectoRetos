package com.doctors.repository;

import com.doctors.model.SpecialtyModel;
import com.doctors.model.AdminUsersModel;
import com.doctors.repository.crudrepository.AdminUsersCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository ///Falta comitear el CrudAdmin
public class AdminUsersRepository {

    @Autowired
    private AdminUsersCrudRepository adminUsersCrudRepository;

    public List<AdminUsersModel> getAllAdminUsers() {
        return (List<AdminUsersModel>) adminUsersCrudRepository.findAll();
    }

    public Optional<AdminUsersModel> getAdminUsers(Integer id) {
        return adminUsersCrudRepository.findById(id);
    }

    public AdminUsersModel saveAdminUsers(AdminUsersModel adminUsersModel){
        return adminUsersCrudRepository.save(adminUsersModel);
    }
    public boolean deleteAdminUsers(Integer id){
        try {
            adminUsersCrudRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public AdminUsersModel updateAdminUsers(AdminUsersModel adminUsersModel){
        if (adminUsersModel.getId() != null) {
            Optional<AdminUsersModel> admin = adminUsersCrudRepository.findById(adminUsersModel.getId());
            if (!admin.isEmpty()) {
                if (adminUsersModel.getName() != null) {
                    admin.get().setName(adminUsersModel.getName());
                }
                if (adminUsersModel.getEmail() != null) {
                    admin.get().setEmail(adminUsersModel.getEmail());
                }
                if (adminUsersModel.getPassword() != null) {
                    admin.get().setPassword(adminUsersModel.getPassword());
                }
                adminUsersModel.save(admin.get());
                return admin.get();
            } else {
                return adminUsersModel;
            }
        } else {
            return adminUsersModel;
        }
    }
}
