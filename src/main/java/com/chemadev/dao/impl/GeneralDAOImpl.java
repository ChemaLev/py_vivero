package com.chemadev.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.chemadev.dao.GeneralDAO;
import com.chemadev.model.Cliente;

@Repository
public class GeneralDAOImpl implements GeneralDAO{
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;

	@Override
	public List<Cliente> buscarClientes() {
		
		String sql = "SELECT * FROM cliente";
		
		List<Cliente> lstClientes = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(url,username,password);
			 Statement stm = con.createStatement()){
			
			ResultSet result = stm.executeQuery(sql);
			
			while(result.next()) {

				Cliente cli = new Cliente();
				
				cli.setIdCliente(result.getInt("id_cliente"));
				cli.setCodCliente(result.getInt("codigo_cliente"));
				cli.setNomCliente(result.getString("nombre_cliente"));
				cli.setNomContacto(result.getString("nombre_contacto"));
				cli.setTelefono(result.getString("telefono"));
				cli.setFax(result.getString("fax"));
				cli.setCiudad(result.getString("ciudad"));
				cli.setRegion(result.getString("region"));
				cli.setPais(result.getString("pais"));
				cli.setCodPostal(result.getString("codigo_postal"));
				cli.setIdEmpl(result.getInt("id_empleado"));
				cli.setLimitCred(result.getDouble("limite_credito"));
				
				lstClientes.add(cli);
			}
			
			result.close();
			stm.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lstClientes;
	}

	
	
}
