import java.util.Scanner;

public class Ahorcado {

	private char[] pUsuario;
	private String pSecreta;
	private int vidas;
	
	public Ahorcado(String palabraSecreta) {
		pUsuario = new char[palabraSecreta.length()];
		for(int i=0;i<pUsuario.length;i++) {
			pUsuario[i]='_';
		}
		pSecreta=palabraSecreta;
		vidas=5;
	}
	
	public boolean arriesgarLetra(char l) {
		boolean encontro=false;
		for(int i=0;i<pSecreta.length();i++) {
			if(l==pSecreta.charAt(i)) {
				pUsuario[i]=pSecreta.charAt(i);
				encontro=true;
			}
			
		}
		if(!encontro) {
			vidas--;
		}
		return encontro;
	}
	
	public void mostrar() {
		if(ganador()) {
			for(int i=0;i<pUsuario.length;i++) {
				System.out.print(pUsuario[i]+" ");		
			}
			System.out.println();
		}else {
			for(int i=0;i<pUsuario.length;i++) {
				System.out.print(pUsuario[i]+" ");
			}
			System.out.println();
			System.out.println("Te quedan "+this.vidas+" vidas");
		}
	}
	
	public boolean arriesgaPalabra(String p) {
		if(p.equals(pSecreta)) {
			for(int i=0;i<pUsuario.length;i++) {
				pUsuario[i]=pSecreta.charAt(i);
			}
		}else {
			vidas=0;
		}
		return ganador();
	}
	
	public boolean terminado() {
		return(vidas==0||palabraCompleta());
	}
	
	public boolean ganador() {
		return(palabraCompleta());
	}
	
	private boolean palabraCompleta() {
		for(int i=0;i<pUsuario.length;i++) {
			if(pUsuario[i]=='_') {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("Ingrese la palabra");
		
		String palabra = s.nextLine();
		
		Ahorcado juegoAhorcado = new Ahorcado (palabra);
		juegoAhorcado.mostrar();
		
		while(!juegoAhorcado.terminado()) {
			System.out.println("Ingrese una letra o palabra");
			String p=s.nextLine();
			if(p.length()==1) {
				juegoAhorcado.arriesgarLetra(p.charAt(0));
			}else {
				juegoAhorcado.arriesgaPalabra(p);
			}
			juegoAhorcado.mostrar();
		}
		if(juegoAhorcado.ganador()) {
			System.out.println("Ganaste!");
		}else {
			System.out.println("Perdiste! la palabra era "+palabra);
		}
	}

}
