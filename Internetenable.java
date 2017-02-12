package com.example.lostphoneapp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import android.net.ConnectivityManager;
import android.util.Log;
import android.content.Context;
public class Internetenable{

//enable Internet connection  
    public static void EnableInternet(Context mycontext)
    {
        try {
            Log.i("Reached Enable", "I am here");
            setMobileDataEnabled(mycontext,true);
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void DisableInternet(Context mycontext)
    {
        try {
            Log.i("Reached Disable", "I am here");
            setMobileDataEnabled(mycontext,false);
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//method to enable net connection 
    private static void setMobileDataEnabled(Context context , boolean enabled) throws NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
           final ConnectivityManager conman = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);

           final Class conmanClass = Class.forName(conman.getClass().getName());

           final Field iConnectivityManagerField = conmanClass.getDeclaredField("mService");
           iConnectivityManagerField.setAccessible(true);
           final Object iConnectivityManager = iConnectivityManagerField.get(conman);
           final Class iConnectivityManagerClass =  Class.forName(iConnectivityManager.getClass().getName());
           final Method setMobileDataEnabledMethod = iConnectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
           setMobileDataEnabledMethod.setAccessible(true);

           setMobileDataEnabledMethod.invoke(iConnectivityManager, enabled);
        }

}