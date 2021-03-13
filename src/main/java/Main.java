import menu.Menu;
import utils.HibernateUtil;

public class Main {
        public static void main(String[] args) {
            new Menu();
            HibernateUtil.shutdown();
        }
    }

