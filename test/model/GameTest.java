/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
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
        String expResult = "adriasn ronsten";

        assertEquals(expResult, result[0]);
    }

    @Test
    public void testGetUser()
    {

        String expResult = "adrian ronsten";

        User result = game.getUser(expResult);

        assertEquals(expResult, result.getUsername());

    }

}
