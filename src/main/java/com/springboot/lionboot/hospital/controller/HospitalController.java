package com.springboot.lionboot.hospital.controller;

import com.springboot.lionboot.hospital.dao.HospitalDao;
import com.springboot.lionboot.hospital.domain.Hospital;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalDao hospitalDao;

    @GetMapping("/hospitals/{id}")
    public Hospital findById(@PathVariable int id) {
        Hospital hospital = hospitalDao.findById(id);
        return hospital;
    }

    @GetMapping("/hospitals")
    public int getCount() {
        int count = hospitalDao.getCount();
        return count;
    }

    @PostMapping("/hospitals/{id}")
    public Hospital addHospital(@ModelAttribute Hospital hospital) {
        hospitalDao.add(hospital);
        return hospital;
    }

}
