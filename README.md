# Product-Ordering-App

## Orhan Uçar Vize 2
 
Bu örnek projede, uygulamaya kullanıcı kayıt olabilir ve kayıtlı olan kullanıcı giriş yapıp servis aracılığı ile çekilen ürünlerin tamamını anasayfa da görebilir. Bunun yanı sıra tıkladığı ürünün detaylarını görür ve sepetine ekleyebilir.

## Kütüphaneler ve Özellikler
- Retrofit
- Glide
- CustomAdapter
- ListView
<h2>İzinler</h2>

Uygulama, internete erişim sağlamak için aşağıdaki izne ihtiyaç duyar:
<pre><code>&lt;uses-permission android:name="android.permission.INTERNET"/&gt;</code></pre>


<h2>plugins</h2>
<pre><code>plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-parcelize'
}</code></pre>

 
<h2>dependencies</h2>

<pre><code>dependencies {
    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.9.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
}</code></pre>    

<h2>Uygulama Ekran Görüntüleri</h2>
<p float="left">
  <img src=https://github.com/orhanucr/Product-Ordering-App/blob/main/images/Screenshot_1685714690.png width="30%" />
  <img src=https://github.com/orhanucr/Product-Ordering-App/blob/main/images/Screenshot_1685714681.png width="30%" />
  <img src=https://github.com/orhanucr/Product-Ordering-App/blob/main/images/Screenshot_1685714676.png width="30%" />

</p>



    
