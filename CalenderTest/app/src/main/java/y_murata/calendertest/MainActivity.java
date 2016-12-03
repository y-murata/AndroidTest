package y_murata.calendertest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

// タイトルバーを消すように継承元を変更
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String datetime = setCalenderView();
        setTextView(datetime);
    }

    public String setCalenderView() {
        CalendarView mCalenderView = ((CalendarView) findViewById(R.id.calendarView));
        mCalenderView.setEnabled(true);

        long unixTime = mCalenderView.getDate();

        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz);

        Calendar currCal = Calendar.getInstance(tz);
        currCal.setTimeInMillis(unixTime);

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return myFormat.format(currCal.getTime());
    }

    public void setTextView(String str) {
        TextView mTextView = ((TextView) findViewById(R.id.textView));
        mTextView.setEnabled(true);
        mTextView.setText(str);

    }
}
