package com.springboot.lionboot.hospital.controller;

import com.springboot.lionboot.hospital.dao.HospitalDao;
import com.springboot.lionboot.hospital.domain.Hospital;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalDao hospitalDao;

    @GetMapping("/members/{id}")
    public Hospital findById(@PathVariable int id) {
        Hospital hospital = hospitalDao.findById(id);
        return hospital;
    }

}
