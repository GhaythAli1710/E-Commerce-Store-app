package ghaythali1710.e_commerce_store_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;


public class SessionManager {
    private static final String SHARED_PRE_NAME = "userToken";
    private static final String KEY_TOKEN = "token";
    @SuppressLint("StaticFieldLeak")
    private static SessionManager mInstance;
    @SuppressLint("StaticFieldLeak")
    private static Context mCtx;

    public SessionManager(Context context){
        mCtx = context;
    }

    public static synchronized SessionManager getInstance(Context context){
        if(mInstance == null){
            mInstance = new SessionManager(context);
        }
        return mInstance;
    }

    public void userLogin(User user){
        SharedPreferences sharedPreferences =
                mCtx.getSharedPreferences(SHARED_PRE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_TOKEN, user.getToken());
        editor.apply();
        Toast.makeText(mCtx, "ok", Toast.LENGTH_SHORT).show();
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences =
                mCtx.getSharedPreferences(SHARED_PRE_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_TOKEN, null) != null;
    }

    public User getToken(){
        SharedPreferences sharedPreferences =
                mCtx.getSharedPreferences(SHARED_PRE_NAME,Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString(KEY_TOKEN, null)
        );
    }

    public void userLogout(){
        SharedPreferences sharedPreferences =
                mCtx.getSharedPreferences(SHARED_PRE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx,LoginActivity.class));
    }

    public User getUser(){
        SharedPreferences sharedPreferences =
                mCtx.getSharedPreferences(SHARED_PRE_NAME,Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString(KEY_TOKEN, null)
        );
    }
}
