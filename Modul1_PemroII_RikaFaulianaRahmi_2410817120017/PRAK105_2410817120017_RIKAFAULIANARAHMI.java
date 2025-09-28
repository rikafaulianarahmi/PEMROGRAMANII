import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormat;

public class PRAK105_2410817120017_RIKAFAULIANARAHMI {
    public static final double PI = 3.14;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.##");

        double jariJari, tinggi;

        System.out.print("Masukkan jari-jari: ");
        jariJari = input.nextDouble();

        System.out.print("Masukkan tinggi: ");
        tinggi = input.nextDouble();

        double volume = PI * jariJari * jariJari * tinggi;

        System.out.println(
                "Volume tabung dengan jari-jari " + df.format(jariJari) + " cm" +
                        " dan tinggi " + df.format(tinggi) + " cm" +
                        " adalah " + String.format("%.3f", volume) + " m3"
        );

        input.close();
    }
}