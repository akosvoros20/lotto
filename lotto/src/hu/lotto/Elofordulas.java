package hu.lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Elofordulas {
	
	private int[] leggyakoribb = new int[3];
	private int gyakoriSzam;
	
	public int[] getLeggyakoribb() {
		return leggyakoribb;
	}

	public void setLeggyakoribb(int[] leggyakoribb) {
		this.leggyakoribb = leggyakoribb;
	}
	

	public int getGyakoriSzam() {
		return gyakoriSzam;
	}

	public void setGyakoriSzam(int gyakoriSzam) {
		this.gyakoriSzam = gyakoriSzam;
	}

	public void elofordulas() {
		Map<Integer, Integer> hm = new HashMap<Integer,Integer>();
		try {
			for(int num : Sorsolas.getKihuzottSzamok()) {
				 Integer j = hm.get(num);
				 hm.put(num, (j == null) ? 1 : j + 1);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 for (int i=0; i < getGyakoriSzam(); i++) {
			 int max = 0;
			 int key = 0;
			 for (Entry<Integer, Integer> entry : hm.entrySet()) {
				 if (entry.getValue() > max) {
	                    max = entry.getValue();
	                    key = entry.getKey();
				 }
		 }
			 leggyakoribb[i] = key;
			 hm.remove(key);
	}	 	
}

public void kiir() {
	System.out.print("[");
	for(int i=0; i < leggyakoribb.length; i++) {
		System.out.print(leggyakoribb[i]+" ");
	}
	System.out.print("]");
	System.out.println();
}

	
}
