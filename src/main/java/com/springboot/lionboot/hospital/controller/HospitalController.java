package com.springboot.lionboot.hospital.controller;

import com.springboot.lionboot.hospital.dao.HospitalDao;
import com.springboot.lionboot.hospital.domain.Hospital;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalDao hospitalDao;

    @GetMapping("/hospitals/{id}")
    public ResponseEntity<Hospital> findById(@PathVariable int id) {
        Hospital hospital = hospitalDao.findById(id);
        Optional<Hospital> optionalHospital = Optional.of(hospital);
        if (!optionalHospital.isEmpty()) {
            return ResponseEntity.ok().body(hospital);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital());
        }
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

    @DeleteMapping("/hospitals")
    public ResponseEntity<Hospital> deleteHospital() {
        hospitalDao.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body(new Hospital());
    }

}
