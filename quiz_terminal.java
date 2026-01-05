import java.util.Scanner;
public class quiz_terminal {
    
    public static void main(String[] args) {
        // 1. DEKLARASI DATA // SOAL 
        String[] pertanyaan = {
            "Berapa hasil dari 2 + 2?",
            "Ibu kota Indonesia adalah?",
            "Java adalah bahasa pemrograman apa?",
            "mana yang salah jenis segitiga berdasarkan panjang sisinya ?",
            "Mana yang salah mengenai unsur unsur lingkaran ?"
        };
        // Array 2D untuk pilihan jawaban
        String[][] pilihan = {
            {"3", "4", "5", "6"},
            {"Jakarta", "IKN", "Bandung", "Medan"},
            {"Tingkat Rendah", "Tingkat Menengah", "Tingkat Tinggi", "Tidak ada"},
            {"Segitiga sama sisi", "Segitiga sama kaki", "segitiga sembarang", "segitiga lancip"},
            {"Titik pusat", "apotema", "juring", "parabola"}
        };
        
        // Jawaban yang benar (index 0-3, dimana 0=A, 1=B, 2=C, 3=D)
        int[] jawabanBenar = {1, 0, 2, 3, 3}; // B, A, C
        
        // 2. PROSES QUIZ
        Scanner scanner = new Scanner(System.in);
        int skor = 0;
        System.out.println("============ TERMINAL QUIZ ============\n");

        // memasukkan data diri
        System.out.println( "MASUKKAN NAMA ANDA");
        String nama = scanner.nextLine();
        System.out.println( "SELAMAT MENGERJAKAN " + nama );        
        // Loop untuk setiap pertanyaan
        for (int i = 0; i < pertanyaan.length; i++) {
            System.out.println("Pertanyaan " + (i + 1) + ": " + pertanyaan[i]);
            
            // Tampilkan pilihan A, B, C, D
            for (int j = 0; j < pilihan[i].length; j++) {
                char pilihan_huruf = (char)('A' + j); // Ubah 0,1,2,3 jadi A,B,C,D
                System.out.println(pilihan_huruf + ". " + pilihan[i][j]);
            }
            
            // Input dari user
            System.out.print("Jawaban Anda (A/B/C/D): ");
            String input = scanner.nextLine().toUpperCase();
            
            // Ubah input huruf jadi angka (A=0, B=1, C=2, D=3)
            int jawabanUser = input.charAt(0) - 'A';
            
            // Cek apakah jawaban benar
            if (jawabanUser == jawabanBenar[i]) {
                System.out.println(" BENAR!\n");
                skor++;
            } else {
                System.out.println(" SALAH!   Jawaban yang benar adalah: " + 
                    (char)('A' + jawabanBenar[i]) + "\n");
            }
        }
        
        // 3. TAMPILKAN HASIL
        System.out.println("========== HASIL AKHIR ==========");
        System.out.println("Skor Anda: " + skor + " dari " + pertanyaan.length);
        System.out.println("Persentase: " + (skor * 100 / pertanyaan.length) + "%");

        if (skor <= 3){
            System.out.println("SKOR ANDA KURANG DARI TARGET BELAJAR LAGI YA");
        }if (skor >=4){
            System.out.println("GG GAMING Ibumu pasti bangga !");
        }
       
        
        scanner.close();
    }
}
