package com.example.kevinsacer.trophy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class trophy_activity extends AppCompatActivity {

    int[] levels = new int[]{0,1,2,0,0,0,0,0,0};
    int state=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.trophy_layout);


        initialiseUI();


    }


    public void EducationClick(View view)
    {
        Toast.makeText(this, "Bookworm", Toast.LENGTH_SHORT).show();
    }

    public void pigClick(View view)
    {
        Toast.makeText(this, "Savvy Saver", Toast.LENGTH_SHORT).show();
    }

    public void gymjunkie(View view)
    {
        Toast.makeText(this, "Gym Junkie", Toast.LENGTH_SHORT).show();
    }

    public void coffree(View view)
    {
        Toast.makeText(this, "Gym Junkie", Toast.LENGTH_SHORT).show();
    }


    public void fashion(View view)
    {
        Toast.makeText(this, "Fashionista", Toast.LENGTH_SHORT).show();
    }
    public void updatebutton(View view){
        switch(state){
            case 0:
                levels =new int[]{1,1,2,0,0,0,0,0,0};
                Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show();
            break;
            case 1:
                levels =new int[]{1,2,2,0,0,0,0,0,0};
                Toast.makeText(this, "New Badge Earned!", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                levels =new int[]{2,2,2,0,0,0,0,0,0};
                Toast.makeText(this, "New Badge Earned!!", Toast.LENGTH_LONG).show();
                break;
        }
        state++;
        updatebadge();
    }
    public void initialiseUI() {

        updatebadge();
    }

    public void updatebadge(){
        ImageView badge1 = (ImageView) findViewById(R.id.badgeIcon1);
        ImageView badge2 = (ImageView) findViewById(R.id.badgeIcon2);
        ImageView badge3 = (ImageView) findViewById(R.id.badgeIcon3);
        ImageView badge4 = (ImageView) findViewById(R.id.badgeIcon4);
        ImageView badge5 = (ImageView) findViewById(R.id.badgeIcon5);
        ImageView badge6 = (ImageView) findViewById(R.id.badgeIcon6);
        ImageView badge7 = (ImageView) findViewById(R.id.badgeIcon7);
        ImageView badge8 = (ImageView) findViewById(R.id.badgeIcon8);
        ImageView badge9 = (ImageView) findViewById(R.id.badgeIcon9);

        badge4.setImageDrawable(getResources().getDrawable(R.drawable.donation0));
        badge5.setImageDrawable(getResources().getDrawable(R.drawable.dumbell0));
        badge6.setImageDrawable(getResources().getDrawable(R.drawable.piggybank1));
        badge7.setImageDrawable(getResources().getDrawable(R.drawable.pt0));
        badge8.setImageDrawable(getResources().getDrawable(R.drawable.tree0));
        badge9.setImageDrawable(getResources().getDrawable(R.drawable.knifefork0));


        switch (levels[0]){
            case 0:
                badge1.setImageDrawable(getResources().getDrawable(R.drawable.book1));
                break;
            case 1:
                badge1.setImageDrawable(getResources().getDrawable(R.drawable.book2));
                break;
            case 2:
                badge1.setImageDrawable(getResources().getDrawable(R.drawable.book3));
                break;
        }
        switch (levels[1]){
            case 0:
                badge2.setImageDrawable(getResources().getDrawable(R.drawable.coffee1));
                break;
            case 1:
                badge2.setImageDrawable(getResources().getDrawable(R.drawable.coffee2));
                break;
            case 2:
                badge2.setImageDrawable(getResources().getDrawable(R.drawable.coffee3));
                break;
        }
        switch (levels[2]){
            case 0:
                badge3.setImageDrawable(getResources().getDrawable(R.drawable.tshirt1));
                break;
            case 1:
                badge3.setImageDrawable(getResources().getDrawable(R.drawable.tshirt2));
                break;
            case 2:
                badge3.setImageDrawable(getResources().getDrawable(R.drawable.tshirt3));
                break;
        }
    }

}
