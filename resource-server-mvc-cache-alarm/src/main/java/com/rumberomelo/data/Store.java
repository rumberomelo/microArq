package com.rumberomelo.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.rumberomelo.alarm.Alarm;
import com.rumberomelo.arq.accessdata.DataSourceBean;

public class Store {
	
	private Set<Alarm> cache = new HashSet<Alarm>();
	
	@Autowired
	private DataSourceBean dataSource;
	
	 public void init() {
		 
		 System.out.println("empieza la carga de cache ");
		 try {
		 Connection conn = dataSource.getDataSource().getConnection();
			Date ini = new Date();
			PreparedStatement query = conn.prepareStatement("select * from EQ_ALARM_TYPE_LANG");
			
			ResultSet rs = query.executeQuery();
			int i = 0;
			while (rs.next()) {
				String userid = rs.getString("LANGUAGE_ID");
				String username = rs.getString("ALARM_TYPE_NAME");
				String des = rs.getString("DESCRIPTION");
				
				cache.add(new Alarm(i, userid, username, des));
				i++;
			}
			Date end = new Date();
			System.out.println("carga completa " + (end.getTime() - ini.getTime())  + " " + i);
		 } catch (Exception e) {
			 System.out.println("fallo la carga " + e);
		}
	 }

	public Set<Alarm> findAlarms(String patern) {
		Set<Alarm> out = new HashSet<Alarm>();
		int i = 0;
		
		for (Alarm action: cache ) {
			if (action.getDescription().contains(patern)) {
				i++;
				out.add(action);
			}
			
			if (i > 20)
				break;
		}
		
		return out;
	}

}
