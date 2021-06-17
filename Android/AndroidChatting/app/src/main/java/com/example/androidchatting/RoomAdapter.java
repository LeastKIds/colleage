package com.example.androidchatting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.CustomViewHolder> {

    private ArrayList<RoomData> arrayList;

    public RoomAdapter(ArrayList<RoomData> arrayList)
    {
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public RoomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.romm_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.CustomViewHolder holder, int position) {
        if(holder.roomTitle != null)
         holder.roomTitle.setText(arrayList.get(position).getName());
        if(holder.roomLeftUser != null)
            holder.roomLeftUser.setText(arrayList.get(position).getUserLimit());
        if(holder.roomGender != null)
            holder.roomGender.setText(arrayList.get(position).getGender());
        if (holder.roomTime != null)
         holder.roomTime.setText(arrayList.get(position).getStartAt());
        if(holder.roomPlace != null)
         holder.roomPlace.setText(arrayList.get(position).getPlace());

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView roomTitle;
        protected TextView roomUserNames;
        protected TextView roomLeftUser;
        protected TextView roomGender;
        protected TextView roomTime;
        protected TextView roomPlace;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.roomTitle = (TextView) itemView.findViewById(R.id.roomTitle);
            this.roomUserNames = (TextView) itemView.findViewById(R.id.roomUserNames);
            this.roomLeftUser = (TextView) itemView.findViewById(R.id.roomLeftUser);
            this.roomGender = (TextView) itemView.findViewById(R.id.roomGender);
            this.roomTime = (TextView) itemView.findViewById(R.id.roomTime);
            this.roomPlace = (TextView) itemView.findViewById(R.id.roomPlace);

        }
    }
}
