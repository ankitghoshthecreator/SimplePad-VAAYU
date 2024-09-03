import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Function_File {

    GUI gui;

    String fileName;
    String fileAddress;
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

        if(fd.getFile()!=null){
            fileName= fd.getFile();
            fileAddress= fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        try{
            BufferedReader br= new BufferedReader(new FileReader(fileAddress + fileName));// we need the address and the name to read the file or to load the file
            gui.textArea.setText("");
            String line = null;

            while ((line = br.readLine())!=null){
                gui.textArea.append(line + "\n");
            }
            br.close();
        }catch (Exception e){
            System.out.println("File not opened");
        }
    }
}
