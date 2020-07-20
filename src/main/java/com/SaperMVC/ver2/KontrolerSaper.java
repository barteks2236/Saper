package com.SaperMVC.ver2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class KontrolerSaper {

	 public static void wygrana() {
	        boolean won = true;
	        for(int i = 0; i < WidokSaper.jakWielka; i++)
	        {
	            for(int j = 0; j < WidokSaper.jakWielka; j++)
	            {
	                if(WidokSaper.bombTab[i][j] != WidokSaper.ileBomb && WidokSaper.guziczki[i][j].isEnabled())
	                {
	                    won = false;
	                }
	            }
	        }
	        if(won) 
	        {
	             JOptionPane.showMessageDialog(null,"You have won!", "Congratulations!",
	                                           JOptionPane.INFORMATION_MESSAGE);
	        }   
	     }
	 
    public static void przegrana(int m){

        for(int x = 0; x <   WidokSaper.jakWielka; x++)
        {
            for(int y = 0; y < WidokSaper.jakWielka; y++)
            {
                if(WidokSaper.guziczki[x][y].isEnabled())          
                {
                    if(WidokSaper.bombTab[x][y] != WidokSaper.ileBomb)
                    {
                        WidokSaper.guziczki[x][y].setText(""+ WidokSaper.bombTab[x][y]);                    
                    }

                    else
                    {
                        WidokSaper.guziczki[x][y].setText("X");

                    }
                    WidokSaper.guziczki[x][y].setEnabled(false);
                }
            }
        }
    JOptionPane.showMessageDialog(null, m==1? "You clicked a mine!":"You Gave Up",
                                 "Game Over", JOptionPane.ERROR_MESSAGE);
    }
	
    
    public static void bomby(int s){  			//B: WYSADZAMY!!!!!!
        ArrayList<Integer> list = new ArrayList<>(); 
            for(int x = 0; x < s; x++)
            {
                for(int y = 0; y < s; y++)
                {
                    list.add(x*100+y);                       
                }
            }
            WidokSaper.bombTab = new int[s][s];                   

            for(int a = 0; a < (int)(s * 1.5); a++)
            {
                int choice = (int)(Math.random() * list.size());
                WidokSaper.bombTab [list.get(choice) / 100] [list.get(choice) % 100] = WidokSaper.ileBomb;     
                list.remove(choice);                                                                            
            }
            
            
            for(int x = 0; x < s; x++)
            {
               for(int y = 0; y < s; y++)
               {
                if(WidokSaper.bombTab[x][y] != WidokSaper.ileBomb)
                {
                    int neighbor = 0;
                    if( x > 0 && y > 0 && WidokSaper.bombTab[x-1][y-1] == WidokSaper.ileBomb)
                    {
                        neighbor++;
                    }
                    if( y > 0 && WidokSaper.bombTab[x][y-1] == WidokSaper.ileBomb)
                    {
                        neighbor++;
                    }
                    if( y < WidokSaper.jakWielka - 1 && WidokSaper.bombTab[x][y+1] == WidokSaper.ileBomb)
                    {
                        neighbor++;
                    }
                    if( x < WidokSaper.jakWielka - 1 && y > 0 && WidokSaper.bombTab[x+1][y-1] == WidokSaper.ileBomb)
                    {
                        neighbor++;
                    }
                    if( x > 0 && WidokSaper.bombTab[x-1][y] == WidokSaper.ileBomb)
                    {
                        neighbor++;
                    }
                    if( x < WidokSaper.jakWielka - 1 && WidokSaper.bombTab[x+1][y] == WidokSaper.ileBomb)
                    {
                        neighbor++;
                    }
                    if( x > 0 && y < WidokSaper.jakWielka - 1 &&WidokSaper.bombTab[x-1][y+1] == WidokSaper.ileBomb)
                    {
                        neighbor++;
                    }
                    if( x < WidokSaper.jakWielka - 1 && y < WidokSaper.jakWielka - 1 && WidokSaper.bombTab[x+1][y+1] == WidokSaper.ileBomb)
                    {
                        neighbor++;
                    }
                    WidokSaper.bombTab[x][y] = neighbor;                      
                }
               }
            }
        }
    
    
    
    
    
    public static void reszta(ArrayList<Integer> toClear){  //B: Nie wiem jak nazwaæ te masowe znikanie okien wiêc bêd¹ to resztki :D 
        if(toClear.isEmpty())
            return;                        

        int x = toClear.get(0) / 100;       
        int y = toClear.get(0) % 100;      
        toClear.remove(0);                   
            if(WidokSaper.bombTab[x][y] == 0)
            {                              

                if( x > 0 && y > 0 && WidokSaper.guziczki[x-1][y-1].isEnabled())
                {
                    WidokSaper.guziczki[x-1][y-1].setText(WidokSaper.bombTab[x-1][y-1] + "");
                    WidokSaper.guziczki[x-1][y-1].setEnabled(false);
                    if(WidokSaper.bombTab[x-1][y-1] == 0)
                    {
                        toClear.add((x-1)*100 + (y-1));     
                    }
                }
                if( y > 0 && WidokSaper.guziczki[x][y-1].isEnabled())
                {
                    WidokSaper.guziczki[x][y-1].setText(WidokSaper.bombTab[x][y-1] + "");
                    WidokSaper.guziczki[x][y-1].setEnabled(false);
                    if(WidokSaper.bombTab[x][y-1] == 0)
                    {
                        toClear.add(x*100 + (y-1));
                    }

                }
                if( y < WidokSaper.jakWielka - 1 && WidokSaper.guziczki[x][y+1].isEnabled())
                {
                    WidokSaper.guziczki[x][y+1].setText(WidokSaper.bombTab[x][y+1] + "");
                    WidokSaper.guziczki[x][y+1].setEnabled(false);
                    if(WidokSaper.bombTab[x][y+1] == 0)
                    {
                        toClear.add(x*100 + (y+1));
                    }

                }
                if( x < WidokSaper.jakWielka - 1 && y > 0 && WidokSaper.guziczki[x+1][y-1].isEnabled())
                {
                    WidokSaper.guziczki[x+1][y-1].setText(WidokSaper.bombTab[x+1][y-1] + "");
                    WidokSaper.guziczki[x+1][y-1].setEnabled(false);
                    if(WidokSaper.bombTab[x+1][y-1] == 0)
                    {
                        toClear.add((x+1)*100 + (y-1));
                    }

                }
                if( x > 0 && WidokSaper.guziczki[x-1][y].isEnabled())
                {
                    WidokSaper.guziczki[x-1][y].setText(WidokSaper.bombTab[x-1][y] + "");
                    WidokSaper.guziczki[x-1][y].setEnabled(false);
                    if(WidokSaper.bombTab[x-1][y] == 0)
                    {
                        toClear.add((x-1)*100 + y);
                    }

                }
                if( x < WidokSaper.jakWielka - 1 && WidokSaper.guziczki[x+1][y].isEnabled())
                {
                    WidokSaper.guziczki[x+1][y].setText(WidokSaper.bombTab[x+1][y] + "");
                    WidokSaper.guziczki[x+1][y].setEnabled(false);
                    if(WidokSaper.bombTab[x+1][y] == 0)
                    {
                        toClear.add((x+1)*100 + y);
                    }

                }
                if( x > 0 && y < WidokSaper.jakWielka - 1 && WidokSaper.guziczki[x-1][y+1].isEnabled())
                {
                    WidokSaper.guziczki[x-1][y+1].setText(WidokSaper.bombTab[x-1][y+1] + "");
                    WidokSaper.guziczki[x-1][y+1].setEnabled(false);
                    if(WidokSaper.bombTab[x-1][y+1] == 0)
                    {
                        toClear.add((x-1)*100 + (y+1));
                    }

                }
                if( x < WidokSaper.jakWielka - 1 && y < WidokSaper.jakWielka - 1 && WidokSaper.guziczki[x+1][y+1].isEnabled())
                {
                    WidokSaper.guziczki[x+1][y+1].setText(WidokSaper.bombTab[x+1][y+1] + "");
                    WidokSaper.guziczki[x+1][y+1].setEnabled(false);
                    if(WidokSaper.bombTab[x+1][y+1] == 0)
                    {
                        toClear.add((x+1)*100 + (y+1));
                    }

				}
			}
			reszta(toClear);
		}
	}
