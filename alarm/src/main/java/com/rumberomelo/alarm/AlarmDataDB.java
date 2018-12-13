package com.rumberomelo.alarm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rumberomelo.Alarm;
import com.rumberomelo.arq.accessdata.DataSourceBean;
@Component
public class AlarmDataDB  implements IAlarmNoCache {
	
	@Autowired
	protected DataSourceBean dataSource;

	
	public Set<Alarm> findAlarms(String patern) {

		System.out.println("por base de datos");
		Set<Alarm> found = new HashSet<Alarm>();
		try {

			Connection conn = dataSource.getDataSource().getConnection();
			Date ini = new Date();
			PreparedStatement query = conn
					.prepareStatement("select * from EQ_ALARM_TYPE_LANG where DESCRIPTION like '%" + patern + "%' and rownum < 15");

			ResultSet rs = query.executeQuery();
			int i = 0;
			while (rs.next()) {
				String userid = rs.getString("LANGUAGE_ID");
				String username = rs.getString("ALARM_TYPE_NAME");
				String des = rs.getString("DESCRIPTION");

				found.add(new Alarm(i, userid, username, des));
				i++;
			}
			Date end = new Date();
			System.out.println("tarda " + (end.getTime() - ini.getTime()) + " " + i);
			
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return found;
	}


}
