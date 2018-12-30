package rifafauzi6.id.sectionrecyclerview.api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rifafauzi6.id.sectionrecyclerview.model.ResponsModelKuesioner;
import rifafauzi6.id.sectionrecyclerview.model.ResponsModelQuestion;

public interface BaseApiService {

        @GET("get1.php")
        Call<ResponsModelQuestion> getPertanyaan(@Query("kd_pertanyaan") String kd_pertanyaan);

//        @FormUrlEncoded
//        @POST("insert1.php")
//        Call<ResponsModelKuesioner> sendKuesioner(@Field("kd_pertanyaan[]") ArrayList<String> kd_pertanyaan,
//                                                  @Field("kd_kuesioner[]") ArrayList<String> kd_kuesioner,
//                                                  @Field("variabel[]") ArrayList<String> variabel);

}
