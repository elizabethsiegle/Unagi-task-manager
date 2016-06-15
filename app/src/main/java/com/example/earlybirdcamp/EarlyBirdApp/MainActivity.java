package com.example.earlybirdcamp.EarlyBirdApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.util.Log;
import android.content.Intent;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.*;




import io.fabric.sdk.android.Fabric;

// @author  Tuan Anh Tran added
// @author Christina Le


public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "MVDpjnBdyr4dtnWD13dOSNsLc";
    private static final String TWITTER_SECRET = "Spu1Z3rwQHeUKS6D9Xwrk5KNVDd9seM7yCR4js5ZpHiC5y6yqF";

    private TwitterLoginButton loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);


        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                //  Remove: commented code we don't need
                TwitterSession session = result.data;
                // Purpose: Creates an intent to send the user to TaskActivity Upon Success
                Intent intent = new Intent(MainActivity.this,TaskActivity.class);
                intent.putExtra("user",session.toString());
                finish();
                startActivity(intent);

            }
            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Login with Twitter failure", exception);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Make sure that the loginButton hears the result from any
        // Activity that it triggered.
        loginButton.onActivityResult(requestCode, resultCode, data);

    }
// hello guys this is a test yes !!!
}

//Lizzie
