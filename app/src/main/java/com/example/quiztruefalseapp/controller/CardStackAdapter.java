package com.example.quiztruefalseapp.controller;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiztruefalseapp.MainActivity;
import com.example.quiztruefalseapp.R;
import com.example.quiztruefalseapp.model.QuizQuestion;
import com.example.quiztruefalseapp.view.GkViewHolder;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<GkViewHolder>{

    private Context mContext;
    private List<QuizQuestion> mGkNames;
    private LayoutInflater mLayoutInflater;

    private CardStackView  mCardStackView ;

    public CardStackAdapter (Context context, List<QuizQuestion> mgkNames, Activity activity){
        mContext = context;
        mGkNames = mgkNames;
        mLayoutInflater = LayoutInflater.from(context);
        mCardStackView= activity.findViewById(R.id.myCardStackView);
        mCardStackView.setLayoutManager(new CardStackLayoutManager(mContext));
    }

    @NonNull
    @Override
    public GkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.gk_view,parent,false);
        return new GkViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GkViewHolder holder, int position) {

          holder.getTxtGkQuestion().setText(mGkNames.get(position).getQuestionText());
          holder.getImgButtonTrue().setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (mGkNames.get(position).isTrueAnswer()){
                  Toast.makeText(mContext,"Correct Answer is Tapped",Toast.LENGTH_SHORT).show();
                    mCardStackView.swipe();
                  }
                else {
                  Toast.makeText(mContext,"Wrong Answer is Tapped",Toast.LENGTH_SHORT).show();
                      mCardStackView.swipe();
                  }

              }
          });

          holder.getImgButtonFalse().setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (mGkNames.get(position).isTrueAnswer()){
                      Toast.makeText(mContext,"Wrong Answer is Tapped",Toast.LENGTH_SHORT).show();
                      mCardStackView.swipe();
                  }
                  else {
                      Toast.makeText(mContext,"Correct Answer is Tapped",Toast.LENGTH_SHORT).show();
                      mCardStackView.swipe();
                  }
              }
          });

    }

    @Override
    public int getItemCount() {
        return mGkNames.size();
    }
}
