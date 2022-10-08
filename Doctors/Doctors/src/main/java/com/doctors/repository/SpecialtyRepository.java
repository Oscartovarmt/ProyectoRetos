package com.doctors.repository;

import com.doctors.model.SpecialtyModel;
import com.doctors.repository.crudrepository.SpecialtyCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecialtyRepository {


    @Autowired
    private SpecialtyCrudRepository specialtyCrudRepository;

    public List<SpecialtyModel> getAllSpecialties() {
        return (List<SpecialtyModel>) specialtyCrudRepository.findAll();

    }

    public Optional <SpecialtyModel> getSpecialty(Integer id){
        return specialtyCrudRepository.findById(id);
    }


    public SpecialtyModel saveSpecialty(SpecialtyModel specialtyModel){
        return specialtyCrudRepository.save(specialtyModel);
    }

    public boolean deleteSpecialty(Integer specialty_id) {
        try {
            specialtyCrudRepository.deleteById(specialty_id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public SpecialtyModel updateSpecialty(SpecialtyModel specialtyModel) {
        if (specialtyModel.getId() != null) {
            Optional<SpecialtyModel> specialty = specialtyCrudRepository.findById( specialtyModel.getId());
            if (!specialty.isEmpty()) {
                if (specialtyModel.getName() != null) {
                    specialty.get().setName(specialtyModel.getName());
                }
                if (specialtyModel.getDescription() != null) {
                    specialty.get().setDescription(specialtyModel.getDescription());
                }
                if (specialtyModel.getDoctors() != null) {
                    specialty.get().setDoctors(specialtyModel.getDoctors());
                }
                specialtyCrudRepository.save(specialty.get());
                return specialty.get();
            } else {
                return specialtyModel;
            }
        } else {
            return specialtyModel;
        }
    }


}



