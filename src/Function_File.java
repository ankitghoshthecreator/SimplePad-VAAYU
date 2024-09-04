import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {

    GUI gui;

    String fileName;
    String fileAddress;
    public Function_File(GUI gui) {
        this.gui = gui; // for accessing the members from the GUI class
    }


    public void newCreate(){
        gui.textArea.setText("");// when we tap new it gives a new file with nothing
        gui.window.setTitle("New");
        fileName=null;
        fileAddress=null;

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

    public void save(){
        if(fileName==null){
            saveAs();
        }
        else{
            try{
                FileWriter fw=new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            } catch (Exception e) {
                System.out.println("Something Went Wrong");
            }
        }

    }
    public void saveAs(){
        FileDialog fd=new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);


        if(fd.getFile()!=null){
            fileName=fd.getFile();
            fileAddress= fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        try{
            FileWriter fw=new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();

        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        }

    }
    public void exit(){
        System.exit(0);
    }

}
