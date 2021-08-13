package com.example.quiztruefalseapp.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiztruefalseapp.R;

public class GkViewHolder extends RecyclerView.ViewHolder {

    private TextView txtGkQuestion;
    private ImageButton imgButtonTrue;
    private ImageButton imgButtonFalse;

    public GkViewHolder(@NonNull View itemView) {
        super(itemView);

        txtGkQuestion = itemView.findViewById(R.id.gk_question_text);
        imgButtonTrue = itemView.findViewById(R.id.trueButton);
        imgButtonFalse = itemView.findViewById(R.id.falseButton);
    }

    public TextView getTxtGkQuestion() {
        return txtGkQuestion;
    }

    public ImageButton getImgButtonTrue() {
        return imgButtonTrue;
    }

    public ImageButton getImgButtonFalse() {
        return imgButtonFalse;
    }
}
