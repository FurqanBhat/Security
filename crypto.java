public class crypto {
    private static String sym_encrypt(String msg, int key){
        String result="";
        for(char c : msg.toCharArray()){
            int dec_c=(int)c;
            dec_c=dec_c^key;
            char c_enc=(char)dec_c;
            result+=c_enc;
        }
        return result;
    }
    private static void asym_encrypt(int msg){
        int p=2, q=7;
        int n=p*q;
        int phi=(p-1)*(q-1);
        System.out.println("Bob has (p,q) = "+ "("+p+","+q+")");
        System.out.println("Bob generates phi= "+phi+" & n= "+n);
        int e=2;
        while(gcd(e,phi)!=1){
            e++;
        }
        System.out.println("Bob generates e = "+e);
        System.out.println("Bob Publishes (e,n) = ("+e+","+n+")");
        //we pblish e and n. These are needed for encyrption. so everyone can encrypt the files. But
        //for decryption, d is needed which requires e and phi for calculation. Since we don't share
        //phi and it can only be calculated by a person if he has p and q which requires him to factorize
        //n that is computationally infeasible, so the only person that can decrypt the file is BOB.
        //SO BOB PUBLISHES INFO TO ENCRYPT THE FILES BUT HE ONLY KNOWS HOT TO DECRYPT THEM, I.E ANYONE CAN ENCRYPT THE FILE AND SENT TO BOB, BUT ONLY BOB CAN DECRYPT
        int d=get_d(e, phi);
        System.out.println("Bob generates d = "+d+" for decryption");
    
        System.out.println("Alex has to send message = "+msg+ " to Bob");
        double enc_msg=Math.pow(msg, e)%n;
        System.out.println("Alex recieves phi and n from Bob and encrypts the message as ENCRYPTED MSG = "+enc_msg);
        System.out.println("Bob recieves the encrypted message "+enc_msg+" and starts Decryption using d");
        int dec_msg=(int)Math.pow(enc_msg, d)%n;
        System.out.println("Bob decrypts message and gets dec_msg = "+dec_msg);
        

    }
    private static int get_d(int e, int phi){
        int d=1;
        while((e*d)%phi!=1){
            d++;
        }
        return d;

    }
    private static int gcd(int a, int b){
        while(b!=0){
            int temp=a;
            a=b;
            b=temp%b;
        }
        return a;
    }

    public static void main(String[] args) {
        // String message="Hello, I'm in Kayseri";
        // String encrypted_msg=sym_encrypt(message, 24);
        // System.out.println(encrypted_msg);
        // for(int i=0; i<50; i++){
        //     System.out.println(sym_encrypt(encrypted_msg, i));
        // }
        asym_encrypt(13);






    }
    
}
