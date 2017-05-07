package com.day.scheduler;

import com.day.schadualer.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LogCatActivity extends Activity{

	String url;
	WebView webView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logcat);
		Intent i = getIntent();
		url = i.getStringExtra("url");
		init();
	}
	
	private void init(){
        webView = (WebView) findViewById(R.id.web_logcat);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //WebView����web��Դ
       webView.loadUrl(url);
        //����WebViewĬ��ʹ�õ�������ϵͳĬ�����������ҳ����Ϊ��ʹ��ҳ��WebView��
       webView.setWebViewClient(new WebViewClient(){
           @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
               //����ֵ��true��ʱ�����ȥWebView�򿪣�Ϊfalse����ϵͳ�����������������
             view.loadUrl(url);
            return true;
        }
       });
    }
}
