package swing2;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CreateWin extends JFrame {
	//метод создания окна программы с элементами
	void createGUI() throws IOException {		
		setTitle("Оптовый склад");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    JLabel label1 = new JLabel("Введите название");	
	    panel.add(label1).setBounds(85, 20, 150, 15);	    
		JLabel label2 = new JLabel("Введите вес (кг)");
		panel.add(label2).setBounds(276, 20, 150, 15);
		JLabel label3 = new JLabel("");
		panel.add(label3).setBounds(50, 100, 300, 60);
	    //JTextField input1 = new JTextField(10);	
		LimitField input1 = new LimitField("", 5, 30);
	    panel.add(input1).setBounds(20, 40, 240, 25);	        
		//JTextField input2 = new JTextField("", 5);
	    LimitField input2 = new LimitField("", 5, 4);
		panel.add(input2).setBounds(280, 40, 80, 25);
		input2.setHorizontalAlignment(LimitField.CENTER);
	    JButton button1 = new JButton("Поиск"); 
	    panel.add(button1).setBounds(145, 80, 100, 23);
	    JButton button2 = new JButton("Купить");
	    JButton button3 = new JButton("Отмена");
	    ArrayList<String> ars = new ArrayList<String>();
		try(BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream("sklad.txt")))){ //автоматом закроется соединение
			String str;
			while((str = bfr.readLine())!= null){
				for(int i = 0; i < str.split(" ").length; i++){					
					ars.add(str.split(" ")[i]);
				}
			}				
		}
	    button1.addActionListener(new AddButListener(panel, input1, input2, button2, button3, label3, ars, button1));
	    button2.addActionListener(new PayButListener(panel, button2, button3, input1, input2, label3, ars, button1));
	    button3.addActionListener(new RemButListener(panel, button2, button3, input1, input2, label3, button1));	             
	    getContentPane().add(panel);
	    setPreferredSize(new Dimension(400, 300));
	    input2.addKeyListener(new java.awt.event.KeyAdapter() { //во 2 текстовом поле запрещаем пробелы и ввод букв
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();            
                if( Character.isWhitespace(key) || Character.isAlphabetic(key)) e.consume();
            }    
        });	    
	}	
}
