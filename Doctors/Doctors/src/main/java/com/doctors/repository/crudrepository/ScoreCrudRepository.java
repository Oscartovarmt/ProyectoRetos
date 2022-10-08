package com.doctors.repository.crudrepository;

import com.doctors.model.ScoreModel;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository <ScoreModel, Integer> {
}