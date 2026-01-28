import java.util.Scanner;
import java.util.ArrayList;

public class minimarket {
    static class CartItem {
        String name;
        int price;
        int quantity;

        CartItem(String name, int price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        int getTotalPrice() {
            return price * quantity;
        }
    }

    static ArrayList<CartItem> cart = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n========== MINIMARKET MARCELLINO ==========");
            System.out.println("1. Belanja");
            System.out.println("2. Lihat Keranjang");
            System.out.println("3. Hapus Item dari Keranjang");
            System.out.println("4. Keluar");
            System.out.println("5. Checkout");
            System.out.print("Pilih menu (1-5): ");

            int menuUtama = scanner.nextInt();

            switch (menuUtama) {
                case 1:
                    belanja(scanner);
                    break;
                case 2:
                    lihatKeranjang();
                    break;
                case 3:
                    hapusItemKeranjang(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("\nTerima kasih telah berbelanja di Minimarket Marcellino!");
                    break;
                case 5:
                    if (cart.isEmpty()) {
                        System.out.println("\n⚠ Keranjang belanja Anda kosong. Tambahkan item sebelum checkout.");
                        break;
                    }

                    // Hitung total harga
                    int totalHarga = 0;
                    for (CartItem it : cart) {
                        totalHarga += it.getTotalPrice();
                    }

                    lihatKeranjang();
                    System.out.println(" ========== SISTEM PEMBAYARAN ========== ");
                    System.out.println("1. Cash");
                    System.out.println("2. E-Wallet");
                    System.out.print("Pilih metode pembayaran (1-2): ");
                    int metode = scanner.nextInt();

                    if (metode == 1) {
                        System.out.print("Masukkan jumlah pembayaran (Rp): ");
                        int bayar = scanner.nextInt();
                        if (bayar < totalHarga) {
                            System.out.println("Uang tidak cukup. Transaksi dibatalkan.");
                        } else {
                            int kembalian = bayar - totalHarga;
                            System.out.println("Pembayaran berhasil. Kembalian: Rp " + kembalian + ". Terima kasih!");
                            cart.clear();
                        }
                    } else if (metode == 2) {
                        System.out.println("1. Transfer (debit/kredit)");
                        System.out.println("2. QR Code");
                        System.out.println("3. Voucher");
                        System.out.print("Pilih metode E-Wallet (1-3): ");
                        int ewallet = scanner.nextInt();
                        switch (ewallet) {
                            case 1:
                                System.out.print("Masukkan nomor rekening/akun: ");
                                scanner.next(); // consume input (no validation here)
                                System.out.println("Pembayaran via Transfer berhasil. Terima kasih!");
                                cart.clear();
                                break;
                            case 2:
                                System.out.println("Pembayaran via QR Code berhasil. Terima kasih!");
                                cart.clear();
                                break;
                            case 3:
                                System.out.print("Masukkan kode voucher: ");
                                scanner.next();
                                System.out.println("Voucher berhasil digunakan. Terima kasih!");
                                cart.clear();
                                break;
                            default:
                                System.out.println("Metode E-Wallet tidak valid.");
                                break;
                        }
                    } else {
                        System.out.println("Metode pembayaran tidak valid.");
                    }
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        }

        scanner.close();
    }

    static void belanja(Scanner scanner) {
        System.out.println("\n========== PILIH KATEGORI PRODUK ==========");
        System.out.println("1. Coffee");
        System.out.println("2. Non Coffee");
        System.out.println("3. Snack");
        System.out.print("Masukkan pilihan kategori (1-3): ");

        int kategori = scanner.nextInt();

        switch (kategori) {
            case 1:
                kategoriCoffee(scanner);
                break;
            case 2:
                kategoriNonCoffee(scanner);
                break;
            case 3:
                kategoriSnack(scanner);
                break;
            default:
                System.out.println("Kategori tidak valid.");
        }
    }

    static void kategoriCoffee(Scanner scanner) {
        System.out.println("\n================ DAFTAR MENU (COFFEE) ================");
        System.out.println("1. Espresso - Rp 15.000");
        System.out.println("2. Latte - Rp 20.000");
        System.out.println("3. Cappuccino - Rp 25.000");
        System.out.println("4. Americano - Rp 18.000");
        System.out.print("Pilih menu (1-4): ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                tambahKeKeranjang(scanner, "Espresso", 15000);
                break;
            case 2:
                tambahKeKeranjang(scanner, "Latte", 20000);
                break;
            case 3:
                tambahKeKeranjang(scanner, "Cappuccino", 25000);
                break;
            case 4:
                tambahKeKeranjang(scanner, "Americano", 18000);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    static void kategoriNonCoffee(Scanner scanner) {
        System.out.println("\n================ DAFTAR MENU (NON COFFEE) ================");
        System.out.println("1. Ice Tea - Rp 10.000");
        System.out.println("2. Lemonade - Rp 12.000");
        System.out.println("3. Mineral Water - Rp 8.000");
        System.out.println("4. Chocolate Hot/Ice - Rp 20.000");
        System.out.print("Pilih menu (1-4): ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                tambahKeKeranjang(scanner, "Ice Tea", 10000);
                break;
            case 2:
                tambahKeKeranjang(scanner, "Lemonade", 12000);
                break;
            case 3:
                tambahKeKeranjang(scanner, "Mineral Water", 8000);
                break;
            case 4:
                tambahKeKeranjang(scanner, "Chocolate Hot/Ice", 20000);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    static void kategoriSnack(Scanner scanner) {
        System.out.println("\n================ DAFTAR MENU (SNACK) ================");
        System.out.println("1. Potato Chips - Rp 15.000");
        System.out.println("2. Donut (3 pieces) - Rp 15.000");
        System.out.println("3. Chocolate Croissant - Rp 20.000");
        System.out.println("4. Sandwich - Rp 25.000");
        System.out.print("Pilih menu (1-4): ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                tambahKeKeranjang(scanner, "Potato Chips", 15000);
                break;
            case 2:
                tambahKeKeranjang(scanner, "Donut (3 pieces)", 15000);
                break;
            case 3:
                tambahKeKeranjang(scanner, "Chocolate Croissant", 20000);
                break;
            case 4:
                tambahKeKeranjang(scanner, "Sandwich", 25000);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    static void tambahKeKeranjang(Scanner scanner, String nama, int harga) {
        System.out.print("Masukkan jumlah pembelian " + nama + ": ");
        int jumlah = scanner.nextInt();

        if (jumlah <= 0) {
            System.out.println("Jumlah tidak valid.");
            return;
        }

        // Cek apakah item sudah ada di keranjang
        boolean found = false;
        for (CartItem item : cart) {
            if (item.name.equals(nama)) {
                item.quantity += jumlah;
                found = true;
                break;
            }
        }

        // Jika belum ada, tambahkan item baru
        if (!found) {
            cart.add(new CartItem(nama, harga, jumlah));
        }

        System.out.println(  jumlah + "x " + nama + " ditambahkan ke keranjang.");
    }

    static void lihatKeranjang() {
        if (cart.isEmpty()) {
            System.out.println("\n⚠ Keranjang belanja Anda kosong.");
            return;
        }

        System.out.println("\n========== KERANJANG BELANJA ==========");
        System.out.printf("%-3s %-25s %-10s %-10s %-15s\n", "No", "Produk", "Harga", "Qty", "Total");
        System.out.println("============================================================");

        int totalHarga = 0;
        for (int i = 0; i < cart.size(); i++) {
            CartItem item = cart.get(i);
            System.out.printf("%-3d %-25s Rp %-8d %-10d Rp %d\n",
                    i + 1, item.name, item.price, item.quantity, item.getTotalPrice());
            totalHarga += item.getTotalPrice();
        }

        System.out.println("============================================================");
        System.out.printf("%-45s TOTAL: Rp %d\n", "", totalHarga);
        System.out.println("============================================================");
    }

    static void hapusItemKeranjang(Scanner scanner) {
        if (cart.isEmpty()) {
            System.out.println("\n⚠ Keranjang belanja Anda kosong.");
            return;
        }

        lihatKeranjang();
        System.out.print("\nMasukkan nomor item yang ingin dihapus (1-" + cart.size() + "): ");
        int nomor = scanner.nextInt();

        if (nomor < 1 || nomor > cart.size()) {
            System.out.println("Nomor item tidak valid.");
            return;
        }

        CartItem removed = cart.remove(nomor - 1);
        System.out.println(removed.name + " telah dihapus dari keranjang.");
        
    }

}