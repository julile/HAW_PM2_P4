package de.hawhh.informatik.sml.kino.werkzeuge;

/**
 * Beobachtet alle Platzverkaufswerkzeuge und informiert über Änderungen, wenn welche eingehen
 */

public class PlatzVerkaufsWerkzeugObserver extends ObservableSubwerkzeug implements SubwerkzeugObserver
{
    @Override
    public void reagiereAufAenderung()
    {
	informiereUeberAenderung();	
    }
}
