package marcveens.androidweek5numbertrivia;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TriviaAdapter triviaAdapter;
    private List<TriviaItem> triviaList;
    private RecyclerView triviaRecyclerView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Random rand = new Random();

        triviaList = new ArrayList<>();

        triviaRecyclerView = findViewById(R.id.triviaList);
        triviaRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        fab = findViewById(R.id.addTriviaItem);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNumber = rand.nextInt(100) + 1;

                requestData(randomNumber);
            }
        });
    }

    private void refreshUI() {
        if (triviaAdapter == null) {
            triviaAdapter = new TriviaAdapter(triviaList);
            triviaRecyclerView.setAdapter(triviaAdapter);
        } else {
            triviaAdapter.notifyDataSetChanged();
        }
    }

    private void requestData(int number)
    {
        NumbersApiService service = NumbersApiService.retrofit.create(NumbersApiService.class);
        Call<TriviaItem> call = service.getTriviaByNumber(number);
        call.enqueue(new Callback<TriviaItem>() {
            @Override
            public void onResponse(Call<TriviaItem> call, Response<TriviaItem> response) {
                TriviaItem dayQuoteItem = response.body();

                triviaList.add(0, dayQuoteItem);

                refreshUI();
            }
            @Override
            public void onFailure(Call<TriviaItem> call, Throwable t) {
            }
        });
    }
}
