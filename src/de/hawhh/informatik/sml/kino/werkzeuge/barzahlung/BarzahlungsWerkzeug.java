package de.hawhh.informatik.sml.kino.werkzeuge.barzahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

import de.hawhh.informatik.sml.kino.fachwerte.Eurocent;
import de.hawhh.informatik.sml.kino.fachwerte.Platz;
import de.hawhh.informatik.sml.kino.materialien.Kinosaal;
import de.hawhh.informatik.sml.kino.materialien.Vorstellung;
import de.hawhh.informatik.sml.kino.werkzeuge.platzverkauf.PlatzVerkaufsWerkzeug;
import de.hawhh.informatik.sml.kino.werkzeuge.platzverkauf.PlatzVerkaufsWerkzeugUI;

public class BarzahlungsWerkzeug
{
	private BarzahlungsWerkzeugUI _ui;
	private Eurocent _preis;
	private Eurocent _eingezahlt;
	private boolean _bezahlt;
	private final static int MAX_EURO = 100000;

	public BarzahlungsWerkzeug(Eurocent preis) {
		_preis = preis;
		_bezahlt = false;
		_ui = new BarzahlungsWerkzeugUI(); //erzeugt die UI
		
		_ui.set_preis(_preis);
		
		_ui.get_okButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e)
			{
				_bezahlt = true;
				_ui.close();
			}
		});	
		_ui.get_abbrechenButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e)
			{
				_ui.close();
			}
		});
		_ui.get_bezahlFeld().addKeyListener(new KeyListener(){
			
			@Override
			public void keyTyped(KeyEvent e)
			{
				//donothing
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
				//donothing
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				aktualisiereAnsicht();
			}
		});

		_ui.zeigeFenster();
	}
	
	private void aktualisiereAnsicht()
	{
		String s = _ui.get_bezahlFeld().getText();
		if (Eurocent.isValid(s))
		{
			_eingezahlt = Eurocent.get(s);
			if (Eurocent.größerGleich(_eingezahlt, _preis)) {
				if (Eurocent.größerGleich(_eingezahlt, Eurocent.get(MAX_EURO))){
					_ui.get_okButton().setEnabled(false);
					_ui.get_rueckgeldFeld().setText("zu großer Wert");
				} else {
					_ui.get_okButton().setEnabled(true);
					_ui.getUIFrame().getRootPane().setDefaultButton(_ui.get_okButton());
					_ui.get_rueckgeldFeld().setText(Eurocent.sub(_eingezahlt, _preis).toString());
				}
			} else {
				_ui.get_okButton().setEnabled(false);
				_ui.get_rueckgeldFeld().setText("zu wenig bezahlt");
			}
		} else {
			_ui.get_rueckgeldFeld().setText("Eingabe prüfen");
		}
	}
	
	/**
	 * @return the _bezahlt
	 */
	public boolean istBezahlt()
	{
		return _bezahlt;
	}
}
