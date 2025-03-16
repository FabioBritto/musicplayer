package br.com.fabiobritto.musicplayer.model.enums;

public enum Estilo {

	POP(1),
	GOSPEL(2),
	ROCK(3),
	CLASSICO(4),
	SERTANEJO(5),
	COUNTRY(6);

	private int value;
	
	Estilo(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static Estilo valueOf(int value) {
		for(Estilo e : Estilo.values()) {
			if(e.getValue() == value) {
				return e;
			}
		}
		throw new IllegalArgumentException("Valor inválido");
	}
}
