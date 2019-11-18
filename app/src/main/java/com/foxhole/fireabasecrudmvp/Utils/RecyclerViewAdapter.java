package com.foxhole.fireabasecrudmvp.Utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.foxhole.fireabasecrudmvp.Model.Player;
import com.foxhole.fireabasecrudmvp.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    public ArrayList<Player> players;
    public onPlayerListener mOnPlayerListener;

    public RecyclerViewAdapter(ArrayList<Player> players, onPlayerListener onPlayerListener) {
        this.players = players;
        this.mOnPlayerListener = onPlayerListener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout,null);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view, mOnPlayerListener);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        holder.mName.setText(players.get(position).getName());
        holder.mAge.setText(players.get(position).getAge());
        holder.mPosition.setText(players.get(position).getPosition());

    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mName;
        public TextView mAge;
        public TextView mPosition;
        public Button mUpdateBtn;
        public Button mDeleteBtn;
        public onPlayerListener mListener;


        public RecyclerViewHolder(@NonNull View itemView, onPlayerListener onPlayerListener) {
            super(itemView);

            this.mListener = onPlayerListener;

            mName = (TextView)itemView.findViewById(R.id.tv_name);
            mAge = (TextView)itemView.findViewById(R.id.tv_age);
            mPosition = (TextView)itemView.findViewById(R.id.tv_position);
            mUpdateBtn = (Button)itemView.findViewById(R.id.btn_update);
            mDeleteBtn = (Button)itemView.findViewById(R.id.btn_delete);

            mUpdateBtn.setOnClickListener(this);
            mDeleteBtn.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            switch (v.getId())
            {
                case R.id.btn_update:
                    mListener.onPlayerUpdateClick(getAdapterPosition());
                    break;
                case R.id.btn_delete:
                    mListener.onPlayerDeleteClick(getAdapterPosition());
                    break;
            }

        }
    }

    public interface onPlayerListener{
        void onPlayerUpdateClick(int position);
        void onPlayerDeleteClick(int position);
    }



}
