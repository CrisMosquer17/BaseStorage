package com.InpetelCloud.Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prueba {

	public Prueba() {

	}

	public void log(String data) {
		try {
			//Ruta para trabajar local
			//String ruta = "C:\\Basestorage\\logs\\LogBS[" + fechaActual() + "].txt";
			//Ruta aws /home/ubuntu/environment/BaseStorage/logs
			String ruta = "/home/ubuntu/environment/BaseStorage/logs/logsBS[" + fechaActual() + "].txt";

			File archivo = new File(ruta);

			BufferedWriter bw;
			if (archivo.exists()) {
				bw = new BufferedWriter(new FileWriter(archivo, true));
				bw.write("[" + fechaActual() + " " + horaActual() + "] " + data);
				bw.newLine();
				Runtime.getRuntime().gc();
			} else {
				bw = new BufferedWriter(new FileWriter(archivo, true));
				bw.write("[" + fechaActual() + " " + horaActual() + "] " + data);
				bw.newLine();
				Runtime.getRuntime().gc();
			}
			bw.close();
		} catch (Exception e) {

		}
	}

	public String fechaActual() {
		java.util.Date fecha = new Date();
		SimpleDateFormat cDate = new SimpleDateFormat("MM-dd-yyyy");
		String fechaFormateada = cDate.format(fecha);

		return fechaFormateada;
	}

	public String horaActual() {
		java.util.Date fecha = new Date();
		SimpleDateFormat cHora = new SimpleDateFormat("HH:mm:ss:SSS");
		String fechaFormateada = cHora.format(fecha);
		return fechaFormateada;
	}

}
