package com.example.kanoun_hana_mesure_glycemie.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.kanoun_hana_mesure_glycemie.model.User;
import com.example.kanoun_hana_mesure_glycemie.view.HomeActivity;
import com.example.kanoun_hana_mesure_glycemie.view.MainActivity;

public class HomeController {
    private static User user;
    private static HomeController instace=null;
    private static final String SHARED_PREFS ="HomeActivitySharedPrefs";
    private HomeController(){super();}
    public static final HomeController getInstance(Context context){
        if(HomeController.instace==null){
            HomeController.instace=new HomeController();
        }
        recapUser(context);
        return HomeController.instace;
    }
    public void createUser(String email, String password, Context context){
        user=new User(email,password);
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email",email);
        editor.putString("password",password);
        editor.apply();
    }
    public static void recapUser(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email","");
        String password = sharedPreferences.getString("password","");
    }
    public String getUserEmail(){
        return user.getEmail();
    }
    public String getUserPassword(){
        return user.getPassword();
    }
}
