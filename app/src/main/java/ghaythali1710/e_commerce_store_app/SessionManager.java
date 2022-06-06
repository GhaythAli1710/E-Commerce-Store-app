package ghaythali1710.e_commerce_store_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.core.util.Pools;

public class SessionManager {
    private static final String SHARED_PRE_NAME = "userToken";
//    private static final String KEY_ID = "user_id";
//    private static final String KEY_NAME = "name";
//    private static final String KEY_EMAIL = "email";
    private static final String KEY_TOKEN = "token";
    private static SessionManager mInstance;
    private static Context mCtx;

    public SessionManager(Context context){
        this.mCtx = context;
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
//        editor.putInt(KEY_ID, user.getId());
//        editor.putString(KEY_NAME, user.getName());
//        editor.putString(KEY_EMAIL, user.getEmail());
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
//    public String getToken(){
        SharedPreferences sharedPreferences =
                mCtx.getSharedPreferences(SHARED_PRE_NAME,Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString(KEY_TOKEN, null)
        );
//        return sharedPreferences.getString(KEY_TOKEN, null);
    }

    public void userLogout(){
        SharedPreferences sharedPreferences =
                mCtx.getSharedPreferences(SHARED_PRE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx,LoginActivity.class));
    }

    public User getUser(User user){
        SharedPreferences sharedPreferences =
                mCtx.getSharedPreferences(SHARED_PRE_NAME,Context.MODE_PRIVATE);
        return new User(
//                sharedPreferences.getInt(KEY_ID, -1),
//                sharedPreferences.getString(KEY_NAME, null),
//                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_TOKEN, null)
        );
    }
}
