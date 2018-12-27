package rifafauzi6.id.sectionrecyclerview.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rifafauzi6.id.sectionrecyclerview.model.ResponsModelQuestion;

public interface BaseApiService {

        @GET("get1.php")
        Call<ResponsModelQuestion> getPertanyaan(@Query("kd_pertanyaan") String kd_pertanyaan);

}
