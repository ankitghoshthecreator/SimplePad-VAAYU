public class Function_File {

    GUI gui;
    public Function_File(GUI gui){
        this.gui=gui; // for accessing the members from the GUI class
    }
    public void newCreate(){
        gui.textArea.setText("");// when we tap new it gives a new file with nothing
        gui.window.setTitle("New");
    }
}
