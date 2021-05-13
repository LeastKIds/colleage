package com.example.tazo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChattingAdapter extends RecyclerView.Adapter<ChattingAdapter.CustomViewHolder> {

    private ArrayList<ChattingData> arrayList;

    public ChattingAdapter(ArrayList<ChattingData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ChattingAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChattingAdapter.CustomViewHolder holder, int position) {

        holder.profile.setImageResource(arrayList.get(position).getProfile());
        holder.nickName.setText(arrayList.get(position).getNickName());
        holder.chattingText.setText(arrayList.get(position).getChattingText());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curNickName= holder.nickName.getText().toString();
                Toast.makeText(v.getContext(),curNickName,Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

//    public void remove(int position)
//    {
//        try{
//            arrayList.remove(position);
//            notifyItemRemoved(position);
//        } catch(IndexOutOfBoundsException e) {
//            e.printStackTrace();
//        }
//    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView profile;
        protected TextView nickName;
        protected TextView chattingText;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profile=(ImageView) itemView.findViewById(R.id.profile);
            this.nickName=(TextView) itemView.findViewById(R.id.nickName);
            this.chattingText=(TextView) itemView.findViewById(R.id.chatting_text);
        }
    }
}
