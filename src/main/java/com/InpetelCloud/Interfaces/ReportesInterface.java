package com.InpetelCloud.Interfaces;

import java.util.List;
import java.util.Map;

public interface ReportesInterface {
	
//	List<Map<String, Object>> curvaHoraria(String reporte,String fechaInicio, String fechaFin
//			, String medidores);
//	
//	List<Map<String, Object>> curvaDiaria(String reporte,String fechaInicio, String fechaFin
//			, String medidores);
//	
//	List<Map<String, Object>> eventoMedidor(String reporte,String fechaInicio, String fechaFin
//			, String medidores);
	
	List<Map<String, Object>> reporte(String reporte, String serialCnc, String fechaInicio, String fechaFin
			, String medidores);

}
