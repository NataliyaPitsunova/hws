package geekbrains;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name="Product",urlPatterns = "/prod")
public class FirstServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(geekbrains.FirstServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        List<Product> list = new ArrayList<>();
        list.add(new Product(1,"молоко",60));
        list.add(new Product(2,"хлеб",40));
        list.add(new Product(3,"курица",300));
        list.add(new Product(4,"оливки",200));
        list.add(new Product(5,"колбаса",300));
        list.add(new Product(6,"творог",150));
        list.add(new Product(7,"масло",300));
        list.add(new Product(8,"яйца",100));
        list.add(new Product(9,"йогурт",60));
        list.add(new Product(10,"гречка",100));

        for (Product p:list
             ) {
            resp.getWriter().printf("<h1>"+ p.getId() + " " + p.getTitle() + " "+p.getCost() + " " +"</h1>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }


    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }
}