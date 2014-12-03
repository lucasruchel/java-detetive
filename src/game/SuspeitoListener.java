package game;

import base.MyActionListener;
import base.MyComponent;

public class SuspeitoListener implements MyActionListener{
	
	private Suspeito suspeito;
	private SuspeitoAdapter lastClicked;

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
				if (suspeito != null)
					System.out.println("O suspeito sugerido é: "+suspeito);
			}
		else if ( c instanceof SuspeitoAdapter){
				if (lastClicked != null)
					lastClicked.setSelected(false);
				
				lastClicked = ((SuspeitoAdapter) c);
			}
	
	}

}
