package swing2;

import java.io.IOException;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Opt extends JFrame {
	//запуск программы 1	     
     public static void main(String[] args) throws IOException {
              	 
         			CreateWin fr = new CreateWin();
         			fr.createGUI();
                    fr.pack();
                    fr.setLocationRelativeTo(null);
                    fr.setResizable(false);
                    fr.setVisible(true);         
     }
          
}