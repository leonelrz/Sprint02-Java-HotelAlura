package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Huesped;

public class HuespedDAO {

	private Connection connection;
		
	public HuespedDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void guardar(Huesped huesped) {
		
		String sql = "INSERT INTO huesped (nombre, apellido, fechanacimiento, nacionalidad, telefono, idreserva)"
				+ "VALUES (?,?,?,?,?,?)";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, huesped.getNombre());
			pstm.setString(2, huesped.getApellido());
			pstm.setDate(3, huesped.getFechaNacimiento());
			pstm.setString(4, huesped.getNacionalidad());
			pstm.setString(5, huesped.getTelefono());
			pstm.setString(6, huesped.getIdReserva());
			
			pstm.executeUpdate();
			
			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while(rst.next()) {
					huesped.setId(rst.getInt(1));
				}
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	public List<Huesped> buscar() {
			
			List<Huesped> huespedes = new ArrayList<>();
			
			try {
				String sql = "SELECT id, nombre, apellido, fechanacimiento, nacionalidad, telefono, idreserva FROM huesped";
				
				try (PreparedStatement pstm = connection.prepareStatement(sql)){
					pstm.execute();
					transformarResultSetEnListaHuesped(huespedes, pstm);
				}
				
				return huespedes;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
	public void transformarResultSetEnListaHuesped(List<Huesped> huespedes, PreparedStatement pstm) throws SQLException{
		try (ResultSet result = pstm.getResultSet()){
			
			while(result.next()) {
				Huesped lineaBase = new Huesped(result.getInt(1), result.getString(2), result.getString(3), result.getDate(4), result.getString(5), result.getString(6), result.getString(7));
				huespedes.add(lineaBase);
			}
		}
	}
	
	public List<Huesped> buscarPorIdReserva(String id) {
		
		List<Huesped> huesped = new ArrayList<>();
		
		try {
			String sql = "SELECT id, nombre, apellido, fechanacimiento, nacionalidad, telefono, idreserva FROM huesped WHERE idreserva = ?";
			
			try (PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.setString(1, id);
				pstm.execute();
				transformarResultSetEnListaHuesped(huesped, pstm);
			}
			
			return huesped;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Huesped> buscarPorApellido(String apellido) {
		List<Huesped> huesped = new ArrayList<>();
		
		try {
			String sql = "SELECT id, nombre, apellido, fechanacimiento, nacionalidad, telefono, idreserva FROM huesped WHERE apellido = ?";
			
			try (PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.setString(1, apellido);
				pstm.execute();
				transformarResultSetEnListaHuesped(huesped, pstm);
			}
			
			return huesped;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void actualizar(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, String idReserva) {
			
			String sql = "UPDATE huespedes SET nombre = ?, apellido = ?, fechanacimiento = ?, nacionalidad = ?, telefono = ?, idreserva= ?  WHERE id = ?";
			try (PreparedStatement pstm = connection.prepareStatement(sql)){
				
				pstm.setString(1, nombre);
				pstm.setString(2, apellido);
				pstm.setDate(3, fechaNacimiento);
				pstm.setString(4, nacionalidad);
				pstm.setString(5, telefono);
				pstm.setString(6, idReserva);
				pstm.setInt(7, id);
				pstm.execute();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	
	public void eliminar(Integer idReserva) {
		
		String sql = "DELETE reservas, huesped FROM huesped JOIN reservas ON huesped.idreserva = Reservas.id WHERE huesped.idreserva = ?";
		try (PreparedStatement pstm = connection.prepareStatement(sql)){
			
			pstm.setInt(1, idReserva);
			pstm.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
