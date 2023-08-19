package hu.lotto;

import java.util.ArrayList;
import java.util.Random;

public class Sorsolas {
	
	private int huzasSzam;
	private int elemSzam;
	private static ArrayList<Integer> kihuzottSzamok = new ArrayList();
	
	public Sorsolas() {
	}
	
	public int getHuzasSzam() {
		return huzasSzam;
	}
	
	public void setHuzasSzam(int huzasSzam) {
		this.huzasSzam = huzasSzam;
	}
	
	public int getElemSzam() {
		return elemSzam;
	}
	
	public void setElemSzam(int elemSzam) {
		this.elemSzam = elemSzam;
	}
	
	public static ArrayList<Integer> getKihuzottSzamok() {
		return kihuzottSzamok;
	}
	
	public void setKihuzottSzamok(ArrayList<Integer> kihuzottSzamok) {
		this.kihuzottSzamok = kihuzottSzamok;
	}
	
	public void sorsolas() {
		Random random = new Random();
		boolean joSzam = false;
		int elem = 0;
		for (int i = 0; i<getHuzasSzam(); i++) {
			for (int k = 0; k < getElemSzam(); k++) {
				elem = random.nextInt(90)+1;
				kihuzottSzamok.add(elem);
				while(!joSzam){
						if(k>1 && elem == kihuzottSzamok.get(Integer.valueOf(k-1))) {
							kihuzottSzamok.remove(k);
							elem = random.nextInt(90)+1;
							kihuzottSzamok.add(elem);
					} else {
						joSzam = true;
					}
				}
			}
		}
	}

}
