import greenfoot.*;
import java.awt.Color;
import javax.swing.JOptionPane;
 
/**
 * THis is the label box where user is notified with the criterias he/she selects as a move in the game.
 */
public class LabelBox extends TextBox
{
    static final int NAME_INPUT_LENGTH = 40;
    String text = "";
    int inputNumber;
     
    public LabelBox()
    {
        updateImage(text);
        text = "";
    }
     
    public void updateImage(String text)
    {
        GreenfootImage image = new GreenfootImage(200, 30);
        image.setColor(Color.white);
        image.fill();
        GreenfootImage textImage = new GreenfootImage(text, 20, Color.black, null);
        image.drawImage(textImage, 20, 5);
        setImage(image);
    }
 
    public void act()
    {
        
    }
    
     /**
     *@rushin 
     * Function to clear text once the search button has been clicked
    */
    public void clearText()
    {
            text = "";
            updateImage(text);
            return;
        }
}