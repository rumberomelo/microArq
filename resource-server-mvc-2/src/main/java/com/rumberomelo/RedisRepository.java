package com.rumberomelo;

import java.util.Map;

public interface RedisRepository {
	
	Map<Object, Object> findAllAlarm();
    
	void addAlarm(Alarm movie);

}
