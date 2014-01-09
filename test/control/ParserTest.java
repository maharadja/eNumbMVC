/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Game;
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
public class ParserTest
{

    private Parser parser;

    public ParserTest()
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
        Game game = new Game();
        parser = new Parser(game);
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testvalidateUserInput()
    {
        String expResult = "abcd";
        Assert.assertEquals(expResult, parser.validateUserInput("ABCD"));
    }

    @Test
    public void testMaxMinLettersControl()
    {

        Assert.assertFalse(Parser.maxLetters("abcdefghijklmnopqrstuvwxyzåäö"));
        Assert.assertTrue(Parser.maxLetters("mumintroll"));

    }

    @Test
    public void testIfInputContainsNumbers()
    {

        Assert.assertFalse(Parser.lookForNumbers("hej123"));
        Assert.assertTrue(Parser.lookForNumbers("hejsan"));

    }

    @Test
    public void testValidatingUsername()
    {

        Assert.assertTrue(parser.validateUserName("SkogsHamster imU"));
        Assert.assertFalse(parser.validateUserName("adrian ronsten"));
        Assert.assertFalse(parser.validateUserName("12312331232131232 1231231231212321"));
    }

    @Test
    public void testPasswordsAreTheSame()
    {

        Assert.assertTrue(Parser.passwordCheck("hej", "då"));
        Assert.assertFalse(Parser.passwordCheck("hej", "hej"));

    }

    @Test
    public void testPasswordMatchingUsername()
    {

        Assert.assertTrue(parser.checkIfPasswordCorrect("adrian ronsten", "lol"));
        Assert.assertFalse(parser.checkIfPasswordCorrect("kalle stropp", "snor"));
    }

}
