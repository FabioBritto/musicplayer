package br.com.fabiobritto.musicplayer.dao;

import java.util.List;

public interface GenericDAO {

	public void create(Object o);
	/*
	 * No caso do READ, se eu passo NULL como parâmetro, é o equivalente a um SELECT *
	 * Por outro lado, quando eu passo um objeto, é como se eu passasse um OBJETO INCOMPLETO
	 * Então, ele me retorna a lista dos objetos que atendem aos requisitos
	 */
	public List<Object> read(Object o);
	public void update(Object o);
	public void delete(Object o);
}
