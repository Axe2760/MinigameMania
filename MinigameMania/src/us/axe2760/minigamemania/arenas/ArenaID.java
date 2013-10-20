package us.axe2760.minigamemania.arenas;

public class ArenaID {

	private int alpha;
	private int beta;
	
	public ArenaID(int alpha, int beta){
		this.alpha = alpha;
		this.beta = beta;
	}
	
	public int getAlpha(){
		return alpha;
	}
	
	public int getBeta(){
		return beta;
	}
	
	public void setAlpha(int alpha){
		this.alpha = alpha;
	}
	public void setBeta(int beta){
		this.beta = beta;
	}
}
