import domain.ProductSpecification;
import shopping.Webshop;

public class MainTest {

    public static void main(String[] args) {
        Webshop ws = new Webshop();

        System.out.println(ws.findCustomer(1));
        ws.addItemToBasket("", 1);
    }
}
