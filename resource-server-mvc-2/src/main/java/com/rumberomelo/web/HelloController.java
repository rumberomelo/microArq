package com.rumberomelo.web;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumberomelo.Alarm;
import com.rumberomelo.RedisRepository;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequestMapping("/")
public class HelloController {
	

	@Autowired
    private RedisRepository redisRepository;
	

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld(Principal principal) {
    	
    	
		
		Map<Object, Object> a = redisRepository.findAllAlarm();
    	
        return principal == null ? "Hello anonymous" : "Hello " + principal.getName();
    }

    @PreAuthorize("#oauth2.hasScope('fooScope') and hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "secret", method = RequestMethod.GET)
    @ResponseBody
    public String helloSecret(Principal principal) {
        return principal == null ? "Hello anonymous" : "S3CR3T  - Hello " + principal.getName();
    }
}