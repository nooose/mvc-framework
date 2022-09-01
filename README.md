# mvc-framework
MVC 프레임워크를 간단하게 만들어보자

# 환경
- JDK 11
- [apache-tomcat-9.0.65.tar.gz](https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.65/bin/apache-tomcat-9.0.65.tar.gz) 
  ```bash
  # 실행
  $TOMCAT_PATH/bin/startup.sh
  # 중지  
  $TOMCAT_PATH/bin/shutdown.sh
  ```

# HTTP 특징
- HTTP/1.1, HTTP/2는 TCP 기반 위에서 동작
- HTTP/3는 UDP 기반 위에서 동작

## HTTP 요청/응답 메시지 구조
- 클라이언트
  - 요청 메시지
    - Request line (`GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1`)
      - httpMethod (`GET`)
      - path (`/calculate`)
      - queryString (`operand1=11&operator=*&operand2=55`)
    - Header
    - Blank line
    - Body
- 서버
  - 응답 메시지
    - Status line
    - Header
    - Blank line
    - Body
## 클라이언트 - 서버 모델
- 무상태 프로토콜 (Stateless)
  - 서버가 클라이언트 상태를 유지하지 않음
  - 해결책 : Keep-Alive 속성 사용
- 비 연결성 (Connectionless)
  - 서버가 클라이언트 요청에 대해 응답을 마치면 맺었던 연결을 끊어버림
  - 해결책 : 쿠키 (클라이언트에 정보 저장), 세션 (서버에 정보 저장), JWT