package com.example.a5l4.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a5l4.R;
import com.example.a5l4.databinding.ItemBoardBinding;
import com.example.a5l4.interFace.OnClickListener;

import java.util.ArrayList;

class BoardAdaptor extends RecyclerView.Adapter<BoardAdaptor.ViewHolder> {
    private ArrayList<Model>list;
    private OnClickListener onClickListener;

    public BoardAdaptor(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
        list = new ArrayList<>();
        list.add(new Model("Love is everything","Love!",R.raw.love1));
        list.add(new Model("Love is everything","Love!",R.raw.love2));
        list.add(new Model("Love is everything","Love!",R.raw.love3));
        list.add(new Model("Love is everything","Love!",R.raw.love4));
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemBoardBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ItemBoardBinding binding;

        public ViewHolder(@NonNull ItemBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Model model) {
            binding.textView.setText(model.getTitle());
            binding.textTitle.setText(model.getDesc());
            binding.LottieAnim.setAnimation(model.getImage());
            if (getAdapterPosition() == 3) {
                binding.buttonStart.setVisibility(View.VISIBLE);
            }
            binding.buttonStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.itemClick();
                }
            });
        }

    }
}
