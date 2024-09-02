import java.awt.*;

public class Function_File {

    GUI gui;
    public Function_File(GUI gui){
        this.gui=gui; // for accessing the members from the GUI class
    }
    public void newCreate(){
        gui.textArea.setText("");// when we tap new it gives a new file with nothing
        gui.window.setTitle("New");
    }
    public void open(){
        FileDialog fd = new FileDialog(gui.window ,"Open", FileDialog.LOAD); // 1. open window 2. what written in title top of window 3. what written
        fd.setVisible(true);

    }
}
