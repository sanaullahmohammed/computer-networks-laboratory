import java.util.Scanner;

public class RSA
{
    int d;
    int e;
    int n;
    String T;

    int gcd(int m, int n)
    {
        int rv = n == 0 ? m : gcd(n, m%n);
        return rv;
    }

    int pow(int a, int m, int n)
    {
        int r = 1;
        while(m-- != 0)
            r = (r*a) % n;
        System.out.println((char)a+"= "+r);
        return r;
    }

    void rsa()
    {
        int p;
        int q;
        int z;

        p=11;
        q=13;

        n = p*q;
        z = (p-1) * (q-1);

        for(e=2; gcd(e,z) != 1; e++);
        for(d=2; (d*e)%z != 1; d++);

        System.out.println("\nS=(d,n) = ("+d+","+n+")");
        System.out.println("\nP=(e,n) = ("+e+","+n+")\n");
    }

    void cipher(char[] T, int k, int n)
    {
        for(int i=0; i<T.length; i++)
        {
            T[i] = (char)pow(T[i], k, n);
        }
        System.out.println("C: "+String.valueOf(T));
    }

    void input()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter T: ");
        T=scanner.next();
        scanner.close();
    }

    void output()
    {
        System.out.println("T: "+T);
        char[]  M= T.toCharArray();
        cipher(M,e,n);
        cipher(M,d,n);
    }

    public static void main(String[] args)
    {
        RSA r = new RSA();
        r.rsa();
        r.input();
        r.output();
    }
}
