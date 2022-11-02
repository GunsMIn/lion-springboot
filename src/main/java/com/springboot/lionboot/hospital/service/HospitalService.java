package com.springboot.lionboot.hospital.service;
import com.springboot.lionboot.hospital.dao.HospitalDao;
import com.springboot.lionboot.hospital.domain.Hospital;
import com.springboot.lionboot.hospital.readlineparser.ReadLineContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private  final ReadLineContext<Hospital> hospitalReadLineContext;

    private final HospitalDao hospitalDao;

    //파일 이름명으로 들어가는 service로직
    @Transactional
    public int insertLargeVolumeHospitalData(String filename) {
        int cnt = 0;
        try {
            List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);
            for (Hospital hospital : hospitalList) {
                try {
                    this.hospitalDao.add(hospital); // db에 insert 구간
                    cnt++;
                } catch (Exception e) {//indsert 문제시
                    System.out.printf("id:%d 레코드에 문제가 있습니다.",hospital.getId());
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cnt;
    }

}
