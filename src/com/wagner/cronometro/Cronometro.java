package com.wagner.cronometro;

public class Cronometro {
    private long tempoInicio = 0;

    private long tempoFim = 0;

    private long tempoTotal = 0;

    private boolean estaPausado = false;

    private boolean sessaoAtiva = false;

    public boolean isSessaoAtiva() {
        return sessaoAtiva;
    }

    public long getTempoTotal() {
        return tempoTotal;
    }

    private void play() {
        this.tempoInicio = System.nanoTime();
        sessaoAtiva = true;
    }

    private void pause() {
        this.tempoFim = System.nanoTime();
        estaPausado = true;
        this.tempoTotal += this.tempoFim - this.tempoInicio;
        this.tempoInicio = 0;
        this.tempoFim = 0;
    }

    public boolean iniciar() {
        if (!estaPausado && !sessaoAtiva) {
            this.tempoTotal = 0;
            play();
            return true;
        } else {
            return false;
        }

    }

    public boolean pausar() {
        if (sessaoAtiva && !estaPausado) {
            pause();
            return true;
        } else {
            return false;
        }
    }

    public boolean retomar() {
        if (sessaoAtiva && estaPausado) {
            estaPausado = false;
            play();
            return true;
        } else {
            return false;
        }
    }

    public boolean encerrar() {
        if (sessaoAtiva && !estaPausado) {
            pause();
            finalizarSessao();
            return true;
        } else if (sessaoAtiva && estaPausado) {
            finalizarSessao();
            return true;
        } else {
            return false;
        }
    }
    private void finalizarSessao() {
        sessaoAtiva = false;
        estaPausado = false;
    }

}

