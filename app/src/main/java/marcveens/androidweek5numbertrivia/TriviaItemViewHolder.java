package marcveens.androidweek5numbertrivia;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TriviaItemViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView number;

    public TriviaItemViewHolder(View itemView) {
        super(itemView);
        title =  itemView.findViewById(R.id.trivia_title);
        number = itemView.findViewById(R.id.trivia_number);
    }
}
