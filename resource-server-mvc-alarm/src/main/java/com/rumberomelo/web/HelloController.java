package com.rumberomelo.web;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rumberomelo.alarm.Alarm;
import com.rumberomelo.alarm.AlarmDataManager;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class HelloController {
	
	@Autowired
	private AlarmDataManager clientCache;
	


	@RequestMapping("/alarmsByDescription/{patern}" )
    public Set<Alarm> findAlarms(@PathVariable("patern") String patern) {
		

		Set<Alarm> out = clientCache.getInterface("resource-server-mvc-cache-alarm").findAlarms(patern);
				System.out.println("se acabo");
		return out;
	
		

    }

    @PreAuthorize("#oauth2.hasScope('fooScope') and hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "secret", method = RequestMethod.GET)
    @ResponseBody
    public String helloSecret(Principal principal) {
        return principal == null ? "Hello anonymous" : "S3CR3T  - Hello " + principal.getName();
    }
}