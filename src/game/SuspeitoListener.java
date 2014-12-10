package game;

import base.MyActionListener;
import base.MyComponent;

public class SuspeitoListener implements MyActionListener{
	
	private Suspeito suspeito,culpado;
	private SuspeitoAdapter lastClicked;
	private boolean culpadoFlag;
	
	public SuspeitoListener(Suspeito culpado) {
		this.culpado = culpado;
		this.culpadoFlag = false;
	}
	public boolean getCulpadoFlag(){
		return culpadoFlag;
	}
	@Override
	public void actionPerformed(MyComponent c) {
		if (c instanceof Caso){
			SuspeitoAdapter adapter = ((Caso) c).getSelectedSuspeito();
			if (adapter != null)
				suspeito = adapter.getSuspeito();
			else
				suspeito = null;
		}
		else
			if (c instanceof MyButton){
				if (suspeito == culpado){
					System.out.println("Well Done!!! Mas você ainda precisa treinar mais");
					this.culpadoFlag = true;
				}else{
					System.out.println("Tente mais uma vez!!!!");
				}
			}
		else if ( c instanceof SuspeitoAdapter){
				if (lastClicked != null)
					lastClicked.setSelected(false);
				
				lastClicked = ((SuspeitoAdapter) c);
			}
	
	}

}
