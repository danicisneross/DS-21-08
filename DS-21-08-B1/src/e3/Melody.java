package e3;

import java.util.ArrayList;

public class Melody {

    public enum Notes {DO, RE, MI, FA, SOL, LA, SI}
    public enum Accidentals {FLAT, NATURAL, SHARP}

    //representa las equivalencias entre notas posición-valor
    private static final int[] canonicalNotes = {0,1,2,2,4,5,5,7,8,7,8,11,11,13,14,14,16,17,17,0,1};

    private ArrayList<Notes> notes;
    private ArrayList<Accidentals> accidentals;
    private ArrayList<Float> times;

    public Melody() {
        this.notes = new ArrayList<>();
        this.accidentals = new ArrayList<>();
        this.times = new ArrayList<>();
    }

    public void addNote(Notes note, Accidentals accidental, float time) {
        if (note == null || accidental == null) {
            throw new IllegalArgumentException();
        }
        if (time <= 0) {
            throw new IllegalArgumentException();
        }
        notes.add(note);
        accidentals.add(accidental);
        times.add(time);
    }

    private void checkValidIndex(int i) {
        if (i >= notes.size()) throw new IllegalArgumentException();
    }

    public Notes getNote(int index) {
        checkValidIndex(index);
        return notes.get(index);
    }

    public Accidentals getAccidental(int index) {
        checkValidIndex(index);
        return accidentals.get(index);
    }

    public float getTime(int index) {
        checkValidIndex(index);
        return times.get(index);
    }

    public int size() {
        return notes.size();
    }

    public float getDuration() {
        float duration = 0;
        for (float t : times) {
            duration += t;
        }
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Melody melodia = (Melody) o;

        if (notes.size() != melodia.notes.size()) return false;

        for (int i = 0; i < notes.size(); i++) {
            int thisCode = notes.get(i).ordinal() * 3 + accidentals.get(i).ordinal();
            int code = melodia.notes.get(i).ordinal() * 3 + melodia.accidentals.get(i).ordinal();
            if (canonicalNotes[thisCode] != canonicalNotes[code]) return false;
        }
        return this.times.equals(melodia.times);
    }

    @Override
    public int hashCode() {
        int result;
        ArrayList<Integer> codes = new ArrayList<>();
        for (int i = 0; i < notes.size(); i++) {
            codes.add(canonicalNotes[notes.get(i).ordinal() * 3 + accidentals.get(i).ordinal()]);
        }
        result = codes.hashCode();
        result = 31 * result + times.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < notes.size(); i++) {
            sb.append(notes.get(i));
            if (accidentals.get(i) == Accidentals.SHARP) {
                sb.append('#');
            }
            if (accidentals.get(i) == Accidentals.FLAT) {
                sb.append('b');
            }
            sb.append('(').append(times.get(i)).append(") ");
        }
        return sb.toString().strip();
    }
} //strip quita los espacios
