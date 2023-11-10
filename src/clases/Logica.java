package clases;

import java.util.ArrayList;

public class Logica {
	
	double imc;
	ArrayList<PersonaVO> listaPersonas;
	
	public Logica() {
		listaPersonas=new ArrayList<PersonaVO>();
	}
	
	public String registrarPersona(PersonaVO persona) {
		String result = "Persona registrada exitosamente! \n";
		result+= "Documento: "+persona.getDocumento()+"\n";
		result+= "Nombre: "+persona.getNombre()+"\n";
		result+= "Edad: "+persona.getEdad()+"\n";
		result+= "Talla: "+persona.getTalla()+"\n";
		result+= "Peso: "+persona.getPeso()+"\n";
		imc = persona.getPeso()/ (persona.getTalla()*persona.getTalla());
		
		String imcMsj = calcularIMC(imc);
		persona.setImcMsj(imcMsj);
		result+=imcMsj+"\n";
		persona.setImc(imc);
		
		listaPersonas.add(persona);
		
		return result;
	}
	
	public String calcularIMC(double imc) {
		
		String msj="";
		if(imc<18) {
			msj="Anorexia";
		}else if(imc>=18 && imc<20) {
			msj="Delgadez";
		}else if(imc>=20 && imc<27) {
			msj="Normalidad";
		}else if(imc>=27 && imc<30) {
			msj="Obesidad Grado 1";
		}else if(imc>=30 && imc<35) {
			msj="Obesidad Grado 2";
		}else if(imc>=35 && imc<40) {
			msj="Obesidad Grado 3";
		}else if(imc>40) {
			msj="Obesidad morbida";
		}
		
		
		return "IMC:"+imc+" su IMC indica que tiene: "+msj+"\n";
	}

	public String consultarListaPersonas() {
		String result="";
		PersonaVO p =null;
		
		for (int i = 0; i < listaPersonas.size(); i++) {
			p=listaPersonas.get(i);
			result+="Documento: "+p.getDocumento()+"\n";
			result+="Nombre: "+p.getNombre()+"\n";
			result+="Edad: "+p.getEdad()+"\n";
			result+="Talla: "+p.getTalla()+"\n";
			result+="Peso: "+p.getPeso()+"\n";
			result+=p.getImcMsj();
			result+="***************************\n";
		}
		return result;
		
	}

	public String consultarPromedio() {
		String result = "";
		double suma = 0;
		for (int i = 0; i < listaPersonas.size(); i++) {
			suma=suma+listaPersonas.get(i).getImc();
		}
		double prom = suma/listaPersonas.size();
		result=calcularIMC(prom);
		return result;
	}
	
	

}
