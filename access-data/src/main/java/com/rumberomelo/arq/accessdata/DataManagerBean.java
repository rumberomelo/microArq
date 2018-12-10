package com.rumberomelo.arq.accessdata;

import org.springframework.beans.factory.annotation.Autowired;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.shared.Application;


public class DataManagerBean<T, K extends T,  E extends T> {
	


	@Autowired
	E interfaceDataManeger;
	
	@Autowired
	K interfaceAlternative;	
	
	public T getInterface(String nameArternative) {
		
		DiscoveryClient client = DiscoveryManager.getInstance().getDiscoveryClient();
		
		 Application all = client.getApplication(nameArternative);
System.out.println("hay vamos");
   	
   	if (all == null || all.getInstances() == null || all.getInstances().size() == 0) {
   		
   		return interfaceDataManeger;
   	}else
   		return interfaceAlternative;
		
	}
}
