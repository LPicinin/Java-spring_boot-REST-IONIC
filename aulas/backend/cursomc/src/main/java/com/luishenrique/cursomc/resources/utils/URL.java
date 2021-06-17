package com.luishenrique.cursomc.resources.utils;

import java.util.ArrayList;
import java.util.List;

public class URL
{
	public static List<Integer> decodeIntList(String listaEmString)// item1,item2,item3
	{
		//return Arrays.asList(listaEmString.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		String[] vet = listaEmString.split(",");
		List<Integer> listaInteiros = new ArrayList<>();
		for (String item : vet)
			listaInteiros.add(Integer.parseInt(item));
		return listaInteiros;
	
	}
}
