import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CloseButton extends Actor
{
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public CloseButton(){
        GreenfootImage image = new GreenfootImage("close.png");
        image.scale(30,30);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
      MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this))
      {
          
          Greenfoot.playSound("button_click.mp3");
          World world = getWorld();
           if(world instanceof GamePlayWorld)
            {
              String message= "You will lose your progress.Do you really want to quit?";
              String title= "CONFIRMATION !!!";
              int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
              if (reply == JOptionPane.YES_OPTION)
                {
              if(getWorldOfType(GamePlayWorld.class).backgroundMusic!=null)
              {
                getWorldOfType(GamePlayWorld.class).backgroundMusic.stop();
                }
              
              //clearing the hashmap
                //for(Map.Entry<String,Boolean> entrySet :getWorldOfType(GamePlayWorld.class).previousQueryResultMap.entrySet())
                QueryResultBox resultBox = getWorldOfType(GamePlayWorld.class).getObjects(QueryResultBox.class).get(0);
                StringBuilder queryTest = new StringBuilder(); 
                for(Iterator<Map.Entry<String,Boolean>> it =getWorldOfType(GamePlayWorld.class).previousQueryResultMap.entrySet().iterator();it.hasNext();)
                 {
                     Map.Entry<String,Boolean> entry = it.next();
                     it.remove();
                     }
                 resultBox.updateImage(queryTest.toString());
                  
                
                
              GuessItWorld gameWorld=new GuessItWorld();
              gameWorld.started();
              Greenfoot.setWorld(gameWorld);
                }  
              
              }
          else
          {
          String message= "Do you really want to quit?";
          String title= "CONFIRM TO QUIT !!!";
          int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
          if (reply == JOptionPane.YES_OPTION)
             {
              GuessItWorld gameWorld=new GuessItWorld();
              gameWorld.started();
              Greenfoot.setWorld(gameWorld);
              }
        
          }   
       }
    }
}