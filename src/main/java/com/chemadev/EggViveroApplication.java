package com.chemadev;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chemadev.dao.GeneralDAO;
import com.chemadev.model.Cliente;

@SpringBootApplication
public class EggViveroApplication implements CommandLineRunner{
	
	@Autowired
	public GeneralDAO generalDAO; 

	public static void main(String[] args) {
		SpringApplication.run(EggViveroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Cliente> lstClientes = generalDAO.buscarClientes();
		
		for(Cliente cliente: lstClientes) {
			System.out.println(cliente.toString());
		}
		
	}

}
