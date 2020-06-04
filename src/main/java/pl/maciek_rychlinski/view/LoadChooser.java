package pl.maciek_rychlinski.view;

/**
 * Okno wczytywania rekordow z pliku textowego:
 */


import pl.maciek_rychlinski.frames.ClickCounter;
import pl.maciek_rychlinski.records.Record;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;


public class LoadChooser extends JFileChooser {


    ClickCounter clickCounter;
    RecordsPanel recordsPanel;


    public LoadChooser(RecordsPanel recordsPanel) {


        // Okno wczytywania:

        super(new File(("C:\\")));

        this.recordsPanel = recordsPanel;


        setDialogTitle("Wczytaj swoje rekordy");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        setFileFilter(filter);
        int returnValue = showOpenDialog(null);

        // Pobieranie tresci z pliku:

        if (returnValue == APPROVE_OPTION) {
            File selectedFile = getSelectedFile();
            try {
                FileReader fileReader = new FileReader(selectedFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String reading = bufferedReader.readLine();
                String[] splited1 = reading.split("!");

                for (String splited : splited1) {
                    String[] templ = splited.split("@");
                    Record record = new Record(templ[0], templ[1], templ[2], Integer.parseInt(templ[3]));
                    if (!recordsPanel.check(record)) {
                        recordsPanel.addRecord(record);
                    }

                }


            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
