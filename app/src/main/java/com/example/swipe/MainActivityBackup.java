//package com.example.swipe;
//
//import androidx.annotation.RequiresApi;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.GestureDetector;
//import android.view.MotionEvent;
//import android.view.View;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class MainActivity extends AppCompatActivity {
//
//    WebView webView;
//    SwipeRefreshLayout swipeRefreshLayout;
//    TextView textViewError;
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        swipeRefreshLayout = findViewById(R.id.swipeContainer);
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//
//            @Override
//            public void onRefresh(){
//                LoadWeb();
//            }
//
//        });
//
//        LoadWeb();
//
//    }
//
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    public void LoadWeb(){
//        textViewError = findViewById(R.id.textError);
//
//        if (isNetworkAvailable()) {
//            Web();
//            textViewError.setVisibility(View.INVISIBLE);
//        }else{
//            textViewError.setVisibility(View.VISIBLE);
//        }
//    }
//
//
//    @SuppressLint("SetJavaScriptEnabled")
//    public void Web(){
//        webView = findViewById(R.id.webView);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("https://akbarak.kontentchi.com/");
//        webView.setWebViewClient(new WebViewClient()
//        {
//            public void onPageFinished(WebView view, String url){
//                swipeRefreshLayout.setRefreshing(false);
//            }
//        });
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    private boolean isNetworkAvailable() {
//        ConnectivityManager connectivityManager
//                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
//    }
//
//    @Override
//    public void onBackPressed(){
//        if (webView.canGoBack()){
//            webView.goBack();
//        }else{
//            finish();
//        }
//    }
//}