package br.com.igti.futebolquiz.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import br.com.igti.futebolquiz.R;
import br.com.igti.futebolquiz.control.QuizFactory;
import br.com.igti.futebolquiz.databinding.FragmentQuizBinding;
import br.com.igti.futebolquiz.model.Answer;
import br.com.igti.futebolquiz.model.Question;
import br.com.igti.futebolquiz.view.FutebolQuizActivity;


public class QuizFragment extends Fragment {
    private static final String LAST_QUESTION = "last_question";
    private int lastQuestion;
    private FragmentQuizBinding binding;
    private Question question;
    private int current = 0;
    public QuizFragment() {
    }

    public static QuizFragment newInstance(int lastQuestion) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putInt(LAST_QUESTION, lastQuestion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            lastQuestion = getArguments().getInt(LAST_QUESTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        question = getQuestion();
        binding.tvQuestion.setText(question.getDescription());
        String[] values = new String[question.getOptions().size()];
        for (int i = 0; i < question.getOptions().size(); i++) {
            values[i] = question.getOptions().get(i).getOption();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        binding.listview.setAdapter(adapter);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FutebolQuizActivity activity = ((FutebolQuizActivity) getActivity());
                if (activity != null)
                    if (position + 1 == question.getCorrectAnswer()) {
                        activity.correct(current);
                    } else {
                        activity.incorrect(lastQuestion);
                    }
            }
        });

    }

    private Question getQuestion() {
        List<Question> questions = QuizFactory.buildQuizQuestions();
        if(lastQuestion+1>questions.size()-1){
            current = 0;
        }else{
            current = lastQuestion+1;
        }
        return questions.get(current);
    }
}
