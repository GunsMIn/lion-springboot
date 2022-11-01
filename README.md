# SpringBoot
**멋쟁이사자처럼 활동내용**
<img width="900" alt="___________2017-02-22______5 47 08" src="https://user-images.githubusercontent.com/104709432/198947114-5f7b3711-53b9-415c-9f38-f95072dc1cd4.png">

<br>
<img src="https://img.shields.io/badge/Java-E34F26?style=flat&logo=Java&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat&logo=Spring Boot&logoColor=white"/></a>
<img src="https://img.shields.io/badge/JUnit5-25A162?style=flat&logo=JUnit5&logoColor=white"/></a>
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white"/></a>

## Contents
<details>
<summary>병원 정보 처리 </summary>


### 221031 (병원 정보처리 api)
![image](https://user-images.githubusercontent.com/104709432/198946914-030c5b49-4a33-40eb-b0d0-7e1e613b9d89.png)
- **practice 패키지**: 
- **readLingParser 패키지** ` : .csv로 받은 10만건 이상의 병원 정모 공공 데이터를 spring에서 제작한 Hospital 객체로 parsing해주는 패키지 
- **domain 패키지**  : Hospital 클래스 제작

### 221101 (MySql과 JDBCtemplate 연동)
- **디비연동 조직도**
![image](https://user-images.githubusercontent.com/104709432/199156854-b9b1c579-f05d-44fa-8acc-f9128b8a378c.png)
- **레이어 계층적용**
![image](https://user-images.githubusercontent.com/104709432/199157116-70106c5c-6e91-4ce2-a5b9-966c9c91853f.png)
- **@SpringBootApplication —> @ComponentScan** ` : componentScan은 @Component를 스캔해서 bean으로 등록한다
- **@SpringBootTest** :등록된 빈을 가져다 쓸수있다(테스트에서) 
- **domain 패키지**  : Hospital 클래스 제작
- **getCount(),deleteAll(), getCount(),findById() 메소드 추가**


</details>

---


