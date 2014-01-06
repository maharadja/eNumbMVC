/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Felix
 */
public class GameTest
{

    Game game;

    public GameTest()
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

        game = new Game();

    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetUsernameList()
    {

        String[] result = game.getUserList();
        String expResult = "adrian ronsten";

        assertEquals(expResult, result[0]);
    }

    @Test
    public void testGetUser()
    {

        String expResult = "adrian ronsten";

        User result = game.getUser(expResult);

        assertEquals(expResult, result.getUsername());

    }

    @Test
    public void testMatchingPassword()
    {

        assertTrue(game.checkPassword("adrian ronsten", "lol"));

    }

    @Test
    public void testAddingNewUser()
    {

        game.addNewUser("kalle", "stropp", "12345", "12345");

        assertNotNull(game.getUser("kalle stropp"));

    }

    @Test
    public void testCreateWordList()
    {

        String[] words = new String[]
        {

            "katt", "cat", "katt", "cat", "katt", "cat", "katt", "cat", "katt", "cat",
            "katt", "cat", "katt", "cat", "katt", "cat", "katt", "cat", "katt", "cat",
        };

        game.createWordList("vecka 1", "engelska", words);

        assertNotNull(game.getWordList("vecka 1"));

    }
    
    @Test
    public void testGettingListOfWordfiles(){
        
        assertNotNull(game.getListOfWordfiles());
        
    }
    
    @Test
    public void testGettingListOfLangauges(){
        
        //assertNotNull(game.getListOfLanguages());
        
    }

}
