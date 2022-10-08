package com.doctors.service;

import com.doctors.model.ScoreModel;
import com.doctors.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<ScoreModel> getAllScores(){
        return scoreRepository.getAllScores();
    }

    public Optional<ScoreModel> getScore(Integer id){
        return scoreRepository.getScore(id);
    }

    public ScoreModel saveScore(ScoreModel scoreModel){
        return scoreRepository.saveScore(scoreModel);
    }

    public boolean deleteScore(Integer id){
        scoreRepository.deleteScore(id);
        return true;
    }

    public ScoreModel updateScore(ScoreModel scoreModel){
        return scoreRepository.updateScore(scoreModel);
    }

}