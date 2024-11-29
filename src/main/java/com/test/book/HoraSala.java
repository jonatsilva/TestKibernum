package com.test.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HoraSala {

	public static void main(String[] args) {

		Integer[][] EntadaSalida = { { 0, 5, 15 }, { 15, 10, 20 } };
		// int[] Salida = {30, 10, 20};

		cantidadSalas(EntadaSalida);

	}

	private static int cantidadSalas(Integer[][] entadaSalida) {
		// TODO Auto-generated method stub

		List<Integer> inicio = new ArrayList<>();
		List<Integer> fin = new ArrayList<>();

		for (Integer[] salas : entadaSalida) {
			inicio.add(salas[0]);
			fin.add(salas[1]);
		}

		Collections.sort(inicio);
		Collections.sort(fin);

		int p = 0;
		int disponibles = 0;

		for (int i = 0; i < inicio.size(); i++) {
			if (inicio.get(i) < fin.get(p)) {
				disponibles++;
			} else {
				p++;
			}
		}

		System.out.println("sala disponible " + disponibles);
		return disponibles;

	}

}
