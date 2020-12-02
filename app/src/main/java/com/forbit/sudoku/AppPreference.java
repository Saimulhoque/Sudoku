package com.forbit.sudoku;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class AppPreference {
    private static final String SP_NAME ="AppPreference";
    private static final String COUNTER ="COUNTER";
    private static final String FINAL_ARRAY ="FINAL_ARRAY";
    private static final String BASIC_ARRAY ="BASIC_ARRAY";


    private SharedPreferences userLocalDatabase;


    private static AppPreference instance;


    private AppPreference(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME,0);
    }

    public static AppPreference getInstance(Context context) {
        if (instance == null) {
            instance = new AppPreference(context);
        }
        return instance;
    }


    public void increaseCounter(){
        int prev = userLocalDatabase.getInt(COUNTER,0);
        prev++;
        userLocalDatabase.edit().putInt(COUNTER,prev).apply();
    }

    public int getCounter(){
        return userLocalDatabase.getInt(COUNTER,0);
    }

    public void resetCounter(){
        userLocalDatabase.edit().putInt(COUNTER,0).apply();
    }

    public void setFinalArray(int[][] array){
        String value = "";
        for (int i=0; i<array.length;i++){
            for (int j=0; j<array[i].length;j++){
                String end;
                if(j==array[i].length-1){
                    end="|";
                }else {
                    end=",";
                }
                value=value+array[i][j]+end;
            }
        }
        value = value.substring(0,value.length()-1);
        userLocalDatabase.edit().putString(FINAL_ARRAY,value).apply();
    }

    public int[][] getFinalArr(){
        String value = userLocalDatabase.getString(FINAL_ARRAY,null);

        int[][] retArr=new int[9][9];
        
        if(value!=null){
            String[] rows = value.split("\\|");
            for (int i=0;i<rows.length;i++){

                String[] cols = rows[i].split(",");
                for (int j=0;j<cols.length;j++){
                    Log.d("YYYYY",cols[j]);
                    retArr[i][j]= Integer.parseInt(cols[j]);
                }
            }
        }

        return retArr;
    }

    public void setBasicArray(int[][] array){
        String value = "";
        for (int i=0; i<array.length;i++){
            for (int j=0; j<array[i].length;j++){
                String end;
                if(j==array[i].length-1){
                    end="|";
                }else {
                    end=",";
                }
                value=value+array[i][j]+end;
            }
        }
        value = value.substring(0,value.length()-1);
        userLocalDatabase.edit().putString(BASIC_ARRAY,value).apply();
    }

    public int[][] getBasicArr(){
        String value = userLocalDatabase.getString(BASIC_ARRAY,null);

        int[][] retArr=new int[9][9];

        if(value!=null){
            String[] rows = value.split("\\|");
            for (int i=0;i<rows.length;i++){

                String[] cols = rows[i].split(",");
                for (int j=0;j<cols.length;j++){
                    retArr[i][j]= Integer.parseInt(cols[j]);
                }
            }
        }

        return retArr;
    }
}
