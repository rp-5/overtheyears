package com.overtheyears.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overtheyears.Repository.HumanCaseRepository;
import com.overtheyears.cases.entity.HumanCase;

@Service
public class HumanCaseService {
    @Autowired
    private HumanCaseRepository humanRepository;

    public void save(HumanCase human) {
        this.humanRepository.save(human);
    }
}
