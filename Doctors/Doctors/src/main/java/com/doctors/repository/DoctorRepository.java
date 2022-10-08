package com.doctors.repository;

import com.doctors.model.DoctorModel;
import com.doctors.repository.crudrepository.DoctorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository {
    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    public List<DoctorModel> getAllDoctors() {
        return (List<DoctorModel>) doctorCrudRepository.findAll();
    }

    public Optional<DoctorModel> getDoctor(Integer id) {
        return doctorCrudRepository.findById(id);
    }

    public DoctorModel saveDoctor(DoctorModel doctorModel){
        return doctorCrudRepository.save(doctorModel);
    }

    public boolean deleteDoctor(Integer id) {
        try {
            doctorCrudRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    /*
    public DoctorModel updateDoctor(DoctorModel doctorModel){
        return doctorCrudRepository.save(doctorModel);
    }
    */
    public DoctorModel updateDoctor(DoctorModel doctorModel) {
        if (doctorModel.getId() != null) {
            Optional<DoctorModel> doctor = doctorCrudRepository.findById(doctorModel.getId());
            if (!doctor.isEmpty()) {
                if (doctorModel.getName() != null) {
                    doctor.get().setName(doctorModel.getName());
                }
                if (doctorModel.getDepartment() != null) {
                    doctor.get().setDepartment(doctorModel.getDepartment());
                }
                if (doctorModel.getYear() != null) {
                    doctor.get().setYear(doctorModel.getYear());
                }
                if (doctorModel.getDescription() != null) {
                    doctor.get().setDescription(doctorModel.getDescription());
                }
                if (doctorModel.getSpecialty() != null) {
                    doctor.get().setSpecialty(doctorModel.getSpecialty());
                }
                if (doctorModel.getMessages() != null) {
                    doctor.get().setMessages(doctorModel.getMessages());
                }
                if (doctorModel.getReservations() != null) {
                    doctor.get().setReservations(doctorModel.getReservations());
                }
                doctorCrudRepository.save(doctor.get());
                return doctor.get();
            } else {
                return doctorModel;
            }
        } else {
            return doctorModel;
        }
    }
}
