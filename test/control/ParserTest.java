/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
        parser = new Parser();
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

}
