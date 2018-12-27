package rifafauzi6.id.sectionrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;
import rifafauzi6.id.sectionrecyclerview.R;

public class QuestionAdapter extends StatelessSection {

    public final static int KS01 = 0;
    public final static int KS02 = 1;
    public final static int KS03 = 2;
    public final static int KS04 = 3;

    private final int topic;
    private Context context;

    private String title;
    private List<String> list;

    public QuestionAdapter(Context context, int topic) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.list_pertanyaan)
                .headerResourceId(R.layout.list_title)
                .build());

        this.context = context;
        this.topic = topic;

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
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemViewHolder itemHolder = (ItemViewHolder) holder;

        String item = list.get(position);

        itemHolder.tvHeader.setText(item);

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

    private class HeaderViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTitle;

        HeaderViewHolder(View view) {
            super(view);

            tvTitle = view.findViewById(R.id.tvTitle);
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvHeader;

        ItemViewHolder(View view) {
            super(view);

            tvHeader = view.findViewById(R.id.question);
        }
    }

}
