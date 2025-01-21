package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//
// DAO - Data Access Object
//
public class DaoEmpregado {

	private static Map<Integer, Empregado> conjEmpregados = new HashMap<Integer, Empregado>();

	public void incluirEmpregado(Empregado d) {
		conjEmpregados.put(d.getId(), d);
	}
	
	public Collection<Empregado> obterEmpregados() {
		return conjEmpregados.values();
	}
	
	public Empregado obterEmpregado(int id) {
		return conjEmpregados.get(id);
	}
	
	public Empregado alterarEmpregado(Empregado d) {
		return d;
	}
	
	public Empregado removerEmpregado(Empregado d) {
		return conjEmpregados.remove(d.getId());
	}
}
