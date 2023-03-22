package com.example.webviewwrapper

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

private class DebugWebViewClient : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        Log.d("WebViewWrapper", "loading url: ${url}")
        return false
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myWebView: WebView = WebView(this)

        // Enable JS initiated navigation
        myWebView.webViewClient = DebugWebViewClient()


        // Enable JS
        myWebView.settings.setJavaScriptEnabled(true)

        // Enable Local Storage
        myWebView.settings.setDomStorageEnabled(true);

        // Setup debug msg
        myWebView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(message: ConsoleMessage): Boolean {
                Log.d("WebViewWrapper", "${message.message()} -- "
                        + "line ${message.lineNumber()}: ${message.sourceId()}")
                return true
            }
        }

        val url: String = "https://www.google.com"
        setContentView(myWebView)
        myWebView.loadUrl(url)
    }
}