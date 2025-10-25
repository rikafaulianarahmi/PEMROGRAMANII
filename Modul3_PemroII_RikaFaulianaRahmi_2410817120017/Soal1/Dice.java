package Soal1;

class Dice {
    private int nilai;

    public Dice() {
        rollValue();
    }

    private void rollValue() {
        this.nilai = (int) (Math.random() * 6) + 1;
    }

    public int getValue() {
        return nilai;
    }
}