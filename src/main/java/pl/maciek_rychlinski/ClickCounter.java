// Projekt ClickMaster
// Autor: Maciej Rychliński

package pl.maciek_rychlinski;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class ClickCounter extends JFrame implements ActionListener {
    JButton counter;
    JTextArea gauge, countdown;
    int ile = 0;
    int time = 10;
    boolean isItEnd = true;

//TIMER @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {

        @Override
        public void run() {
            countdown.setText(String.valueOf(time));
            time--;
            if (time == 0) {
                isItEnd = false;
                timer.cancel();
                JOptionPane.showMessageDialog(null, "Brawo, twĂłj wynik to: " + ile);
            }
        }
    };

    public void start() {
        timer.schedule(task, 1000, 1000);
    }


//KONSTRUKTOR @@@@@@@@@@@@@@@@@@@@@@@

    public ClickCounter() {
        super("Licznik kliknięć");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 300);
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        setLayout(flow);


// KLASA wewnętrzna implemetująca słuchacza myszy:
        MouseAdapter mouseMonitor = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                // Zliczaerka klikniÄ™Ä‡:
                if (e.getClickCount() <= 1 && isItEnd) {
                    ile += e.getClickCount();
                    gauge.setText("" + ile);
                }
                if (e.getClickCount() >= 1 && isItEnd) {
                    ile += 1;
                    gauge.setText("" + ile);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                try {
                    start();
                } catch (java.lang.IllegalStateException exc) {
                    // Ignoruj
                }
            }
        };


// Komponenty:
        counter = new JButton("Tu klikaj");
        gauge = new JTextArea("");
        countdown = new JTextArea(1, 5);
        JLabel info = new JLabel("Twój aktualny wynik:");
        JLabel timeToEnd = new JLabel("Pozostało:");

// Konfiguracja komponentów:
        counter.setPreferredSize(new Dimension(300, 100));
        gauge.setEditable(false);
        countdown.setEditable(false);

// Sluchacze:
        counter.addMouseListener(mouseMonitor);

// Dodania do ramki:
        JOptionPane.showMessageDialog(null,
                "Ten program mierzy Twoją prędkość klikania\n By rozpocząć, wciśnij ok, oraz najedź na przycisk \"Tu klikaj\"");
        add(timeToEnd);
        add(countdown);
        add(counter);
        add(info);
        add(gauge);

        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }


    // MAIN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static void main(String[] arg) {
        new ClickCounter();
    }


}
