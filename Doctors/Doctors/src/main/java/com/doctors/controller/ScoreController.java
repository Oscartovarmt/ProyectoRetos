package com.doctors.controller;

import com.doctors.model.ScoreModel;
import com.doctors.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservequalifications")
@CrossOrigin(origins = "*")

public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<ScoreModel> getAllScores()
    {
        return scoreService.getAllScores();
    }

    @GetMapping("/{id}")
    public Optional<ScoreModel> getScore(@PathVariable Integer id)
    {
        return scoreService.getScore(id);
    }

    @PostMapping("/save")
    public ScoreModel saveScore(@RequestBody ScoreModel scoreModel)
    {
        return scoreService.saveScore(scoreModel);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteScore(@PathVariable Integer id)
    {
        return scoreService.deleteScore(id);
    }

    @PutMapping("/update")
    public ScoreModel updateScore(@RequestBody ScoreModel scoreModel)
    {
        return scoreService.updateScore(scoreModel);
    }
}
