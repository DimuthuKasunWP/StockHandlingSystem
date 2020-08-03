/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.resource;

//import org.hibernate.cfg.AnnotationConfiguration;
import java.io.File;
import lk.edu.ijse.sas.entity.Batch_Add;
import lk.edu.ijse.sas.entity.Batch_Recieve;
import lk.edu.ijse.sas.entity.Company;
import lk.edu.ijse.sas.entity.GRN;
import lk.edu.ijse.sas.entity.Material;
import lk.edu.ijse.sas.entity.Orders;
import lk.edu.ijse.sas.entity.Password;
import lk.edu.ijse.sas.entity.Product;
import lk.edu.ijse.sas.entity.Product_Order;
import lk.edu.ijse.sas.entity.Purchase_Order_Detail;
import lk.edu.ijse.sas.entity.Purchase_Order;
import lk.edu.ijse.sas.entity.Reject_Order;
import lk.edu.ijse.sas.entity.Reject_Order_Detail;
import lk.edu.ijse.sas.entity.Reject_Recieve;
import lk.edu.ijse.sas.entity.Reject_Return_Recieve;
import lk.edu.ijse.sas.entity.Remove_Recieve_Material;
import lk.edu.ijse.sas.entity.Remove_Return_Material;
import lk.edu.ijse.sas.entity.Return_Batch_Recieve;
import lk.edu.ijse.sas.entity.Return_Order;
import lk.edu.ijse.sas.entity.Return_Order_Detail;
import lk.edu.ijse.sas.entity.Sector;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author dimuthu
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private  static final StandardServiceRegistry registry;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            registry = new StandardServiceRegistryBuilder().loadProperties(new File("settings/hibernate.properties")).build();
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Batch_Add.class)
                    .addAnnotatedClass(Batch_Recieve.class)
                    .addAnnotatedClass(Company.class)
                    .addAnnotatedClass(GRN.class)
                    .addAnnotatedClass(Material.class)
                    .addAnnotatedClass(Orders.class)
                    .addAnnotatedClass(Password.class)
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(Product_Order.class)
                    .addAnnotatedClass(Purchase_Order_Detail.class)
                    .addAnnotatedClass(Purchase_Order.class)
                    .addAnnotatedClass(Reject_Order.class)
                    .addAnnotatedClass(Reject_Order_Detail.class)
                    .addAnnotatedClass(Reject_Recieve.class)
                    .addAnnotatedClass(Reject_Return_Recieve.class)
                    .addAnnotatedClass(Remove_Return_Material.class)
                    .addAnnotatedClass(Remove_Recieve_Material.class)
                    .addAnnotatedClass(Return_Batch_Recieve.class)
                    .addAnnotatedClass(Return_Order.class)
                    .addAnnotatedClass(Return_Order_Detail.class)
                    .addAnnotatedClass(Sector.class)
                    .buildMetadata().buildSessionFactory();
//              sessionFactory=
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
