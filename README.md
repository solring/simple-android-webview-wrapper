# simple-android-webview-wrapper

A basic Android webview wrapper with JS/local storage/debug msg enabled.

Most of the code is from [Android Developer docs](https://developer.android.com/develop/ui/views/layout/webapps/webview#kotlin).


### Changing the URL of the page embedded.

Simply open `MainActivity.kt` and change the variable `url` inside:

``` kotlin
val url: String = "https://www.google.com"
```

