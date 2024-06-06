import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.*; 
import java.util.ArrayList; 
import java.util.Arrays; 
 
import static javax.swing.WindowConstants.EXIT_ON_CLOSE; 
 
public class notepad { 
    notepad(){ 
        JFrame f=new JFrame(); 
        JButton b=new JButton("save"); 
        JTextField tf=new JTextField(); 
        tf.setBounds(40,40,400,300); 
        f.add(tf); 
        b.setBounds(340,20,80,20); 
        f.add(b); 
        JButton b1=new JButton("open"); 
        b1.setBounds(230,20,80,20); 
        f.add(b1); 
        b1.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                JFileChooser jf1=new JFileChooser(); 
                int response=jf1.showOpenDialog(null); 
                if (response==JFileChooser.APPROVE_OPTION){ 
                    File f1=new File(jf1.getSelectedFile().getAbsolutePath()); 
                   try{ 
                       FileReader fr=new FileReader(f1); 
                       int i; 
                       int j=0; 
                       StringBuilder sb=new StringBuilder(); 
                       while((i=fr.read())!=-1) 
                       { sb.append((char)i);} 
                       tf.setText(sb.toString()); 
                           System.out.print((char)i); 
                       fr.close(); 
                   } 
                   catch(Exception ef){ 
 
                   } 
 
 
                } 
            } 
        }); 
        b.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent e) { 
                JFileChooser jf=new JFileChooser(); 
                int response=jf.showSaveDialog(null); 
                if (response==JFileChooser.APPROVE_OPTION){ 
                    File file=new File(jf.getSelectedFile().getAbsolutePath()); 
                    FileWriter fw= null; 
                    try { 
                        fw = new FileWriter(file); 
                        fw.write(tf.getText()); 
                        fw.close(); 
                        tf.setText(" "); 
                    } catch (IOException ex) { 
                        throw new RuntimeException(ex); 
                    } 
                } 
            } 
        }); 
f.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        f.setSize(500,400); 
        f.setLayout(null); 
        f.setVisible(true); 
    } 
 
    public static void main(String[] args) { 
        notepad np=new notepad(); 
    } 
} 
