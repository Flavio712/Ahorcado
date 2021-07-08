import java.util.Scanner;

public class Ahorcado {

	private char[] pUsuario;
	private String pSecreta;
	private int vidas;
	private static String[] diccionario = {"INGENIERIA", "INGENIERO", "MANUAL", "METODO",
	        "PROCESO", "DATOS", "PROGRAMA", "INFORMATICA", "COMPUTACION", "COMPUTADORA",
	        "FORMATEO", "RAM", "MEMORIA", "DISCO", "USB", "RED", "WIFI", "INTELIGENCIA",
	        "MOUSE", "TECLADO", "PANTALLA", "CODIGO", "LINUX", "WINDOWS", "SIMULACION",
	        "METODOLOGIA", "KERNEL", "SISTEMA", "OPERACION", "GRAFICACION", "ALGORITMICA",
	        "MATEMATICAS", "CALCULO", "ALGEBRA", "ESTRUCTURA", "DIAGRAMA", "CLASE",
	        "OBJETO", "FUNCION", "LIBRERIA", "PLANTILLA", "EJECUTABLE", "COMANDO",
	        "ERROR", "TERMINAL", "PILA", "PROGRAMADOR", "LICENCIA", "COMPUTO", "PROCESADOR",
	        "LENGUAJE", "PROGRAMACION", "HERRAMIENTAS", "INTERNET", "EJECUTAR", "PROYECTO",
	        "METODO", "METRICA", "SOFTWARE", "ADMINISTRACION", "VENTANA", "MANTENIMIENTO",
	        "ENSAMBLADOR", "PRUEBA", "VERSION", "DEMOSTRACION", "CICLO", "CONDICION",
	        "INSTRUCCION", "BYTE", "BIT", "BUG", "ROLLOVER", "BIOS", "CPU", "ROM",
	        "COBOL", "FORTRAN", "LAN", "WAN", "CANAL", "COMPILADOR", "FUENTE", 
	        "EJECUTABLE", "APLICACION", "KILOBYTE", "MEGABYTE", "INDUSTRIA", "SIMBOLO",
	        "MICROSD"};
	
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
		
		String palabraAzar=null;
		
		for(int i=0;i<diccionario.length;i++) {
			int azar = (int) Math.floor(Math.random()*90);
			palabraAzar = diccionario[azar];
		}
		System.out.println("AYUDA: Las posibles palabras son relacionadas al ambito de la informatica (SE UTILIZAN MAYÚSCULAS)");
		
		Scanner s=new Scanner(System.in);	
		String palabra = palabraAzar;
		
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
