package br.com.igti.futebolquiz.control.media;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
    private MediaPlayer mPlayer;

    public void stop() {
        if(mPlayer !=null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c, int res) {
        // prevenção se o usuário clicar
        // enquanto já estiver um som rodando
        stop();

        // cria uma nova instância
        mPlayer = MediaPlayer.create(c, res);

        // se o som terminou, limpa o player
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });


        mPlayer.start();
    }
}
