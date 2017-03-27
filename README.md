# LanguageSwitchView
To switch the language without restarting the app, create a custom TextView button that can be switched according to the current ResId language EditText ImageView
## Add Library
```
	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
        dependencies {
	        compile 'com.github.twcgood:LanguageSwitchView:v1.1'
	}
  ```
  ## Code Sample
```
1.
    <com.leisure.tang.languageswitchviewlibrary.LSTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/test"/>
    <com.leisure.tang.languageswitchviewlibrary.LSButton
        android:id="@+id/LSBt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/test"/>
    <com.leisure.tang.languageswitchviewlibrary.LSEditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="@string/test"/>

    <com.leisure.tang.languageswitchviewlibrary.LSImageView
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:src="@drawable/loginbackground"/>
 2.    
    findViewById(R.id.LSBt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LSUtil.switchLanguage(MainActivity.this, Locale.ENGLISH);
                LSUtil.updateViewLanguageforActivity(MainActivity.this);
            }
        });
        
  ```      
        

 
   ## Tips
    
    如果要实现全局的改变，需要用EventBus或广播，接收到广播后调用该法
    把切换语言的方法写在BaseActivity里的话，写一遍即可
    
