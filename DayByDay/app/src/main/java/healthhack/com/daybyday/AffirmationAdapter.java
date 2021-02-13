package healthhack.com.daybyday;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AffirmationAdapter extends RecyclerView.Adapter<AffirmationAdapter.ViewHolder>
{
    private ArrayList<Affirmation> affirmations;
    ItemClicked activity;


    public interface ItemClicked
    {
        void onItemClicked(int index);
    }

    public AffirmationAdapter(Context context, ArrayList<Affirmation> list)
    {
        affirmations = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvMessage;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            tvMessage = itemView.findViewById(R.id.tvMessage);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    activity.onItemClicked(affirmations.indexOf((Affirmation) v.getTag()));
                }
            });
        }
    }


    @NonNull
    @Override
    public AffirmationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup,
                false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AffirmationAdapter.ViewHolder viewHolder, int i)
    {
        viewHolder.itemView.setTag(affirmations.get(i));
        viewHolder.tvMessage.setText(affirmations.get(i).getMessage());
    }

    @Override
    public int getItemCount()
    {
        return affirmations.size();
    }
}
