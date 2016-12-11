package com.ceb.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.ceb.models.EnergyConsumption;
import com.ceb.models.Location;

public class EnergyConsumptionRowMapper implements RowMapper<EnergyConsumption>{
	
	public EnergyConsumption mapRow(ResultSet rs, int rowNum) throws SQLException {
		EnergyConsumption e=new EnergyConsumption();
		Location l=new Location();
		l.setLocationID(rs.getInt("locationID"));
		e.setLocationID(l);
		e.setUsage(rs.getInt("energyUsage"));
		return e;
	}
	
}
