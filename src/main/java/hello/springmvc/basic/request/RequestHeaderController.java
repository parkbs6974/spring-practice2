package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpServletRequest request, HttpServletResponse response, HttpMethod httpMethod, Locale locale, @RequestHeader MultiValueMap<String, String> headerMap, @RequestHeader("host") String host, @CookieValue(value = "myCookie", required = false) String cookie){
        //HttpMethod httpMethod : get, post, delete 정보 담고 있다.
        // Locale : 언어 정보
        // @RequestHeader MultiValueMap<String, String> headerMap: header를 다 받고 싶을 떄
        // MultiValueMap<String, String> headerMap : map 이랑 유사하다, header에 같은 값들이 들어오면 저장을 할 수 있게 한다
        //  @RequestHeader("host") String host : 하나만 받고 싶을떄 사용
        //@CookieValue(value = "myCookie", required = false) String cookie : default 는 true이다, 쿠키를 받고 싶을뗴

        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("cookie={}", cookie);

        return "ok";
    }
}
