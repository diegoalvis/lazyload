# Lazy Load
A library for  lazy load of images in Android saving data in cache memory.

#Gradle
build.gradle *project file*
-----
```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
build.gradle *module file*
-----
```
dependencies {
    ...
    compile 'com.github.diegoalvis:lazyload:v1.0'
}
```
... or you can go to https://jitpack.io/#diegoalvis/lazyload and follow the steps

================
#Permissions
* Internet permission 
* Write external storage permission

Manifest.xml 
-----
```xml
  <uses-permission android:name="android.permission.INTERNET"/>
  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```



Usage
-----
```java
  ImageLoader imageLoader = new ImageLoader(activity.getApplicationContext());
  ImageVIew imageView;
  
  imageLoader.DisplayImage(urlImage, imageView, android.R.drawable.default_image); 
  //Change default_image for drawable that show while get image of urlImage
```

in app folder there is a basic example of usage.

License
-------

    Copyright 2016 Diego Alvis

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
