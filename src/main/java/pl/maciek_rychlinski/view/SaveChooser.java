package pl.maciek_rychlinski.view;

import pl.maciek_rychlinski.others.FileTypeFilter;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveChooser extends JFileChooser {

    public SaveChooser() {
        super(new File("C:\\"));
        setDialogTitle("Zapisz swoje rekordy");
        setFileFilter(new FileTypeFilter(".txt", "Text File"));
        int returnValue = showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = getSelectedFile();
            try {
                FileWriter fileWriter = new FileWriter(selectedFile.getPath() + ".txt",true);
                BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
                RecordsPanel recordsPanel=new RecordsPanel();
                bufferedWriter.write(recordsPanel.getListAsString());
                bufferedWriter.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }
}
