import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.UIManager;
public class Main {
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        Calcul cal=new Calcul();
    }
}
