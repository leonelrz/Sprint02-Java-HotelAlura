package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Reserva;

public class ReservaDAO {
	
	private Connection connection;
	
	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public int guardar (Reserva reserva) {
		
		int idReserva = 0;
		
		try {
			String sql = "INSERT INTO reservas (fecha_entrada, fecha_salida, valor, forma_pago)"
					+ "VALUES (?, ?, ?, ?)";
			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				
				pstm.setDate(1, reserva.getFechaEntrada());
				pstm.setDate(2, reserva.getFechaSalida());
				pstm.setString(3, reserva.getValor());
				pstm.setString(4, reserva.getFormaPago());
				
				pstm.executeUpdate();	
				
				ResultSet result = pstm.getGeneratedKeys();
				
				try (result) {
					while(result.next()) {
						reserva.setId(result.getInt(1));
						idReserva = result.getInt(1);
					}
				}
			
		}
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return idReserva;
		}
	
		
		public List<Reserva> buscar(){
			List<Reserva> reservas = new ArrayList<>();
			
			try {
				String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_pago FROM reservas";
				
				try (PreparedStatement pstm = connection.prepareStatement(sql)) {
					pstm.execute();
					transformarResultSetEnReserva(reservas, pstm);
				}
				
				return reservas;
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void transformarResultSetEnReserva(List<Reserva> reservas, PreparedStatement pstm) throws SQLException {
			try (ResultSet result = pstm.getResultSet()){
				while (result.next()) {
					Reserva lineaBase = new Reserva(result.getInt(1), result.getDate(2), result.getDate(3), result.getString(4), result.getString(5));
					reservas.add(lineaBase);
				}
			}
		}
		
		public List<Reserva> buscarPorId (String id) {
			
			List<Reserva> reservaPorId = new ArrayList<>();
			
			try {
				String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_pago FROM reservas WHERE id = ?";
				
				try (PreparedStatement pstm = connection.prepareStatement(sql)){
					pstm.setString(1, id);
					pstm.execute();
					
					transformarResultSetEnReserva(reservaPorId, pstm);
				}
				return reservaPorId;
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		
		public List<Reserva> buscarPorApellido(String apellido) {
			
			List<Reserva> reservaPorApellido = new ArrayList<>();
			
			try {
				String sql = "SELECT R.id, R.fecha_entrada, R.fecha_salida, R.valor, R.forma_pago, H.idreserva FROM reservas R "
						+ "LEFT JOIN huespedes H "
						+ "ON R.id = H.idreserva "
						+ "WHERE apellido = ?";
				
				try (PreparedStatement pstm = connection.prepareStatement(sql)){
					pstm.setString(1, apellido);
					pstm.execute();
					
					transformarResultSetEnReserva(reservaPorApellido, pstm);
				}
				return reservaPorApellido;
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		

		public void actualizar(Date fechaEntrada, Date fechaSalida, String valor, String formaPago, Integer id) {
			
			String sql = "UPDATE reservas SET fecha_entrada = ?, fecha_salida = ?, valor = ?, forma_pago = ? WHERE id = ?";
			try (PreparedStatement pstm = connection.prepareStatement(sql)){
				
				pstm.setDate(1, fechaEntrada);
				pstm.setDate(2, fechaSalida);
				pstm.setString(3, valor);
				pstm.setString(4, formaPago);
				pstm.setInt(5, id);
				pstm.execute();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
		
		public void eliminar(Integer id) {
			
			String sql = "DELETE reservas, huesped FROM huesped JOIN reservas ON reservas.id = huesped.idreserva WHERE reservas.id = ?";
			try (PreparedStatement pstm = connection.prepareStatement(sql)){
				
				pstm.setInt(1, id);
				pstm.execute();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
		
}


