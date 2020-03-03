package pl.maciek_rychlinski.view;

import pl.maciek_rychlinski.frames.NewPlayer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar implements ActionListener {

    JMenu mainMenu;
    JMenuItem gracz;

    public Menu(){
        super();
        mainMenu=new JMenu("Wybór gracza");
        gracz=new JMenuItem("Nowy");
        mainMenu.add(gracz);
        add(mainMenu);
        gracz.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        new NewPlayer();
    }
}
