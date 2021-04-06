package com.InpetelCloud.Model;

import javax.persistence.Id;

public class Macro {

	// ATRIBUTOS
		@Id
		private int id;
		private String idConcentrador;
		private String idMedidor;
		private String idUsuario;
		private String idTrafo;
		private String fechaInicio;
		private String horaInicio;
		private String fechaFin;
		private String horaFin;
//		private String fechaCreate;
//		private String fechaUpdate;
		
		//Constructor vacio
		public Macro() {
			super();
		}

		//Constructor para crear un balance
		public Macro(String idConcentrador,String idMedidor, String idUsuario, String idTrafo, String fechaCreate) {
			super();
			this.idConcentrador = idConcentrador;
			this.idMedidor = idMedidor;
			this.idUsuario = idUsuario;
			this.idTrafo = idTrafo;
//			this.fechaCreate = fechaCreate;
		}
		
		//Constructor para actualizar un balance(no se usa el id)
		public Macro(int id,String idConcentrador,String idMedidor, String idUsuario, String idTrafo, String fechaUpdate) {
			super();
			this.idConcentrador = idConcentrador;
			this.idMedidor = idMedidor;
			this.idUsuario = idUsuario;
			this.idTrafo = idTrafo;
//			this.fechaUpdate = fechaUpdate;
		}
		
		

		public String getIdConcentrador() {
			return idConcentrador;
		}

		public void setIdConcentrador(String idConcentrador) {
			this.idConcentrador = idConcentrador;
		}

		public String getIdMedidor() {
			return idMedidor;
		}

		public void setIdMedidor(String idMedidor) {
			this.idMedidor = idMedidor;
		}

		public String getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(String idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getIdTrafo() {
			return idTrafo;
		}

		public void setIdTrafo(String idTrafo) {
			this.idTrafo = idTrafo;
		}

		public String getFechaInicio() {
			return fechaInicio;
		}

		public void setFechaInicio(String fechaInicio) {
			this.fechaInicio = fechaInicio;
		}

		public String getHoraInicio() {
			return horaInicio;
		}

		public void setHoraInicio(String horaInicio) {
			this.horaInicio = horaInicio;
		}

		public String getFechaFin() {
			return fechaFin;
		}

		public void setFechaFin(String fechaFin) {
			this.fechaFin = fechaFin;
		}

		public String getHoraFin() {
			return horaFin;
		}

		public void setHoraFin(String horaFin) {
			this.horaFin = horaFin;
		}
		
		

//		public String getFechaCreate() {
//			return fechaCreate;
//		}
//
//		public void setFechaCreate(String fechaCreate) {
//			this.fechaCreate = fechaCreate;
//		}
//
//		public String getFechaUpdate() {
//			return fechaUpdate;
//		}
//
//		public void setFechaUpdate(String fechaUpdate) {
//			this.fechaUpdate = fechaUpdate;
//		}
		
		
}