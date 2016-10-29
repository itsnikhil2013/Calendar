package nikhil.development.com.calendar;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tv,tv2,tv3,tv4,tv5,tv6,tv7,current;
    ImageButton prevM,prevY,nextM,nextY;
    int currentMonth,currentDate,currentYear;
    TextView[] dates = new TextView[43];
    String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/HelveticaNeueLT.otf");

        for(int x = 1; x <= 42; x++)
        {
            int tvId = getResources().getIdentifier("day" + x, "id",
                    getPackageName());
            dates[x] = (TextView) findViewById(tvId);
        }

        Calendar calendar = Calendar.getInstance();
        currentMonth = calendar.get(Calendar.MONTH);
        currentYear = calendar.get(Calendar.YEAR);
        currentDate = calendar.get(Calendar.DATE);

        tv = (TextView)findViewById(R.id.textView);
        tv.setTypeface(tf,Typeface.BOLD);
        tv.setTextSize(20);

        tv2 = (TextView)findViewById(R.id.textView2);
        tv2.setTypeface(tf,Typeface.BOLD);
        tv2.setTextSize(20);

        tv3 = (TextView)findViewById(R.id.textView3);
        tv3.setTypeface(tf,Typeface.BOLD);
        tv3.setTextSize(20);

        tv4= (TextView)findViewById(R.id.textView4);
        tv4.setTypeface(tf,Typeface.BOLD);
        tv4.setTextSize(20);

        tv5 = (TextView)findViewById(R.id.textView5);
        tv5.setTypeface(tf,Typeface.BOLD);
        tv5.setTextSize(20);

        tv6 = (TextView)findViewById(R.id.textView6);
        tv6.setTypeface(tf,Typeface.BOLD);
        tv6.setTextSize(20);

        tv7 = (TextView)findViewById(R.id.textView7);
        tv7.setTypeface(tf,Typeface.BOLD);
        tv7.setTextSize(20);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.MONTH, currentMonth);
        cal.set(Calendar.YEAR, currentYear);
        int startDay = cal.get(Calendar.DAY_OF_WEEK);

        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.DATE, 1);
        cal2.set(Calendar.MONTH, currentMonth);
        cal2.set(Calendar.YEAR, currentYear);

        int lastDate = cal2.getActualMaximum(Calendar.DATE);
        int j = 1;

        for(int i = startDay; i <lastDate+startDay; i++)
        {

            dates[i].setText(j+""); j++;
            dates[i].setTypeface(tf);
            dates[i].setBackgroundResource(R.drawable.textview_round);
            dates[i].setTextColor(getResources().getColor(R.color.md_grey_800));
            dates[i].setTextSize(25);
            if(j == currentDate+1)
            {
                dates[i].setBackgroundResource(R.drawable.textview_current_date);
            }
        }
        current = (TextView)findViewById(R.id.current_calender);
        current.setText(month[currentMonth]+" "+currentYear);
        current.setTypeface(tf,Typeface.BOLD);
        current.setTextSize(25);

        //previous month button action
        prevM = (ImageButton)findViewById(R.id.previous_month);
        prevM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentMonth>=1 )
                    --currentMonth;
                else
                {
                    currentMonth = 11;
                    --currentYear;
                }
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.DATE, 1);
                cal.set(Calendar.MONTH, currentMonth);
                cal.set(Calendar.YEAR, currentYear);
                int startDay = cal.get(Calendar.DAY_OF_WEEK);

                Calendar cal2 = Calendar.getInstance();
                cal2.set(Calendar.DATE, 1);
                cal2.set(Calendar.MONTH, currentMonth);
                cal2.set(Calendar.YEAR, currentYear);

                int lastDate = cal2.getActualMaximum(Calendar.DATE);
                int j = 1;

                for(int x = 1; x <= 42; x++)
                {
                    dates[x].setBackgroundResource(R.drawable.textview_normal);
                    dates[x].setText("");
                }

                for(int i = startDay; i <lastDate+startDay; i++)
                {
                    dates[i].setText(j+""); j++;
                    dates[i].setTypeface(tf);
                    dates[i].setBackgroundResource(R.drawable.textview_round);
                    dates[i].setTextColor(getResources().getColor(R.color.md_grey_800));
                    dates[i].setTextSize(25);

                }
                current = (TextView)findViewById(R.id.current_calender);
                current.setText(month[currentMonth]+" "+currentYear);
                current.setTypeface(tf,Typeface.BOLD);
                current.setTextSize(25);

            }
        });

        //previous year button action
        prevY = (ImageButton)findViewById(R.id.previous_year);
        prevY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(currentYear>=1900 )
                    currentYear--;
                else
                {

                }
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.DATE, 1);
                cal.set(Calendar.MONTH, currentMonth);
                cal.set(Calendar.YEAR, currentYear);
                int startDay = cal.get(Calendar.DAY_OF_WEEK);

                Calendar cal2 = Calendar.getInstance();
                cal2.set(Calendar.DATE, 1);
                cal2.set(Calendar.MONTH, currentMonth);
                cal2.set(Calendar.YEAR, currentYear);

                int lastDate = cal2.getActualMaximum(Calendar.DATE);
                int j = 1;

                for(int x = 1; x <= 42; x++)
                {
                    dates[x].setBackgroundResource(R.drawable.textview_normal);
                    dates[x].setText("");
                }

                for(int i = startDay; i <lastDate+startDay; i++)
                {
                    dates[i].setText(j+""); j++;
                    dates[i].setTypeface(tf);
                    dates[i].setBackgroundResource(R.drawable.textview_round);
                    dates[i].setTextColor(getResources().getColor(R.color.md_grey_800));
                    dates[i].setTextSize(25);

                }
                current = (TextView)findViewById(R.id.current_calender);
                current.setText(month[currentMonth]+" "+currentYear);
                current.setTypeface(tf,Typeface.BOLD);
                current.setTextSize(25);


            }
        });

        //next month button action
        nextM = (ImageButton)findViewById(R.id.next_month);
        nextM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(currentMonth > 10)
                {
                    currentMonth = 0;
                    ++currentYear;
                }
                else
                {
                    ++currentMonth ;
                }
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.DATE, 1);
                cal.set(Calendar.MONTH, currentMonth);
                cal.set(Calendar.YEAR, currentYear);
                int startDay = cal.get(Calendar.DAY_OF_WEEK);

                Calendar cal2 = Calendar.getInstance();
                cal2.set(Calendar.DATE, 1);
                cal2.set(Calendar.MONTH, currentMonth);
                cal2.set(Calendar.YEAR, currentYear);

                int lastDate = cal2.getActualMaximum(Calendar.DATE);
                int j = 1;

                for(int x = 1; x <= 42; x++)
                {
                    dates[x].setBackgroundResource(R.drawable.textview_normal);
                    dates[x].setText("");
                }

                for(int i = startDay; i <lastDate+startDay; i++)
                {
                    dates[i].setText(j+""); j++;
                    dates[i].setTypeface(tf);
                    dates[i].setBackgroundResource(R.drawable.textview_round);
                    dates[i].setTextColor(getResources().getColor(R.color.md_grey_800));
                    dates[i].setTextSize(25);

                }
                current = (TextView)findViewById(R.id.current_calender);
                current.setText(month[currentMonth]+" "+currentYear);
                current.setTypeface(tf,Typeface.BOLD);
                current.setTextSize(25);
            }
        });

        //next year button action
        nextY = (ImageButton)findViewById(R.id.next_year);
        nextY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(currentYear<=3000 )
                    currentYear++;
                else
                {}
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.DATE, 1);
                cal.set(Calendar.MONTH, currentMonth);
                cal.set(Calendar.YEAR, currentYear);
                int startDay = cal.get(Calendar.DAY_OF_WEEK);

                Calendar cal2 = Calendar.getInstance();
                cal2.set(Calendar.DATE, 1);
                cal2.set(Calendar.MONTH, currentMonth);
                cal2.set(Calendar.YEAR, currentYear);

                int lastDate = cal2.getActualMaximum(Calendar.DATE);
                int j = 1;
                for(int x = 1; x <= 42; x++)
                {
                    dates[x].setBackgroundResource(R.drawable.textview_normal);
                    dates[x].setText("");
                }

                for(int i = startDay; i <lastDate+startDay; i++)
                {
                    dates[i].setText(j+""); j++;
                    dates[i].setTypeface(tf);
                    dates[i].setBackgroundResource(R.drawable.textview_round);
                    dates[i].setTextColor(getResources().getColor(R.color.md_grey_800));
                    dates[i].setTextSize(25);

                }
                current = (TextView)findViewById(R.id.current_calender);
                current.setText(month[currentMonth]+" "+currentYear);
                current.setTypeface(tf,Typeface.BOLD);
                current.setTextSize(25);



            }
        });
    }
}
