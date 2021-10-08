package e3;

import java.util.ArrayList;
import java.util.Objects;

public class Melody {

    /**
     * Enum of the valid notes.
     */

    public enum Notes {
        DO,
        RE,
        MI,
        FA,
        SOL,
        LA,
        SI,
    }

    /**
     * Enum of the valid accidentals.
     */

    public enum Accidentals {
        FLAT,
        SHARP,
        NATURAL,
    }

    /**
     * Class Notas.
     * As parameters it has nota, accidental and tiempo.
     * This three parameters it will conform a note.
     */

    public static class Notas {
        public final Notes nota;
        public final Accidentals accidental;
        public final float tiempo;

        public Notas(Notes nota, Accidentals accidental, float tiempo) {
            this.nota = nota;
            this.accidental = accidental;
            this.tiempo = tiempo;
        }
    }

    /**
     * Declaring an ArrayList called melody.
     * This melody will have notes in it.
     */

    private ArrayList<Notas> melody;

    /**
     * Creates an empty Melody instance.
     */

    public Melody() {
        this.melody = new ArrayList<Notas>();
    }

    /**
     * Add a note at the end of this melody.
     * @param note The note to add.
     * @param accidental The accidental of the note.
     * @param time The duration of the note in milliseconds.
     * @throws IllegalArgumentException if the note, the accidental
     * or the time are not valid values.
     */

    public void addNote(Notes note, Accidentals accidental, float time) {
        if (note == null || accidental == null || time <= 0)
            throw new IllegalArgumentException();
        else {
            Notas nota = new Notas(note, accidental, time);
            melody.add(nota);
        }
    }

    /**
     * Returns the note on the given position.
     * @param index The position of the note to get.
     * @return The note on index.
     * @throws IllegalArgumentException if the index is not a valid position.
     */

    public Notes getNote(int index) {
        if (0 <= index && index < melody.size())
            return melody.get(index).nota;
        else throw new IllegalArgumentException();
    }

    /**
     * Returns the accidental of the note on the given position.
     * @param index The position of the accidental to get.
     * @return The accidental on index.
     * @throws IllegalArgumentException if the index is not a valid position.
     */
    public Accidentals getAccidental(int index) {
        if (0 <= index && index < melody.size())
            return melody.get(index).accidental;
        else throw new IllegalArgumentException();
    }

    /**
     * Returns the duration of the note on the given position.
     * @param index The position of the time to get.
     * @return The time on index.
     * @throws IllegalArgumentException if the index is not a valid position.
     */

    public float getTime(int index) {
        if (index >= 0)
            return melody.get(index).tiempo;
        else throw new IllegalArgumentException();
    }

    /**
     * @return The number of notes in this melody.
     */

    public int size() {
        return melody.size();
    }

    /**
     * @return The duration of this melody in milliseconds.
     */

    public float getDuration() {
        float duration = 0;
        for (int i = 0; i < melody.size(); i++) {
            duration = duration + melody.get(i).tiempo;
        }
        return duration;
    }

    /**
     * Performs the equality tests of the current melody with another melody
     * passed as a parameter. Two melodies are equal if they represent the same
     * music fragment regardless of the name of its notes.
     * @param o The melody to be compared with the current melody.
     * @return true if the melodies are equals , false otherwise.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Melody melody1 = (Melody) o;
        if (Objects.equals(melody, melody1.melody))
            return true;
        else {
            for (int i = 0; i < melody.size(); i++) {
                if (!((melody.get(i).nota == melody1.melody.get(i).nota) && (melody.get(i).accidental == melody1.melody.get(i).accidental) && (melody.get(i).tiempo == melody1.melody.get(i).tiempo))) {
                    if ((((melody.get(i).nota) == Notes.DO) && ((melody.get(i).accidental) == Accidentals.SHARP)) && (((melody1.melody.get(i).nota) == Notes.RE) && ((melody1.melody.get(i).accidental) == Accidentals.FLAT)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.RE) && ((melody.get(i).accidental) == Accidentals.SHARP)) && (((melody1.melody.get(i).nota) == Notes.MI) && ((melody1.melody.get(i).accidental) == Accidentals.FLAT)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.MI) && ((melody.get(i).accidental) == Accidentals.NATURAL)) && (((melody1.melody.get(i).nota) == Notes.FA) && ((melody1.melody.get(i).accidental) == Accidentals.FLAT)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.MI) && ((melody.get(i).accidental) == Accidentals.SHARP)) && (((melody1.melody.get(i).nota) == Notes.FA) && ((melody1.melody.get(i).accidental) == Accidentals.NATURAL)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.FA) && ((melody.get(i).accidental) == Accidentals.SHARP)) && (((melody1.melody.get(i).nota) == Notes.SOL) && ((melody1.melody.get(i).accidental) == Accidentals.FLAT)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.SOL) && ((melody.get(i).accidental) == Accidentals.SHARP)) && (((melody1.melody.get(i).nota) == Notes.LA) && ((melody1.melody.get(i).accidental) == Accidentals.FLAT)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.LA) && ((melody.get(i).accidental) == Accidentals.SHARP)) && (((melody1.melody.get(i).nota) == Notes.SI) && ((melody1.melody.get(i).accidental) == Accidentals.FLAT)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.SI) && ((melody.get(i).accidental) == Accidentals.NATURAL)) && (((melody1.melody.get(i).nota) == Notes.DO) && ((melody1.melody.get(i).accidental) == Accidentals.FLAT)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.SI) && ((melody.get(i).accidental) == Accidentals.SHARP)) && (((melody1.melody.get(i).nota) == Notes.DO) && ((melody1.melody.get(i).accidental) == Accidentals.NATURAL)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.RE) && ((melody.get(i).accidental) == Accidentals.FLAT)) && (((melody1.melody.get(i).nota) == Notes.DO) && ((melody1.melody.get(i).accidental) == Accidentals.SHARP)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.MI) && ((melody.get(i).accidental) == Accidentals.FLAT)) && (((melody1.melody.get(i).nota) == Notes.RE) && ((melody1.melody.get(i).accidental) == Accidentals.SHARP)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.FA) && ((melody.get(i).accidental) == Accidentals.FLAT)) && (((melody1.melody.get(i).nota) == Notes.MI) && ((melody1.melody.get(i).accidental) == Accidentals.NATURAL)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.FA) && ((melody.get(i).accidental) == Accidentals.NATURAL)) && (((melody1.melody.get(i).nota) == Notes.MI) && ((melody1.melody.get(i).accidental) == Accidentals.SHARP)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.SOL) && ((melody.get(i).accidental) == Accidentals.FLAT)) && (((melody1.melody.get(i).nota) == Notes.FA) && ((melody1.melody.get(i).accidental) == Accidentals.SHARP)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.LA) && ((melody.get(i).accidental) == Accidentals.FLAT)) && (((melody1.melody.get(i).nota) == Notes.SOL) && ((melody1.melody.get(i).accidental) == Accidentals.SHARP)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.SI) && ((melody.get(i).accidental) == Accidentals.FLAT)) && (((melody1.melody.get(i).nota) == Notes.LA) && ((melody1.melody.get(i).accidental) == Accidentals.SHARP)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.DO) && ((melody.get(i).accidental) == Accidentals.FLAT)) && (((melody1.melody.get(i).nota) == Notes.SI) && ((melody1.melody.get(i).accidental) == Accidentals.NATURAL)))
                        continue;
                    if ((((melody.get(i).nota) == Notes.DO) && ((melody.get(i).accidental) == Accidentals.NATURAL)) && (((melody1.melody.get(i).nota) == Notes.SI) && ((melody1.melody.get(i).accidental) == Accidentals.SHARP)))
                        continue;
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Returns an integer that is a hash code representation of the melody.
     * Two melodies m1, m2 that are equals (m1. equals (m2) == true ) must
     * have the same hash code.
     * @return The hash code of this melody.
     */

    @Override
    public int hashCode() {
        int hash = 7;
        for (Notas notas : melody) {
            if ((((notas.nota) == Notes.DO) && ((notas.accidental) == Accidentals.SHARP)) || (((notas.nota) == Notes.RE) && ((notas.accidental) == Accidentals.FLAT))) {
                hash = 31 * hash + (Notes.DO.hashCode());
                hash = 31 * hash + (Accidentals.SHARP.hashCode());
            } else if ((((notas.nota) == Notes.RE) && ((notas.accidental) == Accidentals.SHARP)) || (((notas.nota) == Notes.MI) && ((notas.accidental) == Accidentals.FLAT))) {
                hash = 31 * hash + (Notes.RE.hashCode());
                hash = 31 * hash + (Accidentals.SHARP.hashCode());
            } else if ((((notas.nota) == Notes.MI) && ((notas.accidental) == Accidentals.NATURAL)) || (((notas.nota) == Notes.FA) && ((notas.accidental) == Accidentals.FLAT))) {
                hash = 31 * hash + (Notes.MI.hashCode());
                hash = 31 * hash + (Accidentals.NATURAL.hashCode());
            } else if ((((notas.nota) == Notes.MI) && ((notas.accidental) == Accidentals.SHARP)) || (((notas.nota) == Notes.FA) && ((notas.accidental) == Accidentals.NATURAL))) {
                hash = 31 * hash + (Notes.MI.hashCode());
                hash = 31 * hash + (Accidentals.SHARP.hashCode());
            } else if ((((notas.nota) == Notes.FA) && ((notas.accidental) == Accidentals.SHARP)) || (((notas.nota) == Notes.SOL) && ((notas.accidental) == Accidentals.FLAT))) {
                hash = 31 * hash + (Notes.FA.hashCode());
                hash = 31 * hash + (Accidentals.SHARP.hashCode());
            } else if ((((notas.nota) == Notes.SOL) && ((notas.accidental) == Accidentals.SHARP)) || (((notas.nota) == Notes.LA) && ((notas.accidental) == Accidentals.FLAT))) {
                hash = 31 * hash + (Notes.SOL.hashCode());
                hash = 31 * hash + (Accidentals.SHARP.hashCode());
            } else if ((((notas.nota) == Notes.LA) && ((notas.accidental) == Accidentals.SHARP)) || (((notas.nota) == Notes.SI) && ((notas.accidental) == Accidentals.FLAT))) {
                hash = 31 * hash + (Notes.LA.hashCode());
                hash = 31 * hash + (Accidentals.SHARP.hashCode());
            } else if ((((notas.nota) == Notes.SI) && ((notas.accidental) == Accidentals.NATURAL)) || (((notas.nota) == Notes.DO) && ((notas.accidental) == Accidentals.FLAT))) {
                hash = 31 * hash + (Notes.SI.hashCode());
                hash = 31 * hash + (Accidentals.NATURAL.hashCode());
            } else if ((((notas.nota) == Notes.SI) && ((notas.accidental) == Accidentals.SHARP)) || (((notas.nota) == Notes.DO) && ((notas.accidental) == Accidentals.NATURAL))) {
                hash = 31 * hash + (Notes.SI.hashCode());
                hash = 31 * hash + (Accidentals.SHARP.hashCode());
            } else {
                hash = 31 * hash + (notas.nota.hashCode());
                hash = 31 * hash + (notas.accidental.hashCode());
            }
            hash = 31 * hash + (int) notas.tiempo;
        }
        return hash;
    }

    /**
     * The string representation of this melody.
     * @return The String representantion of this melody.
     */

    @Override
    public String toString() {
        String sharp = "#";
        String flat = "b";
        String natural = "";
        String melodyString = "";

        for (Notas notas : melody) {
            if (notas.accidental == Accidentals.NATURAL)
                melodyString = melodyString + notas.nota + "" + natural + "(" + notas.tiempo + ")" + " ";
            else if (notas.accidental == Accidentals.SHARP)
                melodyString = melodyString + notas.nota + "" + sharp + "(" + notas.tiempo + ")" + " ";
            else if (notas.accidental == Accidentals.FLAT)
                melodyString = melodyString + notas.nota + "" + flat + "(" + notas.tiempo + ")" + " ";
        }
        melodyString = melodyString.trim();
        return melodyString;
    }
}
