package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j

@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username , age);
        response.getWriter().write("ok");;
    }

    @ResponseBody  //ok 를 반환하게 한다 . @RestController와 같은 역활을 하게 한다
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username")String username, @RequestParam("age") int age){
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username, @RequestParam int age){  //이렇게 생략도 가능하게 된다
        log.info("username={}, age={}", username, age);

        return "ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){  //이렇게 생략도 가능하게 된다
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username,@RequestParam(required = false) int age){
        //(@RequestParam(required = true) : true이면 값이 무조건 넘어 와야한다
        //int a = null;이 들어 갈 수가 없다
        // 만약 바꾸고 싶으면 Integer로 바꾸어 주어야한다. 객체형이기에 가능하다

        ////중요한거 null 이랑""은 다른것이다
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(defaultValue = "guest") String username,@RequestParam(defaultValue = "-1") int age){ //required가 필요 없어지게 된다
        // 빈문자가 들어와도 defaultValue값으로 넘어 오게 된다

        ////중요한거 null 이랑""은 다른것이다
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){ //map에 다 넣어서 사용 할 수도 있다
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    //public String modelAttributeV1(@RequestParam String username, @RequestParam int age){
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        //HelloData helloData = new HelloData();
        //helloData.setUsername(username);
        //helloData.setAge(age);  ---> @ModelAttribute를 사용하면 다 없어져도 된다
        log.info("usename={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("usename={}", helloData);// 두개다 비슷한  --> 이거는 toString으로 나온다
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){ //@ModelAttribute 생략이 가능해진다
        log.info("usename={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("usename={}", helloData);// 두개다 비슷한  --> 이거는 toString으로 나온다
        return "ok";
    }
}
