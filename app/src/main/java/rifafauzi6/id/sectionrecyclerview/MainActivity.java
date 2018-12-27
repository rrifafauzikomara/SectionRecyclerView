package rifafauzi6.id.sectionrecyclerview;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;
import rifafauzi6.id.sectionrecyclerview.adapter.QuestionAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_pertanyaan) RecyclerView rvPertanyaan;
    ProgressDialog loading;
    private SectionedRecyclerViewAdapter sectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionAdapter = new SectionedRecyclerViewAdapter();

        sectionAdapter.addSection(new QuestionAdapter(this, QuestionAdapter.KS01));
        sectionAdapter.addSection(new QuestionAdapter(this, QuestionAdapter.KS02));
        sectionAdapter.addSection(new QuestionAdapter(this, QuestionAdapter.KS03));
        sectionAdapter.addSection(new QuestionAdapter(this, QuestionAdapter.KS04));

        loading = new ProgressDialog(this);
        ButterKnife.bind(this);

        rvPertanyaan.setLayoutManager(new LinearLayoutManager(this));
        rvPertanyaan.setAdapter(sectionAdapter);

    }

//    private void callQuestion(String kd_pertanyaan){
//        loading.setMessage("Loading ...");
//        loading.setCancelable(false);
//        loading.show();
//        BaseApiService apiService = Server.getUrl().create(BaseApiService.class);
//        Call<ResponsModelQuestion> getdata = apiService.getPertanyaan(kd_pertanyaan);
//        getdata.enqueue(new Callback<ResponsModelQuestion>() {
//            @Override
//            public void onResponse(@NonNull Call<ResponsModelQuestion> call, @NonNull Response<ResponsModelQuestion> response) {
//                if (response.isSuccessful()){
//                    loading.dismiss();
//                    Log.d("onResponse", "Message : " + Objects.requireNonNull(response.body()).getKode());
//                    List<Question> listPertanyaan = response.body().getResult();
//
//                    QuestionAdapter questionAdapter = new QuestionAdapter(getActivity(), listPertanyaan);
//                    questionAdapter.setListQuestion(listPertanyaan);
//                    questionAdapter.notifyDataSetChanged();
//                    rvPertanyaan.setAdapter(questionAdapter);
//                }
//                else {
//                    loading.dismiss();
//                    Toast.makeText(getApplicationContext(), "Gagal Mengambil Data Kuesioner !", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<ResponsModelQuestion> call, @NonNull Throwable t) {
//                loading.dismiss();
//                Log.e("onFailure : ","Message : "+String.valueOf(t.getMessage()));
//                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}
