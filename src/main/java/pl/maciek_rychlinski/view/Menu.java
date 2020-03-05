package pl.maciek_rychlinski.view;

import pl.maciek_rychlinski.frames.NewPlayer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar{

    JMenu choosePlayer;
    JMenuItem player;

    JMenu records;
    JMenuItem save;
    JMenuItem load;

    public Menu(){
        super();

        // Wybór gracza:
        choosePlayer=new JMenu("Wybór gracza");
        player=new JMenuItem();
// Dodania
        choosePlayer.add(player);
        add(choosePlayer);
// Akcje
        newPlayer.putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        player.setAction(newPlayer);

        // Zapisywanie i wczytywanie rekordów:
        records=new JMenu("Rekordy");
        save=new JMenuItem();
        load=new JMenuItem();
// Dodania
        records.add(save);
        records.add(load);
        add(records);
//Akcje
        saveRecord.putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        save.setAction(saveRecord);
        loadRecord.putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_L,KeyEvent.CTRL_DOWN_MASK));
        load.setAction(loadRecord);


    }


    Action newPlayer=new AbstractAction("Nowy   ") {
        @Override
        public void actionPerformed(ActionEvent e) {
            new NewPlayer();
        }
    };

    Action saveRecord=new AbstractAction("Zapisz   ") {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    Action loadRecord=new AbstractAction("Wczytaj   ") {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

}
