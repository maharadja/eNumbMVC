/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Game;

/**
 *
 * @author Magnum
 */
public class SignupListener
{

    private String firstName;
    private String lastName;
    private String password;
    private String passwordRetype;
    private Game game;

    public SignupListener(String firstName, String lastName, String password, String passwordRetype)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.passwordRetype = passwordRetype;
        game = new Game();
        addNewUser(firstName, lastName, password, password);
        System.out.println(lastName);
    }

    public SignupListener()
    {

    }

    public void addNewUser(String firstName, String lastName, String password, String passwordRetype)
    {
        game.addNewUser(firstName, lastName, password, password);
    }

}
