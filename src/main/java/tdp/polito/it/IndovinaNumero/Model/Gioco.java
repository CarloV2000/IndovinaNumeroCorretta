package tdp.polito.it.IndovinaNumero.Model;

public class Gioco {
	//in questa classe: logica per funzionamento applicazione
	private final int TMax = 8;
	private final int NMax = 100;
	private int NTentativiFatti;
	private int numeroSegreto;
	
	
	
	public int getTMax() {
		return TMax;
	}

	public int getNMax() {
		return NMax;
	}

	public int getNTentativiFatti() {
		return NTentativiFatti;
	}

	public int getNumeroSegreto() {
		return numeroSegreto;
	}

	public void iniziaGioco() {
		//inizializzo variabili
    	this.NTentativiFatti = 0;
    	this.numeroSegreto = (int)(Math.random()*this.NMax)+1;
    	
	}
	
	public int faiTentativo(int tentativo) {
		//incremento numero tentativi
    	this.NTentativiFatti++;
    	
    	//giocare
    	if(tentativo == numeroSegreto) {//caso 0 vittoria
    		return 0;
    	}
    	else if(this.NTentativiFatti==TMax) {//caso 1 sconfitta
    		return 1;
    	}
    	else if(tentativo> numeroSegreto) {//caso 2 numero troppo alto
    		return 2;
    	}
    	else {//caso 3 numero troppo basso
    		return 3;
    	}
	}

}
