package com.InpetelCloud.Interfaces;

import java.util.List;
import java.util.Map;

public interface ReportesInterface {
	
	//1 concentrador, 1 medidor
	List<Map<String, Object>> curvaHoraria(String reporte,String fechaInicio, String fechaFin
			, String medidores);
	
	List<Map<String, Object>> eventoMedidor(String reporte,String fechaInicio, String fechaFin
			, String medidores);

}
