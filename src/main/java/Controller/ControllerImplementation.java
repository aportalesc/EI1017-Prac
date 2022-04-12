package Controller;

import Model.ModelImplementation;
import View.ViewImplementation;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;

public class ControllerImplementation {

    private ModelImplementation model;
    private ViewImplementation view;

    private FileChooser fileChooser;

    ControllerImplementation(ModelImplementation model, ViewImplementation view){
        super();
        this.model = model;
        this.view = view;
    }

    public void setModel(ModelImplementation model) {
        this.model = model;
    }

    public void setView(ViewImplementation view) {
        this.view = view;
    }

    public void loadData() throws FileNotFoundException {
       File f = fileChooser.showOpenDialog(null);
       if(f != null)
           model.loadData(f.getAbsolutePath());
    }
}
