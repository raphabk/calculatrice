

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class raph {
	static double resultat;
	static String text;
	static int i;
	static double operation;
    static String tab[] = {"0", "1","2","3","4","5","6","7","8","9"};
    static String ope[] = {"+","-","x","/","="};
	static JFrame cadre = new JFrame("Calculatrice");
	static JPanel content = new JPanel();
	static JPanel clavier = new JPanel();
	static JPanel operateur = new JPanel();
	static JPanel reset = new JPanel();
	static JLabel ecran = new JLabel();
	static String operande;
	static boolean verif= false;
	
	public static ActionListener AE (final JButton b){
        b.addActionListener(new ActionListener(){
   
            public void actionPerformed(ActionEvent e) {
                if(ecran.getText().equals("0")){
                    ecran.setText(b.getText());
                }
                else {
                    text = ecran.getText();
                    text = text+b.getText();
                    ecran.setText(text);
                }
            }
        });
        return b.getAction();
    }
	
	
    public static void calcul(){
    	if (operande == "+") {
    		resultat = operation + Double.parseDouble(ecran.getText());
    		operation = resultat;
    	}
    	else if (operande == "-") {
    		resultat = operation - Double.parseDouble(ecran.getText());
    		operation = resultat;
    	}
    	else if (operande == "x") {
    		resultat = operation * Double.parseDouble(ecran.getText());
    		operation = resultat;
    	}
    	else if (operande == "/") {
    		resultat = operation / Double.parseDouble(ecran.getText());
    		operation = resultat;
    	}
    }
	
	
	public static void main(String[] args) {
		
		
		cadre.setSize(250, 250);
		cadre.setResizable(true);
	
		ecran.setText("0");
		content.add(ecran);
		clavier.setLayout(new GridLayout(6,2));
		operateur.setLayout(new GridLayout(6,1));
		

		
		JButton bouton[] = new JButton[15];
		JButton bOP[] = new JButton[6];
		JButton c = new JButton("c");
		c.setSize(25,25);
		
		for ( i =0; i<tab.length; i++){
			bouton[i] = new JButton(tab[i]);
			clavier.add(bouton[i]);
		}
		for (i=0;i<ope.length;i++){
			bOP[i] = new JButton(ope[i]);
			operateur.add(bOP[i]);
			
		}
		for(i=0;i<tab.length;i++){
			AE(bouton[i]);
		}
		
		reset.add(c);
		/*
			bOP[0].addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent p) {
	            	System.out.println(ecran.getText().equals("0"));
	                if(ecran.getText().equals("0")){
	                	operation = Double.parseDouble(ecran.getText());
	                    ecran.setText("0");
	                }
	                else {
	                	operation = Double.parseDouble(ecran.getText());
	                    resultat = operation + Double.parseDouble(ecran.getText());
	                    text = String.valueOf(resultat);
	                    ecran.setText(text);
	                }
	            }
	        });*/
			
			bOP[0].addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent p) {
	            	if (ecran.getText().equals("0")==false) 
	            	{
	            		operation = Double.parseDouble(ecran.getText());
	            		ecran.setText("0");
	            		operande = "+";
	            		verif = true;
	            		
	            	    
	            	}
	            	else{
	            		if(verif ==true ) calcul();
	            		ecran.setText("0");
	            		
	            	}
	            }
	        });
			
			bOP[1].addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent p) {
	            	if (ecran.getText().equals("0")==false) 
	            	{
	            		operation = Double.parseDouble(ecran.getText());
	            		ecran.setText("0");
	            		operande = "-";
	            		verif = true;
	            		
	            	    
	            	}
	            	else{
	            		if(verif ==true ) calcul();
	            		ecran.setText("0");
	            		
	            	}
	            }
	        });
			
			bOP[2].addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent p) {
	            	if (ecran.getText().equals("0")==false) 
	            	{
	            		operation = Double.parseDouble(ecran.getText());
	            		ecran.setText("0");
	            		operande = "x";
	            		verif = true;
	            		
	            	    
	            	}
	            	else{
	            		if(verif ==true ) calcul();
	            		ecran.setText("0");
	            		
	            	}
	            }
	        });
			
			bOP[3].addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent p) {
	            	if (ecran.getText().equals("0")==false) 
	            	{
	            		operation = Double.parseDouble(ecran.getText());
	            		ecran.setText("0");
	            		operande = "/";
	            		verif = true;
	            		
	            	    
	            	}
	            	else{
	            		if(verif == true ) calcul();
	            		ecran.setText("0");
	            		
	            	}
	            }
	        });
			
			bOP[4].addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent p) {
	            	calcul();
	            	text = String.valueOf(resultat);
                    ecran.setText(text);
                    verif = false;
	            }
	        });
			
			
			/*bOP[5].addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent p) {
                    ecran.setText("0");
                    verif = false;
	            }
	        });*/
			
			c.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent p) {
                ecran.setText("0");
                verif = false;
            }
        });
		
		cadre.setLayout(new BorderLayout());
		cadre.getContentPane().add(content, BorderLayout.NORTH);
		cadre.getContentPane().add(clavier, BorderLayout.CENTER);
		cadre.getContentPane().add(operateur, BorderLayout.EAST);
		cadre.getContentPane().add(reset,BorderLayout.SOUTH);
		cadre.setVisible(true);
		
	
  }
}


