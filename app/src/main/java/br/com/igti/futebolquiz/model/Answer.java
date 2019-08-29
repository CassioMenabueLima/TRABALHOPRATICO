package br.com.igti.futebolquiz.model;

public class Answer {
    private String option;
    private String urlFoto;

    public Answer(String option) {
        this.option = option;
    }

    public Answer(String option, String urlFoto) {
        this.option = option;
        this.urlFoto = urlFoto;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
