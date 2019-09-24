package nurullahdur.com.Composition;

public class Main {


    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(40,40,4);
        Case theCase = new Case("230B","Toshiba","240",dimensions);
        Monitor theMonitor = new Monitor("17inch ", "Mac",28, new Resolution(1823,1239));

        MotherBoard theMotherBoard = new MotherBoard("Bj-200","Acer",4,5,"v3.03");

        Pc thePc = new Pc(theCase,theMonitor,theMotherBoard);
        /*
        * Kurduğumuz her class ve altındaki değişkenleri Pc classı altında topladık
        * böylelikle Kalıtım yolunu kullanmadan her classın istediğimiz değişkenine
        * erişmemizi sağlayan yapıya Composition yapısı denir.
        * */

        thePc.getMonitor().drawPixelAt(1500,1200,"blue");
        thePc.getMotherBoard().loadProgram("Windiows 10");


    }
}
