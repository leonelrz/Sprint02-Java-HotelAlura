package controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import modelo.Reserva;

public class ReservasController {
	private ReservaDAO reservaDAO;
	
	public ReservasController() {
		Connection connection = new ConnectionFactory().recuperarConexion();
		this.reservaDAO = new ReservaDAO(connection);
	}
	
	public int guardar (Reserva reserva) {
		return this.reservaDAO.guardar(reserva);
	}
	
	public List<Reserva> buscar(){
		return this.reservaDAO.buscar();
	}
	
	public List<Reserva> buscarPorId(String id) {
		return this.reservaDAO.buscarPorId(id);
	}
	
	public List<Reserva> buscarPorApellido(String apellido) {
		return this.reservaDAO.buscarPorApellido(apellido);
	}
	
	public void actualizar(Date fechaEntrada, Date fechaSalida, String valor, String formaPago, Integer id) {
		this.reservaDAO.actualizar(fechaEntrada,fechaSalida,valor,formaPago,id);
		
	}
	
	public void eliminar(Integer id) {
		this.reservaDAO.eliminar(id);
	}

}
