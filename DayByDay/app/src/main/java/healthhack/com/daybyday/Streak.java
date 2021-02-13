package healthhack.com.daybyday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

public class Streak extends AppCompatActivity
{
    TextView tvStreakName, tvStreak, tvInfo;
    long startTime, difference;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streak);

        tvStreakName = findViewById(R.id.tvStreakName);
        tvStreak = findViewById(R.id.tvStreak);
        tvInfo = findViewById(R.id.tvInfo);

        SharedPreferences preferences = getSharedPreferences(ApplicationClass.MY_NAME, MODE_PRIVATE);
        tvStreakName.setText(preferences.getString("user", ""));
        SharedPreferences streak = getSharedPreferences(ApplicationClass.MY_STREAK, MODE_PRIVATE);
        SharedPreferences.Editor streakEditor = getSharedPreferences(ApplicationClass.MY_STREAK,
                MODE_PRIVATE)
                .edit();
        if (streak.getLong("streak", 0) == 0)
        {
            streakEditor.putLong("streak", System.currentTimeMillis());
        }
        startTime = streak.getLong("streak", System.currentTimeMillis());
        long time = System.currentTimeMillis();
        difference = time - startTime;
        day = streak.getInt("day", 0);
        tvStreak.setText(String.valueOf(day));

        streakEditor.putInt("day", day);
        streakEditor.apply();
        if (difference > 2 * 86400000)
        {
            day = 0;
            tvStreak.setText("0");
            streakEditor.putInt("day", day);
            streakEditor.putLong("streak", System.currentTimeMillis());
            streakEditor.apply();
        }
        else if (difference > 86400000)
        {
            day++;
            tvStreak.setText(String.valueOf(day));
            streakEditor.putInt("day", day);
            streakEditor.putLong("streak", System.currentTimeMillis());
            streakEditor.apply();
        }
    }
}