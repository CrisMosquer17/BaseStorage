package com.InpetelCloud.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.ReportesInterface;
import com.InpetelCloud.Model.Prueba;

@Repository
public class ReportesDao implements ReportesInterface {
	
	@Autowired
	JdbcTemplate template;
	
	private Prueba prueba = new Prueba();


	
	public List<Map<String, Object>> curvaHoraria(String reporte, String serialCnc, String fechaInicio,String horaInicio, String fechaFin
			, String horaFin, String medidores) {
		String fechaI = fechaInicio + " "+ horaInicio;
		String fechaF = fechaFin + " "+ horaFin;

	
		List<Map<String,Object>>view = template.queryForList ("SELECT\r\n"
				+ "M.Serial,\r\n"
				+ "(SUBSTRING(MS.Fecha, 1, 20)) as Fecha,\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '8', MS.Num_val ,NULL)) AS 'BC',\r\n"
				+ "M.Magnitud,\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID='2' , MS.Num_val ,NULL )) AS 'AI',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '3' , MS.Num_val  ,NULL)) AS 'AE',\r\n"
				+ "GROUP_CONCAT(IF(MS.InfoMedidas_ID = '4' , MS.Num_val , NULL)) AS 'R1',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '5' , MS.Num_val , NULL)) AS 'R2',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '6' , MS.Num_val , NULL)) AS 'R3',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '7' , MS.Num_val , NULL )) AS 'R4',\r\n"
				+ "GROUP_CONCAT(IF( MS.IdProfile = '11' , 'Es curva horaria' , NULL )) AS 'Load Profile 1'\r\n"
				+ " fROM  Inpetel_Cloud.Medidor M,\r\n"
				+ " Inpetel_Cloud.InfoMedidas IM,\r\n"
				+ " Inpetel_Cloud.Medidas MS\r\n"
				+ " WHERE\r\n"
				//+ " MS.IdProfile = '11' AND\r\n"
				+ " M.ID = MS.Medidor_ID AND\r\n"
				+ " IM.ID = MS.InfoMedidas_ID AND\r\n"
				+ " MS.Fecha >= '"+ fechaI +"' AND MS.Fecha < '"+ fechaF +"' AND\r\n"
				+ " MS.Medidor_ID IN ("+ medidores +")\r\n"
				+ " GROUP BY M.Serial, MS.Fecha;" );
		
		return view;
	}
	
	
	public List<Map<String, Object>> curvaDiaria(String reporte, String serialCnc, String fechaInicio, String horaInicio, String fechaFin
			, String horaFin,
			String medidores) {
		String fechaI = fechaInicio + " "+ horaInicio;
		String fechaF = fechaFin + " "+ horaFin;
		List<Map<String,Object>>view = template.queryForList ("SELECT\r\n"
				+ "M.Serial,\r\n"
				+ "(SUBSTRING(MS.Fecha, 1, 20)) as Fecha,\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '8', MS.Num_val ,NULL)) AS 'BC',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID='2' , MS.Num_val ,NULL )) AS 'AI',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '3' , MS.Num_val  ,NULL)) AS 'AE',\r\n"
				+ "GROUP_CONCAT(IF(MS.InfoMedidas_ID = '4' , MS.Num_val , NULL)) AS 'R1',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '5' , MS.Num_val , NULL)) AS 'R2',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '6' , MS.Num_val , NULL)) AS 'R3',\r\n"
				+ "GROUP_CONCAT(IF( MS.InfoMedidas_ID = '7' , MS.Num_val , NULL )) AS 'R4',\r\n"
				+ "GROUP_CONCAT(IF( MS.IdProfile = '12' , 'Es curva diaria' , NULL )) AS 'Load Profile 2'\r\n"
				+ "\r\n"
				+ " fROM  Inpetel_Cloud.Medidor M,\r\n"
				+ " Inpetel_Cloud.InfoMedidas IM,\r\n"
				+ " Inpetel_Cloud.Medidas MS\r\n"
				+ " WHERE\r\n"
				//+ " MS.IdProfile = '12' AND\r\n"
				+ " M.ID = MS.Medidor_ID AND\r\n"
				+ " IM.ID = MS.InfoMedidas_ID AND\r\n"
				+ " MS.Fecha >= '"+ fechaI +"' AND MS.Fecha < '"+ fechaF +"' AND\r\n"
				+ " MS.Medidor_ID IN ("+ medidores +")\r\n"
				+ "  GROUP BY M.Serial, MS.Fecha;");
		return view;
	}
	
	

	
	public List<Map<String, Object>> eventoMedidor(String reporte,String serialCnc, String fechaInicio,String horaInicio, String fechaFin
			, String horaFin,
			String medidores) {
		String fechaI = fechaInicio + " "+ horaInicio;
		String fechaF = fechaFin + " "+ horaFin;
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
				+ "EV.Fecha >= '"+ fechaI +"' AND EV.Fecha < '"+ fechaF +"' AND\r\n"
				+ " EV.Medidor_ID IN ("+ medidores +");");
		return view;
	}
	
	public List<Map<String, Object>> eventoConcentrador(String reporte,String serialCnc, String fechaInicio,String horaInicio, String fechaFin
			, String horaFin,
			String medidores) {
		String fechaI = fechaInicio + " "+ horaInicio;
		String fechaF = fechaFin + " "+ horaFin;
		List<Map<String,Object>>view = template.queryForList ("SELECT cnc.Serial AS Serial_Cnc,  (SUBSTRING(EC.Fecha, 1, 20)) as Fecha, Descripcion AS Descripcion_Evento\r\n"
				+ "FROM Inpetel_Cloud.EventoConcentrador EC,\r\n"
				+ "Inpetel_Cloud.InfoEventos IE,\r\n"
				+ "Inpetel_Cloud.Asoc_concen_medidor aso,\r\n"
				+ "Inpetel_Cloud.Concentrador cnc\r\n"
				+ "WHERE\r\n"
				+ "EC.Concentrador_ID = cnc.ID AND\r\n"
				+ "EC.InfoEventos_ID = IE.ID AND\r\n"
				+ "aso.Concentrador_ID = cnc.ID AND\r\n"
				+ "EC.Fecha >='"+ fechaI +"' AND EC.Fecha < '"+ fechaF + "'AND\r\n"
				+ " EC.Concentrador_ID IN ( " + serialCnc + ")\r\n"
				+ "GROUP BY EC.Fecha;\r\n"
				+ ";");
		return view;
	}


	@Override
	public List<Map<String, Object>> reporte(String reporte, String serialCnc, String fechaInicio, String horaInicio, String fechaFin
			, String horaFin,String medidores) {
		
		List<Map<String, Object>> resultado = new ArrayList<Map<String,Object>>();
		
		if(reporte.equals("")) {
			prueba.log("[INFO] El nombre del reporte que esta tratando de mandar esta vacio");
		}
		else {
			if(reporte.equals("CurvaHoraria")) {
				prueba.log("[INFO] Creando reporte de curva horaria");
				resultado = curvaHoraria(reporte, serialCnc, fechaInicio, horaInicio, fechaFin, horaFin, medidores);
			}
			else if(reporte.equals("CurvaDiaria")) {
				prueba.log("[INFO] Creando reporte de curva diaria");
				resultado = curvaDiaria(reporte, serialCnc, fechaInicio, horaInicio, fechaFin, horaFin, medidores);
			}
			else if(reporte.equals("EventosMedidor")) {
				prueba.log("[INFO] Creando reporte de eventos del medidor");
				resultado = eventoMedidor(reporte, serialCnc, fechaInicio, horaInicio, fechaFin, horaFin, medidores);
			}
			else if(reporte.equals("EventosConcentrador")) {
				prueba.log("[INFO] Creando reporte de eventos del concentrador");
				resultado = eventoConcentrador(reporte, serialCnc, fechaInicio, horaInicio, fechaFin, horaFin, medidores);
			}
			else {
				prueba.log("[INFO] El nombre del reporte no coincide con ningun reporte establecido por ahora");

			}
		}
		
		return resultado;
	}

	

}
