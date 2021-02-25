package com.InpetelCloud.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.ReportesInterface;

@Repository
public class ReportesDao implements ReportesInterface {
	
	@Autowired
	JdbcTemplate template;

	@Override
	public List<Map<String, Object>> curvaHoraria(String reporte, String fechaInicio, String fechaFin, String medidores) {
		System.out.println(fechaInicio);
		System.out.println(fechaFin);
		System.out.println(medidores);
		//medidores= medidores.replaceAll("[]","");


		List<Map<String,Object>>view = template.queryForList ("SELECT\r\n"
				+ "M.Serial,\r\n"
				+ "(SUBSTRING(MS.Fecha, 1, 20)) as Fecha,\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '8', MS.Num_val ,NULL)) AS 'BC',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID='2' , MS.Num_val ,NULL )) AS 'AE',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '3' , MS.Num_val  ,NULL)) AS 'AE',\r\n"
				+ "GROUP_CONCAT(IF(MS.InfoMedidas_ID = '4' , MS.Num_val , NULL)) AS 'R1',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '5' , MS.Num_val , NULL)) AS 'R2',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '6' , MS.Num_val , NULL)) AS 'R3',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '7' , MS.Num_val , NULL )) AS 'R4',\r\n"
				+ "GROUP_CONCAT(IF( MS.IdProfile = '11' , 'Es curva diaria' , NULL )) AS 'Load Profile 1'\r\n"
				+ " fROM  Inpetel_Cloud.Medidor M,\r\n"
				+ " Inpetel_Cloud.InfoMedidas IM,\r\n"
				+ " Inpetel_Cloud.Medidas MS\r\n"
				+ " WHERE\r\n"
				+ " M.ID = MS.Medidor_ID AND\r\n"
				+ " IM.ID = MS.InfoMedidas_ID AND\r\n"
				+ " MS.Fecha >= '"+ fechaInicio +"' AND MS.Fecha < '"+ fechaFin +"' AND\r\n"
				+ " MS.Medidor_ID IN ("+ medidores +")\r\n"
				+ " GROUP BY M.Serial, MS.Fecha;" );
		return view;
	}

	@Override
	public List<Map<String, Object>> eventoMedidor(String reporte, String fechaInicio, String fechaFin,
			String medidores) {
		List<Map<String,Object>>view = template.queryForList ("SELECT CNC.Serial AS Serial_Cnc, M.Serial AS Serial_Met,  (SUBSTRING(EV.Fecha, 1, 20)) as Fecha, Descripcion AS Descripcion_Evento\r\n"
				+ "FROM Inpetel_Cloud.EventoMedidor EV,\r\n"
				+ "Inpetel_Cloud.Medidor M,\r\n"
				+ "Inpetel_Cloud.Asoc_concen_medidor ASO,\r\n"
				+ "Inpetel_Cloud.Concentrador CNC,\r\n"
				+ "Inpetel_Cloud.InfoEventos IE\r\n"
				+ "WHERE\r\n"
				+ "EV.Medidor_ID = M.ID AND\r\n"
				+ "EV.InfoEventos_ID = IE.ID AND\r\n"
				+ "ASO.Medidor_ID = M.ID AND\r\n"
				+ "ASO.Concentrador_ID = CNC.ID AND\r\n"
				+ "EV.Fecha >= '"+ fechaInicio +"' AND EV.Fecha < '"+ fechaFin +"' AND\r\n"
				+ " EV.Medidor_ID IN ("+ medidores +");");
		return view;
	}

}
