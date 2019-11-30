package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String items[] = new String []{"apple", "banana", "carrot"};
    public static ArrayList<data> trans;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String info = readFile();
        String[] line = info.split("\n");
        trans = new ArrayList<>();
        trans.add(new data("Bills", 0));
        TextView txtView = (TextView)findViewById(R.id.textView2);
        /*String d1 = "01/01/2001";
        String d2 = "01/02/2001";
        try {
            Date done = dateFormat.parse(d1);
            Date dtwo = dateFormat.parse(d2);
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(done);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(dtwo);
            txtView.setText(Long.toString(daysBetween(done,dtwo)));
        }catch(ParseException e){}
*/

        for (int i = 0; i<line.length; i++){
            addtrans(trans, line[i]);
        }

        ListView listview = (ListView) findViewById(R.id.list);
        CustomAdapter customadapter = new CustomAdapter();
        listview.setAdapter(customadapter);

        Button trophybutton = (Button) findViewById(R.id.achievementsButton);
        trophybutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                trophy();
            }
        });
    }

    public static Calendar getDatePart(Date date){
        Calendar cal = Calendar.getInstance();       // get calendar instance
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);            // set hour to midnight
        cal.set(Calendar.MINUTE, 0);                 // set minute in hour
        cal.set(Calendar.SECOND, 0);                 // set second in minute
        cal.set(Calendar.MILLISECOND, 0);            // set millisecond in second

        return cal;                                  // return the date part
    }

    public static long daysBetween(Date startDate, Date endDate) {
        Calendar sDate = getDatePart(startDate);
        Calendar eDate = getDatePart(endDate);

        long daysBetween = 0;
        while (sDate.before(eDate)) {
            sDate.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return trans.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.item, null);
            TextView textview = (TextView) convertView.findViewById(R.id.name);
            textview.setText(trans.get(position).getFname());
            TextView cost = (TextView) convertView.findViewById(R.id.cost);
            cost.setText(trans.get(position).getFvalue());
            String d1 = "27/12/2019";
            try {
                Date done = dateFormat.parse(d1);
                Calendar cal1 = Calendar.getInstance();
                cal1.setTime(done);
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(trans.get(position).getFdate());
            }catch(ParseException e){}

            switch (trans.get(position).getFname()){
                case "Bills":
                    ImageView image = (ImageView) convertView.findViewById(R.id.imageView);
                    image.setImageResource(R.drawable.health);
            }
            return convertView;
        }
    }

    private void addtrans(ArrayList<data> templist, String templine){
        String[] parts = templine.split(",");
        boolean found = false;
        for (data j: templist) {
            if(j.getFname().equals(parts[2])){
                j.addvalue(Double.parseDouble(parts[1].substring(1).trim()));
                j.update(parts[0]);
                found = true;
            }
        }
        if (!found){
            data temp = new data(parts[2], Double.parseDouble(parts[1].substring(1).trim()));
            temp.update(parts[0]);
            trans.add(temp);
        }
    }

    public void yearButton(View view){
        Button oct = (Button) findViewById(R.id.button);
        Button nov = (Button) findViewById(R.id.button2);
        Button dec = (Button) findViewById(R.id.button3);
        oct.setVisibility(View.INVISIBLE);
        nov.setVisibility(View.INVISIBLE);
        dec.setVisibility(View.INVISIBLE);

        String info = readFile();
        String[] line = info.split("\n");
        trans = new ArrayList<>();
        trans.add(new data("Total", 1999));
        TextView txtView = (TextView)findViewById(R.id.textView2);

        for (int i = 0; i<line.length; i++){
            addtrans(trans, line[i]);
        }

        ListView listview = (ListView) findViewById(R.id.list);
        CustomAdapter customadapter = new CustomAdapter();
        listview.setAdapter(customadapter);
    }

    public void monthButton(View view){
        Button oct = (Button) findViewById(R.id.button);
        Button nov = (Button) findViewById(R.id.button2);
        Button dec = (Button) findViewById(R.id.button3);
        oct.setVisibility(View.VISIBLE);
        nov.setVisibility(View.VISIBLE);
        dec.setVisibility(View.VISIBLE);

        String info = readFile();
        String[] line = info.split("\n");
        trans = new ArrayList<>();
        trans.add(new data("Total", 1999));
        TextView txtView = (TextView)findViewById(R.id.textView2);

        for (int i = 0; i<line.length; i++){
            if (line[i].contains("/12/")){
                addtrans(trans, line[i]);
            }
        }

        ListView listview = (ListView) findViewById(R.id.list);
        CustomAdapter customadapter = new CustomAdapter();
        listview.setAdapter(customadapter);
    }

    public void novButton(View view){
        String info = readFile();
        String[] line = info.split("\n");
        trans = new ArrayList<>();
        trans.add(new data("Total", 1499));
        TextView txtView = (TextView)findViewById(R.id.textView2);

        for (int i = 0; i<line.length; i++){
            if (line[i].contains("/11/")){
                addtrans(trans, line[i]);
            }
        }

        ListView listview = (ListView) findViewById(R.id.list);
        CustomAdapter customadapter = new CustomAdapter();
        listview.setAdapter(customadapter);
    }

    public void octButton(View view){
        String info = readFile();
        String[] line = info.split("\n");
        trans = new ArrayList<>();
        trans.add(new data("Total", 999));
        TextView txtView = (TextView)findViewById(R.id.textView2);

        for (int i = 0; i<line.length; i++){
            if (line[i].contains("/10/")){
                addtrans(trans, line[i]);
            }
        }

        ListView listview = (ListView) findViewById(R.id.list);
        CustomAdapter customadapter = new CustomAdapter();
        listview.setAdapter(customadapter);
    }

    public void trophy(){
        Intent intent = new Intent(this, trophy_activity.class);
        startActivity(intent);
    }

    private String readFile() {
        String myData = "";
        try {
            InputStream is = getAssets().open("realdata.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            myData =  new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myData;
    }
}
