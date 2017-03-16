package swing2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PayButListener implements ActionListener{
		//запись в файл sklad.txt измененных данных по нажатию кнопки Купить и возврат к первоначальному положению
		private JPanel p;
		private JButton b2;
		private JButton b3;
		private JTextField t1;
		private JTextField t2;
		private JLabel l3;
		private ArrayList<String> ars1;
		private JButton b1;
		
		public PayButListener(JPanel panel, JButton button2, JButton button3, JTextField input1, JTextField input2, JLabel label3, ArrayList<String> ars, JButton button1) {
			p = panel;
			b2 = button2;
			b3 = button3;
			t1 = input1;
			t2 = input2;
			l3 = label3;
			ars1 = ars;
			b1 = button1;
		}

		public void actionPerformed(ActionEvent e){			
			File f = new File("sklad.txt");
			try{
			if(!f.exists()){
				f.createNewFile();
			}
			PrintWriter pw = new PrintWriter(f.getAbsoluteFile());	
			int i = 1;
			for(String a: ars1){
				if(i % 3 == 0){
					pw.println(a);
				}else{
					pw.print(a);
					pw.print(" ");
				}
				i++;
			}			
			pw.close();
			}catch(IOException e1){
				System.out.println("ERROR!");
			}
			p.remove(b2);
			p.remove(b3);
			p.repaint();
			t1.setText("");
			t2.setText("");
			l3.setText("");	
			b1.setEnabled(true);
		}
}