// Projekt ClickMaster
// Autor: Maciej Rychliński

package pl.maciek_rychlinski;




import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class ClickCounter extends JFrame {

    JButton counter;
    JTextArea gauge, countdown;
    int ile = 0;
    int time = 3;
    boolean isItEnd = true;


    private void setLookAndFeel(){
        try {
            UIManager.setLookAndFeel( new com.formdev.flatlaf.FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }

//TIMER @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {

        @Override
        public void run() {
            if(time>-1) {
                countdown.setText(String.valueOf(time));
                time--;
                if (time == -1) {
                    isItEnd = true;
                    JOptionPane.showMessageDialog(null, "Brawo, twój wynik to: " + ile);
                    countdown.setText("Koniec");
                    counter.setBackground(Color.green);
                    counter.setText("Reset & Start");

                }
            }
        }
    };

    public void start() {
        try {
            timer.schedule(task, 1000, 1000);
        } catch (java.lang.IllegalStateException exc2) {

        }
    }


//KONSTRUKTOR @@@@@@@@@@@@@@@@@@@@@@@

    public ClickCounter() {

        super("Licznik kliknięć");
        setLookAndFeel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(340, 300);
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(flow);



// KLASA wewnętrzna implemetująca słuchacza myszy:
        MouseAdapter mouseMonitor = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                // RESET
                if(e.getClickCount()==1&&isItEnd==true){

                    time = 3;
                    isItEnd =false;
                    ile = 0;
                    gauge.setText("" + ile);
                    start();
                    counter.setBackground(null);
                    counter.setText("Klikaj");
                }



                if (e.getClickCount() >= 1 && isItEnd==false) {
                    ile += 1;
                    gauge.setText("" + ile);
                }
            }

        };


// Komponenty:
        counter = new JButton("Start");
        gauge = new JTextArea(1, 5);
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
                "Ten program mierzy Twoją prędkość klikania\n By rozpocząć, wciśnij \"Start\"");
        mainPanel.add(timeToEnd);
        mainPanel.add(countdown);
        mainPanel.add(counter);
        mainPanel.add(info);
        mainPanel.add(gauge);

        ImageIcon imageIcon = new ImageIcon("F:\\ProgramyJAVA\\ClickMaster\\src\\main\\resources\\fronczewski.jpg");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);

        mainPanel.add(new JLabel(imageIcon));
        add(mainPanel);
        // Umieszczenie okna na srodku:
        setLocationRelativeTo(null);

        setVisible(true);

    }




    // MAIN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static void main(String[] arg) {
        new ClickCounter();
    }


}
