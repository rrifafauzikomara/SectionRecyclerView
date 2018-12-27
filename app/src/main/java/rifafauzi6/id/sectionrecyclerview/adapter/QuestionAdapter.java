package rifafauzi6.id.sectionrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;
import rifafauzi6.id.sectionrecyclerview.R;
import rifafauzi6.id.sectionrecyclerview.model.Question;

public class QuestionAdapter extends StatelessSection {

    public final static int KS01 = 0;
    public final static int KS02 = 1;
    public final static int KS03 = 2;
    public final static int KS04 = 3;

    private List<Question> listQuestion;
    private final int topic;
    private Context context;

    private LayoutInflater inflter;
    public static ArrayList<String> kdPertanyaan;
    public static ArrayList<String> kdKuesioner;
    public static ArrayList<String> selectedAnswers;

    private String title;
    private List<String> list;

    public QuestionAdapter(Context context, int topic, List<Question> listQuestion) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.list_pertanyaan)
                .headerResourceId(R.layout.list_title)
                .build());

        this.context = context;
        this.topic = topic;
//        this.listQuestion = listQuestion;

//        kdPertanyaan = new ArrayList<>();
//        for (int i = 0; i < listQuestion.size(); i++) {
//            kdPertanyaan.add("Nilai tidak boleh kosong");
//        }
//        kdKuesioner = new ArrayList<>();
//        for (int i = 0; i < listQuestion.size(); i++) {
//            kdKuesioner.add("Nilai tidak boleh kosong");
//        }
//        // initialize arraylist and add static string for all the questions
//        selectedAnswers = new ArrayList<>();
//        for (int i = 0; i < listQuestion.size(); i++) {
//            selectedAnswers.add("Jawaban tidak boleh kosong");
//        }
//
//        inflter = (LayoutInflater.from(context));

        switch (topic) {
            case KS01:
                this.title = context.getString(R.string.ks01);
                this.list = getNews(R.array.news_world);
                break;
            case KS02:
                this.title = context.getString(R.string.ks02);
                this.list = getNews(R.array.news_biz);
                break;
            case KS03:
                this.title = context.getString(R.string.ks03);
                this.list = getNews(R.array.news_tech);
                break;
            case KS04:
                this.title = context.getString(R.string.ks04);
                this.list = getNews(R.array.news_sports);
                break;
        }
    }

    public void setListQuestion(List<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }

    private List<String> getNews(int arrayResource) {
        return new ArrayList<>(Arrays.asList(context.getResources().getStringArray(arrayResource)));
    }

    @Override
    public int getContentItemsTotal() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ItemViewHolder itemHolder = (ItemViewHolder) holder;
        String item = list.get(position);
//        Question question = listQuestion.get(position);

//        itemHolder.txtKdPertanyaan.setText(kdPertanyaan.set(position, question.getKd_pertanyaan()));
//        itemHolder.txtKdKuesioner.setText(kdKuesioner.set(position, question.getKd_kuesioner()));
//        itemHolder.txtNo.setText(question.getNo());
        itemHolder.txtPertanyaan.setText(item);
//        itemHolder.question = question;
//        itemHolder.rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                // set Yes values in ArrayList if RadioButton is checked
//                if (isChecked)
//                    selectedAnswers.set(position, "1");
//            }
//        });
//
//        itemHolder.rb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                // set Yes values in ArrayList if RadioButton is checked
//                if (isChecked)
//                    selectedAnswers.set(position, "3");
//            }
//        });
//
//        itemHolder.rb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                // set Yes values in ArrayList if RadioButton is checked
//                if (isChecked)
//                    selectedAnswers.set(position, "5");
//            }
//        });
//
//        itemHolder.rb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                // set Yes values in ArrayList if RadioButton is checked
//                if (isChecked)
//                    selectedAnswers.set(position, "7");
//            }
//        });

    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        HeaderViewHolder headerHolder = (HeaderViewHolder) holder;

        headerHolder.tvTitle.setText(title);
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTitle) TextView tvTitle;

        HeaderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.kd_pertanyaan) TextView txtKdPertanyaan;
        @BindView(R.id.kd_kuesioner) TextView txtKdKuesioner;
        @BindView(R.id.no) TextView txtNo;
        @BindView(R.id.question) TextView txtPertanyaan;
        @BindView(R.id.rbValueOf1) RadioButton rb1;
        @BindView(R.id.rbValueOf3) RadioButton rb3;
        @BindView(R.id.rbValueOf5) RadioButton rb5;
        @BindView(R.id.rbValueOf7) RadioButton rb7;

        Question question;
        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
