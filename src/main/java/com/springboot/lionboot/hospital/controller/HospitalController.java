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
        //null이 넘어올 경우 ,NPE를 던지지 않고 Optional.empty()와 동일하게 비어있는 Optional객체를 얻어온다.
        // 해당 객체가 null인지 아닌지 자신이 없는 상황에서는 이 메소드를 사용해야한다
        Optional<Hospital> optionalHospital = Optional.ofNullable(hospital);
        if (!optionalHospital.isEmpty()) {
            return ResponseEntity.ok().body(hospital);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital());
        }
        //return ResponseEntity.status(HttpStatus.OK).body(optionalHospital.orElse(new Hospital()));

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
