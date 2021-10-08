package e3;

import java.util.ArrayList;
import java.util.Objects;

public class Melody {

        public enum Notes {
            DO,
            RE,
            MI,
            FA,
            SOL,
            LA,
            SI,
        }

        public enum Accidentals {
            FLAT,
            SHARP,
            NATURAL,
        }

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

        private ArrayList<Notas> melody;

        public Melody() {
            this.melody = new ArrayList<Notas>();
        }

        public void addNote(Notes note, Accidentals accidental, float time) {
            boolean valido1 = false;
            boolean valido2 = false;
            boolean valido3 = false;

            if (note == null)
                throw new IllegalArgumentException();
            else valido1 = true;

            if (accidental == null)
                throw new IllegalArgumentException();
            else valido2 = true;

            if (time <= 0)
                throw new IllegalArgumentException();
            else valido3 = true;

            if (valido1 && valido2 && valido3) {
                Notas nota = new Notas(note, accidental, time);
                melody.add(nota);
            }
        }

        public Notes getNote(int index) {
            if (0 <= index && index < melody.size())
                return melody.get(index).nota;
            else throw new IllegalArgumentException();
        }

        public Accidentals getAccidental(int index) {
            if (0 <= index && index < melody.size())
                return melody.get(index).accidental;
            else throw new IllegalArgumentException();
        }

        public float getTime(int index) {
            if (index >= 0)
                return melody.get(index).tiempo;
            else throw new IllegalArgumentException();
        }

        public int size() {
            return melody.size();
        }

        public float getDuration() {
            float duration = 0;
            for (int i = 0; i < melody.size(); i++) {
                duration = duration + melody.get(i).tiempo;
            }
            return duration;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Melody)) return false;
            Melody melody1 = (Melody) o;

            for (int i = 0; i < melody.size(); i++) {
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
            }
            return Objects.equals(melody, melody1.melody);
        }

  /*  @Override
    public int hashCode() {
        int result;
        long temp;
        result = 7;
        for (int i = 0; i < melody.size(); i++) {
            result = 31 * result + (int) melody.get(i).nota;
        }
    }*/

        @Override
        public String toString() {
            String sharp = "#";
            String flat = "b";
            String natural = "";
            String melodyString = "";

            for (int i = 0; i < melody.size(); i++) {
                if (melody.get(i).accidental == Accidentals.NATURAL)
                    melodyString = melodyString + melody.get(i).nota + "" + natural + "(" + melody.get(i).tiempo + ")" + " ";
                else if (melody.get(i).accidental == Accidentals.SHARP)
                    melodyString = melodyString + melody.get(i).nota + "" + sharp + "(" + melody.get(i).tiempo + ")" + " ";
                else if (melody.get(i).accidental == Accidentals.FLAT)
                    melodyString = melodyString + melody.get(i).nota + "" + flat + "(" + melody.get(i).tiempo + ")" + " ";
            }
            melodyString = melodyString.trim();
            return melodyString;
        }





}
