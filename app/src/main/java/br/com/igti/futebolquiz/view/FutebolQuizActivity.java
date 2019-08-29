package br.com.igti.futebolquiz.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.igti.futebolquiz.R;
import br.com.igti.futebolquiz.control.Preferences;
import br.com.igti.futebolquiz.control.media.AudioPlayer;
import br.com.igti.futebolquiz.databinding.ActivityFutebolQuizBinding;
import br.com.igti.futebolquiz.view.fragment.QuizFragment;

public class FutebolQuizActivity extends AppCompatActivity {
    private AudioPlayer audioPlayer;
    private int lastQuestion;
    private ActivityFutebolQuizBinding binding;
    private boolean isFirst=true;
    private int correctsAnswers, incorrectAnswers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_futebol_quiz);
        audioPlayer = new AudioPlayer();
        if(Preferences.isPrimeiraVez(this)){
            Toast.makeText(this, "Bem-vindo ao FutebolQuiz!", Toast.LENGTH_SHORT).show();
            Preferences.setPrimeiraVezFalse(this);
        }
        pushFragment();
    }
    public void pushFragment(){
        FragmentManager fm = getSupportFragmentManager();
        QuizFragment frag =  QuizFragment.newInstance(lastQuestion);
        if(isFirst){
            isFirst = false;
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragment_content, frag);
            ft.commit();
        }else{
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_content,frag);
            ft.commit();
        }
    }
    public void clear(View view){
        Preferences.clear(this);
        incorrectAnswers = 0 ;
        correctsAnswers =0 ;
        lastQuestion = 0;
        pushFragment();
        binding.textView.setText(String.format("Acertos: %d | Erros: %d",correctsAnswers,incorrectAnswers));
    }
    public void correct(int question){
        correctsAnswers++;
        lastQuestion = question;
        audioPlayer.play(this,R.raw.cashregister);
        pushFragment();
        binding.textView.setText(String.format("Acertos: %d | Erros: %d",correctsAnswers,incorrectAnswers));
    }
    public void incorrect(int question){
        incorrectAnswers++;
        lastQuestion = question;
        audioPlayer.play(this,R.raw.buzzer);
        pushFragment();
        binding.textView.setText(String.format("Acertos: %d | Erros: %d",correctsAnswers,incorrectAnswers));
    }
}
