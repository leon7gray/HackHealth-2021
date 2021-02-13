package healthhack.com.daybyday;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Charity extends AppCompatActivity
{
    Button btCharity1, btCharity2, btCharity3, btCharity4, btCharity5, btCharity6, btCharity7,
            btCharity8;
    int clicked, selected;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity);
        btCharity1 = findViewById(R.id.btCharity1);
        btCharity2 = findViewById(R.id.btCharity2);
        btCharity3 = findViewById(R.id.btCharity3);
        btCharity4 = findViewById(R.id.btCharity4);
        btCharity5 = findViewById(R.id.btCharity5);
        btCharity6 = findViewById(R.id.btCharity6);
        btCharity7 = findViewById(R.id.btCharity7);
        btCharity8 = findViewById(R.id.btCharity8);

        SharedPreferences preferences = getSharedPreferences(ApplicationClass.MY_CHARITY,
                MODE_PRIVATE);
        SharedPreferences.Editor editor = getSharedPreferences(ApplicationClass.MY_CHARITY,
                MODE_PRIVATE).edit();

        clicked = preferences.getInt("clicked", 0);
        selected = preferences.getInt("selected", 0);

        if (clicked == 1)
        {
            switch (selected)
            {
                case 1:
                    btCharity1.setBackgroundTintList(getResources().
                            getColorStateList(R.color.BlueSapphire));
                    break;
                case 2:
                    btCharity2.setBackgroundTintList(getResources().
                            getColorStateList(R.color.BlueSapphire));
                    break;
                case 3:
                    btCharity3.setBackgroundTintList(getResources().
                            getColorStateList(R.color.BlueSapphire));
                    break;
                case 4:
                    btCharity4.setBackgroundTintList(getResources().
                            getColorStateList(R.color.BlueSapphire));
                    break;
                case 5:
                    btCharity5.setBackgroundTintList(getResources().
                            getColorStateList(R.color.BlueSapphire));
                    break;
                case 6:
                    btCharity6.setBackgroundTintList(getResources().
                            getColorStateList(R.color.BlueSapphire));
                    break;
                case 7:
                    btCharity7.setBackgroundTintList(getResources().
                            getColorStateList(R.color.BlueSapphire));
                    break;
                case 8:
                    btCharity8.setBackgroundTintList(getResources().
                            getColorStateList(R.color.BlueSapphire));
                    break;

            }
        }


        btCharity1.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v)
            {
                if (clicked == 0)
                {
                    btCharity1.setBackgroundTintList(getResources().getColorStateList(R.color.BlueSapphire));
                    clicked = 1;
                    selected = 1;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }

                else if (clicked == 1 && selected == 1)
                {
                    btCharity1.setBackgroundTintList(getResources().getColorStateList(R.color.MediumAquamarine));
                    clicked = 0;
                    selected = 0;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }
            }
        });

        btCharity2.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v)
            {
                if (clicked == 0)
                {
                    btCharity2.setBackgroundTintList(getResources().getColorStateList(R.color.BlueSapphire));
                    clicked = 1;
                    selected = 2;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }

                else if (clicked == 1 && selected == 2)
                {
                    btCharity2.setBackgroundTintList(getResources().getColorStateList(R.color.MediumAquamarine));
                    clicked = 0;
                    selected = 0;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }
            }
        });

        btCharity3.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v)
            {
                if (clicked == 0)
                {
                    btCharity3.setBackgroundTintList(getResources().getColorStateList(R.color.BlueSapphire));
                    clicked = 1;
                    selected = 3;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }

                else if (clicked == 1 && selected == 3)
                {
                    btCharity3.setBackgroundTintList(getResources().getColorStateList(R.color.MediumAquamarine));
                    clicked = 0;
                    selected = 0;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }
            }
        });

        btCharity4.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v)
            {
                if (clicked == 0)
                {
                    btCharity4.setBackgroundTintList(getResources().getColorStateList(R.color.BlueSapphire));
                    clicked = 1;
                    selected = 4;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }

                else if (clicked == 1 && selected == 4)
                {
                    btCharity4.setBackgroundTintList(getResources().getColorStateList(R.color.MediumAquamarine));
                    clicked = 0;
                    selected = 0;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }
            }
        });

        btCharity5.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v)
            {
                if (clicked == 0)
                {
                    btCharity5.setBackgroundTintList(getResources().getColorStateList(R.color.BlueSapphire));
                    clicked = 1;
                    selected = 5;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }

                else if (clicked == 1 && selected == 5)
                {
                    btCharity5.setBackgroundTintList(getResources().getColorStateList(R.color.MediumAquamarine));
                    clicked = 0;
                    selected = 0;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }
            }
        });

        btCharity6.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v)
            {
                if (clicked == 0)
                {
                    btCharity6.setBackgroundTintList(getResources().getColorStateList(R.color.BlueSapphire));
                    clicked = 1;
                    selected = 6;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }

                else if (clicked == 1 && selected == 6)
                {
                    btCharity6.setBackgroundTintList(getResources().getColorStateList(R.color.MediumAquamarine));
                    clicked = 0;
                    selected = 0;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }
            }
        });

        btCharity7.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v)
            {
                if (clicked == 0)
                {
                    btCharity7.setBackgroundTintList(getResources().getColorStateList(R.color.BlueSapphire));
                    clicked = 1;
                    selected = 7;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }

                else if (clicked == 1 && selected == 7)
                {
                    btCharity7.setBackgroundTintList(getResources().getColorStateList(R.color.MediumAquamarine));
                    clicked = 0;
                    selected = 0;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }
            }
        });

        btCharity8.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v)
            {
                if (clicked == 0)
                {
                    btCharity8.setBackgroundTintList(getResources().getColorStateList(R.color.BlueSapphire));
                    clicked = 1;
                    selected = 8;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }

                else if (clicked == 1 && selected == 8)
                {
                    btCharity8.setBackgroundTintList(getResources().getColorStateList(R.color.MediumAquamarine));
                    clicked = 0;
                    selected = 0;
                    editor.putInt("clicked", clicked);
                    editor.putInt("selected", selected);
                    editor.apply();
                }
            }
        });
    }

}