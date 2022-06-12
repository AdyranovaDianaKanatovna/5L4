package com.example.a5l4.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a5l4.R;
import com.example.a5l4.databinding.PagerBoardBinding;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {
    private String[] titles = new String[]{"Do you want to find your love?", "You came into right place", "Want to know!"};
    private int[] texts = new int[]{R.string.first_board_page, R.string.second_board_page, R.string.third_board_page};

    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BoardViewHolder(PagerBoardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class BoardViewHolder extends RecyclerView.ViewHolder {
        private PagerBoardBinding binding;

        public BoardViewHolder(PagerBoardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(int position) {
            binding.boardTitle.setText(titles[position]);
            binding.boardText.setText(texts[position]);
            if (position == titles.length - 1)
                binding.btnStartBoard.setVisibility(View.VISIBLE);
            else
                binding.btnStartBoard.setVisibility(View.INVISIBLE);
        }
    }
}
