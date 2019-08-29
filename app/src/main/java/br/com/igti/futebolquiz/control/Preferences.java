package br.com.igti.futebolquiz.control;

import android.content.Context;
import android.preference.PreferenceManager;

public class Preferences {
    private static final String PREF_PRIMEIRA_VEZ = "primeiraVez";
    public static boolean isPrimeiraVez(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREF_PRIMEIRA_VEZ,true);
    }
    public static void setPrimeiraVezFalse(Context context){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(PREF_PRIMEIRA_VEZ,false)
                .commit();

    }
    public static void clear(Context context){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(PREF_PRIMEIRA_VEZ,true)
                .commit();

    }
}
