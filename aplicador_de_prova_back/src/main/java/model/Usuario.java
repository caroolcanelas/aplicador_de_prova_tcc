package model;

import java.io.Serializable;

public class Usuario implements Serializable {
	private String conta;
	private long   dataHoraLogin;
	
	public Usuario() {	}

	public Usuario(String conta) {
		this.setConta(conta); 
		this.setDataHoraLogin(System.currentTimeMillis());
	}

	public long getDataHoraLogin() { //pega a data e hora de login do usuario
		return dataHoraLogin; 
	}

	public void setDataHoraLogin(long dataHoraLogin) { //aplica uma data e hora de login do usuario 
		this.dataHoraLogin = dataHoraLogin;
	}

	public String getConta() { //pega a conta do usuario
		return conta;
	}

	public void setConta(String conta) { //aplica uma conta pro usuario (que conta?)
		this.conta = conta;
	}
}
