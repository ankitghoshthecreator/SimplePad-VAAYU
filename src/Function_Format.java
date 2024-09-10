import java.awt.*;

public class Function_Format {
    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;

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
    public void createFont(int fontSize){
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }
    public void setFont(String font){
        selectedFont=font;
        switch (selectedFont){
            case "Arial" : gui.textArea.setFont(arial); break;
            case "Comic Sans MS" : gui.textArea.setFont(comicSansMS); break;
            case "Times New Roman" :gui.textArea.setFont(timesNewRoman); break;
        }

    }
}
