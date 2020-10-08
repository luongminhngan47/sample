package ChangeBase_100loc;
import java.util.Scanner;
public class P0011 {
    static Scanner sc = new Scanner(System.in);
    static char[] digitInDecimal = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static char[] digitInBinary = new char[]{'0', '1'};
    static char[] digitInHexa = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
//
    static char[] DBinary() {
        char[] digitInBinary = new char[]{'0', '1'};
        return digitInBinary;
    }
    //HEX LA 16
    static char[] DHexa() {
        char[] digitInHexa = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        return digitInHexa;
    }

    static char[] DDecimal() {
        char[] digitInDecimal = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int leng = Integer.MAX_VALUE;
        return digitInDecimal;
    }
    //nhận input từ 1-3
    static int getValidInt(int min, int max) {
        while (true) {
            try {
                int temp = Integer.parseInt(sc.nextLine());
                if (temp < min || temp > max) {
                    throw new Exception();
                }
                return temp;
            } catch (Exception e) {
                System.out.print("wrong input, please enter again:");
            }
        }
    }

    static String getValidNumberInStringConvert(int base) {
        char[] digitInBinary = DBinary();
        char[] digitInDecimal = DDecimal();
        char[] digitInHexa = DHexa();
        char[] digitCheck = null;
        if (base == 2) {
            digitCheck = digitInBinary;
        } else if (base == 10) {
            digitCheck = digitInDecimal;
        } else if (base == 16) {
            digitCheck = digitInHexa;
        }
        while (true) {
            try {
                //temp là nhập dữ liệu bin, dec, hex 11110
                String temp = sc.nextLine();
                boolean check = false;
                //nó sẽ tách string mình nhập vào thành mảng. và chạy từ đầu mảng đến cuối mảng
//                for(int i=0; i<temp.length(); i++)
                  //temp.toCharArray() bien string thanh mang array
                  //21110 tach thanh ['2','1','1','1','0']
                for (char i : temp.toCharArray()) {
                    check = false;
                    //tach ra va check voi tung phan tu trong mang
                    //voi i = 0 thi no lay ra 2.
                    //so sanh '2' vs mang  char[]{'0', '1'};
                    //ctemp = '0' ctemp = '1'
                    //i la 1
                    for (char cTemp : digitCheck) {
                        if (i == cTemp) {
                            check = true;
                            break;
                        }
                    }
                    
                    if (check == false) {
                        break;
                    }
                }
                
                if (check == false) {
                    throw new Exception();
                }
                return temp;
            } catch (Exception e) {
                System.out.print("wrong input, please enter again: ");
            }
        }
    }
    //chuyển từ 10 - 16
    static String convertDecToHex(String dec) {
        char[] digitInHexa = DHexa();
        String answer = new String();
        int tempDec = Integer.parseInt(dec);
        while (tempDec != 0) {
            int div = tempDec / 16;
            int mod = tempDec % 16;
            
            answer = digitInHexa[mod] + answer;//de dao ket qua
            tempDec = div;
        }
        return answer;
    }
    //chuyển từ 16 - 10
    static String convertHexToDec(String hex) {
        //hex la thang minh nhap vao 12ab
        //ch lay lan luot 1, 2, a, b
        char[] digitInHexa = DHexa();
        int answer = 0;
        for (int i = 0; i < hex.length(); i++) {
            char ch = hex.charAt(i);
            int value = 0;
            //vong for nay la chay trong ham Dhex()
            for (int j = 0; j < digitInHexa.length; j++) {
                if (ch == digitInHexa[j]) {
                    value = j;
                }
            }
            int pow = (int) Math.pow(16, (hex.length() - 1) - i);
            answer = answer + value * pow;
        }
        return String.valueOf(answer);
    }
    //chuyển từ 10 - 2
    static String convertDecToBin(String dec) {
        char[] digitInBinary = DBinary();
        String answer = new String();
        int tempDec = Integer.parseInt(dec);
        while (tempDec != 0) {
            int div = tempDec / 2;
            int mod = tempDec % 2;
            answer = digitInBinary[mod] + answer;
            tempDec = div;
        }
        return answer;
    }
    //chuyển từ 2 - 10
    static String convertBinToDec(String bin) {
        char[] digitInBinary = DBinary();
        int answer = 0;
        for (int i = 0; i < bin.length(); i++) {
            char ch = bin.charAt(i);
            int value = 0;
            for (int j = 0; j < digitInBinary.length; j++) {
                if (ch == digitInBinary[j]) {
                    value = j;
                }
            }
            int pow = (int) Math.pow(2, (bin.length() - 1) - i);
            answer = answer +value * pow;
        }
        return String.valueOf(answer);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter 1 to binary, 2 to decimal, 3 to hexa!");
        
        //begin of check input and convert to base
        System.out.print("Choose base input: ");
        int inputBase = getValidInt(1, 3);
        inputBase = convertToBase(inputBase);
        System.out.print("Choose base output: ");
        int outputBase = getValidInt(1, 3);
        outputBase = convertToBase(outputBase);
        //end of check input and convert to base
        
        System.out.print("Enter your inpur number:");
        String input = getValidNumberInStringConvert(inputBase);
        String temp = new String();
        switch (inputBase) {
            case 2:
                //khi nhap 1 va input thi se auto convert bin to dec
                temp = convertBinToDec(input);
                if (outputBase == 16) {
                    temp = convertDecToHex(temp);
                }
                break;
            case 10:
                //outputBase == 2 thi co nghia la chon output = 1;
                if (outputBase == 2) {
                    temp = convertDecToBin(input);
                } else {
                    temp = convertDecToHex(input);
                }
                break;
            case 16:
                temp = convertHexToDec(input);
                if (outputBase == 2) {
                    temp = convertDecToBin(temp);
                }
                break;
            default:
                break;
        }
        System.out.println(input + "(" + inputBase + ") = " + temp + "(" + outputBase + ")");

    }
    
    //nếu user nhập 1 thì convert sang binary(2)
    //nếu user nhập 2 thì convert sang decimal(10)
    //nếu user nhập 3 thì convert sang hexa(16)
    private static int convertToBase(int input) {
        if (input == 1) {
            return 2;
        }
        if (input == 2) {
            return 10;
        }
        return 16;
    }

}
