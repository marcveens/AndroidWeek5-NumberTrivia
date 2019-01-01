package marcveens.androidweek5numbertrivia;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class TriviaAdapter extends RecyclerView.Adapter<TriviaItemViewHolder> {
    public List<TriviaItem> listTriviaItems;

    public TriviaAdapter(List<TriviaItem> listTriviaItems) {
        this.listTriviaItems = listTriviaItems;
    }

    @Override
    public TriviaItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean shouldShowAlternativeLayout = this.listTriviaItems.size() % 2 == 0;
        int layout = shouldShowAlternativeLayout ? R.layout.trivia_item_alternative : R.layout.trivia_item;
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new TriviaItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TriviaItemViewHolder holder, final int position) {
        TriviaItem triviaItem = listTriviaItems.get(position);
        holder.title.setText(triviaItem.getText());
        holder.number.setText(triviaItem.getNumber().toString());
    }

    @Override
    public int getItemCount() {
        return listTriviaItems.size();
    }
}
