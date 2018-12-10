package com.rumberomelo.web;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rumberomelo.alarm.Alarm;
import com.rumberomelo.data.Store;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class HelloController {
	
	
	
	
	@Autowired
	private Store store;

	@RequestMapping("/alarmsByDescription/{patern}")
    public Set<Alarm> findAlarms(@PathVariable("patern") String patern) {
		
		long a1 = System.currentTimeMillis();
		Set<Alarm> out = store.findAlarms(patern);
		long a2 = System.currentTimeMillis();
		System.out.println("tarda para " + out.size() + " " + (a2-a1));
		
		return out;
    }

  //  @PreAuthorize("#oauth2.hasScope('fooScope') and hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "secret", method = RequestMethod.GET)
    @ResponseBody
    public String helloSecret(Principal principal) {
        return principal == null ? "Hello anonymous" : "S3CR3T  - Hello " + principal.getName();
    }
}