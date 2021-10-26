import java.io.*;
import java.util.Scanner;

public class Lab5var11 {
    public static void main(String[] args) throws IOException {
        DataOutputStream dout = null;
        DataInputStream din = null;
        DataOutputStream dout2 = null;
        DataInputStream din2 = null;
        File f2;
        try {
            File f1 = new File("src.txt");
            if (f1.exists()) f1.delete();
            f1.createNewFile();
            Scanner sc = new Scanner(System.in);
            System.out.println("count ");
            int size = sc.nextInt();
            dout = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));
            for (int i = 0; i < size; i++) {
                int n = sc.nextInt();
                dout.writeInt(n);
            }
            din = new DataInputStream(new FileInputStream(f1));
            f2 = new File("result.txt");
            if (f2.exists()) f2.delete();
            f2.createNewFile();
            int sum = 0;
            dout2 = new DataOutputStream(new FileOutputStream(f2));
            for (int i = 0; i < size; i++) {
                int number = din.readInt();
                sum = sum + number;
                dout2.writeInt(number);
            }
            dout2.writeInt(sum);
            dout2.writeDouble((double) sum / size);
            din2 = new DataInputStream(new FileInputStream(f2));
            for (int i = 0; i < (size + 1); i++) {
                System.out.println(din2.readInt() + " ");
            }
            System.out.println("avg = " + din2.readDouble());
        }
        catch (IOException io) {
            io.printStackTrace();
        }
        finally {
            dout.flush();
            dout2.close();
            din.close();
            din2.close();
        }
    }
}
