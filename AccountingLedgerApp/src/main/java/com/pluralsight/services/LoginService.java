package com.pluralsight;
import com.pluralsight.models.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginService {
    private ArrayList<User> loginInfo = new ArrayList<User>();

    public void readLoginUserFile() {

        try {
            FileReader fileReader = new FileReader("AccountingLedgerApp/users.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufReader.readLine()) != null) {
                String[] entries = line.split("\\|");
                if (entries.length == 2) {
                    String username = entries[0];
                    String password = entries[1];

                    User newUser = new User(username,password);
                    loginInfo.add(newUser);
                }


            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void login(Scanner read){
        loginPrompt: while(true){
            System.out.println("Please enter your username: ");
            String enteredUsername = read.nextLine();
            System.out.println("Please enter your password: ");
            String enteredPassword = read.nextLine();

            readLoginUserFile();
            for(int i = 0; i < getLoginInfo().size(); i++){
                User listedUser = getLoginInfo().get(i);

                if (enteredUsername.contains(listedUser.getUsername()) &&
                        enteredPassword.contains(listedUser.getPassword())){
                    break loginPrompt;
                }

            }
            System.out.println("Invalid Username or Password");
        }
    }

    public ArrayList<User> getLoginInfo() {
        return loginInfo;
    }
}
