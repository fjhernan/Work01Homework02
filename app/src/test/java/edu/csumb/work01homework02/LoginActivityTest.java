package edu.csumb.work01homework02;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LoginActivityTest {

    @Test
    public void checkUsernameTest(){
        String acceptableNames[] = new String[] {"1","2","3","4","5","6","7","8","9","10"};

        LoginActivity loginActivity = new LoginActivity();
        //Test 1
        assertTrue(loginActivity.checkUsername("4", acceptableNames));
        //Test 2
        assertTrue(loginActivity.checkUsername("1", acceptableNames));
        //Test 3
        assertTrue(loginActivity.checkUsername("10", acceptableNames));
        //Test 4
        assertFalse(loginActivity.checkUsername("11", acceptableNames));
        //Test 5
        assertFalse(loginActivity.checkUsername("adf", acceptableNames));
        //Test 6
        assertFalse(loginActivity.checkUsername("0", acceptableNames));
    }

    @Test
    public void checkPasswordTest(){
        //String acceptableNames[] = new String[] {"1","2","3","4","5","6","7","8","9","10"};
        ArrayList<String> lazyPasswords = new ArrayList<>();
        for(int i = 0; i < 11; i++){
            lazyPasswords.add(Integer.toString(i));
        }
        LoginActivity loginActivity = new LoginActivity();
        //Assuming the user does exist
        //Test 1
        assertTrue(loginActivity.checkPassword("4", 4, lazyPasswords));
        //Test 2
        assertFalse(loginActivity.checkPassword("1", 4 ,lazyPasswords));
        //Test 3
        assertTrue(loginActivity.checkPassword("10", 10, lazyPasswords));
        //Test 4
        assertFalse(loginActivity.checkPassword("11", 10, lazyPasswords));
    }
}