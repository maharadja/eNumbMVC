/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.UserList;
import model.FileManager;
import model.WordList;
import model.User;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author kevin
 */
public class FileManagerTest
{
    FileManager fm;

    public FileManagerTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
        fm = new FileManager();
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testReadWordFile()
    {
       WordList words = fm.readWordFile("words1.txt");
       
       String result = words.getLang();
       String expResult = "engelska";
       
        Assert.assertEquals(expResult, result);
       
    }
    
    @Test
    public void testWriteWordListFile(){
        
        WordList wl = new WordList("hund");
        for (int i = 0; i < 10; i++) {
            wl.addNewWord("hund", "dog", "engelska");
        }
                
        fm.writeWordFile(wl);
        
        File result = new File("hund.txt");
        
        Assert.assertTrue("lol", result.exists());
        
    }
    
    @Test
    public void testReadUserFile(){
        
        UserList result = fm.readUserFiles();
        String[] expResult = new String[]{"adrian", "ronsten", "lol"};
        Assert.assertEquals(expResult[0], result.getUser(0).getfirstname());
        Assert.assertEquals(expResult[1], result.getUser(0).getlastname());
        Assert.assertEquals(expResult[2], result.getUser(0).getPassword());
    }
    
    @Test
    public void testWriteUserFile(){
        
        User user = new User("viktor", "zetterberg", "korvkalas");
        user.setHighscore(2000);
        fm.writeUserFile(user);
        
        File result = new File("viktor zetterberg.txt");
        
        Assert.assertTrue("lol", result.exists());
        
    }
    
    @Test
    public void testRemovingFile(){
        
        fm.removeFile("viktor zetterberg");
        
        File result = new File("viktor zetterberg.txt");
        
        Assert.assertFalse("lol", result.exists());
    }
            

}
