package jefersonm.model;

/**
 * Created by jefersonm on 6/15/16.
 */

public class Tweet {

    private String firstName;
    private String lastName;

    public Tweet(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
