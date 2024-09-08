public class Function_Format {
    GUI gui;

    Function_Format(GUI gui){
        this.gui=gui;
    }
    public void wordWrap(){
        if (gui.wordWrapOn==false) {
            gui.wordWrapOn=true;
            gui.textArea.setLineWrap(true); // text wrapoing true
            gui.textArea.setWrapStyleWord(true); // line break only after a word
            gui.iWrap.setText("Word Wrap: On");
        } else if (gui.wordWrapOn== true) {
            gui.wordWrapOn=false;
            gui.textArea.setLineWrap(false); // text wrapoing true
            gui.textArea.setWrapStyleWord(false); // line break only after a word
            gui.iWrap.setText("Word Wrap: Off");
        }


    }
}
