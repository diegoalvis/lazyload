package com.example.alvis.lazyloadlibrary;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int STORAGE_PERMISSION_CODE = 212;
    ListView list;
    ImageLoadAdapter adapter;
    Button refresh;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solicitarPermisos();

        list = (ListView) findViewById(R.id.list);
        refresh = (Button) findViewById(R.id.button_refresh);
        refresh.setOnClickListener(listener);

        adapter = new ImageLoadAdapter(this, mStrings);
        list.setAdapter(adapter);

    }


    @Override
    public void onDestroy()
    {
        // Remove adapter refference from list
        list.setAdapter(null);
        super.onDestroy();
    }

    public View.OnClickListener listener=new View.OnClickListener(){
        @Override
        public void onClick(View arg0) {
            //Refresh cache directory downloaded images
            adapter.imageLoader.clearCache();
            adapter.notifyDataSetChanged();
        }
    };


    public void onItemClick(int mPosition)
    {
        String tempValues = mStrings[mPosition];

        Toast.makeText(MainActivity.this,
                "Image URL : "+tempValues,
                Toast.LENGTH_LONG).show();
    }

    // Image urls used in ImageLoadAdapter.java file

    private String[] mStrings= {
            "http://www.wallpapereast.com/static/images/Mario-mario-wallpaper-hd-games-1920x1080_tcCtADV.jpg",
            "https://newevolutiondesigns.com/images/freebies/cool-wallpaper-3.jpg",
            "http://www.wallpapereast.com/static/images/3d-wallpaper-hd_nB6k1Up.jpg",
            "https://newevolutiondesigns.com/images/freebies/hd-widescreen-wallpaper-2.jpg",
            "http://www.planwallpaper.com/static/images/cool-wallpapers-hd-8087-8418-hd-wallpapers.jpg",
            "http://imgsplanet.com/pics/main/1/215926-cool-images.jpg",
            "http://www.qdtricks.org/wp-content/uploads/2014/03/computer-hd-wallpapers-technology.jpg",
            "http://mundotech.net/wp-content/uploads/2008/05/serpent-widescreen.jpg",
            "http://www.wallpapereast.com/static/images/Mario-mario-wallpaper-hd-games-1920x1080_tcCtADV.jpg",
            "https://newevolutiondesigns.com/images/freebies/cool-wallpaper-3.jpg",
            "http://www.wallpapereast.com/static/images/3d-wallpaper-hd_nB6k1Up.jpg",
            "https://newevolutiondesigns.com/images/freebies/hd-widescreen-wallpaper-2.jpg",
            "http://www.planwallpaper.com/static/images/cool-wallpapers-hd-8087-8418-hd-wallpapers.jpg",
            "http://imgsplanet.com/pics/main/1/215926-cool-images.jpg",
            "http://www.qdtricks.org/wp-content/uploads/2014/03/computer-hd-wallpapers-technology.jpg",
            "http://mundotech.net/wp-content/uploads/2008/05/serpent-widescreen.jpg"
    };




    private void solicitarPermisos() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                onRestart();
            else
                solicitarPermisos();
        }
    }
}
