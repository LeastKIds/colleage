package com.example.tazo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ChattingAdapter extends RecyclerView.Adapter<ChattingAdapter.CustomViewHolder> {

    private ArrayList<ChattingData> arrayList;
    private int inOut;

    public ChattingAdapter(ArrayList<ChattingData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ChattingAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        inOut = viewType;
        System.out.println("-------------------------------");
        System.out.println("CahttingAdapter inOut : " + inOut);
        if(viewType == 0)
        {
            System.out.println("veiwType = 0");
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
            CustomViewHolder holder = new CustomViewHolder(view);
            return holder;
        } else if(viewType == 2)
        {
            System.out.println("veiwType = 2");
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.chatting_in_out,parent,false);
            CustomViewHolder holder = new CustomViewHolder(view);
            return holder;
        } else {
            System.out.println("viewType = 1");
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my,parent,false);
            CustomViewHolder holder = new CustomViewHolder(view);
            return holder;
        }






    }

    @Override
    public void onBindViewHolder(@NonNull ChattingAdapter.CustomViewHolder holder, int position) {

        if(inOut == 2)
        {
            System.out.println("nickname test");
            System.out.println(arrayList.get(position).getNickName());
            System.out.println("onBindViewHolder inOut : " + inOut);
            if(holder.nickName_first != null)
                holder.nickName_first.setText(arrayList.get(position).getNickName()+"님 이 들어오셨습니다.");
        } else {
//            holder.profile.setImage(arrayList.get(position).getProfile());
            Glide.with(holder.profile).load(arrayList.get(position).getProfile()).into(holder.profile);
            holder.nickName.setText(arrayList.get(position).getNickName());
            holder.chattingText.setText(arrayList.get(position).getChattingText());

//            holder.itemView.setTag(position);
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String curNickName= holder.nickName.getText().toString();
//                    Toast.makeText(v.getContext(),curNickName,Toast.LENGTH_SHORT).show();
//                }
//            });
        }




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
        protected TextView nickName_first;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.profile=(ImageView) itemView.findViewById(R.id.profile);
            this.nickName=(TextView) itemView.findViewById(R.id.nickName);
            this.chattingText=(TextView) itemView.findViewById(R.id.chatting_text);
            this.nickName_first = (TextView) itemView.findViewById(R.id.nickName_first);
        }
    }

    @Override
    public int getItemViewType(int position) {
        ChattingData chattingData=arrayList.get(position);
        System.out.println("inout : " +chattingData.getInOut() );
        if (chattingData.getInOut() == 2)
            return 2;
        else if (chattingData.getNickName().equals(chattingData.getMyName()))
            return 1;
        else
            return 0;
    }
}
