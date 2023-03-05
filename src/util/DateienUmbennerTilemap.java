package util;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class DateienUmbennerTilemap {

    public static void main(String[] args) {
        // Pfad zum Ordner, der die zu importierenden Dateien enthält
        String ordnerPfad = "D:\\Aseprite\\Escape\\tilemap";

        // Array aller Dateien im Ordner
        File[] dateien = new File(ordnerPfad).listFiles();

        // Benutzerdefinierte Sortierfunktion, die Dateinamen numerisch sortiert
        Arrays.sort(dateien, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                int num1_2 = extractNumber(f1.getName().substring(0, f1.getName().indexOf("x")));
                int num1_1 = extractNumber(f1.getName().substring(f1.getName().indexOf("x")+1, f1.getName().lastIndexOf(".")));
                int num2_2 = extractNumber(f2.getName().substring(0, f2.getName().indexOf("x")));
                int num2_1 = extractNumber(f2.getName().substring(f2.getName().indexOf("x")+1, f2.getName().lastIndexOf(".")));

                if (num1_1 == num2_1) {
                    return num1_2 - num2_2;
                } else {
                    return num1_1 - num2_1;
                }
            }

            private int extractNumber(String name) {
                int i = 0;
                int n = name.length();
                while (i < n && !Character.isDigit(name.charAt(i))) {
                    i++;
                }
                int num = 0;
                while (i < n && Character.isDigit(name.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(name.charAt(i));
                    i++;
                }
                return num;
            }
        });

        // Gehe durch alle Dateien und benenne sie um
        for (int i = 0; i < dateien.length; i++) {
            File datei = dateien[i];

            // Benenne die Datei um, indem du ihr einen neuen Namen gibst
            String neuerName = i + ".png"; // Oder ändere die Endung entsprechend deiner Dateien
            File neueDatei = new File(datei.getParentFile(), neuerName);

            // Verschiebe die Datei an ihren neuen Speicherort
            try {
                datei.renameTo(neueDatei);
            } catch (Exception e) {
                System.err.println("Fehler beim Umbenennen der Datei " + datei.getName() + ": " + e.getMessage());
            }
        }

        System.out.println("Alle Dateien wurden sortiert und umbenannt!");
    }
}
