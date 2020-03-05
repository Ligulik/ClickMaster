/**
 * Panel dodawnia rekordów:
 */

package pl.maciek_rychlinski.view;

import pl.maciek_rychlinski.records.Record;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class RecordsPanel extends JPanel {
    JLabel records;
    String[] descriptions = {"Poz", "Gracz", "Data", "Czas", "Wynik"};
    JTextField[] textFieldsArray = new JTextField[30];
    int j = 1;
    boolean newRecord;


    static List<Record> lista = new ArrayList<>();

    public RecordsPanel() {

        JPanel mainPanel = new JPanel();
        BoxLayout mainLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(mainLayout);

        JPanel labelPanel = new JPanel();
        records = new JLabel("Rekordy");
        labelPanel.add(records);

        JPanel textAreasPanel = new JPanel();
        textAreasPanel.setLayout(new GridLayout(6, 6));
        for (int i = 0; i < 30; i++) {
            if (i > 4) {
                if (i == 5 || i == 10 || i == 15 || i == 20 || i == 25) {
                    textFieldsArray[i] = new JTextField(8);
                    textFieldsArray[i].setText("" + j);
                    textFieldsArray[i].setForeground(Color.red);
                    textFieldsArray[i].setEditable(false);
                    textAreasPanel.add(textFieldsArray[i]);
                    j++;
                } else
                    textFieldsArray[i] = new JTextField(8);
                textFieldsArray[i].setEditable(false);
                textAreasPanel.add(textFieldsArray[i]);
            } else {
                textFieldsArray[i] = new JTextField(8);
                textFieldsArray[i].setText("" + descriptions[i]);
                textFieldsArray[i].setEditable(false);
                textAreasPanel.add(textFieldsArray[i]);
            }
        }

        mainPanel.add(labelPanel);
        mainPanel.add(textAreasPanel);
        add(mainPanel);
        setVisible(true);
    }


// Metody:

    public void addRecord(Record record) {

        lista.add(record);
        lista.sort(Comparator.comparingInt(Record::getScore).reversed());
        if(lista.size()>1 && record.getScore()>lista.get(1).getScore()){
            newRecord=true;
        }else{
            newRecord=false;
        }

        if (lista.size() > 5) {
            lista.remove(lista.size() - 1);
        }

        int j = 0;

        for (int i = 5; i <= lista.size() * 5; i += 5) {
            textFieldsArray[i + 1].setText(lista.get(j).getPlayerName());
            textFieldsArray[i + 2].setText(lista.get(j).getDateOfPlay());
            textFieldsArray[i + 3].setText(lista.get(j).getClockOFPlay());
            textFieldsArray[i + 4].setText(String.valueOf(lista.get(j).getScore()));
            j++;
        }

    }

        public boolean infoAboutNewRecord(){
            return newRecord;
        }

        public String getListAsString(){
        String finalResult="";

        for(int i=0;i<=lista.size()-1;i++){
            finalResult=finalResult+
                    lista.get(i).getPlayerName()+"@"+
                    lista.get(i).getDateOfPlay()+"@"+
                    lista.get(i).getClockOFPlay()+"@"+
                    lista.get(i).getScore()+"@";
        }


            return finalResult;
    }
}
