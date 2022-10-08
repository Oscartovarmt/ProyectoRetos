package com.doctors.repository;

import com.doctors.model.ReservationModel;
import com.doctors.model.ScoreModel;
import com.doctors.repository.crudrepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<ScoreModel> getAllScores() {
        return (List<ScoreModel>) scoreCrudRepository.findAll();
    }

    public Optional<ScoreModel> getScore(Integer id) {
        return scoreCrudRepository.findById(id);
    }

    public ScoreModel saveScore(ScoreModel scoreModel){
        return scoreCrudRepository.save(scoreModel);
    }

    public boolean deleteScore(Integer id) {
        try {
            scoreCrudRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public ScoreModel updateScore(ScoreModel scoreModel) {
        if (scoreModel.getId() != null) {
            Optional<ScoreModel> score = scoreCrudRepository.findById( scoreModel.getId());
            if (!score.isEmpty()) {
                if (scoreModel.getScore() != null) {
                    score.get().setScore(scoreModel.getScore());
                }
                if (scoreModel.getReservations() != null) {
                    score.get().setReservations(scoreModel.getReservations());
                }
                scoreCrudRepository.save(score.get());
                return score.get();
            } else {
                return scoreModel;
            }
        } else {
            return scoreModel;
        }
    }
}