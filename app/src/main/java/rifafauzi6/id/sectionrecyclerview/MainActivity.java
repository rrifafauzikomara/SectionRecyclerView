package rifafauzi6.id.sectionrecyclerview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rifafauzi6.id.sectionrecyclerview.adapter.QuestionAdapter;
import rifafauzi6.id.sectionrecyclerview.api.BaseApiService;
import rifafauzi6.id.sectionrecyclerview.api.Server;
import rifafauzi6.id.sectionrecyclerview.model.Question;
import rifafauzi6.id.sectionrecyclerview.model.ResponsModelKuesioner;
import rifafauzi6.id.sectionrecyclerview.model.ResponsModelQuestion;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_pertanyaan) RecyclerView rvPertanyaan;
    @BindView(R.id.sendKuesioner) Button btnSend;
    ProgressDialog loading;

    private SectionedRecyclerViewAdapter sectionAdapter;

    String KS01 = "KS01";
    String KS02 = "KS02";
    String KS03 = "KS03";
    String KS04 = "KS04";

    String titleA = "A. Kompetensi Pedagogik : Kemampuan mengelola proses pembelajaran mahasiswa.";
    String titleB = "B. Kompetensi Profesional : Kemampuan penguasaan materi pelajaran secara luas dan mendalam.";
    String titleC = "C. Kompetensi Kepribadian : Kemampuan kepribadian yang mantap, berakhlak mulia, arif, dan berwibawa serta menjadi teladan mahasiswa.";
    String titleD = "D. Kompetensi Sosial : Kemampuan berkomunikasi dan berinteraksi secara efektif dan efisien dengan mahasiswa, sesama dosen, orangtua/wali, dan masyarakat sekitar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loading = new ProgressDialog(this);
        ButterKnife.bind(this);

        sectionAdapter = new SectionedRecyclerViewAdapter();
        rvPertanyaan.setLayoutManager(new LinearLayoutManager(this));

        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                callQuestion1(KS01);
            }
        }, 100);
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                callQuestion2(KS02);
            }
        }, 200);
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                callQuestion3(KS03);
            }
        }, 300);
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                callQuestion4(KS04);
            }
        }, 400);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kuesioner();
            }
        });

    }

    private void callQuestion1(String kd_pertanyaan){
        loading.setMessage("Loading ...");
        loading.setCancelable(false);
        loading.show();
        BaseApiService apiService = Server.getUrl().create(BaseApiService.class);
        Call<ResponsModelQuestion> getdata = apiService.getPertanyaan(kd_pertanyaan);
        getdata.enqueue(new Callback<ResponsModelQuestion>() {
            @Override
            public void onResponse(@NonNull Call<ResponsModelQuestion> call, @NonNull Response<ResponsModelQuestion> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    Log.d("onResponse", "Message : " + Objects.requireNonNull(response.body()).getKode());
                    List<Question> listPertanyaan = response.body().getResult();

                    QuestionAdapter adapter = new QuestionAdapter(getApplicationContext(), titleA, listPertanyaan);
                    adapter.setListQuestion(listPertanyaan);
                    sectionAdapter.addSection(adapter);
                    rvPertanyaan.setAdapter(sectionAdapter);
                }
                else {
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(), "Gagal Mengambil Data Kuesioner !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponsModelQuestion> call, @NonNull Throwable t) {
                loading.dismiss();
                Log.e("onFailure : ","Message : "+String.valueOf(t.getMessage()));
                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callQuestion2(String kd_pertanyaan){
        loading.setMessage("Loading ...");
        loading.setCancelable(false);
        loading.show();
        BaseApiService apiService = Server.getUrl().create(BaseApiService.class);
        Call<ResponsModelQuestion> getdata = apiService.getPertanyaan(kd_pertanyaan);
        getdata.enqueue(new Callback<ResponsModelQuestion>() {
            @Override
            public void onResponse(@NonNull Call<ResponsModelQuestion> call, @NonNull Response<ResponsModelQuestion> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    Log.d("onResponse", "Message : " + Objects.requireNonNull(response.body()).getKode());
                    List<Question> listPertanyaan = response.body().getResult();

                    QuestionAdapter adapter1 = new QuestionAdapter(getApplicationContext(), titleB, listPertanyaan);
                    adapter1.setListQuestion(listPertanyaan);
                    sectionAdapter.addSection(adapter1);
                    rvPertanyaan.setAdapter(sectionAdapter);
                }
                else {
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(), "Gagal Mengambil Data Kuesioner !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponsModelQuestion> call, @NonNull Throwable t) {
                loading.dismiss();
                Log.e("onFailure : ","Message : "+String.valueOf(t.getMessage()));
                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callQuestion3(String kd_pertanyaan){
        loading.setMessage("Loading ...");
        loading.setCancelable(false);
        loading.show();
        BaseApiService apiService = Server.getUrl().create(BaseApiService.class);
        Call<ResponsModelQuestion> getdata = apiService.getPertanyaan(kd_pertanyaan);
        getdata.enqueue(new Callback<ResponsModelQuestion>() {
            @Override
            public void onResponse(@NonNull Call<ResponsModelQuestion> call, @NonNull Response<ResponsModelQuestion> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    Log.d("onResponse", "Message : " + Objects.requireNonNull(response.body()).getKode());
                    List<Question> listPertanyaan = response.body().getResult();

                    QuestionAdapter adapter2 = new QuestionAdapter(getApplicationContext(), titleC, listPertanyaan);
                    adapter2.setListQuestion(listPertanyaan);
                    sectionAdapter.addSection(adapter2);
                    rvPertanyaan.setAdapter(sectionAdapter);
                }
                else {
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(), "Gagal Mengambil Data Kuesioner !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponsModelQuestion> call, @NonNull Throwable t) {
                loading.dismiss();
                Log.e("onFailure : ","Message : "+String.valueOf(t.getMessage()));
                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callQuestion4(String kd_pertanyaan){
        loading.setMessage("Loading ...");
        loading.setCancelable(false);
        loading.show();
        BaseApiService apiService = Server.getUrl().create(BaseApiService.class);
        Call<ResponsModelQuestion> getdata = apiService.getPertanyaan(kd_pertanyaan);
        getdata.enqueue(new Callback<ResponsModelQuestion>() {
            @Override
            public void onResponse(@NonNull Call<ResponsModelQuestion> call, @NonNull Response<ResponsModelQuestion> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    Log.d("onResponse", "Message : " + Objects.requireNonNull(response.body()).getKode());
                    List<Question> listPertanyaan = response.body().getResult();

                    QuestionAdapter adapter3 = new QuestionAdapter(getApplicationContext(), titleD, listPertanyaan);
                    adapter3.setListQuestion(listPertanyaan);
                    sectionAdapter.addSection(adapter3);
                    rvPertanyaan.setAdapter(sectionAdapter);
                }
                else {
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(), "Gagal Mengambil Data Kuesioner !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponsModelQuestion> call, @NonNull Throwable t) {
                loading.dismiss();
                Log.e("onFailure : ","Message : "+String.valueOf(t.getMessage()));
                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void kuesioner() {

        ArrayList<String> kodePertanyaan = new ArrayList<>();
        String kd_pertanyaan = "";
        //array
        for (int i = 0; i < QuestionAdapter.kdPertanyaan.size(); i++) {
            kodePertanyaan.add(kd_pertanyaan + QuestionAdapter.kdPertanyaan.get(i));
        }

        ArrayList<String> kodeKuesioner = new ArrayList<>();
        String kd_kuesioner = "";
        // array
        for (int i = 0; i < QuestionAdapter.kdKuesioner.size(); i++) {
            kodeKuesioner.add(kd_kuesioner + QuestionAdapter.kdKuesioner.get(i));
        }

        ArrayList<String> variable = new ArrayList<>();
        String valueOfKuesioner = "";
        //array
        for (int i = 0; i < QuestionAdapter.selectedAnswers.size(); i++) {
            variable.add(valueOfKuesioner + QuestionAdapter.selectedAnswers.get(i));
        }

        String message1 = "Jawaban tidak boleh kosong";
        if (variable.toString().contains(message1)) {
            Toast.makeText(getApplicationContext(), message1, Toast.LENGTH_SHORT).show();
        } else {
            sendData(kodePertanyaan, kodeKuesioner, variable);
        }
    }

    private void sendData(ArrayList<String> kodePertanyaanX, ArrayList<String> kodeKuesionerX, ArrayList<String> variableX) {
        loading.setMessage("Mengirim Kuesioner ...");
        loading.setCancelable(false);
        loading.show();
        BaseApiService apiService = Server.getUrl().create(BaseApiService.class);
        Call<ResponsModelKuesioner> getValueofKuesioner = apiService.sendKuesioner(kodePertanyaanX, kodeKuesionerX, variableX);
        getValueofKuesioner.enqueue(new Callback<ResponsModelKuesioner>() {
            @Override
            public void onResponse(@NonNull Call<ResponsModelKuesioner> call, @NonNull Response<ResponsModelKuesioner> response) {
                loading.dismiss();
                Log.d("onResponse", "Message : " + Objects.requireNonNull(response.body()).toString());
                String kode = response.body().getKode();
                String message = response.body().getPesan();
                if (kode.equals("1")) {
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
//                    updateStatus(npm, nik);
                    Intent send = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(send);
                } else {
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponsModelKuesioner> call, @NonNull Throwable t) {
                loading.dismiss();
                Log.e("onFailure : ", "Message : " + String.valueOf(t.getMessage()));
                Toast.makeText(getApplicationContext(), "Gagal Menghubungkan Internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
