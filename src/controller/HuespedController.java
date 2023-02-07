package controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import dao.HuespedDAO;
import factory.ConnectionFactory;
import modelo.Huesped;

public class HuespedController {

private HuespedDAO huespedDAO;
	
	public HuespedController() {
		Connection connection = new ConnectionFactory().recuperarConexion();
		this.huespedDAO = new HuespedDAO(connection);
	}
	
	public void guardar (Huesped huesped) {
		this.huespedDAO.guardar(huesped);
	}
	
	public List<Huesped> buscar(){
		return this.huespedDAO.buscar();
	}
	
	public List<Huesped> buscarPorIdReserva(String id) {
		return this.huespedDAO.buscarPorIdReserva(id);
	}
	
	public List<Huesped> buscarPorApellido(String apellido) {
		return this.huespedDAO.buscarPorApellido(apellido);
	}
	

	public void actualizar (Integer id, String nombre, String apellido, Date fechaNacimineto, String nacionalidad, String telefono, String idReserva) {
		this.huespedDAO.actualizar(id, nombre, apellido, fechaNacimineto, nacionalidad, telefono, idReserva);
	}
	
	public void eliminar(Integer idReserva) {
		this.huespedDAO.eliminar(idReserva);
	}
}
