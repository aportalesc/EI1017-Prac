package Controller;

import Model.ModelImplementation;
import View.ViewImplementation;
import javafx.stage.FileChooser;

import java.io.File;

public class ControllerImplementation implements Controller{

    private ModelImplementation model;
    private ViewImplementation vista;
    private FileChooser fileChooser;
    public loadData() {
       File f = fileChooser.showOpenDialog(null);
       if(f != null)
           modelo.loadData(f.getAbsolutePath());
    }
}
