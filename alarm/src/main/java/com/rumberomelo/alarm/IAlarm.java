package com.rumberomelo.alarm;

import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;

public interface IAlarm {
	public Set<Alarm> findAlarms(@PathVariable("patern") String patern) ;

}
