package com.rumberomelo.alarm;

import java.util.Set;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rumberomelo.Alarm;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@FeignClient(name = "resource-server-mvc-cache-alarm")
public interface IAlarmCache extends IAlarm{
	
	@RequestMapping("/alarmsByDescription/{patern}")
    public Set<Alarm> findAlarms(@PathVariable("patern") String patern) ;

}
