package Praktikum2.Soal3;

// public class Employee {}
// error : nama class tidak sesuai dengan nama file yang disimpan
public class Pegawai {
    public String nama;

    // public char asal;
    // tipe data char berbeda dengan tipe data di Soal3Main yaitu String
    public String asal;
    public String jabatan;
    public int umur;

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    // public void setJabatan() {}
    // tidak memiliki parameter didalmnya.
    public void setJabatan(String j) {
        this.jabatan=j;
    }
}