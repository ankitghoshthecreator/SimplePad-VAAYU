import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame window;
    JTextArea textArea;
    public static  void main(String[] args){


        new GUI();

    }
    public GUI(){
        createWindow();
        createTextArea();


        window.setVisible(true);

    }

    public void createWindow(){ // window creation
       window = new JFrame("VAAYU-pad");
       window.setSize(900,700);
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void createTextArea(){
        textArea=new JTextArea();
        window.add(textArea);
    }

}
