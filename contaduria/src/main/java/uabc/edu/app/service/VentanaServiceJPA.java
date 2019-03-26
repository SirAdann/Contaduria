package uabc.edu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.edu.app.model.Documento;
import uabc.edu.app.model.Ventana;
import uabc.edu.app.repository.VentanaRepository;

@Service
public class VentanaServiceJPA implements IVentanaService {
	
	@Autowired
	VentanaRepository ventanaRepository;

	@Override
	public List<Ventana> buscarTodas() {
		List<Ventana> lista = ventanaRepository.findAll();
		return lista;
	}
	
	//@Override
	//public Ventana buscarPorId(int id_ventana) {
		// TODO Auto-generated method stub
	//	return null;
	

}
