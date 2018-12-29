/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc.wat.jee.lab2;

import java.io.IOException;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author PC
 */
@WebServlet(urlPatterns = "/db")
public class DBServlet extends HttpServlet{

    @PersistenceContext
    EntityManager manager;
    
    @Resource 
    private UserTransaction utx;
    
    private final String persistenceUnitName = "";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        Books book = new Books();
        book.setIsbn10("00-11-22");
        book.setTitle("my book");
        try
        {
        utx.begin();
        manager.persist(book);
        utx.commit();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        //manager = Persistence.createEntityManagerFactory("YoloLibPU").createEntityManager();
        //Query query = manager.createNamedQuery("FictionalCharacters.findAll");
        
    }
    
    
}
