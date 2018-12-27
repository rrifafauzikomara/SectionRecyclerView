package rifafauzi6.id.sectionrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;
import rifafauzi6.id.sectionrecyclerview.R;

public class QuestionAdapter extends StatelessSection {

    String title;
    List<String> list;

//    private List<Question> listQuestion;
//    private Context context;
//
//    private LayoutInflater inflter;
//    public static ArrayList<String> kdPertanyaan;
//    public static ArrayList<String> kdKuesioner;
//    public static ArrayList<String> selectedAnswers;

    public QuestionAdapter(String title, List<String> list) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.list_pertanyaan)
                .headerResourceId(R.layout.list_title)
                .build());

        this.title = title;
        this.list = list;
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
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemViewHolder itemHolder = (ItemViewHolder) holder;

        String name = list.get(position);

        itemHolder.tvItem.setText(name);
        itemHolder.imgItem.setImageResource(name.hashCode() % 2 == 0 ? R.drawable.ic_face_black_48dp : R.drawable.ic_tag_faces_black_48dp);

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

        //        @BindView(R.id.tvTitle) TextView tvTitle;
        private final TextView tvTitle;

        HeaderViewHolder(View view) {
            super(view);

            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            ButterKnife.bind(this, view);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.kd_pertanyaan) TextView txtKdPertanyaan;
//        @BindView(R.id.kd_kuesioner) TextView txtKdKuesioner;
//        @BindView(R.id.no) TextView txtNo;
//        @BindView(R.id.question) TextView txtPertanyaan;
//        @BindView(R.id.rbValueOf1) RadioButton rb1;
//        @BindView(R.id.rbValueOf3) RadioButton rb3;
//        @BindView(R.id.rbValueOf5) RadioButton rb5;
//        @BindView(R.id.rbValueOf7) RadioButton rb7;

        private final ImageView imgItem;
        private final TextView tvItem;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            imgItem = (ImageView) view.findViewById(R.id.imgItem);
            tvItem = (TextView) view.findViewById(R.id.tvItem);
        }
    }

}
