package com.rumberomelo;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
	
	
	private Set<Alarm> cache = new HashSet<Alarm>();
	
    private static final String KEY = "1";
    private RedisTemplate<String, Object> redisTemplate;
    private SetOperations<String, Object> hashOperations ;
    
    String [] todos = {"18,CONF_PKG_USER_ERROR,CONF_PKG_USER_ERROR",
	"1,No Communication,No Communication",
	"1,CONF_PKG_SECURITY_LIST_ERROR,CONF_PKG_SECURITY_LIST_ERROR",
	"1,CONF_PKG_PARAM_ERROR,CONF_PKG_PARAM_ERROR",
	"1,CONF_PKG_TOPOLOGY_ERROR,CONF_PKG_TOPOLOGY_ERROR",
	"1,CONF_PKG_USER_ERROR,CONF_PKG_USER_ERROR",
	"1,CONF_PKG_FARE_ERROR,CONF_PKG_FARE_ERROR",
	"1,CONF_PKG_AGENCY_ERROR,CONF_PKG_AGENCY_ERROR",
	"1,CONF_PKG_CONF_ERROR,CONF_PKG_CONF_ERROR",
	"1,CONF_PKG_ACTION_LIST_ERROR,CONF_PKG_ACTION_LIST_ERROR",
	"1,CONF_PKG_SAM_KEY_SET_ERROR,CONF_PKG_SAM_KEY_SET_ERROR",
	"1,CONF_PKG_SAM_KEYS_ERROR,CONF_PKG_SAM_KEYS_ERROR",
	"1,Insufficient disk space,Insufficient disk space",
	"1,On Battery,On Battery",
	"1,On Alarm,On Alarm",
	"1,Not communication,Not communication",
	"1,Emergency button,emergency button",
	"1,Photocells failure,Photocells failure",
	"1,Maintenace door open,Maintenace door open",
	"1,Not communication,Not communication",
	"1,BANKNOTE SYSTEM CASHBOX NOT PPRESENT,BANKNOTE SYSTEM CASHBOX NOT PPRESENT",
	"1,BANKNOTE SYSTEM LOADER EMPTY,BANKNOTE SYSTEM LOADER EMPTY",
	"1,BANKNOTE BOX EXTRACTED WITHOUT AUTHORIATION,BANKNOTE BOX EXTRACTED WITHOUT AUTHORIATION",
	"1,BANKNOTE BOX ALMOST FULL,BANKNOTE BOX ALMOST FULL",
	"1,BANKNOTE BOX FULL,BANKNOTE BOX FULL",
	"1,BANKNOTE SYSTEM COMMUNICATIONS FAILURE,BANKNOTE SYSTEM COMMUNICATIONS FAILURE",
	"1,BANKNOTE SYSTEM OUT OF SERVICE,BANKNOTE SYSTEM OUT OF SERVICE",
	"1,BANKNOTE BOX FULL OR WRONGLY INSERTED,BANKNOTE BOX FULL OR WRONGLY INSERTED",
	"1,BANK CARD SYSTEM IS NOT OPERATIVE TO ACCEPT BANK CARDS,BANK CARD SYSTEM IS NOT OPERATIVE TO ACCEPT BANK CARDS",
	"1,THERE IS NO COMMUNICATION WITH BANK PAYMENT GATEWAY,THERE IS NO COMMUNICATION WITH BANK PAYMENT GATEWAY",
	"1,COMMUNICATION ERROR IN CONTACTLESS CARD RECHARGING,COMMUNICATION ERROR IN CONTACTLESS CARD RECHARGING",
	"1,CONTACTLESS CARD RECHARGING ERROR,CONTACTLESS CARD RECHARGING ERROR",
	"1,CTL RELOAD SAM NOT PRESENT,CTL RELOAD SAM NOT PRESENT",
	"1,CTL RELOAD SAM NOT WORK,CTL RELOAD SAM NOT WORK",
	"1,I/O CARD NOT COMMUNICATION,I/O CARD NOT COMMUNICATION",
	"1,I/O CARD NOT WORK,I/O CARD NOT WORK",
	"1,LOGICAL 24V DOWN,LOGICAL 24V DOWN",
	"1,OUT OF SERVICE,OUT OF SERVICE",
	"1,THERMICAL PRINTER NOT COMMUNICATION,THERMICAL PRINTER NOT COMMUNICATION",
	"1,THERMICAL PRINTER JAMMED,THERMICAL PRINTER JAMMED",
	"1,THERMICAL PRINTER PAPER NEAR END,THERMICAL PRINTER PAPER NEAR END",
	"1,RECEIPT PRINTER WITHOUT PAPER,RECEIPT PRINTER WITHOUT PAPER",
	"1,Not SAM Found,Not SAM Found",
	"1,POWER FAILURE,POWER FAILURE",
	"1,SAM error ,SAM error",
	"1,Not communication,Not communication",
	"1,HIGH TEMPERATURE,HIGH TEMPERATURE",
	"1,BANKNOTE JAMMED,BANKNOTE JAMMED",
	"1,CARD DISPENSER INOPERATIVE,CARD DISPENSER INOPERATIVE",
	"1,COMMUNICATION ERROR OF THE CARD DISPENSER,COMMUNICATION ERROR OF THE CARD DISPENSER",
	"1,STACKER EMPTY,STACKER EMPTY",
	"1,Not SAM Found,Not SAM Found",
	"18,CONF_PKG_FARE_ERROR,CONF_PKG_FARE_ERROR",
	"18,CONF_PKG_AGENCY_ERROR,CONF_PKG_AGENCY_ERROR",
	"18,CONF_PKG_CONF_ERROR,CONF_PKG_CONF_ERROR",
	"18,CONF_PKG_ACTION_LIST_ERROR,CONF_PKG_ACTION_LIST_ERROR",
	"18,CONF_PKG_SAM_KEY_SET_ERROR,CONF_PKG_SAM_KEY_SET_ERROR",
	"1,POWER FAULT,POWER FAULT",
	"1,POWER RESTORED,POWER RESTORED",
	"1,LOW BATERY,LOW BATERY",
	"1,EXPIRED BATTERY TIME. SHUTDOWN IN PROCCESS,EXPIRED BATTERY TIME. SHUTDOWN IN PROCCESS",
	"1,COMMUNICATION LOST,COMMUNICATION LOST",
	"1,COMMUNICATION RESTORED,COMMUNICATION RESTORED",
	"1,POWER FAULT,POWER FAULT",
	"1,POWER RESTORED,POWER RESTORED",
	"1,LOW BATERY,LOW BATERY",
	"1,EXPIRED BATTERY TIME. SHUTDOWN IN PROCCESS,EXPIRED BATTERY TIME. SHUTDOWN IN PROCCESS",
	"1,Time for checking configuration update exceeded,Time for checking configuration update exceeded",
	"1,Low space remaining for record storage,Low space remaining for record storage",
	"1,Configuration not available to boot,Configuration not available to boot",
	"1,SAM not detected,SAM not detected",
	"1,SAM unrecognized,SAM unrecognized",
	"1,Not enough space to store more records,Not enough space to store more records",
	"1,Not Found,Not Found",
	"1,Open,Open",
	"1,DISK WITH CORRUPT ERRORS OK,DISK WITH CORRUPT ERRORS OK",
	"1,Not Found,Not Found",
	"1,Open,Open",
	"1,REBOOTING IN PROGRESS,REBOOTING IN PROGRESS",
	"1,REBOOTING FINISHED,REBOOTING FINISHED",
	"18,Configuration not available to boot,Configuration not available to boot",
	"18,SAM not detected,SAM not detected",
	"18,SAM unrecognized,SAM unrecognized",
	"18,Not enough space to store more records,Not enough space to store more records",
	"18,Not Found,Not Found",
	"18,Open,Open",
	"1,DOWNLOAD ERROR,DOWNLOAD ERROR",
	"18,Not Found,Not Found",
	"18,Open,Open",
	"18,BANKNOTE SYSTEM CASHBOX NOT PPRESENT,BANKNOTE SYSTEM CASHBOX NOT PPRESENT",
	"18,BANKNOTE SYSTEM LOADER EMPTY,BANKNOTE SYSTEM LOADER EMPTY",
	"18,BANKNOTE BOX EXTRACTED WITHOUT AUTHORIATION,BANKNOTE BOX EXTRACTED WITHOUT AUTHORIATION",
	"18,BANKNOTE BOX ALMOST FULL,BANKNOTE BOX ALMOST FULL",
	"18,BANKNOTE BOX FULL,BANKNOTE BOX FULL",
	"18,BANKNOTE SYSTEM COMMUNICATIONS FAILURE,BANKNOTE SYSTEM COMMUNICATIONS FAILURE",
	"18,BANKNOTE SYSTEM OUT OF SERVICE,BANKNOTE SYSTEM OUT OF SERVICE",
	"18,BANKNOTE BOX FULL OR WRONGLY INSERTED,BANKNOTE BOX FULL OR WRONGLY INSERTED",
	"18,BANK CARD SYSTEM IS NOT OPERATIVE TO ACCEPT BANK CARDS,BANK CARD SYSTEM IS NOT OPERATIVE TO ACCEPT BANK CARDS",
	"18,BANK CARD SYSTEM DOES NOT RESPOND TO APPLICATION COMMANDS,BANK CARD SYSTEM DOES NOT RESPOND TO APPLICATION COMMANDS",
	"18,THERE IS NO COMMUNICATION WITH BANK PAYMENT GATEWAY,THERE IS NO COMMUNICATION WITH BANK PAYMENT GATEWAY"}; 

    
    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    @PostConstruct
    private void init(){
    	//valueOperation = redisTemplate.opsForValue();
    	
    	
    	
        hashOperations = redisTemplate.opsForSet();
        
        
    
        
        
    }
    public void addAlarm(final Alarm movie) {

    	for (Integer i = 0 ; i <1104100; i++)		
		{
			
			 String[] count = todos[i % todos.length].split(",");
			
			System.out.println("son " + count);
		
			hashOperations.add(i + "", count[0], count[1],count[2]);
			
			cache.add(new Alarm(i, count[0], count[1],count[2]));
			System.out.println("-->" + i);
		}
    	
    	
      System.out.println("oki");
    }
   
    public Map<Object, Object> findAllAlarm(){
    	
    	if (cache.size()== 0)
    		addAlarm(null); 
    
    	Set<Alarm> found = new HashSet<Alarm>();
    	long a1 = System.currentTimeMillis();
    	for (Alarm current:cache)		
		{
			if (current.getDescription().contains("_U"))
				found.add(current);
		}
    	
    	long a2 = System.currentTimeMillis();
    	
    	 System.out.println("oki -->" + found.size() + " " + (a2 -a1));
		return null;
    }
}