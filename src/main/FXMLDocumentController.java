package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FXMLDocumentController implements Initializable {
    LinkedHashMap<Character,Integer> map;
    BufferedReader in;
    FileChooser a;
    @FXML
    private TextArea text1;
    @FXML
    private TextArea text2;
    @FXML
    private MenuItem menu1;
    @FXML
    private MenuItem menu2;
    int sign;
    int temp;
    boolean flag;
    
    @FXML
    private void open(ActionEvent event) throws FileNotFoundException, IOException{
        map = new LinkedHashMap();
        for (int i=32;i<=127;i++)
        {
            map.put((char) i ,0);
        }
        a = new FileChooser();
        ExtensionFilter a1 = new ExtensionFilter("Pliki tekstowe","*.txt");
        a.getExtensionFilters().add(a1);
        flag=false;
        try (BufferedReader in = new BufferedReader(new FileReader(a.showOpenDialog(null)))) {
            while (!flag)
            {
                sign = in.read();
                if (sign==-1){
                    break;
                }
                text1.appendText(String.valueOf((char) sign));
                if(map.containsKey((char)sign))
                map.replace((char)sign, map.get((char)sign)+1);
            }
        }
        for (int i=32;i<128;i++){
            text2.appendText((char) i  + " = " + map.get((char)i)+ "\n");
        }
        in.close();
    }
    @FXML
    private void close(){
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
