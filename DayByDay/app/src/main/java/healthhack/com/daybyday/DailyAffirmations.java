package healthhack.com.daybyday;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DailyAffirmations extends AppCompatActivity implements AffirmationAdapter.ItemClicked
{
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Affirmation> list;
    FloatingActionButton fabAdd;
    public static long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_affirmations);
        fabAdd = findViewById(R.id.fabAdd);

        recyclerView = findViewById(R.id.lvList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        SharedPreferences preferences = getSharedPreferences(ApplicationClass.MY_LIST, MODE_PRIVATE);
        int listSize = preferences.getInt("size", 6);
        list = new ArrayList<Affirmation>();
        list.add(new Affirmation("I am well respected"));
        list.add(new Affirmation("I deserved all my success"));
        list.add(new Affirmation("I am proud of who I am"));
        list.add(new Affirmation("I can’t be brought down"));
        list.add(new Affirmation("I am my own person"));
        list.add(new Affirmation("I am beautiful"));

        SharedPreferences.Editor editor = getSharedPreferences(ApplicationClass.MY_LIST,
                MODE_PRIVATE)
                .edit();
        editor.putString("user" + 0, "I am well respected");
        editor.putString("user" + 1, "I deserved all my success");
        editor.putString("user" + 2, "I am proud of who I am");
        editor.putString("user" + 3, "I can’t be brought down");
        editor.putString("user" + 4, "I am my own person");
        editor.putString("user" + 5, "I am beautiful");
        editor.apply();

        if (listSize > 6)
        {
            for (int i = 6; i < listSize; i++)
            {
                String message = preferences.getString("user" + i, null);
                list.add(new Affirmation(message));
            }
        }


        adapter = new AffirmationAdapter(DailyAffirmations.this, list);
        recyclerView.setAdapter(adapter);

        fabAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivityForResult(new Intent(DailyAffirmations.this,
                        AddMessage.class), 1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
        {
            if (resultCode == RESULT_OK)
            {
                list.add(new Affirmation((data.getStringExtra("message"))));
                SharedPreferences preferences = getSharedPreferences(ApplicationClass.MY_LIST,
                        MODE_PRIVATE);
                int listSize = preferences.getInt("size", 6);
                SharedPreferences.Editor editor = getSharedPreferences(ApplicationClass.MY_LIST,
                        MODE_PRIVATE)
                        .edit();
                editor.putString("user" + listSize, data.getStringExtra("message"));
                editor.putInt("size", list.size());
                editor.apply();
            }
        }
        else if (requestCode == 2)
        {
            if (resultCode == RESULT_OK)
            {
                list.remove(data.getIntExtra("index", 0));
                adapter.notifyDataSetChanged();
                SharedPreferences preferences = getSharedPreferences(ApplicationClass.MY_LIST, MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedPreferences(ApplicationClass.MY_LIST,
                        MODE_PRIVATE)
                        .edit();
                int index = data.getIntExtra("index", 0);
                if (index  + 1 < preferences.getInt("size", 0))
                {
                    editor.remove("user" + index);
                    for (int i = index; i < preferences.getInt("size", 0); i++)
                    {
                        String string = preferences.getString("user" + i, null);
                        editor.putString("user" + i, preferences.getString("user" + (i + 1), null));
                    }
                }

                editor.putInt("size", preferences.getInt("size", 0) - 1);
                editor.apply();
            }
        }
    }

    @Override
    public void onItemClicked(int index)
    {
        Intent intent = new Intent(DailyAffirmations.this, ViewMessage.class);
        SharedPreferences preferences = getSharedPreferences(ApplicationClass.MY_LIST,
                MODE_PRIVATE);
        intent.putExtra("message", preferences.getString("user" + index, ""));
        intent.putExtra("index", index);
        startActivityForResult(intent, 2);
    }

}

