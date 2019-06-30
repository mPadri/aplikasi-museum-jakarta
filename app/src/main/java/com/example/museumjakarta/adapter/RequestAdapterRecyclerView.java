package com.example.museumjakarta.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.museumjakarta.DetailActivity;
import com.example.museumjakarta.R;
import com.example.museumjakarta.model.Request;

import java.util.List;

public class RequestAdapterRecyclerView extends RecyclerView.Adapter<RequestAdapterRecyclerView.MyViewHolder> {

    private List<Request> moveList;
    private Activity mActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout rl_layout;
        TextView tv_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            rl_layout = itemView.findViewById(R.id.rl_layout);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }

    public RequestAdapterRecyclerView(List<Request> moveList, Activity activity){
        this.moveList = moveList;
        this.mActivity = activity;
    }


    @NonNull
    @Override
    public RequestAdapterRecyclerView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_request, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestAdapterRecyclerView.MyViewHolder myViewHolder, int i) {

        final Request move = moveList.get(i);

        myViewHolder.tv_title.setText(move.getNama());

        myViewHolder.rl_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goDetail = new Intent(mActivity, DetailActivity.class);

                goDetail.putExtra("id", move.getKey());
                goDetail.putExtra("nama", move.getNama());
                goDetail.putExtra("alamat", move.getAlamat());
                goDetail.putExtra("desk", move.getDesk());
                goDetail.putExtra("oprasional", move.getOprasional());

                mActivity.startActivity(goDetail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return moveList.size();
    }

}
