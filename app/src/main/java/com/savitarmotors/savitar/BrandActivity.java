package com.savitarmotors.savitar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class BrandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridView gridview=(GridView)findViewById(R.id.brands_grid_view);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                switch (position){
                    case 0:
                        Intent brand0= new Intent(BrandActivity.this,BrandChevroletActivity.class);
                        startActivity(brand0);
                        break;
                    case 1:
                        Intent brand1=new Intent(BrandActivity.this,BrandRollRoyceActivity.class);
                        startActivity(brand1);
                        break;

                    case 2:
                        Intent brand2=new Intent(BrandActivity.this,BrandBugattiActivity.class);
                        startActivity(brand2);
                        break;

                    case 3:
                        Intent brand4=new Intent(BrandActivity.this,BrandMercedes.class);
                        startActivity(brand4);
                        break;

                    case 4:
                        Intent brand5=new Intent(BrandActivity.this,BrandAudiActivity.class);
                        startActivity(brand5);
                        break;

                    case 5:
                        Intent brand6=new Intent(BrandActivity.this,BrandLamborghiniActivity.class);
                        startActivity(brand6);
                        break;

                    case 6:
                        Intent brand7=new Intent(BrandActivity.this,BrandAstonMartinActivity.class);
                        startActivity(brand7);
                        break;

                    case 7:
                        Intent brand8=new Intent(BrandActivity.this,BrandFordActivity.class);
                        startActivity(brand8);
                        break;

                    case 8:
                        Intent brand9=new Intent(BrandActivity.this,BrandJaguar.class);
                        startActivity(brand9);
                        break;

                    case 9:
                        Intent brand10=new Intent(BrandActivity.this,BrandMclaren.class);
                        startActivity(brand10);
                        break;

                    case 10:
                        Intent brand11=new Intent(BrandActivity.this,BrandLandRoverActivity.class);
                        startActivity(brand11);
                        break;

                    case 11:
                        Intent brand12=new Intent(BrandActivity.this,BrandPorsche.class);
                        startActivity(brand12);
                        break;

                    case 12:
                        Intent brand13=new Intent(BrandActivity.this,BrandPagani.class);
                        startActivity(brand13);
                        break;

                    case 13:
                        Intent brand14=new Intent(BrandActivity.this,BrandTesla.class);
                        startActivity(brand14);
                        break;

                    case 14:
                        Intent brand15=new Intent(BrandActivity.this,BrandToyota.class);
                        startActivity(brand15);
                        break;

                    case 15:
                        Intent brand16=new Intent(BrandActivity.this,BrandVolkswagen.class);
                        startActivity(brand16);
                        break;

                }
            }

        });
    }
}
