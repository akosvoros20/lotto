package hu.lotto;

import java.util.Scanner;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Menu {
	
	private String menuValaszto;
	

	public String getMenuValaszto() {
		return menuValaszto;
	}

	public void setMenuValaszto(String menuValaszto) {
		this.menuValaszto = menuValaszto;
	}

	public void proc() {
		Resource resource= new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Sorsolas sors = (Sorsolas)factory.getBean("sorsolas");
		Elofordulas elo = (Elofordulas)factory.getBean("gyakorisag");
		
		if(menuValaszto.equals("sima")) {
			boolean exit = false;
			while(!exit) {
				System.out.println("Valassz egy menupontot:");
				System.out.println("A. Lottoszamok huzasa");
				System.out.println("B. Leggyakoribb 3 szam kigyujtese");
				System.out.println("C. Tomb kiiratasa");
				System.out.println("D. Kilepes");
				System.out.print("> "); Scanner sc = new Scanner(System.in);
					char valasztas = sc.next().charAt(0);		
						switch(valasztas){
						case 'A':						
							sors.sorsolas();
							break;
						case 'B':
							elo.elofordulas();
						  break;
						case 'C':
							elo.kiir();
						  break;
						case 'D':
						  System.out.println("Viszontlatasra");
						  exit = true;
						  break;
						default:
							System.out.println("Hibas betu");
					    	break;
						}
					}
				}else {
					System.out.println("NEM LÉTEZŐ MENÜ OPCIÓ");
					}
		

}
}