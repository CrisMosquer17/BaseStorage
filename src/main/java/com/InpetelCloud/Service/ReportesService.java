package com.InpetelCloud.Service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InpetelCloud.Dao.ReportesDao;
import com.InpetelCloud.Interfaces.ReportesInterface;

@Service
public class ReportesService implements ReportesInterface {
	
	@Autowired
	ReportesDao dao;
	
    private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public List<Map<String, Object>> reporte(String reporte, String serialCnc, String fechaInicio,String horaInicio, String fechaFin
			, String horaFin, String medidores) {
		return dao.reporte(reporte, serialCnc, fechaInicio, horaInicio, fechaFin, horaFin, medidores);
	}

//	@Override
//	public List<Map<String, Object>> curvaHoraria(String reporte, String fechaInicio, String fechaFin, String medidores) {
//		return dao.curvaHoraria(reporte, fechaInicio, fechaFin, medidores);
//	}
//	
//	@Override
//	public List<Map<String, Object>> curvaDiaria(String reporte, String fechaInicio, String fechaFin,
//			String medidores) {
//		return dao.curvaDiaria(reporte, fechaInicio, fechaFin, medidores);
//	}         
//
//	@Override
//	public List<Map<String, Object>> eventoMedidor(String reporte, String fechaInicio, String fechaFin, String medidores) {
//		return dao.eventoMedidor(reporte, fechaInicio, fechaFin, medidores);
//	}

	


}
