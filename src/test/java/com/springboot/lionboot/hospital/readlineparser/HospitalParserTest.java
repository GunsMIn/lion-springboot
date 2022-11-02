package com.springboot.lionboot.hospital.readlineparser;

import com.springboot.lionboot.hospital.domain.Hospital;
import com.springboot.lionboot.hospital.dao.HospitalDao;
import com.springboot.lionboot.hospital.service.HospitalService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//@SpringBootApplication —> 얘가 스캔해서 등록한 Bean들을 가져다 씁니다.
@SpringBootTest // 스프링부트 환경에서 테스트 할 수 있게 해주는 어노테이션
class HospitalParserTest {

    String line1 = "\"1\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100004\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";

    @Autowired
    ReadLineContext<Hospital> hospitalReadLineContext;

    @Autowired
    HospitalDao hospitalDao;

    @Autowired
    HospitalService hospitalService;



    @Test
    @DisplayName("Hospital이 insert가 잘 되고, select도 잘 되는지")
    void addAndGet() {
        hospitalDao.deleteAll();
        assertEquals(0, hospitalDao.getCount());
        HospitalParser hp = new HospitalParser();
        Hospital hospital = hp.parse(line1);
        hospitalDao.add(hospital);
        assertEquals(1, hospitalDao.getCount());

        Hospital selectedHospital = hospitalDao.findById(hospital.getId());
        assertEquals(selectedHospital.getId(), hospital.getId());
        assertEquals(selectedHospital.getOpenServiceName(), hospital.getOpenServiceName());
        assertEquals(selectedHospital.getHospitalName(), hospital.getHospitalName());
        // 날짜, float
        assertTrue(selectedHospital.getLicenseDate().isEqual(hospital.getLicenseDate()));
        assertEquals(selectedHospital.getTotalAreaSize(), hospital.getTotalAreaSize());
        // findById
    }




    @Test
    @DisplayName("10만건 이상 데이터가 파싱 되는지")
    void name() throws IOException {
//        hospitalDao.deleteAll();
//        String filename = "C:\\Users\\User\\Downloads\\fulldata_01_01_02_P_의원.csv";
//       /* List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);*/
//        int cnt = hospitalService.insertLargeVolumeHospitalData(filename);
//        assertTrue(cnt > 1000);
//        assertTrue(cnt > 10000);
//        System.out.printf("파싱된 데이터 개수:", cnt);
    }


    @Test
    @DisplayName("csv 1줄은 Hospital로 잘 만드는지 TEST")
    void convertToHospital(){
        HospitalParser hp = new HospitalParser();
        Hospital hospital = hp.parse(line1);

        assertEquals(1, hospital.getId());
        assertEquals("의원", hospital.getOpenServiceName());
        assertEquals(3620000,hospital.getOpenLocalGovernmentCode());
        assertEquals("PHMA119993620020041100004",hospital.getManagementNumber());
        assertEquals(LocalDateTime.of(1999, 6, 12, 0, 0, 0), hospital.getLicenseDate()); //19990612
        assertEquals(1, hospital.getBusinessStatus());
        assertEquals(13, hospital.getBusinessStatusCode());
        assertEquals("062-515-2875", hospital.getPhone());
        assertEquals("광주광역시 북구 풍향동 565번지 4호 3층", hospital.getFullAddress());
        assertEquals("광주광역시 북구 동문대로 24, 3층 (풍향동)", hospital.getRoadNameAddress());
        assertEquals("효치과의원", hospital.getHospitalName());
        assertEquals("치과의원", hospital.getBusinessTypeName());
        assertEquals(1, hospital.getHealthcareProviderCount());
        assertEquals(0, hospital.getPatientRoomCount());
        assertEquals(0, hospital.getTotalNumberOfBeds());
        assertEquals(52.29f, hospital.getTotalAreaSize());
    }




}
