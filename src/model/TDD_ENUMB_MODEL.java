/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.GetHandler;
import java.io.IOException;

/**
 *
 * @author Felix
 */
public class TDD_ENUMB_MODEL
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {

        GetHandler handle = new GetHandler();
        handle.getUserList();

    }

}
