package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by 16020267 on 6/8/2018.
 */


public class WebViewActivity extends AppCompatActivity {
    WebView wvPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_page);

        wvPage = findViewById(R.id.webviewpage);

        wvPage.setWebViewClient(new WebViewClient());

        wvPage.getSettings().setDisplayZoomControls(true);

        Intent intentReceived = getIntent();
        String url = intentReceived.getStringExtra("url");
        wvPage.loadUrl(url);
    }
}