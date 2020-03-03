package pl.maciek_rychlinski.frames;


import javax.swing.*;
import java.awt.event.*;


public class NewPlayer extends JFrame implements ActionListener{

    JTextField inputName;
    JLabel name;
    JButton confirm;
    public static String playerName;


    public NewPlayer() {
        super("Dodaj nowego gracza");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(270, 100);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setFocusable(true);

        inputName = new JTextField("player", 8);
        name = new JLabel("Podaj swoje imie:");
        confirm = new JButton("Zapisz");

        confirm.addActionListener(this);
        inputName.addKeyListener(keyAdapter);
        inputName.addMouseListener(mouseAdapter);

        mainPanel.add(name);
        mainPanel.add(inputName);
        mainPanel.add(confirm);
        add(mainPanel);
        setVisible(true);
    }

    private void close() {
        dispose();
    }

    KeyAdapter keyAdapter=new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                playerName = inputName.getText();
                close();
            }
        }
    };

    MouseAdapter mouseAdapter=new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            inputName.setText("");
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        playerName = inputName.getText();
        close();
    }



}
