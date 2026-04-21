interface Payable {
    int getPayableAmount();
}

class Invoice implements Payable {

    private String productName;
    private int quantity;
    private int pricePerItem;

    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    @Override
    public int getPayableAmount() {
        return quantity * pricePerItem;
    }

    @Override
    public String toString() {
        return "Produk: " + productName +
                ", Jumlah: " + quantity +
                ", Harga per item: Rp" + pricePerItem +
                ", Total: Rp" + getPayableAmount();
    }
}

class Employee implements Payable {

    private int registrationNumber;
    private String name;
    private int salaryPerMonth;
    private Invoice[] invoices;

    public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    @Override
    public int getPayableAmount() {
        int totalInvoice = 0;
        for (Invoice inv : invoices) {
            totalInvoice += inv.getPayableAmount();
        }
        return salaryPerMonth - totalInvoice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== Data Karyawan ===\n");
        sb.append("No. Registrasi: ").append(registrationNumber).append("\n");
        sb.append("Nama: ").append(name).append("\n");
        sb.append("Gaji Bulanan: Rp").append(salaryPerMonth).append("\n\n");

        sb.append("=== Detail Belanjaan ===\n");
        for (Invoice inv : invoices) {
            sb.append(inv.toString()).append("\n");
        }

        sb.append("\nTotal gaji setelah dipotong belanja: Rp")
          .append(getPayableAmount());

        return sb.toString();
    }
}

public class MainPraktikum {

    public static void main(String[] args) {

        Invoice[] belanjaan = {
                new Invoice("Beras", 2, 60000),
                new Invoice("Minyak Goreng", 3, 20000),
                new Invoice("Gula", 1, 15000)
        };

        Employee emp = new Employee(101, "dapuy", 2000000, belanjaan);

        System.out.println(emp);
    }
}