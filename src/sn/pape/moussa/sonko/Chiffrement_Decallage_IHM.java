package sn.pape.moussa.sonko;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.UIManager;


public class Chiffrement_Decallage_IHM  extends JFrame

{

	
	private Thread t;
	private JProgressBar bar;
	
	private JWindow splash=new JWindow();
    private JPanel  splashpan =new JPanel();
    
    private ImageIcon icon =new ImageIcon("images/roll.png");
  //private ImageIcon img =new ImageIcon("images/quit.png");
	private ImageIcon logo =new ImageIcon("images/sonko.png");
	private ImageIcon imge =new ImageIcon("images/progress.gif");
	
	private JPanel pan_haut = new JPanel() ;
	private JPanel pan_milieu = new JPanel() ;
	private JPanel pan_bas = new JPanel() ;	
	private JPanel container = new JPanel() ;
	
	
	
	private JTextArea jta1 = new JTextArea();
	private JFormattedTextField jftf1 = new JFormattedTextField(NumberFormat.getInstance());
	
	private JScrollPane jsp1 = new JScrollPane(jta1);
	
	private JLabel label1 = new JLabel("Veuillez Saisir le Message à Crypter ci-dessous: ");
	private JLabel label2 = new JLabel("Clé: ");
	private JLabel label3 = new JLabel(new ImageIcon("images/encours.gif")); //Affichage Baniere "En cours".
	private JLabel label4 = new JLabel("");
	
	private ImageIcon img = new ImageIcon("images/icone_appli.png");
	private JButton jb1 = new JButton("Chiffrer");
	private JButton jb2 = new JButton("Déchiffrer");
	
	private JMenuBar menubar = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier");
	private JMenu afficher = new JMenu("Affichage");
	private JMenu apropos = new JMenu("?");
	private JMenu police = new JMenu("> Police du texte");
	private JMenu rendu = new JMenu("> Rendu à l'affichage ");
	
	private JMenuItem fermer = new JMenuItem("> Fermer l'application");
	private JMenuItem effacer = new JMenuItem("> Effacer Message");
	private JRadioButtonMenuItem clair_cryte = new JRadioButtonMenuItem("Texte Clair + Texte Crypte");
	private JRadioButtonMenuItem crypte = new JRadioButtonMenuItem("Texte Crypte Seul");
	private JMenuItem auteur = new JMenuItem("A propos de l'Auteur ?");
	
	private JRadioButtonMenuItem jrmi1 = new JRadioButtonMenuItem("Texte Petit");
	private JRadioButtonMenuItem jrmi2 = new JRadioButtonMenuItem("Texte Moyen");
	private JRadioButtonMenuItem jrmi3 = new JRadioButtonMenuItem("Texte Grand");
	
	private JOptionPane jop1 = new JOptionPane();
	private JOptionPane jop2 = new JOptionPane();
	
	private ButtonGroup bg1 = new ButtonGroup();
	private ButtonGroup bg2 = new ButtonGroup();
	
	
	
	
	
	int i,j,n,cle1,cle2,k1,k2,m;
	char carac1, carac2,carac3,carac4;
    char alphabet[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' '};
   	private String msg1,msg2,msg3,msg4,str1,str2,tmp1,tmp2 = new String();			
	char tmp3,tmp4,tmp5;
	
	
		
			public Chiffrement_Decallage_IHM()
		
				{
					this.setTitle("CHIFFREUR_PAR_DECALAGE...   by Pape Moussa SONKO");
					this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					this.setSize(600,315);
					this.setLocationRelativeTo(null);
					this.setAlwaysOnTop(false);
					this.setResizable(false);					
					this.setIconImage(img.getImage());
					
				        t = new Thread(new Traitement()); //Nouvel thread pour la barre de progression de notre "screensplash"		       
				        bar  = new JProgressBar(); //Barre de progression.		        
				        bar.setMaximum(500);
				        bar.setMinimum(0);
				        //bar.setString("Traitement en cours...");
				        //bar.setBackground(Color.white);
				        //bar.setForeground(Color.lightGray);
				        bar.setStringPainted(true);
		          
					
					Font police0 = new Font("Times new roman",Font.BOLD,20);
					Font police1 = new Font("Times new roman",Font.ITALIC, 8);
					Font police2 = new Font("Times new roman",Font.ITALIC, 14);
					Font police3 = new Font("Times new roman",Font.ITALIC, 18);
					Font police4 = new Font("Arial black",Font.BOLD, 20);
					Font police5 = new Font("Times new roman",Font.BOLD, 30);
					Font police6 = new Font("Agency FB",Font.BOLD, 24);
					
					jsp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					jsp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					
					label1.setFont(police6);
					label1.setHorizontalAlignment(JLabel.CENTER);
					label1.setVerticalAlignment(JLabel.CENTER);
					
					
					label2.setFont(police0);
					label2.setHorizontalAlignment(JLabel.CENTER);
					label2.setVerticalAlignment(JLabel.CENTER);
					label2.setForeground(Color.BLACK);
					
					jrmi2.setSelected(true);
					
					bg1.add(jrmi1); //Ajout des JRadioButtonMenuItem a l'objet ButtonGroup "bg1"
					bg1.add(jrmi2);
					bg1.add(jrmi3);
					
					crypte.setSelected(true);
					
					bg2.add(clair_cryte);  //Ajout des JRadioButtonMenuItem a l'objet ButtonGroup "bg2"
					bg2.add(crypte);
					
					jb1.setFont(police6);
					jb2.setFont(police6);
					
					
				    jb1.setPreferredSize(new Dimension(120,40));
				    jb2.setPreferredSize(new Dimension(120,40));
				    jb2.setPressedIcon(new ImageIcon("images/icone_appli.png"));
					
				    jb1.setToolTipText("> Cliquez ici, pour Crypter");
				    jb2.setToolTipText("> Cliquez ici, pour Decrypter");
				    
				    jta1.setToolTipText("> Veuillez Ecrire Ici le Message à Crypter !");
				    
				    jta1.setLayout(new BorderLayout());
				    jta1.setBorder(BorderFactory.createTitledBorder("Message"));
				    jta1.setBackground(Color.WHITE);
				    jta1.setForeground(Color.BLUE);
				    jta1.setFont(police5);
				    
				    jftf1.setToolTipText("> Saisir une valeur K (K <= 26)");
				    
					jftf1.setPreferredSize(new Dimension(70,40));
					jftf1.setText("3");
					jftf1.setFont(police4);
					jftf1.setHorizontalAlignment(JFormattedTextField.CENTER);
					
					pan_haut.setPreferredSize(new Dimension(580,40));
					pan_haut.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));					
					pan_haut.add(label1);
					
					pan_milieu.setLayout(new BorderLayout());
					pan_milieu.add(jsp1, BorderLayout.CENTER);					
					pan_milieu.setBackground(Color.DARK_GRAY);
					
					pan_bas.setBackground(Color.LIGHT_GRAY);
					pan_bas.setPreferredSize(new Dimension(580,50));
					
					pan_bas.add(label2);
					pan_bas.add(jftf1);
					pan_bas.add(jb1);
					pan_bas.add(jb2);
					
			/*---------------------------------------------------------------------------------------------------------------------------------------------*/			
					
					jb1.addActionListener(new ActionListener() {  //Ecoute du bouton "jb1" avec une classe anonyme implementant l'interface ActionListener.
						
																	
																		public void actionPerformed(ActionEvent arg0) 
																				{
																				   jta1.add(label3,BorderLayout.LINE_END); //Affichage de la baniere.
																				   
																			       try {                             //Pause de 2 secondes.
																					    Thread.sleep(1000);
																					  
																				      }
																			      
																			      catch (InterruptedException e) 
																			        {
																				      e.printStackTrace();
																				    }
																				   
																				   
																				   cryptage();
																					
																				}
																		
					                                               }
											);
					
			/*---------------------------------------------------------------------------------------------------------------------------------------------*/		
					jb2.addActionListener(new ActionListener() {   //Ecoute du bouton "jb2" avec une classe anonyme implementant l'interface ActionListener.
						
																		@Override
																		public void actionPerformed(ActionEvent arg0)
																				{
																			       jta1.add(label3,BorderLayout.EAST); //Affichage de la baniere.
																			       
																			       try {                             //Pause de 2 secondes.
																					    Thread.sleep(1500);
																					  
																				      }
																			      
																			      catch (InterruptedException e) 
																			        {
																				      e.printStackTrace();
																				    }
																			       
																			       decryptage();  
																					
																				}
																}
										 );
			/*---------------------------------------------------------------------------------------------------------------------------------------------*/		
				
					
					jftf1.addActionListener(new ActionListener() {   //Ecoute de la zone de texte formatee "jftf2" avec une classe anonyme implementant l'interface ActionListener.
						
																	@Override
																	public void actionPerformed(ActionEvent arg0)
																			{
																				
																				
																			}
																 }
										  );
					
					
			/*---------------------------------------------------------------------------------------------------------------------------------------------*/			
					fermer.addActionListener(new ActionListener()
																	{
																	
																			@Override
																			public void actionPerformed(ActionEvent arg0) 
																			{
																				
																				  int quit = jop2.showConfirmDialog(null,"Voulez-vous quitter ?","Déconnexion ...",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,new ImageIcon("images/info.png"));
																                  if (quit==0)
																                     {
																                
																          	            System.exit(0);
																                     }
																				
																			}
											
																	 }
											);
					
			/*---------------------------------------------------------------------------------------------------------------------------------------------*/
				
					
					 auteur.addActionListener(new ActionListener()    //Ecoute du JMenuItem "auteur" par une classe anonyme implementant actionListener.
															       {
																	
																			@Override
																			public void actionPerformed(ActionEvent arg0)
																			{
																							   
																				   jop1.showMessageDialog(null," Ce programme a été codé par :\n M. Pape Moussa SONKO,\n Administrateur Systeme Reseau,\n Developpeur d'Applications...\n Tel: 70 643 80 29 / 78 544 67 79","A propos de l'auteur",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("images/pape.png"));
																				
																			
																			}
															       }
																			
											  );

			/*---------------------------------------------------------------------------------------------------------------------------------------------*/
				jrmi1.addActionListener(new ActionListener() //Definition de la taille de police "petite"
														{
															
															
															public void actionPerformed(ActionEvent arg0)
																{						
																   Font police6 = new Font("Times new roman",Font.BOLD, 22);
																   jta1.setFont(police6);
																}
														}
										);	
					
			/*---------------------------------------------------------------------------------------------------------------------------------------------*/	
				jrmi2.addActionListener(new ActionListener() //Definition de la taille de police "petite"
													{
														
														
														public void actionPerformed(ActionEvent arg0)
															{						
															   Font police6 = new Font("Times new roman",Font.BOLD, 26);
															   jta1.setFont(police6);
															}
													}
										);	
					
		   /*---------------------------------------------------------------------------------------------------------------------------------------------*/
				jrmi3.addActionListener(new ActionListener() //Definition de la taille de police "petite"
														{
															
															
															public void actionPerformed(ActionEvent arg0)
																{						
																   Font police6 = new Font("Times new roman",Font.BOLD, 34);
																   jta1.setFont(police6);
																}
															
														}

										);	
		  /*---------------------------------------------------------------------------------------------------------------------------------------------*/
				
				effacer.addActionListener(new ActionListener() //Definition de la taille de police "petite"
							{
								
								
								public void actionPerformed(ActionEvent arg0)
									{						
									   
									   jta1.setText("");;
									}
								
							}
			
			);	
        /*---------------------------------------------------------------------------------------------------------------------------------------------*/	
				
				
				
				
				
				
				
				
				
					container.setLayout(new BorderLayout());				
					container.add(pan_haut, BorderLayout.NORTH);
					container.add(pan_milieu, BorderLayout.CENTER);
					container.add(pan_bas, BorderLayout.SOUTH);
					
					t.start(); //On demarre le Thread.
					screen(); //Appel de la methode du screensplash
					initMenu(); //Appel de la methode du menu
					this.setContentPane(container);
					this.setVisible(true);
				}
	
	//*********************************************************************************************************************************************
			 public void screen ()
			   
		       {
			      label2=new JLabel(new ImageIcon("images/splash.png"));
			      splashpan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			      splashpan.setBackground(Color.gray);
			      splashpan.setLayout(new BorderLayout());
			      splashpan.add(label2,BorderLayout.CENTER);
			      splashpan.add(bar, BorderLayout.SOUTH);
			      splash.setContentPane(splashpan);
			      
			      splash.setSize(700, 300);
			      splash.setLocationRelativeTo(null);
			      splash.setVisible(true);
			      
			      try {
					    Thread.sleep(5000); //Pause de 5 secondes.
					  }
			      
			      catch (InterruptedException e) 
			          {
				          e.printStackTrace();
				      }
			      
			      splash.setVisible(false); //Apres 5 secondes, le screen splash disparait.
		       }
			//***************************************************************************************************************************************
			 /*----------------Methode  la barre de progression--------------------------------------------------*/    
			   
			   class Traitement implements Runnable
			   
			       {   
				          public void run()
				    
				               {
				     
				         
						                 for(int val = 0; val <= 500; val++)
						      
						                    {
								                 bar.setValue(val);
								                 
								                 try
								                    {
								                        t.sleep(9);
								                    } 
								        
								                 catch (InterruptedException e)					        
								                     {
								                          // TODO Auto-generated catch block
								                          e.printStackTrace();
								                     }	
								                 
								               
				                            }
				     
				                }  
				    }
				 //*****************************************************************************************************************************************
	
			
	
				public void initMenu ()
				
						{
					
					       
					
					       police.add(jrmi1);
					       police.add(jrmi2);
					       police.add(jrmi3);
					       
					       rendu.add(clair_cryte);
					       rendu.add(crypte);
					       
					      
					       
					       afficher.add(police);
					       afficher.addSeparator();
					       afficher.addSeparator();
					       afficher.add(rendu);
					       
					       
					      
					       fichier.add(effacer);
					       afficher.addSeparator();
					       afficher.addSeparator();
					       fichier.add(fermer);
					      
					       apropos.add(auteur);
					       
					       menubar.add(fichier);
					       menubar.add(afficher);
					       menubar.add(apropos);
					       
					       this.setJMenuBar(menubar);
					
						}
				
				
				
				/*-----------------------------------------------------Cryptage--------------------------------------------------------------------*/
				
				public void cryptage ()
				
				
						{
					
				        	
								
					 			msg1 = jta1.getText().trim();
					 			msg2 = msg1.toUpperCase();
					 		    cle1 = Integer.valueOf(jftf1.getText()).intValue();	//Conversion de String a Int.
					 		   
					 		    //System.out.println(cle1);
					 		   
					 		   char tabChar[]=new char[msg2.length()];
					 		 
								for ( i=0; i<msg2.length();i++)
								  
								    {
										  carac1=msg2.charAt(i);
										 
											
											for (j=0; j<alphabet.length;j++)
												{
												       carac2=alphabet[j];
												      
														       if(carac1==carac2)
																   {  
																       k1=((j+cle1)%27); //k1 recoit un entier.
																      
																       tabChar[i]=(alphabet[k1]); //Chaque element du message code sera mis dans le tableau de caracteres.
																       
																       str1=str1.copyValueOf(tabChar); //Copie des valeurs d'un tableau de caracteres et concatenation puis affectation dans un string "str" 
																       jta1.setForeground(Color.RED);
																      
																      
																       
																     
																        
																        jta1.setText(str1);
																     
																      
															    	   
																   }
														       
														      
												}
											
								     }
								
						   }
				
				
				/*-----------------------------------------------------Decryptage--------------------------------------------------------------------*/
								
							public void decryptage()
							
											{
											
												msg3 = jta1.getText();
									 			msg4 = msg3.toUpperCase();
												cle2= Integer.valueOf(jftf1.getText()).intValue();	//Conversion de String a Int.
												
												char tabChar[]=new char[msg4.length()];
												 //System.out.println(msg4);
												 //System.out.println(cle2);												
															
																 for (m=0; m < msg4.length();m++)
																 
																		 {	
																			  carac3=msg4.charAt(m);
																			  
																				 for  (j=0; j< alphabet.length;j++)
																				  
																					 {	
																						 carac4=alphabet[j];
																						 
																							if(carac3==carac4 && cle1==cle2)
																								 {	
																								   k2=((27+j-cle2)%27); 			//27 egale 26 et 1
																								   tabChar[m]=(alphabet[k2]);
																								   str2=str2.copyValueOf(tabChar);
																								   jta1.setForeground(Color.GREEN);
																									   
																								     if(crypte.isSelected())
																										   {
																								    	       
																											   jta1.setText(str2);
																										   }
																								     else
																								           {
																								    	      jta1.setText(msg2+" ");
																								    	      jta1.setText(str2);
																								    	     
																								           }
																								           
																								 }
																							
																							
																							if (cle1!=cle2 )
																							{
																						       jta1.setForeground(Color.RED);
																						       jta1.setAlignmentX(200);
																						       jta1.setText( " << CLE INCORRECT >>\n\n\n- Veuillez vérifier la clé de Décryptage !");
																																					
																							}
																							
																					  }	
																				 
																		  }
										
											}
	      /*---------------------------------------------------------------------------------------------------------------------------------------------*/
	
				
	
	
	
	
			public static void main(String[] args)
				
				{
				
						try{
			                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");	          
			                new Chiffrement_Decallage_IHM();  //Instanciation d'un objet "Chiffrement_Decallage_IHM".
			             }
				      
			          catch (Exception e)
			               {
			               }
				      
				   
			      
				}
				
				

}
