package marcveens.androidweek5numbertrivia;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface NumbersApiService {
    String BASE_URL = "http://numbersapi.com/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("/{number}/?json")
    Call<TriviaItem> getTriviaByNumber(@Path("number") int number);
}
