package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // return 하는 값을 그냥 string으로 반환을 하게 한다
@Slf4j
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass());  -> @Slf4j을 사용하면 필요 없다


    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);
        //log.info(" info log=" + name); // 이렇게 사용하면 된다.....

        log.trace("trace log={}", name);
        log.debug("debug log={}", name); //debug모드 개발 서버에서 보는거
        log.info(" info log={}", name);// 비지니스 정보 및 운영시스템 정보
        log.warn(" warn log={}", name); // 경고
        log.error(" error log={}", name); //에러

        return "ok";
    }
}
