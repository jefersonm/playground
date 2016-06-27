package com.ilegra.horas.pojo;

public class Atividade {

	private String data;
	private String desc;
	
	public Atividade(String data, String desc) {
		super();
		this.data = data;
		this.desc = desc;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
