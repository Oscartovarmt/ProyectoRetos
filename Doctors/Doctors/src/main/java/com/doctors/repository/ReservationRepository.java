package com.doctors.repository;

import com.doctors.model.DoctorModel;
import com.doctors.model.ReservationModel;
import com.doctors.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAllReservation(){
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }

    public Optional<ReservationModel> getReservation(Integer id) {
        return reservationCrudRepository.findById((id));
    }

    public ReservationModel saveReservation(ReservationModel reservationModel){
        return reservationCrudRepository.save(reservationModel);
    }

    public boolean deleteReservation(Integer id){ //aparecia public void no boolean
        try {
            reservationCrudRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public ReservationModel updateReservation(ReservationModel reservationModel){
        if (reservationModel.getIdReservation() != null) {
            Optional<ReservationModel> reservation = reservationCrudRepository.findById( reservationModel.getIdReservation());
            if (!reservation.isEmpty()) {
                if (reservationModel.getStartDate() != null) {
                    reservation.get().setStartDate(reservationModel.getStartDate());
                }
                if (reservationModel.getDevolutionDate() != null) {
                    reservation.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                if (reservationModel.getStatus() != null) {
                    reservation.get().setStatus(reservationModel.getStatus());
                }
                if (reservationModel.getDoctor() != null) {
                    reservation.get().setDoctor(reservationModel.getDoctor());
                }
                if (reservationModel.getClient() != null) {
                    reservation.get().setClient(reservationModel.getClient());
                }
                if (reservationModel.getScore() != null) {
                    reservation.get().setScore(reservationModel.getScore());
                }
                reservationCrudRepository.save(reservation.get());
                return reservation.get();
            } else {
                return reservationModel;
            }
        } else {
            return reservationModel;
        }
    }
}
